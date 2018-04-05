package ppl.algor.sort;

public class ShellSort<T> extends SortFrame<T>
{
	@Override
	public void sort(Comparable<T>[] a)
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
				for (int j=i; j>=h; j-=h)
				{
					counter++;
					if (less(a[j],a[j-h]))
					{
						SortFrame.<T>exch(a, j, j-h);
						counter++;
					}
					else
					{
						break;
					}
				}
			}
			h = h/3;
		}
	}

	@Override
	String getTag()
	{
		return "SORT003-shell sort";
	}
}
