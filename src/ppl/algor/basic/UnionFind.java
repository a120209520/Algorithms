package ppl.algor.basic;

import ppl.algor.struct.PairInt;
import ppl.algor.util.FileDataIO;
import ppl.algor.util.TimeCounter;

public class UnionFind
{
	public static long counter = 0; //记录效率
	static TimeCounter tc = new TimeCounter();

	public static void basic(int type, String file)
	{
		PairInt pis[] = FileDataIO.loadPairInt(file);
		UnionFinder uf = createUnionFinder(type, pis.length);
		tc.start(createTag(type));
		for(PairInt pi:pis)
		{
			uf.connect(pi.getVal1(), pi.getVal2());
		}
		tc.stop();
		uf.print();
	}
	private static UnionFinder createUnionFinder(int type, int len)
	{
		switch(type)
		{
			case 1: return new UnionFind001(len);
			case 2: return new UnionFind002(len);
			case 3: return new UnionFind003(len);
		}
		return null;
	}
	private static String createTag(int type)
	{
		switch(type)
		{
			case 1: return "cal-001";
			case 2: return "cal-002";
			case 3: return "cal-003";
		}
		return null;
	}
	
	public static void speedTest()
	{
		//basic(1,"largeUF.txt");  //too long
		basic(2,"largeUF.txt");
		basic(3,"largeUF.txt");
	}
	public static void main(String[] args)
	{
//		basic(1,"mediumUF.txt");
//		basic(2,"mediumUF.txt");
//		basic(3,"mediumUF.txt");
		speedTest();
	}		
}

abstract class UnionFinder
{
	int[] point = null;
	int blockNum = 0;
	abstract void connect(int p1, int p20);
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
	public UnionFind001(int N)
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
}

//加权quick-union算法
class UnionFind002 extends UnionFinder
{
	int[] treeSize = null;
	public UnionFind002(int N)
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
}


//路径压缩quick-union算法
class UnionFind003 extends UnionFinder
{
	int[] treeSize = null;
	
	public UnionFind003(int N)
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
}