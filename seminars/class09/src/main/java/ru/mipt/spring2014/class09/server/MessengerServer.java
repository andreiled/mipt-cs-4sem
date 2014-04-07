/**
 * MessengerServer.java
 * Created on Apr 6, 2014
 */
package ru.mipt.spring2014.class09.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ru.mipt.spring2014.class09.common.Message;

public class MessengerServer implements Runnable
{
	private final int serverPort;
	private final Map<String, ClientConnection> connectedClients = new ConcurrentHashMap<String, ClientConnection> ();
	private final ExecutorService async = Executors.newFixedThreadPool (5);

	public MessengerServer (int serverPort)
	{
		this.serverPort = serverPort;
	}

	public void run ()
	{
		final ServerSocket srvSocket;
		try{
			srvSocket = new ServerSocket (serverPort);
		} catch (Exception e)
		{
			System.out.println ("Couldn't start listening on port " + serverPort + ": " + e);
			return;
		}

		try{
			run (srvSocket);
		} catch (Exception e)
		{
			System.out.println ("Error accepting clinet connections: " + e);
		} finally
		{
			try{
				srvSocket.close ();
			} catch (Exception e)
			{
				System.out.println ("Error stopping listening on the port " + serverPort + ": " + e);
			}
		}
	}

	private void run (ServerSocket srvSocket) throws IOException
	{
		Socket clientConn;
		while (!Thread.interrupted ())
		{
			clientConn = srvSocket.accept ();
			clientConn.setTcpNoDelay (true);

			new Thread (new ConnectionHandler (this, clientConn)).start ();
		}
		System.out.println ("Stop listening on port " + serverPort);
	}

	public void registerClient (String uid, ClientConnection client)
	{
		final ClientConnection prevConn = connectedClients.put (uid, client);
		if (prevConn != null)
		{
			try{
				prevConn.close ();
			} catch (Exception e)
			{
				System.out.println ("Error closing old connection: " + e);
			}
		}
	}
	
	public Collection<String> getConnectedClients ()
	{
		return Collections.unmodifiableCollection (connectedClients.keySet ());
	}

	public void sendMessage (final Message msg)
	{
		final ClientConnection receiver = connectedClients.get (msg.getTo ());
		if (receiver != null)
		{
			async.execute (new Runnable ()
			{
				public void run ()
				{
					try{
						receiver.send (msg);
					} catch (IOException e)
					{
						System.out.println ("Error sending message " + msg + ": " + e);
					}
				}
			});
		}
	}
}
