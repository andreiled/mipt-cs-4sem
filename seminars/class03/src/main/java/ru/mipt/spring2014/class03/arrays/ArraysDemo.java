/**
 * ArraysDemo.java
 * Created on Feb 19, 2014
 */
package ru.mipt.spring2014.class03.arrays;

public class ArraysDemo
{
	public static void main (String[] args)
	{
		Vector vectorA = new Vector (4);
		Vector vectorB = new Vector (4.0, 2.6, -0.9);
		Vector vectorD = new Vector (4.0, 2.6, -0.9, -3.1);

		System.out.println ("Vectors: A: " + vectorA + "; B: " + vectorB + "; D: " + vectorD);

		double[] comps = new double[5];
		comps[0] = 7.1;
		comps[1] = Math.random ();
		comps[2] = Math.E;
		comps[4] = -3.7;
		Vector vectorC = new Vector (comps);
		System.out.println ("Third vector: " + vectorC);

		System.out.println ("A + D: " + vectorA.add (vectorD));
//		System.out.println ("Summ of first two vectors: " + vectorA.add (vectorB));

		System.out.println ("1 + 3 == 4: " + (1 + 3 == 4));
		Vector vectorE = new Vector (2);
		Vector vectorF = new Vector (2);
		System.out.println ("vectorE == vectorF: " + (vectorE == vectorF));
		System.out.println ("vectorE equals vectorF: " + (vectorE.equals (vectorF)));
	}
}
