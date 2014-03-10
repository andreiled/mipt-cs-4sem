/**
 * CollectionsDemo.java
 * Created on Mar 4, 2014
 */
package ru.mipt.spring2014.class05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsDemo
{
	public static void main (String[] args)
	{
		final List<String> listOfStrings = new ArrayList<> ();
		listOfStrings.add ("Str1");
		listOfStrings.add ("Str2");
		listOfStrings.add ("str3");
		System.out.println ("listOfStrings = " + listOfStrings);
		final Collection<String> stillList = listOfStrings;
		System.out.println ("stillList = " + stillList);

		final Set<String> setOfStrings = new HashSet<> ();
		setOfStrings.add ("Str1");
		setOfStrings.add ("Str2");
		setOfStrings.add ("Str1");
		setOfStrings.add ("Str3");
		setOfStrings.add ("Str4");
		setOfStrings.add ("str1");
		setOfStrings.add ("Str0");
		setOfStrings.add ("Abc");
		setOfStrings.add ("Ccc");
		setOfStrings.add ("Qwerty");
		System.out.println ("setOfStrings = " + setOfStrings);

		final Set<String> orderedSetOfStrings = new TreeSet<> (setOfStrings);
		System.out.println ("orderedSetOfStrings = " + orderedSetOfStrings);
	}
}
