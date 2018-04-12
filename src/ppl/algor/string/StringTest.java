package ppl.algor.string;

import java.util.Arrays;
import java.util.Random;

import ppl.algor.sort.QuickSort;
import ppl.algor.util.TimeCounter;

public class StringTest
{
	static TimeCounter tc = new TimeCounter();
	public static String getRandomStr(int length) 
	{
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";
	    int randomNum;
	    char randomChar;
	    Random random = new Random();
        StringBuffer str = new StringBuffer();
 
        for (int i = 0; i < length; i++) 
        {
	        randomNum = random.nextInt(base.length());
	        randomChar = base.charAt(randomNum);
	        str.append(randomChar);
	    }
	    return str.toString();
    }
	public static String[] getRandomStrs(int size)
	{
		String[] strs = new String[size];
		for(int i=0; i<size; i++)
		{
			Random rd = new Random();
			int len = Math.abs(rd.nextInt()%100);
			strs[i] = getRandomStr(len);
		}
		return strs;
	}
	public static void speedTest()
	{
		String[] strs = getRandomStrs(10000);
		tc.start("QuickSort");
		new QuickSort().sort(strs);
		tc.stop();
		tc.start("MSD");
		MSD.sort(strs, MSD.ASCII);
		tc.stop();
		//差别好大
	}
	public static void main(String[] args)
	{
		speedTest();
	}
}
