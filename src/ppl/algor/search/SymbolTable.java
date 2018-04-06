package ppl.algor.search;


public abstract class SymbolTable<K,V>
{
	protected int size = 0;
	protected long compC = 0;
	
	public abstract void put(K key, V val);
	public abstract V get(K key);
	public abstract void delete(K key);
	public abstract String getTag();
	public abstract void print();
	
	public boolean containsKey(K key)
	{
		return get(key) != null;
	}
	public boolean isEmpty()
	{
		return size == 0;
	}
	public int size()
	{
		return size;
	}
	public long getCounter()
	{
		System.out.println("[comp]:"+compC);
		System.out.println("[total]:"+compC);
		return compC;
	}
}
