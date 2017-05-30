package llllll;

import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;

public class Server2 {        
   public static void main(String args[]) {
	   ServerSocket s = null;
	   Socket t = null;
	   List<Socket> list = new ArrayList<Socket>();
	   Map<String,Socket> map = new HashMap<String,Socket>();
	   try{
		   //创建服务端，并开通注册端口
			System.out.println("创建成功，正在等待客户端连接");
			s = new ServerSocket(9997);  
			//监听对应端口 阻塞
			while(true){
				System.out.println("等待客户端发送数据");
				t = s.accept();
				BufferedReader bf = new BufferedReader(new InputStreamReader(t.getInputStream()));
				String name = bf.readLine();
				map.put(name,t);
				list.add(t);
				new Thread(new ServerRunnable(t,list,map)).start();	
			}       
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}    
}   
