/**
 * Ball.java
 * Created on Mar 30, 2014
 */
package ru.mipt.spring2014.class08.field;

import java.awt.Color;

public class Ball
{
	private final long id;
	private final double r;
	private final Color color;
	private double x, y;
	private double vx, vy;

	public Ball (double r, Color color)
	{
		this.id = -1;
		this.r = r;
		this.color = color;
	}

	protected Ball (long id, double r, Color color)
	{
		assert (id >= 0);
		this.id = id;
		this.r = r;
		this.color = color;
	}

	public Ball copyBase ()
	{
		return new Ball (id, r, color);
	}

	public long getId ()
	{
		return id;
	}

	public double getX ()
	{
		return x;
	}

	public double getY ()
	{
		return y;
	}

	public double getR ()
	{
		return r;
	}

	public Color getColor ()
	{
		return color;
	}

	public void setPosition (double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public double getVx ()
	{
		return vx;
	}

	public double getVy ()
	{
		return vy;
	}

	public void setVelocity (double vx, double vy)
	{
		this.vx = vx;
		this.vy = vy;
	}
}
