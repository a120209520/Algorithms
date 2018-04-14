package ppl.algor.graph;

public interface Graph
{
	int V();  //nums of points
	int E();  //nums of edges
	void addEdge(int v, int w);
	Iterable<Integer> adj(int v);
}
