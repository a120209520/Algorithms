package ppl.algor.sort;

/**
 * 插入排序
 * compare: N^2/4 (avg)
 * exchange: N^2/4 (avg)
 * o(N^2)
 * @author Smith
 *
 */
public class InsertSort extends SortFrame
{
	//方式1：逐个交换，效率较低
	/* 
	@Override
	public void sort(Comparable[] a)
	{
		int N = a.length;
		if (N <= 1)
			return;
		for (int i=1; i<N; i++)
		{
			for (int j=i; j>0 && less(a[j],a[j-1]); j--)
			{
				lessCounter++;
				exchCounter++;
				SortFrame.exch(a, j-1, j);
			}
		}
	}*/

	//方式2：记录后移，效率较高
	@Override
	public void sort(Comparable[] a)
	{
		int N = a.length;
		if (N <= 1)
			return;
		for (int i=1; i<N; i++)
		{
			Comparable t = a[i];
			int j;
			for (j=i; j>0 && less(t,a[j-1]); j--)
			{
				lessC++;
				assignC++;
				a[j] = a[j-1]; //赋值耗时跟less时间差不多		 	
			}   
			assignC++;
			a[j] = t;
		}
	}
	
	@Override
	public String getTag()
	{
		return "SORT002-insert sort";
	}
}
