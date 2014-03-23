/**
 * ExecutorsDemo.java
 * Created on Mar 19, 2014
 */
package ru.mipt.spring2014.class07.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsDemo
{
	public static void main (String[] args) throws InterruptedException, ExecutionException
	{
		final ExecutorService execSrv = Executors.newFixedThreadPool (2);

		final int tasksNumber = 6;
		final Future<Double>[] tasks = new Future[tasksNumber];
		System.out.println ("main: start creating tasks");
		for (int i = 0; i < tasksNumber; i++)
		{
			tasks[i] = execSrv.submit (new SleepAction (i, 100L));
		}
		System.out.println ("main: all tasks created");

//		execSrv.shutdown ();

//		for (int i = 0; i < tasksNumber; i++)
//		{
//			System.out.println ("Task #" + i + " took " + tasks[i].get () + " ms");
//		}

//		execSrv.shutdown ();

		System.out.println ("main: end");
	}
}
