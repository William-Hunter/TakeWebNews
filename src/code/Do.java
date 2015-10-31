package code;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Do {
	private int count=0;
	Logger logger = LoggerFactory.getLogger(Do.class);
	void page(String PageURL) throws IOException, InterruptedException{	//这个方法和下面的list()取代了原本的list()，这是循环调用的方式，不会有大量的stack，性能更稳定
		String nextLink=list(PageURL);
		while(nextLink!=null){
			nextLink=list(nextLink);
		}
	}
	String list(String PageURL) throws IOException, InterruptedException{		
		Document doc=Jsoup.connect(PageURL).timeout(300000).get();
		Elements es_NSlink=doc.select("a.c67738");
		for(Element e_NSlink:es_NSlink){
			atricle(e_NSlink.absUrl("href"));
			System.out.println();
		}
		Element NextPage=doc.select("a.Next").first();
		if(NextPage!=null){
			return NextPage.absUrl("href");
		}else{
			return null;
		}	
	}
	void atricle(String artiUrl) throws IOException, InterruptedException {
		Document doc=Jsoup.connect(artiUrl).timeout(300000).get();
		++count;
		logger.debug(count+"\t"+artiUrl);
		Element title=doc.select("td.titlestyle67448").first();
		System.out.println("《《"+title.text()+"》》");
		Element time=doc.select("span.timestyle67448").first();
		System.out.println(time.text());
		Element text=doc.select("div#vsb_newscontent").first();
		System.out.println(text.text());
		Elements images=doc.select("img[src]");
		for(Element e:images){
//			String img="www.zhzhu.edu.cn"+e.attr("src").split("\\.")[4]+"."+e.attr("src").split("\\.")[5];
			System.out.println("\t"+e.attr("src"));//img 是文章里的图片链接
		}		
		Thread.sleep(500);	
		//每次循环的时候暂停0.5秒，这样可以降低访问频率，不会被网站的安全机制屏蔽，
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
