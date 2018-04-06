package ppl.algor.search;

abstract public class SortedSymbolTable<K extends Comparable<K>,V> 
	extends SymbolTable<K,V>
{
	protected abstract int rank(K key);
}
