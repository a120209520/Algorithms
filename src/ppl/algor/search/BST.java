package ppl.algor.search;

/**
 * 3.二叉查找树
 * 插入: o(lgN)
 * 查找: o(lgN)
 * @author Smith
 *
 * @param <K>
 * @param <V>
 */
public class BST<K extends Comparable<K>,V> extends SortedSymbolTable<K, V>
{
	private Node root;
	
	private class Node
	{
		private K key;
		private V val;
		private Node left;
		private Node right;
		private int N;
		public Node(K key, V val, int N)
		{
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}
	
	public int size()
	{
		return size(root);
	}
	
	public int size(Node x)
	{
		if(null != x)
		{
			return x.N;
		}
		return 0;
	}
	
	@Override
	public int rank(K key)
	{
		return rank(root, key);
	}
	private int rank(Node x, K key)
	{
		if(null == x)
			return 0;
		int cmp = key.compareTo(x.key);
		if(cmp > 0)
		{
			return 1 + size(x.left) + rank(x.right, key);	
		}
		else if(cmp < 0)
		{
			return rank(x.left, key);
		}
		else
		{
			return size(x.left);
		}
	}

	@Override
	public K min()
	{
		if(null == root)
			return null;
		Node temp = root;
		while(temp.left != null)
		{
			temp = temp.left;
		}
		return temp.key;
	}

	@Override
	public K max()
	{
		if(null == root)
			return null;
		Node temp = root;
		while(temp.right != null)
		{
			temp = temp.right;
		}
		return temp.key;
	}

	@Override
	public void deleteMax()
	{
	}

	@Override
	public void deleteMin()
	{
	}

	@Override
	public K select(int i)
	{
		return select(root, i);
	}
	private K select(Node x, int i)
	{
		if(null == x)
			return null;
		int t = size(x.left);
		if(t > i)
		{
			return select(x.left, i);
		}
		else if(t < i)
		{
			return select(x.right, i-t-1);
		}
		else
		{
			return x.key;
		}
	}

	@Override
	public K justMore(K key)
	{
		if(null == root)
			return null;
		return justMore(root,key);
	}
	private K justMore(Node x, K key)
	{
		int cmp = key.compareTo(x.key);
		if(cmp > 0)
		{
			if(null == x.right)
				return null;
			return justMore(x.right,key);
		}
		else if(cmp < 0)
		{
			if(null == x.left)
				return x.key;
			if(key.compareTo(x.left.key) > 0)
				return x.key;
			return justMore(x.left,key);
		}
		else
		{
			return x.key;
		}
	}

	@Override
	public K justLess(K key)
	{
		if(null == root)
			return null;
		return justLess(root,key);
	}
	private K justLess(Node x, K key)
	{
		int cmp = key.compareTo(x.key);
		if(cmp > 0)
		{
			if(null == x.right)
				return x.key;
			if(key.compareTo(x.right.key) < 0)
				return x.key;
			return justLess(x.right,key);
		}
		else if(cmp < 0)
		{
			if(null == x.left)
				return null;
			return justLess(x.left,key);
		}
		else
		{
			return x.key;
		}
	}

	@Override
	public void put(K key, V val)
	{
		root = put(root, key, val);
	}
	private Node put(Node x, K key, V val)
	{
		if(null == x)
			return new Node(key,val,1);
		int cmp = key.compareTo(x.key);
		compC++;
		if(cmp > 0)
		{
			x.right = put(x.right,key,val);
		}
		else if(cmp < 0)
		{
			x.left = put(x.left,key,val);
		}	
		else
		{
			x.val = val;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	@Override
	public V get(K key)
	{
		return get(root,key);
	}
	private V get(Node x, K key)
	{
		if(null == x)
			return null;
		int cmp = key.compareTo(x.key);
		compC++;
		if(cmp > 0)
		{
			return get(x.right, key);
		}
		else if(cmp < 0)
		{
			return get(x.left, key);
		}	
		else
		{
			return x.val;
		}
	}

	@Override
	public void delete(K key)
	{
	}

	@Override
	public String getTag()
	{
		return "SEARCH003-BST";
	}

	@Override
	public void print()
	{
	}
}
