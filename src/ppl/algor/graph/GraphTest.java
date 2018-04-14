package ppl.algor.graph;

import ppl.algor.struct.PairInt;
import ppl.algor.util.TimeCounter;
import ppl.algor.util.FileDataIO;

public class GraphTest
{
	static TimeCounter tc = new TimeCounter();
	
	public static void basic01()
	{
		//undirected graph
		int[] V = new int[1];
		PairInt[] g = FileDataIO.loadGraph("tinyG.txt", V);
		DeepFirst df = new DeepFirst(V[0], g, 5);
		df.printPath(2);
	}
	public static void main(String[] args)
	{
		basic01();
	}
}
