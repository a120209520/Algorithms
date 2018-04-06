package ppl.algor.sort;

/**
 * 选择排序
 * compare: N^2/2
 * exchange: N
 * o(N^2)
 * @author Smith
 *
 */
public class SelectSort extends SortFrame
{
	@Override
	public void sort(Comparable[] a)
	{
		int N = a.length;
		for (int i=0; i<N; i++)
		{
			int min = i;
			for(int j=i+1; j<N; j++)
			{
				lessC++;
				if(less(a[j],a[min]))
				{
					min = j;
				}
			}
			exch(a, i, min);exchC++;
		}
	}

	@Override
	public String getTag()
	{
		return "SORT001-select sort";
	}
}
