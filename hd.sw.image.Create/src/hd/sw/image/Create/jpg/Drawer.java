package hd.sw.image.Create.jpg;

import java.awt.Graphics2D;

public interface Drawer {
	/**
	 * �ڻ滭���ϻ����ַ���
	 * 
	 * @param creator ͼƬ����������
	 * @param g �滭��
	 * @param text �����Ƶ��ַ���
	 */
	public void draw(AbstractImageCreator creator, Graphics2D g, String text);
}