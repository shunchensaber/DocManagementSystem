package Bean;

import javax.xml.stream.events.EndDocument;

public class Dividepage {
	
	public int totalpage;
	public int pagecontain = 5;
	int pages;
	public Dividepage(int totalpage)
	{
		this.totalpage = totalpage;
		pages = totalpage/pagecontain;
		pages+=totalpage%pagecontain==0?0:1;
		
	}
	public void ini(int totalpage)
	{
		this.totalpage = totalpage;
		pages = totalpage/pagecontain;
		pages+=totalpage%pagecontain==0?0:1;
		
	}
	public int getpages()
	{
		return pages;
	}
	public int[] getStartend(int index)
	{
		int start = (index-1)*pagecontain;
		int end;
		if(index*pagecontain>totalpage)
		{
			end = totalpage;
		}
		else {
			end = index*pagecontain;
		}
		System.out.println("start"+start+"end"+end);
		return new int[] {start,end};
		
	}
	
	

}
