/**
 * ConsoleDemo.java
 * Created on Mar 12, 2014
 */
package ru.mipt.spring2014.class06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleDemo
{
	public static void main (String[] args) throws IOException
	{
		final BufferedReader stdIn = new BufferedReader (new InputStreamReader (System.in));
		String line = stdIn.readLine ();
		System.out.println (">>>> " + line);
	}
}
