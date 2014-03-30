/**
 * CustomGuiDemoApp.java
 * Created on Feb 25, 2014
 */
package ru.mipt.spring2014.class08;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import ru.mipt.spring2014.class08.ui.GraphDemoWindow;

public class CustomGuiDemoApp
{
	/**
	 * @param args the command line arguments
	 */
	public static void main (String args[])
	{
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		try
		{
			UIManager.setLookAndFeel (UIManager.getSystemLookAndFeelClassName ());
		} catch (Exception ex)
		{
			Logger.getLogger (GraphDemoWindow.class.getName ()).log (Level.SEVERE, "Couldn't set Look&Feel", ex);
		}
		//</editor-fold>

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater (new Runnable ()
		{
			public void run ()
			{
				new GraphDemoWindow ().setVisible (true);
			}
		});
	}
}
