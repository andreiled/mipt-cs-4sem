/**
 * WriteFileDemo.java
 * Created On Mar 26, 2013
 * @author Andrei
 */
package ru.mipt.spring2014.class06;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Properties;

public class WriteFileDemo
{
	public static void main (String[] args) throws IOException
	{
		final Writer w = new BufferedWriter (new OutputStreamWriter (new FileOutputStream ("!tmp.txt")));
		try{
			final Properties props = System.getProperties ();
			for (String property : props.stringPropertyNames ())
			{
				w.write ("system.properties[");
				w.write (property);
				w.write ("]=\"");
				w.write (props.getProperty (property));
				w.write ("\"\n");
			}
		} finally
		{
			w.close ();
		}
	}
}
