package qunfa;
import java.io.*;
import java.util.Scanner;
import java.net.*;
public class Kehuduan{
	public static void main(String[] kl) throws IOException{
		Socket socket = null;
		try{
			//创建客户端
			socket = new Socket("192.168.199.143",9998);
			System.out.println("是否连接成功"+socket.isConnected());
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.write("老铁666\n");
			printWriter.flush();
			
			new Thread(new Yonghushuru(socket)).start();
			new Thread(new Kehuduan1(socket)).start();	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}