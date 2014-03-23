/**
 * SleeperThread.java
 * Created on Mar 19, 2014
 */
package ru.mipt.spring2014.class07.threads;

public class SleeperThread extends Thread
{
	private final long interval;
	private final int maxWaits;

	public SleeperThread (long interval, int maxWaits)
	{
		this.interval = interval;
		this.maxWaits = maxWaits;
	}

	@Override
	public void run ()
	{
		final long startTime = System.currentTimeMillis ();
		for (int i = 0; i < maxWaits && !Thread.interrupted (); i++)
		{
			System.out.println (getClass ().getSimpleName ()
					+ ": wait for " + interval + " ms");
			try
			{
				Thread.sleep (interval);
			} catch (InterruptedException e)
			{
				final long waitTime = System.currentTimeMillis () - startTime;
				System.out.println (getClass ().getSimpleName () + ": interrupted after " + waitTime + " ms");
				return;
			}
		}
		final long execTime = System.currentTimeMillis () - startTime;
		System.out.println (getClass ().getSimpleName () + ": finished after " + execTime + " ms");
	}
}
