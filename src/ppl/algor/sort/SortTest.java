package ppl.algor.sort;

import java.util.Arrays;

import ppl.algor.util.FileDataIO;
import ppl.algor.util.TimeCounter;

public class SortTest
{
	static TimeCounter tc = new TimeCounter();
	public static void basic(SortFrame sf, String file)
	{
		Integer[] a = FileDataIO.loadInteger(file);
		tc.start(sf.getTag());
		sf.sort(a);
		tc.stop();
		assert SortFrame.isSorted(a);
		//sf.show(a);
		sf.getCounter();
	}
	public static void speedTest()
	{
		//TinyW.txt < 1Kints.txt < 32Kints.txt < largeW.txt
		
		//32Kints
//		basic(new SelectSort(), "32Kints.txt");
//		basic(new InsertSort(), "32Kints.txt");
//		basic(new ShellSort(), "32Kints.txt");
//		basic(new MergeSort(), "32Kints.txt");
		//largeW.txt
		basic(new ShellSort(), "largeW.txt");
		basic(new MergeSort(), "largeW.txt");
		basic(new QuickSort(), "largeW.txt");
		basic(new Quick3WaySort(), "largeW.txt");
		basic(new HeapSort(), "largeW.txt");
	}
	public static void main(String[] args)
	{
		//basic(new MergeSort(), "TinyW.txt");
		//basic(new ShellSort(), "MyTinyInt.txt");
		//basic(new MergeSort(), "largeW.txt");
		//basic(new QuickSort(), "largeW.txt");
		//basic(new Quick3WaySort(), "largeW.txt");
		speedTest();
	}
}
