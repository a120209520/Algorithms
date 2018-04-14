package ppl.algor.string;

import java.util.LinkedList;
import java.util.List;

/**
 * 3. 单词查找数
 * o(1) = l , 其中l为字符串长度
 * 对于字符串，查找速度是最快的，但消耗内存也非常大
 * @author Smith
 *
 */
public class TrieST<V>
{
	public static final int ASCII = 128;
	public static final int ASCII_EX = 256;
	public static final int UNICODE16 = 65536;
	private int R = ASCII_EX;
	private Node root = null;
	private int size = 0;
	public static long max = 0;
	
	private static class Node
	{
		private Object val = null;
		private Node[] next = null;
		public Node(Object val, int R)
		{
			this.val = val;
			next = new Node[R];
		}
	}
	
	public TrieST(){}
	public TrieST(int R)
	{
		this.R = R;
	}
	
	public boolean containsKey(String key)
	{
		return get(key) != null;
	}
	
	public V get(String key)
	{
		Node ret = get(root, key, 0);
		if(null == ret)
			return null;
		return (V)ret.val;
	}
	private Node get(Node x, String key, int d)
	{
		if(null == x)
			return null;
		if(d == key.length())
			return x;
		char c = key.charAt(d);
		return get(x.next[c], key, d+1);
	}
	
	public void put(String key, V val)
	{
		root = put(root, key, val, 0);
	}
	private Node put(Node x, String key, V val, int d)
	{
		if(null == x)
		{
			x = new Node(null,R);
			max += 1032;
		}
		if(d == key.length())
		{
			x.val = val;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d+1);
		return x;
	}
	
	public Iterable<String> keysWithPrefix(String pre)
	{
		List<String> list = new LinkedList<>();
		collect(get(root, pre, 0), pre, list);
		return list;
	}
	public Iterable<String> keys()
	{
		return keysWithPrefix("");
	}
	
	public void delete(String key)
	{
		root = delete(root, key, 0);
	}
	private Node delete(Node x, String key, int d)
	{
		if (null == x)
			return null;
		if (d == key.length())
		{
			x.val = null;
		}
		else
		{
			char c = key.charAt(d);
			x.next[c] = delete(x.next[c], key, d+1);
			if(null != x.next[c])
				return x;
		}
		if(null != x.val)
			return x;
		for(char c=0; c<R; c++)
			if(null != x.next[c])
				return x;
		return null;
	}
	
	private void collect(Node x, String pre, List<String> list)
	{
		if (null == x)
			return;
		if (null != x.val)
		{
			list.add(pre);
		}
		for(char c=0; c<R; c++)
		{
			collect(x.next[c], pre+c, list);
		}
	}
}


















