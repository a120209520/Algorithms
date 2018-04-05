package ppl.algor.util;

public class MathTest
{
	public static void Test01()
	{
		int i = 1;
		while(i<1000)
		{
			double a = Math.pow((double)i, 1.3);
			double b = i*(Math.log(i)/Math.log(2));
			System.out.println(a+"/"+b);
			if (a<b)
			{
				System.out.println(i);
				//break;
			}
			i++;
		}
	}
	public static void main(String[] args)
	{
		Test01();
	}
}
