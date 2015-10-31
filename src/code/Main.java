package code;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		Do obj=new Do();
//		System.setProperty(arg0, arg1);
		Logger logger = LoggerFactory.getLogger(Main.class);
		logger.debug("spider is start");
		obj.page("http://www.zhzhu.edu.cn/index/xxxw.htm");
//		obj.page("http://www.zhzhu.edu.cn/index/tzgg.htm");
//		obj.atricle("http://www.zhzhu.edu.cn/info/1036/16577.htm");
		logger.debug("spider is finish***********");
	}
}
