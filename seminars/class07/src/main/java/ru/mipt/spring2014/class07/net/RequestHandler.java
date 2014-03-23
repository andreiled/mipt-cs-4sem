/**
 * RequestHandler.java
 * Created on Mar 24, 2014
 */
package ru.mipt.spring2014.class07.net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RequestHandler implements Runnable
{
	private final Socket connection;

	public RequestHandler (Socket connection)
	{
		this.connection = connection;
	}

	public void run ()
	{
		try{
			final ObjectInputStream in = new ObjectInputStream (new BufferedInputStream (connection.getInputStream ()));
			final ObjectOutputStream out = new ObjectOutputStream (new BufferedOutputStream (connection.getOutputStream ()));

			Request req = (Request) in.readObject ();
			System.out.println ("Server: Request received: " + req);
			out.writeObject (req.getBody ().toUpperCase ());
			out.flush ();
		} catch (Exception e)
		{
			System.err.println ("Server: Error handling request: " + e);
		} finally
		{
			try{
				connection.close ();
			} catch (IOException e)
			{
				System.err.println ("Server: Error closing connection: " + e);
			}
		}
	}
}
