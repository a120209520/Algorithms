package ppl.algor.util;

public class TimeCounter
{
	private long startTime = 0;
	private long endTime = 0;
	private String tag;
	public void start(String tag)
	{
		this.tag = tag;
		startTime = System.currentTimeMillis();
	}
	public void start()
	{
		this.tag = "noName";
		startTime = System.currentTimeMillis();
	}
	public void stop()
	{
		endTime = System.currentTimeMillis();
		System.out.println("["+tag+"]:"+(endTime-startTime)+"ms");
	}
}
