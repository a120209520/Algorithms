package ppl.algor.search;

import java.util.ArrayList;

/**
 * 2.基于二分查找的符号表
 * 插入: o(N)
 * 查找: o(lgN)
 * @author Smith
 *
 * @param <K>
 * @param <V>
 */
public class BinarySearchST<K extends Comparable<K>,V>
	extends SortedSymbolTable<K,V>
{
	private K[] keys;
	private V[] vals;
	
	public BinarySearchST(int capacity)
	{
		this.capacity = capacity;
		keys = (K[])new Comparable[capacity];
		vals = (V[])new Object[capacity];
	}

	public BinarySearchST()
	{
		this.capacity = 16;
		keys = (K[])new Comparable[capacity];
		vals = (V[])new Object[capacity];
	}
	
	@Override
	public int rank(K key)
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
		//未命中: 返回的是要插入的地方
		//若是小值，left则返回0
		//若是不存在的中值，left返回最接近的右值
		//若是大值，left则返回size
		return left;
	}

	@Override
	public void put(K key, V val)
	{
		if( size+1 > capacity)
		{
			capacity *= 2;
			K[] nkeys = (K[])new Comparable[capacity];
			V[] nvals = (V[])new Object[capacity];
			System.arraycopy(keys, 0, nkeys, 0, size);
			System.arraycopy(vals, 0, nvals, 0, size);
			keys = nkeys;
			vals = nvals;
		}
		int i = rank(key);
		if(i<size && keys[i].compareTo(key) == 0)
		{
			vals[i] = val;
			return;
		}
		for(int j=size; j>i; j--)
		{
			assignC++;
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
				assignC++;
				keys[j] = keys[j+1];
				vals[j] = vals[j+1];
			}
			size--;
		}
	}
	@Override
	public K min()
	{
		return keys[0];
	}
	@Override
	public K max()
	{
		return keys[size-1];
	}
	@Override
	public K select(int i)
	{
		return keys[i];
	}
	@Override
	public K justMore(K key)
	{
		int i = rank(key);
		if(i < size)
			return keys[i];
		else
			return null;
	}
	@Override
	public K justLess(K key)
	{
		int i = rank(key);
		if(i<size && keys[i].compareTo(key)==0)
		{
			return keys[i];
		}
		else
		{
			if(i != 0)
			{
				return keys[i-1];
			}
			else
			{
				return null;
			}
		}
	}
	
	@Override
	public void deleteMax()
	{
		keys[size-1] = null;
		vals[size-1] = null;
		size--;
	}

	@Override
	public void deleteMin()
	{
		for(int i=0; i<size-1; i++)
		{
			keys[i] = keys[i+1];
			vals[i] = vals[i+1];
		}
		keys[size-1] = null;
		vals[size-1] = null;
		size--;		
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
