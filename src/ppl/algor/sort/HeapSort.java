package ppl.algor.sort;

public class HeapSort extends SortFrame
{
	@Override
	public void sort(Comparable[] a)
	{
		int N = a.length;
		//1.创建堆
		for (int i=N/2; i>=1; i--)
		{
			down(a, i, N);
		}
		//2.堆排序
		while(N > 1)
		{
			exch(a, 1-1, N-1);
			N--;
			down(a, 1, N);
		}
	}
	//a基于[0,N-1]，而堆基于[1,N]，在函数调用处-1
	private void down(Comparable[] a, int k, int N)
	{
		int j = 0;
		while (2*k<=N)
		{
			j = 2*k;
			assignC++;
			lessC++;
			if (j<N && less(a[j -1], a[j+1 -1]))
				j++;
			if (!less(a[k -1], a[j -1]))
				break;
			exch(a, k -1, j -1);exchC++; 
			k = j;
		}
	}
	
	@Override
	public String getTag()
	{
		return "SORT007-heap sort";
	}
}
