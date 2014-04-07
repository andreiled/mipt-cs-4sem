/**
 * MessageListener.java
 * Created on Apr 6, 2014
 */
package ru.mipt.spring2014.class09.client;

import ru.mipt.spring2014.class09.common.Message;

public interface MessageListener
{
	void onMessage (Message message);
}
