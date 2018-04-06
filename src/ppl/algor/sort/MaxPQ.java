package ppl.algor.sort;

public class MaxPQ<K extends Comparable<K>>
{
	private K[] pq;
	private int N = 0;  //only [1,N] is valid
	
	public MaxPQ(int max)
	{
		pq = (K[])new Comparable[max+1];
	}
	public int size()
	{
		return N;
	}
	public void insert(K k)
	{
		N++;
		pq[N] = k;
		up(N);
	}
	public K delMax()
	{
		K max = pq[1];
		pq[1] = pq[N];
		pq[N--] = null;
		down(1);
		return max;
	}
	
	private boolean less(int i, int j)
	{
		return pq[i].compareTo(pq[j]) < 0;
	}
	private void exch(int i, int j)
	{
		K temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}
	private void up(int k)
	{
		while (k>1 && less(k/2, k))
		{
			exch(k/2, k);
			k = k/2;
		}
	}
	private void down(int k)
	{
		int j = 0;
		while (2*k<=N)
		{
			j = 2*k;
			if (j<N && less(j, j+1))
				j++;
			if (!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}
}









