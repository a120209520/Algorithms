package ppl.algor.basic;

import ppl.algor.struct.PairInt;
import ppl.algor.util.FileDataIO;
import ppl.algor.util.TimeCounter;

public class UnionFind
{
	static TimeCounter tc = new TimeCounter();

	public static void basic(UnionFinder uf, String file)
	{
		PairInt pis[] = FileDataIO.loadPairInt(file);
		uf.init(pis.length);
		tc.start(uf.getTag());
		for(PairInt pi:pis)
		{
			uf.connect(pi.getVal1(), pi.getVal2());
		}
		tc.stop();
		uf.print();
	}
	
	public static void speedTest()
	{
		//basic(new UnionFind001(),"largeUF.txt");  //too long
		basic(new UnionFind002(),"largeUF.txt");
		basic(new UnionFind003(),"largeUF.txt");
	}
	public static void main(String[] args)
	{
//		basic(new UnionFind001(),"mediumUF.txt");
//		basic(new UnionFind002(),"mediumUF.txt");
//		basic(new UnionFind003(),"mediumUF.txt");
		speedTest();
	}		
}

abstract class UnionFinder
{
	int[] point = null;
	int blockNum = 0;
	abstract void init(int N);
	abstract void connect(int p1, int p20);
	abstract String getTag();
	protected int find(int p) {return 0;}
	protected boolean isConnected(int p1, int p2)
	{
		return find(p1) == find(p2);
	}
	public void print()
	{
		System.out.println("has "+blockNum+" blocks");
	}
}

//quick-union算法
class UnionFind001 extends UnionFinder
{
	@Override
	public void init(int N)
	{
		blockNum = N;
		point = new int[N];
		for (int i=0; i<N; i++)
		{
			point[i] = i;
		}
	}
	@Override
	public void connect(int p1, int p2)
	{
		int root1 = find(p1);
		int root2 = find(p2);
		if (root1 != root2)
		{
			point[root2] = root1;
			blockNum--;			
		}
	}	
	@Override
	protected int find(int p)
	{
		while(point[p] != p)
		{
			p = point[p];
		}
		return p;
	}

	@Override
	public String getTag()
	{
		return "UF001-quick-union";
	}
}

//加权quick-union算法
class UnionFind002 extends UnionFinder
{
	int[] treeSize = null;
	@Override
	public void init(int N)
	{
		blockNum = N;
		point = new int[N];
		treeSize = new int[N];
		for (int i=0; i<N; i++)
		{
			point[i] = i;
			treeSize[i] = 1;
		}
	}
	@Override
	public void connect(int p1, int p2)
	{
		int root1 = find(p1);
		int root2 = find(p2);
		if (root1 != root2)
		{
			if (treeSize[root1] <= treeSize[root2])
			{
				point[root1] = root2;
				treeSize[root2] += treeSize[root1];
			}
			else
			{
				point[root2] = root1;
				treeSize[root1] += treeSize[root2];
			}
			blockNum--;
		}
	}
	@Override
	protected int find(int p)
	{
		while(point[p] != p)
		{
			p = point[p];
		}
		return p;
	}
	@Override
	public String getTag()
	{
		return "UF002-weighted-quick-union";
	}
}


//路径压缩quick-union算法
class UnionFind003 extends UnionFinder
{
	int[] treeSize = null;
	@Override
	public void init(int N)
	{
		blockNum = N;
		point = new int[N];
		treeSize = new int[N];
		for (int i=0; i<N; i++)
		{
			point[i] = i;
			treeSize[i] = 1;
		}
	}
	@Override
	public void connect(int p1, int p2)
	{
		int root1 = find(p1);
		int root2 = find(p2);
		if (root1 != root2)
		{
			if (treeSize[root1] <= treeSize[root2])
			{
				point[root1] = root2;
				treeSize[root2] += treeSize[root1];
			}
			else
			{
				point[root2] = root1;
				treeSize[root1] += treeSize[root2];
			}
			blockNum--;
		}	
	}	

	@Override
	protected int find(int p)
	{
		int t = p;
		int root;
		while(t != point[t])
		{
			t = point[t];
		}
		root = t;
		
		//compress-path
		int tp;
		t = p;
		while(root != point[t])
		{
			tp = point[t];
			point[t] = root;
			t = tp;
		}
		return root;
	}
	@Override
	public String getTag()
	{
		return "UF003-compress-weighted-quick-union";
	}
}