/**
 * Person.java
 * Created on Feb 18, 2014
 */
package ru.mipt.spring2014.class03.study;

public class Person
{
	private String firstName, lastName;

	public Person ()
	{
	}

	public Person (String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName ()
	{
		return firstName;
	}

	public String getLastName ()
	{
		return lastName;
	}

	public void setFirstName (String firstName)
	{
		this.firstName = firstName;
	}

	public void setLastName (String lastName)
	{
		this.lastName = lastName;
	}

	@Override
	public String toString ()
	{
		return (firstName == null ? "" : firstName + " ") + (lastName == null ? "" : lastName);
	}
}
