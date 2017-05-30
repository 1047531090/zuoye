package qunfa;
import java.io.*;
import java.util.*;
import java.net.*;
class Kehuduan1 implements Runnable{
	Socket socket = null;
	public Kehuduan1(Socket socket){
		this.socket = socket;
	}
	public void run(){
		while(true){
			try{
				//读入客户端返回的内容
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String string=null;
				string = bufferedReader.readLine();
				System.out.println(string);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}