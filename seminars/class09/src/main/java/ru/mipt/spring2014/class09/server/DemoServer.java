/**
 * DemoServer.java
 * Created on Apr 6, 2014
 */
package ru.mipt.spring2014.class09.server;

public class DemoServer
{
	public static void main (String[] args)
	{
		new Thread (new MessengerServer (9999)).start ();
	}
}
