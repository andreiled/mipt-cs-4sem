/**
 * StandardGuiDemoApp.java
 * Created On Mar 5, 2013
 * @author Andrei
 */
package ru.mipt.spring2014.class04.std_gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class StandardGuiDemoApp
{
	/**
	 * @param args the command line arguments
	 */
	public static void main (String args[])
	{
		try
		{
			UIManager.setLookAndFeel (UIManager.getSystemLookAndFeelClassName ());
		} catch (Exception ex)
		{
			Logger.getLogger (MainAppWindow.class.getName ()).log (Level.SEVERE, "Couldn't set Look&Feel", ex);
		}

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater (new Runnable ()
		{
			public void run ()
			{
				new MainAppWindow ().setVisible (true);
			}
		});
	}
}
