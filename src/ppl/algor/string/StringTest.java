package ppl.algor.string;

import java.util.Iterator;
import java.util.Random;

import ppl.algor.sort.QuickSort;
import ppl.algor.sort.SortFrame;
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
		String[] strs = getRandomStrs(1000000);
		tc.start("QuickSort");
		new QuickSort().sort(strs);
		tc.stop();
		assert SortFrame.isSorted(strs);
		
		strs = getRandomStrs(1000000);
		tc.start("MSD");
		MSD.sort(strs, MSD.ASCII);
		tc.stop();
		assert SortFrame.isSorted(strs);
	}
	public static void TrieTest()
	{
		TrieST<Integer> st = new TrieST<>(TrieST.ASCII_EX);
		st.put("adfa", 1);
		st.put("bgfd", 2);
		st.put("adgg", 3);
		st.put("adfad", 4);
		st.delete("adfa");
		//System.out.println(st.get("a"));
		Iterator<String> itr = null;
		itr = st.keys().iterator();
		//itr = st.keysWithPrefix("ad").iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
	}
	public static void TSTTest()
	{
		TST<Integer> st = new TST<>();
		st.put("adfa", 1);
		st.put("bgfd", 2);
		st.put("adgg", 3);
		st.put("adfad", 4);
		System.out.println(st.get("adfa"));
	}
	public static void main(String[] args)
	{
		//speedTest();
		//TrieTest();
		TSTTest();
	}
}
