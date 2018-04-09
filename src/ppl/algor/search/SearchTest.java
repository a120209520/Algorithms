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
		//st.getCounter();
		System.out.println(st.size());
	}
	public static void speedTest()
	{
		//freqCounter(new BinarySearchST<String,Integer>(), "tale.txt");
		
		//单次RedBlackTree的插入可能会比BST慢
		freqCounter(new BST<String,Integer>(), "leipzig1M.txt");
		freqCounter(new RedBlackTree<String, Integer>(), "leipzig1M.txt");
	}
	public static void speedTest2()
	{
		//按升序插入效果明显
		BST<Integer,Integer> bst = new BST<>();
		RedBlackTree<Integer, Integer> rbt = new RedBlackTree<>();
		tc.start("BST");
		for(int i=0; i<10000; i++)
		{
			bst.put(i, i);
			rbt.get(i);
		}
		tc.stop();
		tc.start("RBT");
		for(int i=0; i<10000; i++)
		{
			rbt.put(i, i);
			rbt.get(i);
		}
		tc.stop();
	}
	public static void basic()
	{
		//BST<String,Integer> bst = new BST<>();
		RedBlackTree<String, Integer> bst = new RedBlackTree<>();

		bst.put("b", 1);
		bst.put("d", 2);
		bst.put("e", 3);
		bst.put("a", 4);
		bst.print();
	}
	public static void main(String[] args)
	{
		//freqCounterHashMap("tinyTale.txt");
		//freqCounter(new SequenSearchST<String,Integer>(), "tinyTale.txt");
		//freqCounter(new BinarySearchST<String,Integer>(10000), "tinyTale.txt");
		//basic();
		speedTest();
	}
}
