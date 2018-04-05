package ppl.algor.sort;

public class InsertSort<T> extends SortFrame<T>
{
	@Override
	public void sort(Comparable<T>[] a)
	{
		for (int i=1; i<a.length; i++)
		{
			for (int j=i; j>0; j--)
			{
				counter++;
				if (less(a[j],a[j-1]))
				{
					counter++;
					SortFrame.<T>exch(a, j-1, j);
				}
				else 
				{
					break;
				}
			}
		}
	}

	@Override
	String getTag()
	{
		return "SORT002-insert sort";
	}
}
