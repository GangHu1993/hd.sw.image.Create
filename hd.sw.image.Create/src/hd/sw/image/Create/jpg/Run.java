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
* Comments:���С�
*/ 

public class Run {
	public void runCreate() throws IOException{
		String xmlPath="d:\\xml";
		String imagePath="d:\\image";
		FileImageCreator creator =null;
		FileOperate fp = null;
		StringBuffer sb = new StringBuffer();  
		sb.append("����\n");  
		sb.append("������\n");  

		for(int i=0;i<500;i++){
		creator	= new FileImageCreator(new SimpleDrawer(), imagePath+"\\"+i+".jpg");
		fp = new FileOperate(xmlPath);
		creator.setWidth(650); //ͼƬ���
		creator.setHeight(800); //ͼƬ�߶�
		//creator.setLineNum(20); //����������
		//creator.setFontSize(18); //�����С
		//creator.setFontName("����");
		
		//������ת
//	creator.setRadian(30.0); //��ת����
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
