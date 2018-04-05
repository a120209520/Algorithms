package ppl.algor.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ppl.algor.struct.PairInt;

public class FileDataIO
{
	private static String dataPath = "G:/OneDrive/Study/Java/lib/Alib/algs4-data/";
	static TimeCounter tc = new TimeCounter();
	public static int[] loadInt(String fileName)
	{	
		File f = new File(dataPath+fileName);
		BufferedReader br = null;
		List<Integer> ls = new ArrayList<>();
		String temp = null;
		try
		{
			br = new BufferedReader(new FileReader(f));
			while (null != (temp=br.readLine()))
			{
				ls.add(Integer.parseInt(temp.trim()));
			}
			Integer[] arr = new Integer[ls.size()];
			arr = ls.toArray(arr);
			int[] res = unboxInt(arr);
			return res;
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			return null;
		} catch (IOException e)
		{
			e.printStackTrace();
			return null;
		} finally
		{
			CloseUtil.closeAll(br);
		}
	}
	
	public static PairInt[] loadPairInt(String fileName)
	{	
		File f = new File(dataPath+fileName);
		BufferedReader br = null;
		List<PairInt> ls = new ArrayList<>();
		String temp = null;
		int size = 0;
		try
		{
			br = new BufferedReader(new FileReader(f));
			size = Integer.parseInt(br.readLine().trim());
			for(int i=0; i<size; i++)
			{
				temp = br.readLine().trim();
				String[] s = temp.split(" ");
				PairInt pi = new PairInt(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
				ls.add(pi);
			}
			PairInt[] arr = new PairInt[ls.size()];
			arr = ls.toArray(arr);
			return arr;
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			return null;
		} catch (IOException e)
		{
			e.printStackTrace();
			return null;
		} finally
		{
			CloseUtil.closeAll(br);
		}
	}
	
	private static int[] unboxInt(Integer[] arr)
	{
		int[] res = new int[arr.length];
		for(int i=0; i<arr.length; i++)
		{
			res[i] = arr[i];
		}
		return res;
	}
		
	public static void main(String[] args)
	{
		tc.start();
		//loadInt("largeW.txt");
		//loadPairInt("tinyUF.txt");
		tc.stop();
	}
}










