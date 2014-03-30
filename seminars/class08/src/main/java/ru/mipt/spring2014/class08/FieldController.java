/**
 * ImagePositioner.java
 * Created On Apr 24, 2013
 * @author Andrei
 */
package ru.mipt.spring2014.class08;

import java.awt.Color;
import javax.swing.JComponent;
import ru.mipt.spring2014.class08.field.Ball;
import ru.mipt.spring2014.class08.field.FieldEngine;
import ru.mipt.spring2014.class08.field.FieldModel;

public class FieldController implements Runnable
{
	private static final Color[] COLORS = new Color[] {Color.GREEN, Color.BLACK, Color.BLUE, Color.RED, Color.YELLOW};

	private final FieldEngine engine = new FieldEngine ();
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

	public void stepOver (long dTime)
	{
		currentState = engine.calculateNewState (currentState, dTime);
		component.repaint ();
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
