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
    public static int num=1;//����
    public static LinkedList<database> data=new LinkedList<database>();//�x�s�{�b����
    public static Set<hashdata> data2 = new LinkedHashSet<hashdata>();//�����Ǫ��x�s�L�h����
    int exceedtime=600000;//�����ƫO�s���ɶ�(�@��p��)
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
    		//���R���L�������
    		int s=0;
    		System.out.println("���"+array1.keyword+(Spide.t1-array1.time1));
    		if((Spide.t1-array1.time1)>exceedtime) {
    			data2.remove(array1);//�W�L�ɶ�����N�R��
    			s=1;
    		}
    		if(s==0) {
    			System.out.println(array1.select+"abc"+Spide.select1);
    			if(array1.keyword.equals(searchWord) && array1.select==Spide.select1) {//�j�M�쭫�ƪ��N�������L�h�����
    				for(int i=0;i<array1.data.size();i++) {
    					database newdata2 = array1.data.get(i);//���
    					newdata2.setname(searchWord, array1.data.get(i).link,array1.data.get(i).title,array1.data.get(i).rank,array1.data.get(i).rank);//�x�s���
    					data.add(newdata2);//�x�s���
    				}
    				exist1=1;
    			}
    			//Spide.textArea.append("\n*Done* Visited " + data.size() + " web page(s)");
    		}
    	}
    	 
        while(pagesVisited.size() < MAX_PAGES_TO_SEARCH)    {//�j�M�����W�LMAX_PAGES_TO_SEARCH�N����j�M �άO�W�L30�Ӧ��\�����]�O����
            if(exist1==1) {
            	System.out.println("���ݭn�j��F");
            	break;
            }
        	String currentUrl;
            database newdata2=new database();//�x�s���
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
    	            	database newdata=new database();//�x�s���
    	            	int cau=((2*spiderleg.number*5*(30-e1))/((30-e1)+(spiderleg.number*5)));
    	        	    newdata.setname(searchWord, currentUrl,spiderleg.content,spiderleg.number,cau);//�x�s���
    	        		data.add(newdata);//�x�s���
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
        	Spide.textArea.append("�䤣������������");
        }
        
        
        
        if(exist1==0) {//�p�G�O�e���L�h�ҨS������ơA���N�|�i�J���x�s���q
        	Collections.sort (data, new database());
            hashdata hash=new hashdata();
            hash.sethashset(searchWord, data);
            data2.add(hash);//�x�shashset(�j�M�r��ƧǹL�᪺datalink)
        }
        
        
        for(int i=0;i<data.size();i++) {//�L�X�j�M��P�Ƨǫ᪺�e�Q�����
			database newdata2 = data.get(i);//���
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
