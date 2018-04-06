package ppl.algor.search;


public class BinarySearchST<K extends Comparable<K>,V>
	extends SortedSymbolTable<K,V>
{
	private K[] keys;
	private V[] vals;
	
	public BinarySearchST(int capacity)
	{
		keys = (K[])new Comparable[capacity];
		vals = (V[])new Object[capacity];
	}

	@Override
	protected int rank(K key)
	{
		int left = 0, right = size-1;
		int mid = 0;
		int cmp = 0;
		while(left <= right)
		{
			mid = (left+right)/2;
			cmp = key.compareTo(keys[mid]);compC++;
			if(cmp > 0)
			{
				left = mid + 1;
			}
			else if(cmp < 0)
			{
				right = mid - 1;
			}
			else
			{
				return mid;
			}
		}
		//未命中
		//若是小值，left则返回0
		//若是大值，left则返回size
		return left;
	}

	@Override
	public void put(K key, V val)
	{
		int i = rank(key);
		if(i<size && keys[i].compareTo(key) == 0)
		{
			vals[i] = val;
			return;
		}
		for(int j=size; j>i; j--)
		{
			keys[j] = keys[j-1];
			vals[j] = vals[j-1];
		}
		keys[i] = key;
		vals[i] = val;
		size++;
	}

	@Override
	public V get(K key)
	{
		if(isEmpty())
			return null;
		int i = rank(key);
		if (i<size && keys[i].compareTo(key) == 0)
		{
			return vals[i];
		}
		return null;
	}

	@Override
	public void delete(K key)
	{
		int i = rank(key);
		if(i<size && keys[i].compareTo(key) == 0)
		{
			keys[i] = null;
			vals[i] = null;
			for(int j=i; j<size-1; j++)
			{
				keys[j] = keys[j+1];
				vals[j] = vals[j+1];
			}
			size--;
		}
	}

	@Override
	public String getTag()
	{
		return "SEARCH002-binaryST";
	}

	@Override
	public void print()
	{
		for(int i=0; i<size; i++)
		{
			System.out.printf("[%s|%s]->",keys[i], vals[i]);
			if(i%5==4)
				System.out.println();
		}
		System.out.println();
	}
}
