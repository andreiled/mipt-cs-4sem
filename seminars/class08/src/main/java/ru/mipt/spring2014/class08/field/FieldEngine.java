/**
 * FieldEngine.java
 * Created on Mar 30, 2014
 */
package ru.mipt.spring2014.class08.field;

import java.util.Collection;

public class FieldEngine
{
	public FieldModel calculateNewState (FieldModel state, long dTime)
	{
		final Collection<Ball> balls = state.getBalls ();
		final FieldModel newState = new FieldModel (state.getWidth (), state.getHeight (), balls.size ());

		for (Ball ball : balls)
		{
			newState.put (calculateNewState (state, ball, dTime));
		}

		return newState;
	}

	private Ball calculateNewState (FieldModel field, Ball ball, long dTime)
	{
		double vx = ball.getVx (), vy = ball.getVy ();
		double x = ball.getX () + vx * .001 * dTime;
		double y = ball.getY () + vy * .001 * dTime;

		if (x < ball.getR ())
		{
			x = 2 * ball.getR () - x;
			vx = -vx;
		}
		if (y < ball.getR ())
		{
			y = 2 * ball.getR () - y;
			vy = -vy;
		}
		if (x > field.getWidth () - ball.getR ())
		{
			x = 2 * field.getWidth () - 2 * ball.getR () - x;
			vx = -vx;
		}
		if (y > field.getHeight () - ball.getR ())
		{
			y = 2 * field.getHeight () - 2 * ball.getR () - y;
			vy = -vy;
		}

		final Ball result = ball.copyBase ();
		result.setPosition (x, y);
		result.setVelocity (vx, vy);
		return result;
	}
}
