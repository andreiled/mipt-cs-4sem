/**
 * SleeperJob.java
 * Created on Mar 19, 2014
 */
package ru.mipt.spring2014.class07.threads;

public class SleeperJob implements Runnable
{
	private final long interval;
	private final int maxWaits;

	public SleeperJob (long interval, int maxWaits)
	{
		this.interval = interval;
		this.maxWaits = maxWaits;
	}

	@Override
	public void run ()
	{
		final long startTime = System.nanoTime ();
		for (int i = 0; i < maxWaits && !Thread.interrupted (); i++)
		{
			System.out.println (getClass ().getSimpleName ()
					+ ": wait for " + interval + " ms");
			try
			{
				Thread.sleep (interval);
			} catch (InterruptedException e)
			{
				final long waitTime = System.nanoTime () - startTime;
				System.out.printf ("%s: interrupted after %.3f ms\n",
						getClass ().getSimpleName (), .001 * .001 * waitTime);
				return;
			}
		}
		final long execTime = System.nanoTime () - startTime;
		System.out.println (String.format ("%s: finished after %.3f ms",
				getClass ().getSimpleName (), .001 * .001 * execTime));
	}
}
