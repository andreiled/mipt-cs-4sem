/**
 * Demo.java
 * Created on Feb 13, 2014
 */
package ru.mipt.spring2014.class01;

public class Demo
{
	public static void main (String[] args)
	{
		System.out.println ("ComplextNumber class demo");

		ComplexNumber c1 = new ComplexNumber (5, 3), c2 = new ComplexNumber (2, -1);

		System.out.println ("(" + c1 + ") + (" + c2 + ") = " + c1.add (c2));
		
		//TODO: добавить демонстрацию работы методов вычитания, умножения и деления
	}
}
