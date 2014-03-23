/**
 * ClientDemo.java
 * Created on Mar 24, 2014
 */
package ru.mipt.spring2014.class07.net;

public class ServerDemo
{
	private static final int PORT = 9999;

	public static void main (String[] args)
	{
		new Thread (new Server (PORT)).start ();
	}
}
