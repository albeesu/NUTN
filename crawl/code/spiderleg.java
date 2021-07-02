package spider;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class spiderleg {
	
	   private static final String USER_AGENT = "Chrome/56.0.2924.87";//Chrome/56.0.2924.87
	    private List<String> links = new LinkedList<String>();
	    private Document htmlDocument;
	    public List<String> getLinks() {return links;}
	    public static String title;
	    public static String content="";
	    public static int a1;
	    public static int number=0;
	public static int appearNumber(String srcText, String findText) {
	    	  int count = 0;
	    	  Pattern p = Pattern.compile(findText);
	    	  Matcher m = p.matcher(srcText);
	    	  while (m.find()) {
	    	    count++;
	    	  }
	    	  return count;
	   }
	public boolean crawl(String url) {
		try {
			
			Connection connection=Jsoup.connect(url).userAgent(USER_AGENT);
			Document htmlDocument=connection.get();
			this.htmlDocument=htmlDocument;
			if(connection.response().statusCode()==200) {
				//Spide.textArea.append("\n**visting** Retrieved web page at "+url);
			}
			if(!connection.response().contentType().contains("text/html")) {
			
				Spide.textArea.append("\n**failure** Retrieved something other than HTML");
				return false;
			}
			
			if(Spide.select1==1) {//聯合報
				Elements linksOnPage=htmlDocument.select("a[href]");
				for(Element link:linksOnPage) {
					this.links.add(link.absUrl("href"));
				}
			}
			else if(Spide.select1==2) {//巴哈
				Elements linksOnPage=htmlDocument.select("a[href]");
				for(Element link:linksOnPage) {
					this.links.add(link.absUrl("href"));
				}
			}
			else if(Spide.select1==3) {//youtube
				Elements linksOnPage=htmlDocument.select("a[href]");
				for(Element link:linksOnPage) {
					this.links.add(link.absUrl("href"));
				}
			}
			else if(Spide.select1==4) {//PTT
				Elements linksOnPage=htmlDocument.select("a[href]");
				for(Element link:linksOnPage) {
					this.links.add(link.absUrl("href"));
				}
			}
			else if(Spide.select1==5) {//維基百科
				Elements linksOnPage=htmlDocument.select("a[href]");
				for(Element link:linksOnPage) {
					this.links.add(link.absUrl("href"));
				}
			}
			else if(Spide.select1==6) {//momo購物網站
				Elements linksOnPage=htmlDocument.select("a[href]");
				for(Element link:linksOnPage) {
					this.links.add(link.absUrl("href"));
				}
			}
			else if(Spide.select1==7) {//yahoo
				Elements linksOnPage=htmlDocument.select("a[href]");
				for(Element link:linksOnPage) {
					this.links.add(link.absUrl("href"));
				}
			}
			else if(Spide.select1==8) {//dcard
				Elements linksOnPage=htmlDocument.select("a[href]");
				for(Element link:linksOnPage) {
					this.links.add(link.absUrl("href"));
				}
			}
			return true;
		}
		catch(IOException ioe) {
			return false;
		}
	}
	public boolean searchforword(String searchword) {
		
		if(htmlDocument==null) {
			Spide.textArea.append("\nerror !! empty page");
			return false;
		}
		//Spide.textArea.append("\n searching for the word"+searchword+"...");
		String bodytext=htmlDocument.body().text();
		if(bodytext.toLowerCase().contains(searchword.toLowerCase())) {
			int x=bodytext.toLowerCase().indexOf(searchword.toLowerCase());
			number=appearNumber(bodytext.toLowerCase(),searchword.toLowerCase());
			content="";
			for(int i=0;i<10;i++) {
				content=content+bodytext.charAt(x+i);
			}
		}
		return bodytext.toLowerCase().contains(searchword.toLowerCase());
	}
	
	public List<String> getLink()
    {
        return this.links;
    }


	
	
}
