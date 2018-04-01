package ppl.algor.basic;

import java.util.Arrays;

import ppl.algor.util.FileIO;
import ppl.algor.util.TimeCounter;

public class BinarySearch
{
	public static long counter = 0; //记录效率
	static TimeCounter tc = new TimeCounter();
	
	private static int binarySearch(int[] arr, int key)
	{
		int left = 0;
		int right = arr.length - 1;
		int mid = 0;
		while(left <= right)
		{
			counter++;
			mid = left + (right-left)/2;
			if(key < arr[mid])
			{
				right = mid - 1;
			}
			else if(key > arr[mid])
			{
				left = mid + 1;
			}
			else
			{
				return mid;
			}
		}
		return -1;
	}
	public static void basic()
	{
		tc.start("load");
		int[] arr = FileIO.loadInt("largeW.txt");
		Arrays.sort(arr);
		tc.end();
		tc.start("search");
		System.out.println(binarySearch(arr,141720));
		tc.end();
		System.out.println(counter);
	}
	public static void main(String[] args)
	{
		basic();
	}
}


