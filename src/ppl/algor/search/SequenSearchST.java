package ppl.algor.search;

/**
 * 1.基于链表的符号表
 * 插入: o(N)
 * 查找: o(N)
 * @author Smith
 *
 * @param <K>
 * @param <V>
 */
public class SequenSearchST<K,V> extends SymbolTable<K, V>
{
	private Node head;
	private class Node
	{
		K key;
		V val;
		Node next;
		public Node(K key, V val, Node next)
		{
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	
	public SequenSearchST()
	{
		size = 0;
		head = null;
	}
	@Override
	public void put(K key, V val)
	{
		Node temp = head;
		for(int i=0; i<size; i++)
		{
			compC++;
			if(temp.key.equals(key))
			{
				temp.val = val;
				return;
			}
			temp = temp.next;
		}
		head = new Node(key, val, head);
		size++;
	}

	@Override
	public V get(K key)
	{
		Node temp = head;
		for(int i=0; i<size; i++)
		{
			compC++;
			if(temp.key.equals(key))
			{
				return temp.val;
			}
			temp = temp.next;
		}
		return null;
	}

	@Override
	public void delete(K key)
	{
		if(size == 0)
		{
			return;
		}
		if(head.key.equals(key))
		{
			head = head.next;
			size--;
			return;
		}
		Node temp = head;
		for(int i=0; i<size; i++)
		{
			compC++;
			if(temp.next.key.equals(key))
			{
				temp.next = temp.next.next;
				size--;
			}
		}
	}
	
	@Override
	public void print()
	{
		if(size == 0)
		{
			System.out.println("null");
			return;
		}
		Node temp = head;
		for(int i=0; i<size; i++)
		{
			System.out.printf("[%s|%s]->",temp.key, temp.val);
			temp = temp.next;
			if(i%5==4)
				System.out.println();
		}
		System.out.println();
	}
	
	@Override
	public String getTag()
	{
		return "SEARCH001-sequenST";
	}
}
