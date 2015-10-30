package code;

import java.io.IOException;
import org.slf4j.*;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Do {
	int count=0;
//	Logger logger = LoggerFactory.getLogger(Do.class);   
	void page(String PageURL) throws IOException{	//这个方法和下面的list()取代了原本的list()，这是循环调用的方式，不会有大量的stack，性能更稳定
		String nextLink=list(PageURL);
		while(nextLink!=null){
			nextLink=list(nextLink);
		}
	}
	String list(String PageURL) throws IOException{		
		Document doc=Jsoup.connect(PageURL).get();
		Elements es_NSlink=doc.select("a.c67738");
		for(Element e_NSlink:es_NSlink){
			atricle(e_NSlink.absUrl("href"));
		}
		Element NextPage=doc.select("a.Next").first();
		if(NextPage!=null){
			return NextPage.absUrl("href");
		}else{
			return null;
		}	
	}
	void atricle(String artiUrl) throws IOException {
		Document doc=Jsoup.connect(artiUrl).get();
		count++;
		System.out.println("\n"+count+"URL---->>"+artiUrl);
		Element title=doc.select("td.titlestyle67448").first();
		System.out.println("《《"+title.text()+"》》");
		Element time=doc.select("span.timestyle67448").first();
		System.out.println(time.text());
		Element text=doc.select("div#vsb_newscontent").first();
		System.out.println(text.text());
		Elements images=doc.select("img[src]");
		for(Element e:images){
			System.out.println("\t"+e.attr("src"));
		}
		
	}

//这是使用递归调用的方法，会产生大量的stack，
//  void list(String pageURL) throws IOException{		
//		Document doc=Jsoup.connect(pageURL).get();
//		Elements es_NSlink=doc.select("a.c67738");
//		for(Element e_NSlink:es_NSlink){
//			atricle(e_NSlink.absUrl("href"));
//		}
//		Element NextPage=doc.select("a.Next").first();
//		if(NextPage!=null){
//			list(NextPage.absUrl("href"));
//		}	
//	}
 

}
