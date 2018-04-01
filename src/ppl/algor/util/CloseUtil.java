package ppl.algor.util;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtil
{
	public static void closeAll(Closeable... clos)
	{
		for(Closeable c:clos)
		{
			try
			{
				c.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
