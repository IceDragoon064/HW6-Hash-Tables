import java.util.Map.Entry;

/**
 * 
 * @author Leon Lu
 * @version May 18, 2022
 * @param <K> The key value of the hashmap pair
 * @param <V> The value of the hashmap pair
 */
public class HashTableEntry<K,V> implements Entry<K, V> 
{
	private K key;
	private V value;
	private Boolean available = false;
	
	/**
	 * Constructor with K and V parameters
	 * @param key - the key value of the hashmap pair
	 * @param value - the value of the hashmap pair
	 */
	public HashTableEntry(K key, V value)
	{
		// TODO Auto-generated method stub
		this.key = key;
		this.value = value;
		this.available = false;
	}
	
	/**
	 * Return the value of boolean variable
	 * @return the available value true or false
	 */
	public boolean isAvailable()
	{
		// TODO Auto-generated method stub
		return available;
	}
	
	/**
	 * Setter for available variable
	 * @param isAvailable the set value for the available variable
	 */
	public void setAvailable(boolean isAvailable)
	{
		// TODO Auto-generated method stub
		this.available = isAvailable;
	}

	/**
	 * Getter for the key value
	 * @return key - the value of the key
	 */
	@Override
	public K getKey() 
	{
		// TODO Auto-generated method stub
		return this.key;
	}

	/**
	 * Getter for the value variable
	 * @return value - the value within the hash table
	 */
	@Override
	public V getValue() 
	{
		// TODO Auto-generated method stub
		return this.value;
	}

	/**
	 * Set the value variable with the new value and returns the old value
	 * @param value - the value to be set in this instance
	 * @return oldValue - the old value before being replaced
	 */
	@Override
	public V setValue(V value)
	{
		V oldValue = this.value;
		this.value = value;
		return oldValue;
	}
	
	/**
	 * Method to return the has code of a hash pair
	 * @return hasCode - the hash code for the hash pair
	 */
	@Override
	public int hashCode()
	{
		// TODO Auto-generated method stub
		return key.hashCode();
	}
	
	/**
	 * Method to return true or false if Object o is the same as value
	 * @param o - the object value to be compared with the entry's value
	 * @return true if the value is the same as Object o; false if otherwise
	 */
	@Override
	public boolean equals(Object o)
	{
		// TODO Auto-generated method stub
		return (value == o);
	}
}