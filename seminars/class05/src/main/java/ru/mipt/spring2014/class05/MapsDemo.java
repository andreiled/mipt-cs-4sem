/**
 * MapsDemo.java
 * Created on Mar 4, 2014
 */
package ru.mipt.spring2014.class05;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapsDemo
{
	public static void main (String[] params)
	{
		final Map<String, String> mapOfStrings = new HashMap<> ();
		mapOfStrings.put ("key1", "value1");
		mapOfStrings.put ("key2", "value2");
		mapOfStrings.put ("key0", "value0");
		mapOfStrings.put ("key2", "value2-new");
		mapOfStrings.put ("Aaa", "AAA");
		mapOfStrings.put ("q", "Qwerty");
		System.out.println ("mapOfStrings = " + mapOfStrings);
		System.out.println ("mapOfStrings[key0] = " + mapOfStrings.get ("key0"));
		System.out.println ("mapOfStrings[key2] = " + mapOfStrings.get ("key2"));
		System.out.println ("mapOfStrings[unknownKey] = " + mapOfStrings.get ("unknownKey"));

		final Map<String, String> orderedMapOfStrings = new TreeMap<> (mapOfStrings);
		System.out.println ("orderedMap = " + orderedMapOfStrings);

		final Map<IndexString, Long> map = new HashMap<> ();
		map.put (new IndexString (4, "Qwerty"), 1L);
		map.put (new IndexString (1, null), 2L);
		map.put (new IndexString (56, "Last1"), 3L);
		map.put (new IndexString (56, "Last2"), 4L);
		map.put (new IndexString (7, "Bbb"), 4L);
		map.put (new IndexString (-6, "Yyy"), 5L);
		map.put (new IndexString (0, "---"), 6L);
		map.put (new IndexString (1, "NotEmpty"), 7L);
		map.put (new IndexString (0, "---"), 9L);
		map.put (new IndexString (7, "Aaa"), 8L);
		System.out.println ("map = " + map);
		System.out.println ("map[#0 ---] = " + map.get (new IndexString (0, "---")));

		final Map<IndexString, Long> orderedMap = new TreeMap<> (map);
		System.out.println ("orderedMap = " + orderedMap);
	}
}
