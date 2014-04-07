/**
 * ConnectionHandler.java
 * Created on Apr 6, 2014
 */
package ru.mipt.spring2014.class09.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import ru.mipt.spring2014.class09.common.request.Connect;
import ru.mipt.spring2014.class09.common.request.GetConnectedClients;
import ru.mipt.spring2014.class09.common.request.Request;
import ru.mipt.spring2014.class09.common.request.SendMessage;
import ru.mipt.spring2014.class09.common.response.ConnectedClients;

public class ConnectionHandler implements Runnable
{
	private final MessengerServer server;
	private final Socket connection;

	public ConnectionHandler (MessengerServer server, Socket connection)
	{
		this.server = server;
		this.connection = connection;
	}

	public void run ()
	{
		try{
			runInternal ();
		} catch (Exception e)
		{
			System.out.println ("Error handling connection: " + e);
		}
	}

	private void runInternal () throws IOException
	{
		final ObjectOutputStream out = new ObjectOutputStream (new BufferedOutputStream (connection.getOutputStream ()));
		final ObjectInputStream in = new ObjectInputStream (new BufferedInputStream (connection.getInputStream ()));
		final ClientConnection conn = new ClientConnection (connection, out, in);

		final Connect connect = conn.acceptRequest ();
		server.registerClient (connect.getUid (), conn);

		Request request;
		while (!Thread.interrupted ())
		{
			request = conn.acceptRequest ();
			handleRequest (conn, request);
		}
	}

	private void handleRequest (ClientConnection conn, Request request) throws IOException
	{
		if (request instanceof GetConnectedClients)
		{
			conn.send (new ConnectedClients (server.getConnectedClients ()));
		} else if (request instanceof SendMessage)
		{
			server.sendMessage (((SendMessage) request).getMessage ());
		} else
		{
			System.out.println ("Unsupported request received: " + request);
		}
	}
}
