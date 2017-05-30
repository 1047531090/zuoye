package qunfa;
import java.io.*;
import java.util.Scanner;
import java.net.*;
import java.util.*;
class Yonghushuru implements Runnable{
	Socket socket = null;
	public Yonghushuru(Socket socket){
		this.socket = socket;
	}
	public void run(){
		while(true){
			Scanner sc = new Scanner(System.in);
			try{
				System.out.println("请输入内容:");
				String string= sc.next();
				System.out.println("用户输入的内容是"+string);
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
				printWriter.write(string+"\n");
				printWriter.flush();
				//清空缓存
			}catch(Exception e){
				e.printStackTrace();
			}
		}	
	}
}