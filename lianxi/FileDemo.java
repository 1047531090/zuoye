package lianxi;

import java.io.*;

public class FileDemo {
	public static void main(String[] args){
		
		/*
		
		
		File file = new File("src/xiancheng/textt.txt");
//		try{
//			file.createNewFile();
//		}catch(IOException e){
//			e.printStackTrace();
//		}
		
		try{
			FileReader fileReader = new FileReader(file);
//			int a = filReader.read();
			char[] chars = new char[10(int)file.length()];//缓冲区
			fileReader.read(chars);
			for(char c:chars){
				System.out.println(c);
			}
			
			String ss = "";
			int len = 0;//知道读了多少个字符
			while((len = fileReader.read(chars)) != -1){
				System.out.println("读取个数"+len);
				String sss = new String(chars,0,len);
				ss+=sss;
			}
			System.out.println(ss);
			
//			FileWriter fileWriter = new FileWriter(file);
//			String s = "徐福真帅";
//			fileWriter.write(s,0,s.length());
//			fileWriter.close();
			
		    
			 * FileWriter fileWriter = new FileWriter(file,true);
			 *String s = "徐福真帅";
			 *fileWriter.write(s,0,s.length());
			 *fileWriter.close();
			 *
			 
			
//			System.out.println(a);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
//		if(file.exists()){
//			file.delete();
//		}
		
		
		 *System.out.println("是否存在文件"+file.isFile());
		 *System.out.println("是否存在文件夹"+file.isDirectory());
		 *System.out.println("返回文件名或目录"+file.getName());
		 *System.out.println("返回对象对应的路径名"+file.getPath());
		 *System.out.println("返回绝对路径"+file.getAbsoluteFile());
		 *System.out.println("返回对象对应的绝对路径"+file.getAbsolutePath());
		 *System.out.println("返回文件目录的上一级目录名"+file.getParent());
		 *System.out.println("返回上一次修改的时间"+file.lastModified());
		 *System.out.println("返回文件内容的长度"+file.length());
		 
		
		
		*/
		
		
		//字节流的输入
		File file = new File("src/xiancheng/textt.txt");
		try{
			
			/*
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] bytes = new byte[10];
			int len = 0;
			StringBuffer snb = new StringBuffer();//String是不可变的，StringBuffer提高效率
//			String s = "";
			while((len = fileInputStream.read(bytes)) != -1){
//				s+= new String(bytes,0,len);
				snb.append(new String(bytes,0,len));
				
			}
//			System.out.println(s);
			System.out.println(snb.toString());
			
			
//			fileInputStream.read(bytes);
//			String ss = new String(bytes);
//			System.out.println(ss);
			*/
			
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			String s = "xufuzhenshuai";
			byte[] bytes = s.getBytes();
			fileOutputStream.write(bytes);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
}
