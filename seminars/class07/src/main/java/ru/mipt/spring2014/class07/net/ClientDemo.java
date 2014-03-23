/**
 * ClientDemo.java
 * Created on Mar 24, 2014
 */
package ru.mipt.spring2014.class07.net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientDemo
{
	private static final int PORT = 9999;

	public static void main (String[] args)
	{
		for (int id = 1; id < 5; id++)
		{
			System.out.println ("Client: sending request #" + id);
			System.out.println ("Client: received response: "
					+ communicate (new Request (id, "Sample MesSage " + Math.random ())));
		}
	}

	private static String communicate (Request request)
	{
		try{
			final Socket connection = new Socket ("127.0.0.1", PORT);
			
			try{
				final ObjectOutputStream out = new ObjectOutputStream (new BufferedOutputStream (connection.getOutputStream ()));
				out.writeObject (request);
				out.flush ();

				final ObjectInputStream in = new ObjectInputStream (new BufferedInputStream (connection.getInputStream ()));
				return (String) in.readObject ();
			} finally
			{
				connection.close ();
			}
		} catch (Exception e)
		{
			System.err.println ("Client: Error communicating with the server: " + e);
			throw new RuntimeException ("Error communicating with the server", e);
		}
	}
}
