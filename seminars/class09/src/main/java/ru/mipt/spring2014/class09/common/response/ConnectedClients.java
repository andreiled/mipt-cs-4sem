/**
 * ConnectedClients.java
 * Created on Apr 6, 2014
 */
package ru.mipt.spring2014.class09.common.response;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ConnectedClients extends Response
{
	private final Collection<String> clients;

	public ConnectedClients (Collection<String> clients)
	{
		this.clients = new ArrayList<String> (clients);
	}

	public Collection<String> getClients ()
	{
		return Collections.unmodifiableCollection (clients);
	}
}
