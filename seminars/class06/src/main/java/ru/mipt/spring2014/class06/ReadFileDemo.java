/**
 * ReadFileDemo.java
 * Created On Mar 26, 2013
 * @author Andrei
 */
package ru.mipt.spring2014.class06;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReadFileDemo
{
	public static void main (String[] args) throws IOException
	{
		final Reader r = new InputStreamReader (new FileInputStream ("!system.properties"));
		try{
			final char[] buff = new char[1024];
			System.out.println ("----------Start reading file data----------");
			int count;
			while ((count = r.read (buff)) != -1)
			{
				System.out.print (new String (buff, 0, count));
			}
			System.out.println ("\n--------------------DONE-------------------");
		} finally
		{
			r.close ();
		}
	}
}
