package ppl.algor.search;

abstract public class SortedSymbolTable<K extends Comparable<K>,V> 
	extends SymbolTable<K,V>
{
	public abstract int rank(K key);
	public abstract K min();
	public abstract K max();
	public abstract void deleteMax();
	public abstract void deleteMin();
	public abstract K select(int i);
	public abstract K justMore(K key);	
	public abstract K justLess(K key);
}
