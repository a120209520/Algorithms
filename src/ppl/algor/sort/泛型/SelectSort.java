package ppl.algor.sort;

public class SelectSort<T> extends SortFrame<T>
{
	@Override
	public void sort(Comparable<T>[] a)
	{
		for (int i=0; i<a.length; i++)
		{
			int min = i;
			for(int j=i+1; j<a.length; j++)
			{
				counter++;
				if(less(a[j],a[min]))
				{
					min = j;
				}
			}
			counter++;
			SortFrame.<T>exch(a, i, min);	
		}
	}

	@Override
	String getTag()
	{
		return "SORT001-select sort";
	}
}
