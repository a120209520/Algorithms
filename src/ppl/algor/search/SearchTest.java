package ppl.algor.search;

import java.util.HashMap;
import java.util.Map;

import ppl.algor.util.FileDataIO;
import ppl.algor.util.TimeCounter;

public class SearchTest
{
	static TimeCounter tc = new TimeCounter();
	public static void freqCounterHashMap(String file)
	{
		String[] words = FileDataIO.loadWords(file);
		Map<String,Integer> map = new HashMap<>();
		tc.start("SEARCH000-HashMap");
		String max = "";
		map.put(max, 0);
		for(String word:words)
		{
			if(map.containsKey(word))
			{
				map.put(word, map.get(word)+1);
				if(map.get(word) > map.get(max))
				{
					max = word;
				}
			}
			else
			{
				map.put(word, 1);
			}
		}
		tc.stop();
		System.out.println(max+":"+map.get(max));
	}
	public static void freqCounter(SymbolTable<String,Integer> st, String file)
	{
		String[] words = FileDataIO.loadWords(file);
		tc.start(st.getTag());
		String max = "";
		st.put(max, 0);
		for(String word:words)
		{
			if(st.containsKey(word))
			{
				st.put(word, st.get(word)+1);
				if(st.get(word) > st.get(max))
				{
					max = word;
				}
			}
			else
			{
				st.put(word, 1);
			}
		}
		tc.stop();
		System.out.println(max+":"+st.get(max));
		//st.print();
		st.getCounter();
	}
	public static void speedTest()
	{
		freqCounter(new BinarySearchST<String,Integer>(), "tale.txt");
		freqCounter(new BST<String,Integer>(), "tale.txt");
	}
	public static void basic()
	{
		BST<String,Integer> bst = new BST<>();
		bst.put("b", 0);
		bst.put("d", 0);
		bst.put("e", 0);
		System.out.println(bst.rank("a"));
		System.out.println(bst.rank("b"));
		System.out.println(bst.rank("c"));
		System.out.println(bst.rank("e"));
	}
	public static void main(String[] args)
	{
		//freqCounterHashMap("tinyTale.txt");
		//freqCounter(new SequenSearchST<String,Integer>(), "tinyTale.txt");
		//freqCounter(new BinarySearchST<String,Integer>(10000), "tinyTale.txt");
		basic();
		//speedTest();
	}
}
