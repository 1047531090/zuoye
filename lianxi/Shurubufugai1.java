package lianxi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Shurubufugai1 {
	public static void main(String[] args){
		//用户输入内容写入文件
		Scanner scanner = new Scanner(System.in);
		File file = new File("src/lianxi/test1.txt");
		if(!file.exists()){
			try{
				
				file.createNewFile();
				
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
			//输入内容
			String userInput = "";
			System.out.println("请输入文件内容：");
			userInput = scanner.nextLine();
			
			//读取内容并写入
			RandomAccessFile randomAccessFile = null;
			try {
				
				randomAccessFile = new RandomAccessFile(file,"rw");
				randomAccessFile.seek(file.length());
				randomAccessFile.write(userInput.getBytes());
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}finally{
				if(randomAccessFile != null){
					try{
						randomAccessFile.close();
					}catch(IOException e){
						e.printStackTrace();
					}
				}
			}
		
	}
}
