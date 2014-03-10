/**
 * IndexString.java
 * Created on Mar 4, 2014
 */
package ru.mipt.spring2014.class05;

public class IndexString implements Comparable<IndexString>
{

	private final int index;
	private final String value;

	public IndexString (int index, String value)
	{
		this.index = index;
		this.value = value;
	}

	@Override
	public String toString ()
	{
		return "#" + index + " " + value;
	}

	@Override
	public int hashCode ()
	{
		//TODO: реализовать этот метод
		// хеш код должен зависеть от обоих полей класса и обеспечивать приемлимый разброс значений
		throw new UnsupportedOperationException ("Implement it!!!");
	}

	@Override
	public boolean equals (Object obj)
	{
		//TODO: реализовать этот метод
		// должен возвращать true только если оба поля двух объектов совпадают
		throw new UnsupportedOperationException ("Implement it!!!");
	}

	@Override
	public int compareTo (IndexString other)
	{
		//TODO: реализовать этот метод
		// метод отвечает за упорядочивание объектов этого класса
		// если данный объект условно меньше other, то вернуть -1
		// если данный объект равен other, то вернуть 0
		// если данный объект условно больше other, то вернуть 1
		// сделать так, чтобы сначала упорядочивание шло по index и затем по value
		throw new UnsupportedOperationException ("Implement it!!!");
	}
}
