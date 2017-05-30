package qunfa;
import java.io.*;
import java.util.Scanner;

import javax.print.attribute.HashAttributeSet;

import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
public class Fuwuduan{
	public static void main(String[] kl) throws IOException{
		ServerSocket serverSocket = null;
		Socket socket = null;
		serverSocket = new ServerSocket(9999);
		System.out.println("服务器建立成功");
		List<Socket> list = new ArrayList<Socket>();
		Map<String, Socket> socketHashMap = new HashMap<String,Socket>();
		try{
			while(true){
				socket = serverSocket.accept();
				
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String name = bufferedReader.readLine();
				socketHashMap.put(name,socket);//映射名字和客户端
				list.add(socket);
				
				new Thread(new Fuwuduan1(socket,list,socketHashMap)).start();
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}