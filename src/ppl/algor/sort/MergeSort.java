package ppl.algor.sort;

import java.util.Arrays;

/**
 * 归并排序
 * o(NlgN)
 * @author Smith
 *
 */
public class MergeSort extends SortFrame
{
	private Comparable[] ori = null;
	private int factor = 8;   
	
	@Override
	public void sort(Comparable[] a)
	{
		ori = new Comparable[a.length];
		partSort(a, 0, a.length-1);
	}
	
	private void partSort(Comparable[] a, int left, int right)
	{
		if (left >= right)
			return;
		int mid = (left+right)/2;
		partSort(a, left, mid);
		partSort(a, mid+1, right);
		merge(a, left, mid, right);
	}
	private void merge(Comparable[] a, int left, int mid, int right)
	{
		if (less(a[mid],a[mid+1]))
			return;
		
		int i = left; 
		int j = mid+1;
		for (int k=left; k<=right; k++)
		{
			ori[k] = a[k];
			ifCounter++;
		}
		for(int k=left; k<=right; k++)
		{
			ifCounter += 2;
			if(i >= mid+1) {a[k] = ori[j++]; continue;}
			if(j >= right+1) {a[k] = ori[i++]; continue;}
			if(less(ori[i],ori[j]))
			{
				a[k] = ori[i++];
			}
			else
			{
				a[k] = ori[j++];
			}
		}
	}

	@Override
	public String getTag()
	{
		return "SORT004-merge sort";
	}
}
