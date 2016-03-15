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
* Comments:运行。
*/ 

public class Run {
	public void runCreate() throws IOException{
		String xmlPath="d:\\xml";
		String imagePath="d:\\image";
		FileImageCreator creator =null;
		FileOperate fp = null;
		StringBuffer sb = new StringBuffer();  
		sb.append("胡豆\n");  
		sb.append("胡豆豆\n");  

		for(int i=0;i<500;i++){
		creator	= new FileImageCreator(new SimpleDrawer(), imagePath+"\\"+i+".jpg");
		fp = new FileOperate(xmlPath);
		creator.setWidth(650); //图片宽度
		creator.setHeight(800); //图片高度
		//creator.setLineNum(20); //干扰线条数
		//creator.setFontSize(18); //字体大小
		//creator.setFontName("黑体");
		
		//文字旋转
//	creator.setRadian(30.0); //旋转弧度
//	creator.setRotateX(creator.getWidth()/5);
//	creator.setRotateY(creator.getHeight()*5/10);
		creator.generateImage(sb.toString());  
		//System.out.println( creator.retPara[0]);
		fp.write(i+"", creator.getRetPara()[0], creator.getRetPara()[1], creator.getRetPara()[2], creator.getRetPara()[3]);
		creator=null;
		fp = null;
		System.out.println(i);
		}
	}

}
