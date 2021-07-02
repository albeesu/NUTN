package spider;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;


public class spider extends Thread{
	private static final int MAX_PAGES_TO_SEARCH = 50;
    private Set<String> pagesVisited = new HashSet<String>();
    private List<String> pagesToVisit = new LinkedList<String>();
    private static final int count=0;
    public static int num=1;//頁數
    public static LinkedList<database> data=new LinkedList<database>();//儲存現在紀錄
    public static Set<hashdata> data2 = new LinkedHashSet<hashdata>();//有順序的儲存過去紀錄
    int exceedtime=600000;//限制資料保存的時間(毫秒計算)
    public void run() {
    	try {
			search(Main.url,Main.search);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void search(String url, String searchWord) throws IOException   {
    	Spide.textArea.append("\n searching for the word"+searchWord+"...");
    	int e=0;
    	int c1=0;
    	int c2=0;
    	int e1=0;
    	int exist1=0;
    	data.clear();
    	ArrayList<hashdata> array2 = new ArrayList<hashdata>(data2);
    	
    	for(hashdata array1 : array2){
    		//先刪除過期的資料
    		int s=0;
    		System.out.println("資料"+array1.keyword+(Spide.t1-array1.time1));
    		if((Spide.t1-array1.time1)>exceedtime) {
    			data2.remove(array1);//超過時間限制就刪除
    			s=1;
    		}
    		if(s==0) {
    			System.out.println(array1.select+"abc"+Spide.select1);
    			if(array1.keyword.equals(searchWord) && array1.select==Spide.select1) {//搜尋到重複的就直接拿過去的資料
    				for(int i=0;i<array1.data.size();i++) {
    					database newdata2 = array1.data.get(i);//資料
    					newdata2.setname(searchWord, array1.data.get(i).link,array1.data.get(i).title,array1.data.get(i).rank,array1.data.get(i).rank);//儲存資料
    					data.add(newdata2);//儲存資料
    				}
    				exist1=1;
    			}
    			//Spide.textArea.append("\n*Done* Visited " + data.size() + " web page(s)");
    		}
    	}
    	 
        while(pagesVisited.size() < MAX_PAGES_TO_SEARCH)    {//搜尋介面超過MAX_PAGES_TO_SEARCH就停止搜尋 或是超過30個成功頁面也是停止
            if(exist1==1) {
            	System.out.println("不需要迴圈了");
            	break;
            }
        	String currentUrl;
            database newdata2=new database();//儲存資料
            spiderleg leg = new spiderleg();
            if(this.pagesToVisit.isEmpty())  {
                currentUrl = url;
                pagesVisited.add(url);
            }
            else  {  
            	currentUrl = nextUrl(); 
            }
            
            leg.crawl(currentUrl); 
            
            boolean success = leg.searchforword(searchWord);
            
            Document doc = Jsoup.connect(url).get();
    		Elements linksOnPage = doc.select("a[href]");
            if(success)  {
            	String temptext="";
        		int i=0;
    			for(Element link : linksOnPage) {
    				if(i==c2) {
    					temptext=link.text();
    	            	database newdata=new database();//儲存資料
    	            	int cau=((2*spiderleg.number*5*(30-e1))/((30-e1)+(spiderleg.number*5)));
    	        	    newdata.setname(searchWord, currentUrl,spiderleg.content,spiderleg.number,cau);//儲存資料
    	        		data.add(newdata);//儲存資料
    	        		e1++;    	   
    					break;
    				}
    				i++;
    				if(e1>30) {
            			break;
            		}
    			}  	
        		c1++;
        		
                //break;  
        		
             }
            c2++;
            pagesToVisit.addAll(leg.getLinks());
            
        }
        if(data.size()==0) {
        	Spide.textArea.append("找不到任何相關頁面");
        }
        
        
        
        if(exist1==0) {//如果是前面過去所沒有的資料，那就會進入此儲存階段
        	Collections.sort (data, new database());
            hashdata hash=new hashdata();
            hash.sethashset(searchWord, data);
            data2.add(hash);//儲存hashset(搜尋字跟排序過後的datalink)
        }
        
        
        for(int i=0;i<data.size();i++) {//印出搜尋後與排序後的前十筆資料
			database newdata2 = data.get(i);//資料
			Spide.textArea.append("\n"+(i+1)+":");
			num=1;
        	newdata2.getname();
        	if(i>8) {
        		break;
        	}
		}
        
        
    }

   

    private String nextUrl()   {
        String nextUrl;
        do {
            nextUrl = pagesToVisit.remove(0);
        } while(pagesVisited.contains(nextUrl));
        pagesVisited.add(nextUrl);
        return nextUrl;
    }

    
	public spider() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
