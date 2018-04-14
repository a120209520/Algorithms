package ppl.algor.graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import ppl.algor.struct.PairInt;

public class DeepFirst extends UdGraph
{
	private boolean[] marked;
	private int count;
	private int[] edgeTo;
	private final int s;
	
	public DeepFirst(int V, PairInt[] g, int s)
	{
		super(V, g);
		marked = new boolean[V];
		edgeTo = new int[V];
		this.s = s;
		dfs(s);
		System.out.println();
	}
	
	public void dfs(int v)
	{
		rangeCheck(v);
		marked[v] = true;
		System.out.printf("[%d]-",v);
		for(int w:adj(v))
		{
			if(!marked[w])
			{
				edgeTo[w] = v;
				dfs(w);
			}		
		}
	}
	
	public Iterable<Integer> pathTo(int v)
	{
		if(!hasPathTo(v))
			return null;
		List<Integer> path = new LinkedList<>();
		for(int x=v; x!=s; x=edgeTo[x])
			path.add(x);
		path.add(s);
		Collections.reverse(path);
		return path;
	}
	
	public void printPath(int v)
	{
		Iterable<Integer> it = pathTo(v);
		if(null == it)
		{
			System.out.println("can't reach:"+v);
			return;
		}
		for(int x: it)
		{
			if(x == s) System.out.print(x);
			else System.out.print("-"+x);
		}
		System.out.println();
	}
	
	public boolean hasPathTo(int v)
	{
		rangeCheck(v);
		return marked[v];
	}

	private void rangeCheck(int v)
	{
		if (v <0 || v>=V)
		{
			try
			{
				throw new Exception();
			} catch (Exception e)
			{
				e.printStackTrace();
				System.out.println("point is not exist!");
			}
		}
	}
	
	public static void main(String[] args)
	{
	}
}
