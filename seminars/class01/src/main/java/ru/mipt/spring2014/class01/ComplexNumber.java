/**
 * ComplexNumber.java
 * Created On Feb 26, 2013
 * @author Andrei
 */
package ru.mipt.spring2014.class01;

public class ComplexNumber
{
	private final double a, b;

	public ComplexNumber (double a, double b)
	{
		this.a = a;
		this.b = b;
	}

	//TODO: создать конструктор без аргументов

	public double getReal ()
	{
		return a;
	}

	public double getIm ()
	{
		return b;
	}

	public ComplexNumber add (ComplexNumber other)
	{
		return new ComplexNumber (a + other.a, b + other.b);
	}

	public ComplexNumber subtract (ComplexNumber other)
	{
		//TOOD: реализовать по аналогии с методом add
		throw new UnsupportedOperationException ("Division isn't supported yet");
	}

	//TODO: аналогичным образом реализовать методы умножения (multiply) и деления (divide)

	@Override
	public String toString ()
	{
		return String.valueOf (a) + " + " + b + "*i";
	}

	@Override
	public boolean equals (Object obj)
	{
		if (obj instanceof ComplexNumber)
		{
			final ComplexNumber other = (ComplexNumber) obj;
			return a == other.a && b == other.b;
		} else
		{
			return false;
		}
	}
}
