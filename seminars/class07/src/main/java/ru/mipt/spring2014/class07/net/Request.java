/**
 * Request.java
 * Created on Mar 24, 2014
 */
package ru.mipt.spring2014.class07.net;

import java.io.Serializable;

public class Request implements Serializable
{
	private final long id;
	private final String body;

	public Request (long id, String body)
	{
		this.id = id;
		this.body = body;
	}

	@Override
	public String toString ()
	{
		return "#" + id + ": <[" + body + "]>";
	}

	public long getId ()
	{
		return id;
	}

	public String getBody ()
	{
		return body;
	}
}
