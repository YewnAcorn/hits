import java.util.*;
/**
 * implement HashMap<String, Integer>
 *need Tuple()
 *
 */

public class HashingMap
{
	int capacity;

	ArrayList<ArrayList<Object[]>> theMap;		

	public HashingMap()
	{
		capacity = 10;
		theMap = new ArrayList<ArrayList<Object[]>>(capacity);
		// an array 
		// 	of arraylists 
		// 		of arrays of len 2
	}


	public void put(String key, Integer val)
	{
		Object[] pair = {key, val};  
		ArrayList<Object[]> innerArrayList;
		int hash = hash(key);
		if(theMap.get(hash) == null)
		{
			innerArrayList  = new ArrayList<Object[]>();
			theMap.set(hash, innerArrayList);
		}
		else
		{
			innerArrayList = theMap.get(hash);
		}
		innerArrayList.add(pair);

	}
	
	public int hash(String key)
	{
		int hash;

		String hkey = key;
		int stringLength = hkey.length();
		int sum = 0;
		char[] keyChars = new char[stringLength];

		for(int i = 0; i < stringLength; i++)
		{
			sum += (int)hkey.charAt(i);
		}

		hash = sum % capacity;

		return hash;


	}
	//get(Object key)
	//put(K hey, V value)
	//isEmpty()
	//keySet() returns all keys
	//remove(Object key) returns null if not in map, or
	//	key if it is
	//

	class Pair
	{
		String key;
		Integer val;

		protected Pair(String k, Integer v)
		{
			key = k;
			val = v;
		}
	}

}



