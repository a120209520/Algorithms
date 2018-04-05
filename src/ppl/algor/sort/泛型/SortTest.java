package ppl.algor.sort;

import ppl.algor.util.FileDataIO;
import ppl.algor.util.TimeCounter;

public class SortTest
{
	static TimeCounter tc = new TimeCounter();
	public static void basic(SortFrame<Integer> sf, String file)
	{
		Integer[] a = FileDataIO.loadInteger(file);
		tc.start(sf.getTag());
		sf.sort(a);
		tc.stop();
		assert SortFrame.<Integer>isSorted(a);
		//sf.show(a);
		sf.getCounter();
	}
	public static void main(String[] args)
	{
		//TinyW.txt < 1Kints.txt < 32Kints.txt < largeW.txt
		basic(new SelectSort<Integer>(), "32Kints.txt");
		basic(new InsertSort<Integer>(), "32Kints.txt");
		//basic(new InsertSort<Integer>(), "largeW.txt"); //too long
		//basic(new ShellSort<Integer>(), "largeW.txt"); //too long
		basic(new ShellSort<Integer>(), "32Kints.txt");
	}
}
