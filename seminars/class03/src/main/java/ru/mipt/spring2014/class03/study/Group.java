/**
 * Group.java
 * Created on Feb 18, 2014
 */
package ru.mipt.spring2014.class03.study;

public class Group
{
	private final int year;
	private final int faculty;
	private final int number;

	public Group (int year, int faculty, int number)
	{
		this.year = year;
		this.faculty = faculty;
		this.number = number;
	}

	@Override
	public String toString ()
	{
		return String.valueOf (year % 10) + faculty + number;
	}
}
