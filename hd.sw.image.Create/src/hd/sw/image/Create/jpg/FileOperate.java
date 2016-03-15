package hd.sw.image.Create.jpg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/** 
* CopyRright(c)2016-3-15:<HD>                          
* Project:<视问-项目 >数据仿真
* Module:图片生成                                                                                  
* JDK version used:<JDK1.7>                                                            
* Author:<Gang Hu>                 
* Create Date: <创建日期:2016-3-15>                                         
* Version:0.1
* Comments:文件操作。
*/ 

public class FileOperate {
	String path=null;
	String content;
	
	public FileOperate(String path){
		this.path = path;
	}
	public void write(String fileName,int bx,int by, int ex,int ey) {

		File storageFolder = new File(path);

		if (!storageFolder.exists()) {
			storageFolder.mkdirs();
		}
		
		String filename = storageFolder.getAbsolutePath() + "/"+ fileName+".xml";
		
		File saveFile = new File(filename);

		if (!saveFile.exists()) {
			try {
				saveFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			BufferedWriter TxtWriter = new BufferedWriter(new FileWriter(
					filename));
			if(bx>ex){
				bx= bx+ex;
				ex = bx-ex;
				bx = bx -ex;
			}
			if(by>ey){
				by = by+ey;
				ey = by-ey;
				by = by-ey;
			}
			content = "<annotation>\n<object>\n<name>table</name>\n<difficult>0</difficult>\n<bndbox>\n<xmin>"+bx+"</xmin>\n<ymin>"+by+"</ymin>\n<xmax>"+ex+"</xmax>\n<ymax>"+ey+"</ymax>\n</bndbox>\n</object>\n<filename>"+fileName+".jpg</filename>\n<size>\n<width>650</width>\n<height>800</height>\n<depth>3</depth>\n</size>\n</annotation>";
			TxtWriter.write(content);
			TxtWriter.flush();
			TxtWriter.close();
			TxtWriter = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("IO Exception");
		}
		saveFile = null;
		storageFolder = null;
	}
}
