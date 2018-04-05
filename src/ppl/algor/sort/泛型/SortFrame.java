package ppl.algor.sort;

public abstract class SortFrame<T>
{
	 long counter = 0;
	abstract void sort(Comparable<T>[] a);
	abstract String getTag();
	public void show(Comparable<T>[] a)
	{
		for(Comparable<T> c:a)
		{
			System.out.print(c+" ");
		}
		System.out.println();
	}
	public long getCounter()
	{
		System.out.println(getTag()+counter);
		return counter;
	}
	protected static <T> boolean less(Comparable<T> x, Comparable<T> y)
	{
		return x.compareTo((T)y) < 0;
	}
	protected static <T> void exch(Comparable<T>[] a, int i, int j)
	{
		Comparable<T> t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static <T> boolean isSorted(Comparable<T>[] a)
	{
		for (int i=0; i<a.length-1; i++)
		{
			if (a[i].compareTo((T)a[i+1]) > 0)
				return false;
		}
		return true;
	}
}
