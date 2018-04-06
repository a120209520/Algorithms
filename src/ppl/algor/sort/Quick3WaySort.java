package ppl.algor.sort;

/**
 * 快速排序:三向切分，适用于有重复对象的数据
 * o(NlgN)
 * @author Smith
 *
 */
public class Quick3WaySort extends SortFrame
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
		int i = left, eq = left+1, j = right;
		Comparable k = a[left];
		int cmp = 0;
		while(eq<=j)
		{
			lessC++;
			cmp = a[eq].compareTo(k);
			if (cmp > 0)
			{
				exch(a, eq, j--);exchC++;
			}
			else if(cmp < 0)
			{
				exch(a, i++, eq++);exchC++;
			}
			else
			{
				eq++;
			}
		}
		partSort(a, left, i-1);
		partSort(a, j+1, right);
	}

	@Override
	public String getTag()
	{
		return "SORT006-quick 3way sort";
	}
}
