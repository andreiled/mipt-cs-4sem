/**
 * Connect.java
 * Created on Apr 7, 2014
 */
package ru.mipt.spring2014.class09.common.request;

public class Connect extends Request
{
	private final String uid;

	public Connect (String uid)
	{
		this.uid = uid;
	}

	public String getUid ()
	{
		return uid;
	}
}
