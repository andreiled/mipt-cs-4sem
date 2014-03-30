/**
 * FieldModel.java
 * Created on Mar 30, 2014
 */
package ru.mipt.spring2014.class08.field;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FieldModel
{
	private final double width, height;
	private final Collection<Ball> balls;

	public FieldModel (double width, double height)
	{
		this (width, height, 16);
	}

	public FieldModel (double width, double height, int initialCapacity)
	{
		this.width = width;
		this.height = height;
		this.balls = new ArrayList<Ball> (initialCapacity);
	}

	public double getWidth ()
	{
		return width;
	}

	public double getHeight ()
	{
		return height;
	}

	public Collection<Ball> getBalls ()
	{
		return Collections.unmodifiableCollection (balls);
	}

	public void addNew (Ball ball)
	{
		assert (ball.getId () == -1);
		final Ball newBall = new Ball (balls.size (), ball.getR (), ball.getColor ());
		newBall.setPosition (ball.getX (), ball.getY ());
		newBall.setVelocity (ball.getVx (), ball.getVy ());
		balls.add (newBall);
	}

	protected void put (Ball ball)
	{
		assert (ball.getId () == balls.size ());
		balls.add (ball);
	}
}
