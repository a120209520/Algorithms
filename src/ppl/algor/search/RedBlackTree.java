package ppl.algor.search;


/**
 * 4.红黑树
 * 插入: o(lgN)
 * 查找: o(lgN)
 * @author Smith
 *
 * @param <K>
 * @param <V>
 */
public class RedBlackTree<K extends Comparable<K>,V> extends SortedSymbolTable<K, V>
{

	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private Node root;
	
	private class Node
	{
		K key;
		V val;
		int N;
		Node left;
		Node right;
		boolean color;
		public Node(K key, V val, int n, boolean color)
		{
			this.key = key;
			this.val = val;
			N = n;
			this.color = color;
		}
	}
	
	private boolean isRed(Node x)
	{
		if(null == x)
			return false;
		return x.color == RED;
	}

	
	public int size(Node x)
	{
		if(null != x)
		{
			return x.N;
		}
		return 0;
	}
	
	private void updateSize(Node x)
	{
		if(null == x)
			return;
		x.N = size(x.left) + size(x.right) + 1;
	}
	//左旋转
	private Node rotateLeft(Node x)
	{
		Node t = x.right;
		x.right = t.left;
		t.left = x;
		t.color = x.color;
		x.color = RED;
		t.N = x.N;
		updateSize(x);
		return t;
	}
	//右旋转
	private Node rotateRight(Node x)
	{
		Node t = x.left;
		x.left = t.right;
		t.right = x;
		t.color = x.color;
		x.color = RED;
		t.N = x.N;
		updateSize(x);
		return t;
	}
	//颜色转换
	private void filpColors(Node x)
	{
		x.color = RED;
		x.left.color = BLACK;
		x.right.color = BLACK;
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
		root.color = BLACK;
	}
	private Node put(Node x, K key, V val)
	{
		if (null == x)
			return new Node(key, val, 1, RED);
		int cmp = key.compareTo(x.key);
		if (cmp > 0)
		{
			x.right = put(x.right, key, val);
		}
		else if (cmp < 0)
		{
			x.left = put(x.left, key, val);
		}
		else
		{
			x.val = val;
		}
		
		if( !isRed(x.left) && isRed(x.right) )
		{
			x = rotateLeft(x);
		}
		if( isRed(x.left) && isRed(x.left.left) )
		{
			x = rotateRight(x);
		}
		if( isRed(x.left) && isRed(x.right) )
		{
			filpColors(x);
		}
		
		updateSize(x);
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
	public boolean isEmpty()
	{
		return root == null;
	}
	
	@Override
	public int size()
	{
		return size(root);
	}

	@Override
	public String getTag()
	{
		return "SEARCH004-red black tree";
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
