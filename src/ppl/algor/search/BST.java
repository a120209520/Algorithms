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
	public boolean isEmpty()
	{
		return root == null;
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
		return min(root).key;
	}
	private Node min(Node x)
	{
		if(null == x.left)
			return x;
		return min(x.left);
	}

	@Override
	public K max()
	{
		return max(root).key;
	}
	private Node max(Node x)
	{
		if(null == x.right)
			return x;
		return max(x.right);
	}

	@Override
	public void deleteMax()
	{
		root = deleteMax(root);
	}
	private Node deleteMax(Node x)
	{
		if(x.right == null)
			return x.left;
		x.right = deleteMax(x.right);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	@Override
	public void deleteMin()
	{
		root = deleteMin(root);
	}
	private Node deleteMin(Node x)
	{
		if(x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
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
		root = delete(root, key);
	}
	private Node delete(Node x, K key)
	{
		if(x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if(cmp > 0)
		{
			x.right = delete(x.right, key);
		}	
		else if(cmp < 0)
		{
			x.left =  delete(x.left, key);
		}	
		else
		{
			if (x.right == null) return x.left;
			if (x.left == null) return x.right;
			Node t = x;
			x = min(t.right);
			x.left = t.left;
			x.right = deleteMin(t.right);
		}
		//x.N = size(x.left) + size(x.right) + 1;
		x.N--;
		return x;
	}
	
	@Override
	public String getTag()
	{
		return "SEARCH003-BST";
	}

	@Override
	public void print()
	{
		print(root);
		System.out.println();
	}
	private void print(Node x)
	{
		if(x == null)
		{
			System.out.print("[Empty]");
			return;
		}
		if(x.left != null)
			print(x.left);
			System.out.print("["+x.key+"]--");
		if(x.right != null)
			print(x.right);
	}
}
