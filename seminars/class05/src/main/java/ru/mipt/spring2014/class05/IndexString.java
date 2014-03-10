/**
 * IndexString.java
 * Created on Mar 4, 2014
 */
package ru.mipt.spring2014.class05;

public class IndexString
{
	private final int index;
	private final String value;

	public IndexString (int index, String value)
	{
		this.index = index;
		this.value = value;
	}

	@Override
	public String toString ()
	{
		return "#" + index + " " + value;
	}
}
