/**
 * Student.java
 * Created on Feb 18, 2014
 */
package ru.mipt.spring2014.class03.study;

public class Student extends Person
{
	private Group group;

	public Student ()
	{
	}

	public Student (String firstName, String lastName)
	{
		super (firstName, lastName);
	}

	public Group getGroup ()
	{
		return group;
	}

	public void setGroup (Group group)
	{
		this.group = group;
	}

	@Override
	public String toString ()
	{
		return super.toString () + (group == null ? "" : " (group #" + group + ")");
	}
}
