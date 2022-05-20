import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Leon Lu
 * @version May 18, 2022
 * @param <K> The key value that is the identifier for the value V
 * @param <V> The value that will be added to the array
 */
public class LinearProbingHashTable<K, V> implements GradableMap<K, V> 
{
	private HashTableEntry<K, V>[] array;
	private double maxLoad;
	private int size;
	
	/**
	 * Constructor method with no parameters. Automatically set size to 11 and max load to 0.75
	 */
	public LinearProbingHashTable()
	{
		// TODO Auto-generated method stub
		this.size = 11;
		array = (HashTableEntry<K,V>[]) new HashTableEntry<?,?>[11];
		this.maxLoad = 0.75;
	}
	
	/**
	 * Constructor method with one parameter. Automatically set maxLoad to 0.75
	 * @param size - the size of the hash table
	 */
	public LinearProbingHashTable(int size)
	{
		// TODO Auto-generated method stub
		this.size = size;
		array =  (HashTableEntry<K,V>[]) new HashTableEntry<?,?>[size];;
		this.maxLoad = 0.75;
	}

	/**
	 * Constructor method with two parameters
	 * @param size - the size of the hash table
	 * @param loadFactor - the value that maxLoad will be assigned
	 */
	public LinearProbingHashTable(int size, double loadFactor)
	{
		// TODO Auto-generated method stub
		this.size = size;
		array =  (HashTableEntry<K,V>[]) new HashTableEntry<?,?>[size];;
		this.maxLoad = loadFactor;
	}
	
	/**
	 * Method to clear out the hash table
	 */
	@Override
	public void clear() 
	{
		// TODO Auto-generated method stub
		this.size = 0;
		this.array = null;
	}


	/**
	 * Method to check if object key is found in the table
	 * @param arg0 - the object key 
	 * @return true if object key is in the table; false if otherwise
	 */
	@Override
	public boolean containsKey(Object arg0) {
		// TODO Auto-generated method stub
		
		// Check if the key is null
		if(arg0 == null)
		{
			throw new IllegalArgumentException("Argument is null");
		}
		
		// Key is not null
		else 
		{
			// Return true if key is found in the hash table; false if otherwise
			if(array[arg0.hashCode()].getKey() == arg0)
			{
				return true;
			}
			return false;
		}
	}

	
	/**
	 * Method to check if object value is in the table
	 * @param arg0 - the object value to be found in the table
	 * @return - true if the value is in the table, false if otherwise
	 */
	@Override
	public boolean containsValue(Object arg0) 
	{
		// TODO Auto-generated method stub
		
		// Check if input value is null
		if(arg0 == null)
		{
			throw new IllegalArgumentException("Argument is null");
		}
		
		else
		{
			//Iterate through the hash table array to find the value
			for(int i = 0; i < this.size; i++)
			{
				if(array[i].getValue().equals(arg0))
				{
					return true;
				}
			}
			return false;
		}
	}

	/**
	 * Method to return a set of entries on this hash table
	 * @return setArray - the set from the arrays on this hash table
	 */
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		Set<Map.Entry<K,V>> setArray = Set.of(array);
		return setArray;
	}
	
	/**
	 * Method to find value with a given key
	 * @param arg0 - the object key
	 * @return value that is associated with the key; null if otherwise
	 */
	@Override
	public V get(Object arg0) {
		// TODO Auto-generated method stub
		if(arg0 == null)
		{
			throw new NullPointerException("get parameter is null");
		}
		
		else
		{
			V returnValue = array[arg0.hashCode()].getValue();
			if(returnValue != null)
			{
				return returnValue;
			}
			else
			{
				return null;
			}
		}
	}

	
	/**
	 * Method to check if the hash table
	 * @return true if the hash table is empty; false if otherwise
	 */
	@Override
	public boolean isEmpty() 
	{
		// TODO Auto-generated method stub
		return (this.size == 0);
	}

	/**
	 * Method to get the key from the entries in the hash table
	 * @return setKey - the set that have the entries' keys
	 */
	@Override
	public Set<K> keySet() 
	{
		// TODO Auto-generated method stub
		Set<K> setKey;
		Object[] keyArray = new Object[this.size];
		for(int i = 0; i < array.length; i++)
		{
			keyArray[i] = array[i].getKey();
		}
		return setKey = (Set<K>) Set.of(keyArray);
	}

	
	/**
	 * Method to add new value to the hash table
	 * @param K key - they key associated with the new entry
	 * @param V value - the value associated with new entry
	 */
	@Override
	public V put(K key, V value)
	{
		// TODO Auto-generated method stub
		if (key == null)
		{
			throw new NullPointerException("Key is null");
		}
		
		else 
		{
			for(int i = 0; i < this.size; i++)
			{
				if(array[i].getKey().equals(key))
				{
					V returnValue = array[i].getValue();
					array[i].setValue(value);
					return returnValue;
				}
			}
			return null;
		}
	}

	/**
	 * Method to insert entries from otherMap to this instance map
	 * @param otherMap - the another instance hash map
	 */
	@Override
	public void putAll(Map<? extends K, ? extends V> otherMap) 
	{
		// TODO Auto-generated method stub
		HashTableEntry<K, V>[] tempArray = ((GradableMap<K, V>) otherMap).getArray();
		for (int i = 0; i < tempArray.length; i++)
		{
			for(int j = 0; j < array.length; i++)
			{
				array[j] = tempArray[i];
			}
		}
	}

	
	/**
	 * Method to remove the entry with the given key
	 * @param key - the key for the entry within the has map
	 * @return the value associated with the key; null if either key is null or entry does not exist
	 */
	@Override
	public V remove(Object key) 
	{
		if(key == null)
		{
			throw new NullPointerException("key is null");
		}
		
		else
		{
			for(int i = 0; i < this.size; i++)
			{
				if(array[i].getKey().equals(key))
				{
					V returnValue = array[i].getValue();
					array[i] = null;
					array[i].setAvailable(true);
					return returnValue;
				}
			}
			return null;
		}
	}

	
	/**
	 * The getter for this instance size
	 * @return size - the size of the hash table 
	 */
	@Override
	public int size() 
	{
		// TODO Auto-generated method stub
		return this.size;
	}

	/**
	 * Method to return a collection of entry values
	 * @return listValue - an arraylist of values from the hash table array
	 */
	@Override
	public Collection<V> values()
	{
		// TODO Auto-generated method stub
		ArrayList<V> listValue = null;
		Object[] valueArray = new Object[this.size];
		for(int i = 0; i < this.size; i++)
		{
			listValue.add(array[i].getValue());
		}

		return listValue;
	}

	
	/**
	 * The getter for this has table array
	 * @return array - the hash table array
	 */
	@Override
	public HashTableEntry<K, V>[] getArray() 
	{
		// TODO Auto-generated method stub
		return this.array;
	}

	
	/**
	 * The setter for this hash table array
	 * @param array - sets the new array
	 */
	@Override
	public void setArray(HashTableEntry<K, V>[] array)
	{
		// TODO Auto-generated method stub
		this.array = array;
	}


	/**
	 * The setter for the instance size
	 * @param size - sets the size of the hash table
	 */
	@Override
	public void setSize(int size) 
	{
		// TODO Auto-generated method stub
		this.size = size;
	}

}