package qunfa;
import java.io.*;
import java.util.Scanner;
import java.net.*;
public class Kehuduan{
	public static void main(String[] kl) throws IOException{
		Socket socket = null;
		try{
			//�����ͻ���
			socket = new Socket("192.168.199.143",9998);
			System.out.println("�Ƿ����ӳɹ�"+socket.isConnected());
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.write("����666\n");
			printWriter.flush();
			
			new Thread(new Yonghushuru(socket)).start();
			new Thread(new Kehuduan1(socket)).start();	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}