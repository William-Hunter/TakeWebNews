package code;

import java.io.IOException;
import org.slf4j.*;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Do {
//	private slf4j logger=new slf4j();
	void page(String PaperURL) throws IOException{	//这个方法和下面的list()取代了原本的list()，这是循环调用的方式，不会有大量的stack，性能更稳定
		String nextLink=list(PaperURL);
		while(nextLink!=null){
			nextLink=list(nextLink);
		}
	}
	String list(String PaperURL) throws IOException{		
		Document doc=Jsoup.connect(PaperURL).get();
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
		Element title=doc.select("td.titlestyle67448").first();
		System.out.println("《《"+title.text()+"》》");
		Element time=doc.select("span.timestyle67448").first();
		System.out.println(time.text());
		Element text=doc.select("div#vsb_newscontent").first();
		System.out.println(text.text()+"\n");
	}

/*//这是使用递归调用的方法，会产生大量的stack，
 * 
 * void list(String NewsURL) throws IOException{		
		Document doc=Jsoup.connect(NewsURL).get();
		Elements es_NSlink=doc.select("a.c67738");
		for(Element e_NSlink:es_NSlink){
			atricle(e_NSlink.absUrl("href"));
		}
		Element NextPage=doc.select("a.Next").first();
		if(NextPage!=null){
			list(NextPage.absUrl("href"));
		}	
	}
 * 
 * 
 * */



}
