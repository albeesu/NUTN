package spider;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;


public class Main {
	//public static String search;
	public static String url;//="http://www.ptt.cc/bbs/index.html";//http://en.wikipedia.org/
	public static String search;//https://sites.google.com/view/nutnumc/
	public Main() throws IOException {
		List<String> links = new LinkedList<String>();
		Document doc = Jsoup.connect(url).get();
		
		Elements linksOnPage = doc.select("a[href]");
		Elements media = doc.select("[src]");
		int e=0;
		
		System.out.printf("\nMedia: (%d)\n", media.size());
		System.out.println("Found (" + linksOnPage.size() + ") links");
		
		int i=0;
		for(Element link : linksOnPage) {
			links.add(link.absUrl("href"));
			i++;
		
			if(i==10) {
				break;
			}
		}
			 spider user=new spider ();		
			 user.start();
		 
		
	}
	public static void main(String[] args) throws IOException{
		// TODO 自動產生的方法 Stub
		
	}

}

