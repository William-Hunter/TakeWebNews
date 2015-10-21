package code;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Do obj=new Do();
		obj.Page("http://www.zhzhu.edu.cn/index/xxxw.htm");
		obj.Page("http://www.zhzhu.edu.cn/index/tzgg.htm");
		System.out.println("spider is finish***********");
	}
}
