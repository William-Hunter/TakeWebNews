package code;

import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Do {
	void list(String NewsURL) throws IOException{		
		Document doc=Jsoup.connect(NewsURL).get();
		Elements es_NSlink=doc.select("a.c67738");
		for(Element e_NSlink:es_NSlink){
			atricle(e_NSlink.absUrl("href"));
		}
		Element NextPage=doc.select("a.Next").first();
		if(NextPage!=null){
			list(NextPage.artiUrl("href"));
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
}
