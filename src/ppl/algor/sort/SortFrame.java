package ppl.algor.sort;

import ppl.algor.util.TimeCounter;

public abstract class SortFrame
{
	long lessC = 0;
	long exchC = 0;
	long assignC = 0;
	public abstract void sort(Comparable[] a);
	public abstract String getTag();
	public void show(Comparable[] a)
	{
		for(Comparable c:a)
		{
			System.out.print(c+" ");
		}
		System.out.println();
	}
	public long getCounter()
	{
		System.out.println("[less]:"+lessC+"[assign]:"+assignC+"[exch]:"+exchC);
		System.out.println("[total]:"+(lessC+assignC+exchC*2));
		return lessC+assignC+exchC*2;
	}
	
	protected static boolean less(Comparable x, Comparable y)
	{
		return x.compareTo(y) < 0;
	}
	
	protected static boolean lesse(Comparable x, Comparable y)
	{
		return x.compareTo(y) <= 0;
	}
	
	protected static void exch(Comparable[] a, int i, int j)
	{
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static boolean isSorted(Comparable[] a)
	{
		for (int i=0; i<a.length-1; i++)
		{
			if (a[i].compareTo(a[i+1]) > 0)
				return false;
		}
		return true;
	}
	
	/*
	  [less]:3725ms
	  [exch]:6816ms
	  [assign]:3408ms
	 */
	public static void main(String[] args)
	{
	}
}
