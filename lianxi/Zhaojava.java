package lianxi;

import java.io.*;

public class Zhaojava {
	public static void main(String[] args){
		
		File file = new File("src");
		findFile(file);
		
	}
	
	public static void findFile(File f){
		if(f.isDirectory()){
			File[] files = f.listFiles();
			for(File f1:files){
				findFile(f1);
			}
		}else{
			if(f.getName().endsWith(".java")){
				System.out.println("Path===="+f.getAbsolutePath());
			}
		}
	}
}
