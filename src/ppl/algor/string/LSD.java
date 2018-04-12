package ppl.algor.string;

import java.util.Arrays;

/**
 * 1. 低位优先字符串排序
 * @author Smith
 *
 */
public class LSD
{
	public static final int ASCII = 128;
	public static final int ASCII_EX = 256;
	public static final int UNICODE16 = 65536;
	public static void sort(String[] strs, int R)
	{
		int N = strs.length;
		if(0 == N)
			return;
		int W = strs[0].length();
		String[] temp = new String[N];
		for(int d=W-1; d>=0; d--)
		{
			int[] count = new int[R+1];
			for(int i=0; i<N; i++)
				count[strs[i].charAt(d)+1]++;
			for(int i=0; i<R; i++)
				count[i+1] += count[i];
			for(int i=0; i<N; i++)
				temp[count[strs[i].charAt(d)]++] = strs[i];
			for(int i=0; i<N; i++)
				strs[i] = temp[i];
		}
	}
	public static void main(String[] args)
	{
		String[] a = {"abd","dfa","aaa","bbb"};
		LSD.sort(a, LSD.ASCII);
		System.out.println(Arrays.toString(a));
	}
}
