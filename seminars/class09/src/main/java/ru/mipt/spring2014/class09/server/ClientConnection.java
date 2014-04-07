/**
 * ClientConnection.java
 * Created on Apr 7, 2014
 */
package ru.mipt.spring2014.class09.server;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import ru.mipt.spring2014.class09.common.Message;
import ru.mipt.spring2014.class09.common.request.Request;
import ru.mipt.spring2014.class09.common.response.Response;

public class ClientConnection implements Closeable
{
	private final Socket connection;
	private final ObjectOutputStream out;
	private final ObjectInputStream in;

	public ClientConnection (Socket connection, ObjectOutputStream out, ObjectInputStream in)
	{ 
		this.connection = connection;
		this.out = out;
		this.in = in;
	}

	<R extends Request> R acceptRequest () throws IOException
	{
		try
		{
			return (R) in.readObject ();
		} catch (ClassNotFoundException e)
		{
			throw new IllegalArgumentException ("Request format unsupported", e);
		}
	}

	public void send (Response resp) throws IOException
	{
		sendInternal (resp);
	}

	public void send (Message msg) throws IOException
	{
		sendInternal (msg);
	}

	private void sendInternal (Object obj) throws IOException
	{
		synchronized (this.out)
		{
			out.writeObject (obj);
			out.flush ();
		}
	}

	public void close () throws IOException
	{
		connection.close ();
	}
}
