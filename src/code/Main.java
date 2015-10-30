package code;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		Do obj=new Do();
		obj.page("http://www.zhzhu.edu.cn/index/xxxw.htm");
//		obj.page("http://www.zhzhu.edu.cn/index/tzgg.htm");
//		obj.atricle("http://www.zhzhu.edu.cn/info/1036/16577.htm");
		System.out.println("spider is finish***********");
		

	}
}
