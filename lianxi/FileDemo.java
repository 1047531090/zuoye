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
			char[] chars = new char[10(int)file.length()];//������
			fileReader.read(chars);
			for(char c:chars){
				System.out.println(c);
			}
			
			String ss = "";
			int len = 0;//֪�����˶��ٸ��ַ�
			while((len = fileReader.read(chars)) != -1){
				System.out.println("��ȡ����"+len);
				String sss = new String(chars,0,len);
				ss+=sss;
			}
			System.out.println(ss);
			
//			FileWriter fileWriter = new FileWriter(file);
//			String s = "�츣��˧";
//			fileWriter.write(s,0,s.length());
//			fileWriter.close();
			
		    
			 * FileWriter fileWriter = new FileWriter(file,true);
			 *String s = "�츣��˧";
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
		
		
		 *System.out.println("�Ƿ�����ļ�"+file.isFile());
		 *System.out.println("�Ƿ�����ļ���"+file.isDirectory());
		 *System.out.println("�����ļ�����Ŀ¼"+file.getName());
		 *System.out.println("���ض����Ӧ��·����"+file.getPath());
		 *System.out.println("���ؾ���·��"+file.getAbsoluteFile());
		 *System.out.println("���ض����Ӧ�ľ���·��"+file.getAbsolutePath());
		 *System.out.println("�����ļ�Ŀ¼����һ��Ŀ¼��"+file.getParent());
		 *System.out.println("������һ���޸ĵ�ʱ��"+file.lastModified());
		 *System.out.println("�����ļ����ݵĳ���"+file.length());
		 
		
		
		*/
		
		
		//�ֽ���������
		File file = new File("src/xiancheng/textt.txt");
		try{
			
			/*
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] bytes = new byte[10];
			int len = 0;
			StringBuffer snb = new StringBuffer();//String�ǲ��ɱ�ģ�StringBuffer���Ч��
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
