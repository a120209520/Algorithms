package ppl.algor.graph;

import java.util.LinkedList;

import ppl.algor.struct.PairInt;

public class UdGraph implements Graph
{
	protected int V;
	protected int E;
	LinkedList<Integer>[] link;
	
	public UdGraph(int V, PairInt[] g)
	{
		super();
		this.V = V;
		link = (LinkedList<Integer>[]) new LinkedList[V];
		for(int i=0; i<V; i++)
		{
			link[i] = new LinkedList<Integer>();
		}
		for(int i=0; i<g.length; i++)
		{
			addEdge(g[i].getVal1(), g[i].getVal2());
		}
	}

	@Override
	public int V()
	{
		return V;
	}

	@Override
	public int E()
	{
		return E;
	}

	@Override
	public void addEdge(int a, int b)
	{
		link[a].add(b);
		link[b].add(a);
		E++;
	}

	@Override
	public Iterable<Integer> adj(int v)
	{
		return link[v];
	}
}
