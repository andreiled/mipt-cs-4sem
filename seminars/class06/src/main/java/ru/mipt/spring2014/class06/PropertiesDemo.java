/**
 * PropertiesDemo.java
 * Created On Mar 26, 2013
 * @author Andrei
 */
package ru.mipt.spring2014.class06;

import java.io.*;
import java.util.Date;
import java.util.Properties;

public class PropertiesDemo
{
	private static void printProperties (String filePath) throws IOException
	{
		final InputStream in = PropertiesDemo.class.getResourceAsStream (filePath);
		if (in != null)
		{
			try{
				final Properties props = new Properties ();
				props.load (in);
				System.out.println ("Info: Properties[" + filePath + "]: " + props);
			} finally
			{
				try{in.close ();}
				catch (IOException e) {e.printStackTrace (System.err);}
			}
		} else
		{
			System.out.println ("Waring: " + filePath + " not found");
		}
	}

	private static void dumpSystemProperties () throws FileNotFoundException, IOException
	{
		final Properties props = System.getProperties ();
		final OutputStream out = new FileOutputStream ("!system.properties");
		try{
			props.store (out, "Written from Java sample program (time: " + new Date () + ")");
		} finally
		{
			try{out.close ();}
			catch (IOException e) {e.printStackTrace (System.err);}
		}
	}

	public static void main (String[] args) throws IOException
	{
		printProperties ("/global.properties");
		printProperties ("local.properties");

		dumpSystemProperties ();
	}
}
