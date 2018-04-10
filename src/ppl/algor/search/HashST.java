package ppl.algor.search;

/**
 * 5.哈希表
 * 插入: o(1)
 * 查找: o(1)
 * @author Smith
 *
 * @param <K>
 * @param <V>
 */
public class HashST<K extends Comparable<K>,V> extends SymbolTable<K, V>
{
	private SequenSearchST<K,V>[] st;
	public HashST()
	{
		this(9);
	}
	public HashST(int capacity)
	{
		this.capacity = capacity;
		st = (SequenSearchST<K,V>[])new SequenSearchST[capacity];
		for(int i=0; i<capacity; i++)
		{
			st[i] = new SequenSearchST<K,V>();
		}
	}
	
	private int hash(K key)
	{
		return (key.hashCode()&0x7fffffff)%capacity;
	}
	
	private void reSize(int size)
	{
		if(size > capacity/2)
		{
			SequenSearchST<K,V>[] nst = (SequenSearchST<K,V>[])new SequenSearchST[2*capacity];
			System.arraycopy(st, 0, nst, 0, capacity);
			capacity *= 2;
			st = nst;
		}
	}
	
	@Override
	public void put(K key, V val)
	{
		if(!st[hash(key)].containsKey(key))
		{
			size++;
			reSize(size);
		}
		st[hash(key)].put(key, val);
	}

	@Override
	public V get(K key)
	{
		return st[hash(key)].get(key);
	}

	@Override
	public void delete(K key)
	{
		if(st[hash(key)].containsKey(key))
		{
			size--;
		}
		st[hash(key)].delete(key);
	}

	@Override
	public String getTag()
	{
		return "SEARCH005-hash ST";
	}

	@Override
	public void print()
	{
		for(int i=0; i<capacity; i++)
		{
			if(st[i].size() != 0)
			{
				st[i].print();
			}
		}
	}
}
