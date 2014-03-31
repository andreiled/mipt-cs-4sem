/**
 * ImagePositioner.java
 * Created On Apr 24, 2013
 * @author Andrei
 */
package ru.mipt.spring2014.class08;

import java.awt.Color;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.swing.JComponent;
import ru.mipt.spring2014.class08.field.Ball;
import ru.mipt.spring2014.class08.field.FieldEngine;
import ru.mipt.spring2014.class08.field.FieldModel;

public class FieldController implements Runnable
{
	private static final Color[] COLORS = new Color[] {Color.GREEN, Color.BLACK, Color.BLUE, Color.RED, Color.YELLOW};

	private final FieldEngine engine = new FieldEngine ();
	private final Queue<Ball> changeRequests = new ConcurrentLinkedQueue ();
	private final JComponent component;
	private FieldModel currentState;

	public FieldController (JComponent component)
	{
		this.component = component;

		currentState = new FieldModel (4, 3, 5);
		for (int i = 0; i < 5; i++)
		{
			Ball ball = new Ball (0.2 + 0.1 * Math.random (), COLORS[i % COLORS.length]);
			ball.setPosition (1 + 0.5 * i, 1);
			ball.setVelocity (Math.random (), Math.random ());
			currentState.addNew (ball);
		}
	}

	public FieldModel getCurrentState ()
	{
		return currentState;
	}

	public void changeBall (Ball ball)
	{
		changeRequests.add (ball);
	}

	public void stepOver (long dTime)
	{
		currentState = engine.calculateNewState (processChanges (), dTime);
		component.repaint ();
	}

	private FieldModel processChanges ()
	{
		final FieldModel state = engine.calculateNewState (currentState, 0);
		while (!changeRequests.isEmpty ())
		{
			final Ball changeRequest = changeRequests.poll ();
			for (Ball ball : state.getBalls ())
			{
				if (changeRequest.getId () == ball.getId ())
				{
//					ball.setPosition (changeRequest.getX (), changeRequest.getY ());
					ball.setVelocity (changeRequest.getVx (), changeRequest.getVy ());
				}
			}
		}
		return state;
	}

	@Override
	public void run ()
	{
		long time = System.currentTimeMillis ();
		while (!Thread.interrupted ())
		{
			long newTime = System.currentTimeMillis ();
			stepOver (newTime - time);
			time = newTime;
			try{
				Thread.sleep (20L);
			} catch (InterruptedException e)
			{
				break;
			}
		}
	}
}
