/**
 * ThreadDemo.java
 * Created on Mar 19, 2014
 */
package ru.mipt.spring2014.class07.threads;

public class ThreadDemo
{
	public static void main (String[] args) throws InterruptedException
	{
		final Thread sleeperA = new SleeperThread (500L, 4);
		final Thread sleeperB = new Thread (new SleeperJob (475, 6));
		sleeperA.start ();
		sleeperB.start ();

//		Thread.sleep (1258L);
//		sleeperA.interrupt ();
//		sleeperB.interrupt ();

		System.out.println ("main: end");
	}
}
