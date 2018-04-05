package ppl.algor.sort;

/**
 * 希尔排序
 * o(N^1.3)
 * @author Smith
 *
 */
public class ShellSort extends SortFrame
{
	@Override
	public void sort(Comparable[] a)
	{
		int N = a.length;
		int h = 1;
		while(h < N/3) 
		{
			h = h*3 + 1;
		}
		while(h >= 1)
		{
			for(int i=h; i<N; i++)
			{
				for (int j=i; j>=h && less(a[j],a[j-h]); j-=h)
				{
					ifCounter++;
					exchCounter++;
					SortFrame.exch(a, j, j-h);
				}
			}
			h = h/3;
		}
	}

	@Override
	public String getTag()
	{
		return "SORT003-shell sort";
	}
}
