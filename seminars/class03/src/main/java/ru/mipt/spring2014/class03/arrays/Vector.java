/**
 * Vector.java
 * Created on Feb 19, 2014
 */
package ru.mipt.spring2014.class03.arrays;

public class Vector
{
	private final double[] components;

	public Vector (int dimension)
	{
		this.components = new double[dimension];
	}

	public Vector (double... components)
	{
		this.components = components;
	}

	public Vector add (Vector other)
	{
		if (components.length == other.components.length)
		{
			final double[] newCoords = new double[components.length];
			for (int i = 0; i < components.length; i++)
			{
				newCoords[i] = components[i] + other.components[i];
			}
			return new Vector (newCoords);
		} else
		{
			throw new IllegalArgumentException ("Vectors dimension missmatch");
		}
	}

	@Override
	public String toString ()
	{
		StringBuilder sb = new StringBuilder ("{");
		for (int i = 0; i < components.length; i++)
		{
			if (i > 0)
			{
				sb.append (", ");
			}
			sb.append (components[i]);
		}
		sb.append ("}");
		return sb.toString ();
	}

	@Override
	public boolean equals (Object obj)
	{
		if (obj instanceof Vector)
		{
			Vector other = (Vector) obj;
			if (components.length != other.components.length)
			{
				return false;
			}
			for (int i = 0; i < components.length; i++)
			{
				if (components[i] != other.components[i])
				{
					return false;
				}
			}
			return true;
		} else
		{
			return false;
		}
	}
}
