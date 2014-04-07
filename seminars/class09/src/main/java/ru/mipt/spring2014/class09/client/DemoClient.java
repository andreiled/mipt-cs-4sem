/**
 * DemoClient.java
 * Created on Apr 6, 2014
 */
package ru.mipt.spring2014.class09.client;

import java.io.IOException;
import java.net.Socket;
import ru.mipt.spring2014.class09.common.Message;

public class DemoClient
{
	public static void main (String[] args) throws IOException
	{
		final Socket conn = new Socket ("127.0.0.1", 9999);
		final MessageListener msgListener = new MessageListener ()
		{
			public void onMessage (Message message)
			{
				System.out.println ("Message received from " + message.getFrom () + ": " + message.getBody ());
			}
		};

		new Thread (new ServerConnectionHandler (conn, msgListener)).start ();
	}
}
