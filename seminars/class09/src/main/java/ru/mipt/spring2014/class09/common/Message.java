/**
 * Message.java
 * Created on Apr 6, 2014
 */
package ru.mipt.spring2014.class09.common;

import java.io.Serializable;

public class Message implements Serializable
{
	private final String from;
	private final String to;
	private final String body;

	public Message (String from, String to, String body)
	{
		this.from = from;
		this.to = to;
		this.body = body;
	}

	public String getFrom ()
	{
		return from;
	}

	public String getTo ()
	{
		return to;
	}

	public String getBody ()
	{
		return body;
	}
}
