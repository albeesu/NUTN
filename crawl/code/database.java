package spider;

import java.util.Comparator;
import java.util.Objects;

public class database implements Comparator<database>{
	//LinkedList<grade> grade2=new LinkedList<grade>();
	String keyword;
	String link;
	String title;
	
	int num;
	int rank;
	public database() {
		// TODO Auto-generated constructor stub
		
		
	}
	public database(String keyword, String link, String title, int num, int rank) {
		// TODO Auto-generated constructor stub
		this.keyword=keyword;
		this.link=link;
		this.title=title;
		this.num=num;
		this.rank=rank;
		//time1=System.currentTimeMillis();
	}
	
	public void setname(String keyword,String link,String title,int num,int rank) {
		this.keyword=keyword;
		this.link=link;
		this.title=title;
		this.num=num;
		this.rank=rank;
		//time1=System.currentTimeMillis();
	}
	public void getkey() {
		Spide.textArea.append(keyword);
	}
	public void getname() {
		Spide.textArea.append("關鍵字:"+title+"\n文章地址:"+link+"\n相似度:"+num+" rank:"+rank+"\n");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	@Override
	public int compare(database o1, database o2) {
		// TODO Auto-generated method stub
		return (o2 . rank -o1. rank ); //依照順序高的排列下來
		
	}
	
    @Override
    public String toString()  {
        return String.format("\n關鍵字:"+title+"\n文章地址:"+link+"\n相似度:"+num+"rank:"+rank);
    }

}
