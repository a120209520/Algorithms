package ppl.algor.string;

import java.util.Arrays;

import ppl.algor.sort.InsertSort;

/**
 * 2. 高位优先字符串排序
 * o(N) = wN , 其中w为字符串平均长度
 * 适用于R比较小的情况
 * @author Smith
 *
 */
public class MSD
{
	public static final int ASCII = 128;
	public static final int ASCII_EX = 256;
	public static final int UNICODE16 = 65536;
	public static void sort(String[] strs, int R)
	{
		sort(strs, R, 0, strs.length-1, 0);
	}
	private static void sort(String[] strs, int R, int left, int right, int d)
	{
		int N = right - left + 1;
		if (N <= 1)
			return;
		if (N < 2)
		{
			new InsertSort().sort(strs);
			return;
		}
		String[] temp = new String[N];
		int[] count = new int[R+2];
		for(int i=left; i<=right; i++)
			count[charAt(strs[i],d)+2]++;
		for(int i=0; i<R+1; i++)
			count[i+1] += count[i];
		for(int i=left; i<=right; i++)
			temp[count[charAt(strs[i],d)+1]++] = strs[i];
		for(int i=left; i<=right; i++)
			strs[i] = temp[i-left];
		
		for(int i=0; i<R; i++)
		{
			sort(strs, R, left+count[i], left+count[i+1]-1, d+1);
		}
	}
	private static int charAt(String str, int i)
	{
		if(i >= str.length())
			return -1;
		return (int)str.charAt(i);
	}
	public static void main(String[] args)
	{
		String[] a = {"abfdaf","dfgfdagda","aaqerqdsafa","bfdsafdbb"};
		MSD.sort(a, MSD.ASCII);
		System.out.println(Arrays.toString(a));
	}
}
