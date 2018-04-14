package ppl.algor.string;

/**
 * 4. 三向单词查找数
 * o(lgN)
 * 权衡速度和内存
 * @author Smith
 *
 */
public class TST<V>
{
	private Node root;
	public static long max = 0;
	private class Node
	{
		char c;
		Node left,mid,right;
		V val;
	}
	
	public boolean containsKey(String key)
	{
		return get(key) != null;
	}
	
	public V get(String key)
	{
		Node x = get(root, key, 0);
		if(null == x)
			return null;
		return x.val;
	}
	private Node get(Node x, String key, int d)
	{
		if (null == x)
			return null;
		char c = key.charAt(d);
		if (c < x.c)
			return get(x.left, key, d);
		else if (c > x.c)
			return get(x.right, key, d);
		else if(d < key.length()-1)
			return get(x.mid, key, d+1);
		else 
			return x;
	}
	
	public void put(String key, V val)
	{
		root = put(root, key, val, 0);
	}
	private Node put(Node x, String key, V val, int d)
	{
		char c = key.charAt(d);
		if (null == x)
		{
			x = new Node(); x.c = c;
			max += 27;
		}
		if (c < x.c)
			x.left =  put(x.left, key, val, d);
		else if (c > x.c)
			x.right = put(x.right, key, val, d);
		else if(d < key.length()-1)
			x.mid =  put(x.mid, key, val, d+1);
		else 
			x.val = val;
		return x;
	}
	public static void main(String[] args)
	{
		TST<Integer> tst = new TST<>();
		tst.put("it", 99);
		tst.put("the", 1);
		tst.put("best", 2);
		tst.put("age", 3);
		System.out.println(tst.get("its"));
	}
}
