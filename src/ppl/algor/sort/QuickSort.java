package ppl.algor.sort;

import java.util.Arrays;

/**
 * 快速排序
 * o(NlgN)
 * @author Smith
 *
 */
public class QuickSort extends SortFrame
{
	@Override
	public void sort(Comparable[] a)
	{
		partSort(a, 0, a.length-1);
	}
	
	private void partSort(Comparable[] a, int left, int right)
	{
		if (left >= right)
			return;
		int key = findKey(a, left, right);
		partSort(a, left, key-1);
		partSort(a, key+1, right);
	}
	private int findKey(Comparable[] a, int left, int right)
	{
		int i = left;
		int j = right+1;
		Comparable key = a[left];
		while(true)
		{
			while(lesse(a[++i],key))
			{
				lessC++;
				if (i>=right)
					break;
			}
			while(lesse(key,a[--j]))
			{
				lessC++;
				if (j<=left)
					break;
			}
			if (i >= j)
				break;
			exch(a, i, j);exchC++;
		}
		exch(a, left, j);exchC++;
		return j;
	}

	@Override
	public String getTag()
	{
		return "SORT005-quick sort";
	}
}
