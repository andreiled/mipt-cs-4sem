/**
 * SleepAction.java
 * Created on Mar 19, 2014
 */
package ru.mipt.spring2014.class07.threads;

import java.util.concurrent.Callable;

public class SleepAction implements Callable<Double>
{
	private final int id;
	private final long interval;

	public SleepAction (int id, long interval)
	{
		this.id = id;
		this.interval = interval;
	}

	@Override
	public Double call () throws Exception
	{
		final long startTime = System.nanoTime ();

		System.out.println ("Start task #" + id);
		Thread.sleep (interval);
		System.out.println ("Finished task #" + id);

		return .001 * .001 * (System.nanoTime () - startTime);
	}
}
