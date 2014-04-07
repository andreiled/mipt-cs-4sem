/**
 * ServerConnectionHandler.java
 * Created on Apr 6, 2014
 */
package ru.mipt.spring2014.class09.client;

import java.net.Socket;

public class ServerConnectionHandler implements Runnable
{
	private final Socket connection;
	private final MessageListener messageListener;

	public ServerConnectionHandler (Socket connection, MessageListener messageListener)
	{
		this.connection = connection;
		this.messageListener = messageListener;
	}

	public void run ()
	{
		throw new UnsupportedOperationException ("Not supported yet.");
	}
}
