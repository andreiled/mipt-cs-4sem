/**
 * SendMessage.java
 * Created on Apr 6, 2014
 */
package ru.mipt.spring2014.class09.common.request;

import ru.mipt.spring2014.class09.common.Message;

public class SendMessage extends Request
{
	private final Message message;

	public SendMessage (Message message)
	{
		this.message = message;
	}

	public Message getMessage ()
	{
		return message;
	}
}
