package spider;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;

public class hashdata {
	
	String keyword;
	String link;
	String title;
	long time1;
	int num;
	int rank;
	int select;
	LinkedList<database> data=new LinkedList<database>();
	public void sethashset(String keyword,LinkedList<database> data2) {
		//this.data=data;
		for(int i=0;i<data2.size();i++) {
			database newdata2 = data2.get(i);//資料
        	data.add(newdata2);
		}
		this.keyword=keyword;
		time1=System.currentTimeMillis();
		//System.out.println(keyword+"的儲存時間"+time1);
		select=Spide.select1;
	}
	public void getdatalink() {//印出LinkedList資料
		for(int i=0;i<data.size();i++) {
			database newdata2 = data.get(i);//資料
			Spide.textArea.append("\n關鍵字:"+newdata2.title+"\n文章地址:"+newdata2.link+"\n相似度:"+newdata2.num+" rank:"+newdata2.rank);
		}
	}
	@Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.keyword);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {//重複值的判斷 這裡是以搜尋字為判斷
        if (obj == null) {
            return false;
        }
        final hashdata other = (hashdata) obj;
        if (!Objects.equals(this.keyword,other.keyword)) {
            return false;
        }
        if (!Objects.equals(this.select,other.select)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString()  {
    	for(int i=0;i<data.size();i++) {
			database newdata2 = data.get(i);//資料
			Spide.textArea.append("\n關鍵字:"+newdata2.title+"\n文章地址:"+newdata2.link+"\n相似度:"+newdata2.num+"rank:"+newdata2.rank);
		}
    	return String.format("");
    }
    
	public hashdata() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
