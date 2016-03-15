package hd.sw.image.Create.jpg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

/** 
* CopyRright(c)2016-3-15:<HD>                          
* Project:<����-��Ŀ >���ݷ���
* Module:ͼƬ����                                                                                  
* JDK version used:<JDK1.7>                                                            
* Author:<Gang Hu>                 
* Create Date: <��������:2016-3-15>                                         
* Version:0.1
* Comments:ͼƬ��������
*/ 

public abstract class AbstractImageCreator {
	private static Random rnd = new Random(new Date().getTime());
	private Drawer drawer;
	
	int [] retPara = new int [4];
	
	//ͼƬ���
	private int width = 200;
	
	//ͼƬ�߶�
	private int height = 80;
	
	//�����ɫ
	private Color rectColor;
	
	//����ɫ
	private Color bgColor;
	
	//��������Ŀ
	private int lineNum = 0;
	
	//ͼƬ��ʽ
	private String formatName = "JPEG";
	
	//������ɫ
	private Color fontColor = new Color(0, 0, 0);
	
	//��������
	private String fontName = "����";
	
	//�����С
	private int fontSize = 15;
	
	//������ת�Ļ�����
	private double radian = 0;
	private double rotateX = 0;
	private double rotateY = 0;
	
	//����
	private double scale = 1;
	

	//##### �˴�ʡ��getter��setter���� #####


	public AbstractImageCreator(Drawer drawer){
		this.drawer = drawer;
	}
	
	/**
	 * ��������
	 */
	private void drawRandomLine(Graphics graph){
		for(int i=0;i<lineNum;i++){
			//��������ɫ
			graph.setColor(getRandomColor(100, 155));
			
			//������������ֵ
			int x1 = rnd.nextInt(width);
			int y1 = rnd.nextInt(height);
					
			int x2 = rnd.nextInt(width);
			int y2 = rnd.nextInt(height);
			
			//������
			graph.drawLine(x1, y1, x2, y2);
		}
	}
	
	private void drawLine(Graphics graph,int x1,int y1,int x2,int y2){
			//��������ɫ
			graph.setColor(getRandomColor(0, 255));
			//������
			graph.drawLine(x1, y1, x2, y2);
	}
	
	/**
	 * ��������
	 */
	private void drawRandomtable(Graphics graph){
		int bx = 5+rnd.nextInt((width-10)/2);
		int by = 5+rnd.nextInt((height-10)/2);
		int ex = 5+width/2+rnd.nextInt((width-10)/2);
		int ey = 5+height/2+rnd.nextInt((height-10)/2);
		
		setRetPara(new int []{bx,by,ex,ey}); 

		//����
		drawLine(graph, bx,by,ex,by);
		drawLine(graph, bx,by,bx,ey);
		drawLine(graph, ex,ey,bx,ey);
		drawLine(graph, ex,ey,ex,by);
		
		int xNum = rnd.nextInt(10);
		int yNum = rnd.nextInt(10);
		//������
		for(int i=0;i<yNum;i++){
			drawLine(graph, bx,by+i*(ey-by)/yNum,ex,by+i*(ey-by)/yNum);
		}
		
		//������
		for(int i=0;i<xNum;i++){
			drawLine(graph, bx+i*(ex-bx)/xNum,by,bx+i*(ex-bx)/xNum,ey);
		}
	}
	

	/**
	 * �����ȡ��ɫ����
	 */
	private Color getRandomColor(int base, int range){
		if((base + range) > 255) range = 255 - base;
		
		int red = base + rnd.nextInt(range);
		int green = base + rnd.nextInt(range);
		int blue = base + rnd.nextInt(range);
		
		return new Color(red, green, blue);
	}
	
	public void generateImage(String text)throws IOException{
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		if(rectColor == null) rectColor = new Color(0, 0, 0);
		if(bgColor == null) bgColor = new Color(255,255,255 );
		
		//��ȡ����
		Graphics2D g = (Graphics2D)image.getGraphics();
		
		//��������
		g.setColor(bgColor);
		g.fillRect(0, 0, width, height);
		
		//���
		g.setColor(rectColor);
		g.drawRect(0, 0, width-1, height-1);
		
		//��������
		//drawRandomLine(g);
		
		//���ַ���
		//drawer.draw(this, g, text);
		drawRandomtable(g);
		//ִ��
		g.dispose();
		//���ͼƬ���
		saveImage(image);
	}
	
	public int[] getRetPara() {
		return retPara;
	}

	public void setRetPara(int[] retPara) {
		this.retPara = retPara;
	}

	public static Random getRnd() {
		return rnd;
	}

	public static void setRnd(Random rnd) {
		AbstractImageCreator.rnd = rnd;
	}

	public Drawer getDrawer() {
		return drawer;
	}

	public void setDrawer(Drawer drawer) {
		this.drawer = drawer;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getRectColor() {
		return rectColor;
	}

	public void setRectColor(Color rectColor) {
		this.rectColor = rectColor;
	}

	public Color getBgColor() {
		return bgColor;
	}

	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}

	public int getLineNum() {
		return lineNum;
	}

	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	public String getFormatName() {
		return formatName;
	}

	public void setFormatName(String formatName) {
		this.formatName = formatName;
	}

	public Color getFontColor() {
		return fontColor;
	}

	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}

	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public double getRadian() {
		return radian;
	}

	public void setRadian(double radian) {
		this.radian = radian;
	}

	public double getRotateX() {
		return rotateX;
	}

	public void setRotateX(double rotateX) {
		this.rotateX = rotateX;
	}

	public double getRotateY() {
		return rotateY;
	}

	public void setRotateY(double rotateY) {
		this.rotateY = rotateY;
	}

	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

	protected abstract void saveImage(BufferedImage image)throws IOException;
	
}