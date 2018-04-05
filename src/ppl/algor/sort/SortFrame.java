package ppl.algor.sort;

import ppl.algor.util.TimeCounter;

public abstract class SortFrame
{
	long ifCounter = 0;
	long exchCounter = 0;
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
		System.out.println("[less]:"+ifCounter+"[exch]:"+exchCounter);
		System.out.println("[total]:"+(ifCounter+exchCounter*2));
		return ifCounter+exchCounter*2;
	}
	//执行10^10次[less]:3852ms
	protected static boolean less(Comparable x, Comparable y)
	{
		return x.compareTo(y) < 0;
	}
	//执行10^10次[exch]:6996ms，1次exch相当于2次less
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
		/*
		TimeCounter tc = new TimeCounter();
		int a = 0; 
		int b = 1;
		tc.start("less");
		for (long i=0; i<10000000000L; i++)
		{
			if(a>b)
			{
				
			}
		}
		tc.stop();
		tc.start("exch");
		for (long i=0; i<10000000000L; i++)
		{
			int t = a;
			a = b;
			b = t;
		}
		tc.stop();
		tc.start("assign");
		for (long i=0; i<10000000000L; i++)
		{
			a = b;
		}
		tc.stop();
		*/
	}
}
