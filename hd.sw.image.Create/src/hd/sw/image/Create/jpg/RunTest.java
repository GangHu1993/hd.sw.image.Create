package hd.sw.image.Create.jpg;

import java.io.IOException;
/** 
* CopyRright(c)2016-3-15:<HD>                          
* Project:<����-��Ŀ >���ݷ���
* Module:ͼƬ����                                                                                  
* JDK version used:<JDK1.7>                                                            
* Author:<Gang Hu>                 
* Create Date: <��������:2016-3-15>                                         
* Version:0.1
* Comments:��������ڡ�
*/ 

public class RunTest {
	public static void main(String[] args) {
		Run runT = new Run();
		try {
			runT.runCreate();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}