/**
 * StudyDemo.java
 * Created on Feb 19, 2014
 */
package ru.mipt.spring2014.class03.study;

public class StudyDemo
{
	public static void main (String[] args)
	{
		Student studentA = new Student ("Petr", "Ivanov");
		Student studentB = new Student ("Ivan", "Popov");
		Tutor tutor = new Tutor ("Vasily", "Sidorov");

		System.out.println ("Students: " + studentA + " and " + studentB);
		System.out.println ("Tutor: " + tutor);

		Group group = new Group (2013, 7, 4);
		studentA.setGroup (group);
		studentB.setGroup (group);

		System.out.println ("Students: " + studentA + " and " + studentB);

		Person[] persons = new Person[] {tutor, studentA, studentB};
		System.out.println ("Persons:");
		for (Person person : persons)
		{
			System.out.println ("\t" + person);
		}
	}
}
