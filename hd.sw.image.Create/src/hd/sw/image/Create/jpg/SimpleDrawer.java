package hd.sw.image.Create.jpg;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

/** 
* CopyRright(c)2016-3-15:<HD>                          
* Project:<����-��Ŀ >���ݷ���
* Module:ͼƬ����                                                                                  
* JDK version used:<JDK1.7>                                                            
* Author:<Gang Hu>                 
* Create Date: <��������:2016-3-15>                                         
* Version:0.1
* Comments:ͼƬ�����������ִ���
*/ 

public class SimpleDrawer implements Drawer {
	public void draw(AbstractImageCreator creator, Graphics2D g, String text){
		//������ת
		g.rotate(Math.toRadians(creator.getRadian()), creator.getRotateX(), creator.getRotateY());
		g.scale(creator.getScale(), creator.getScale());
		
		g.setColor(creator.getFontColor());
		Font font = new Font(creator.getFontName(), Font.PLAIN, creator.getFontSize());
		g.setFont(font);
		
		FontMetrics fm = g.getFontMetrics(font);
		int fontHeight = fm.getHeight(); //�ַ��ĸ߶�
		
		int offsetLeft = 0;
		int rowIndex = 1;
		for(int i=0;i<text.length();i++){
			char c = text.charAt(i);
			int charWidth = fm.charWidth(c); //�ַ��Ŀ��
			
			//����һ��
			if(Character.isISOControl(c) || offsetLeft >= (creator.getWidth()-charWidth)){
				rowIndex++;
				offsetLeft = 0;
			}
			
			g.drawString(String.valueOf(c), offsetLeft, rowIndex * fontHeight);
			offsetLeft += charWidth;
		}
	}
}