package hd.sw.image.Create.jpg;

import java.io.IOException;
/** 
* CopyRright(c)2016-3-15:<HD>                          
* Project:<视问-项目 >数据仿真
* Module:图片生成                                                                                  
* JDK version used:<JDK1.7>                                                            
* Author:<Gang Hu>                 
* Create Date: <创建日期:2016-3-15>                                         
* Version:0.1
* Comments:主函数入口。
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