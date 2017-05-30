package qunfa;
import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
class Fuwuduan1 implements Runnable{
	Socket socket = null;
	List<Socket> list;
	Map<String,Socket> socketHashMap = new HashMap<String,Socket>();
	public Fuwuduan1(Socket socket,List<Socket> list,Map<String, Socket> socketHashMap){
		this.socket = socket;
		this.list = list;
		this.socketHashMap = socketHashMap;
	}
	public void run(){
		while(true){
			try{
				//服务器读入
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String xx = null;
				
				xx = bufferedReader.readLine();//读取一行字符
				
				Set<String> keys = socketHashMap.keySet();
				String name = "";
				for(String s:keys){
					Socket so = socketHashMap.get(s);
					if(socket==so){
						name = s;
					}
				}
				
				System.out.println("客户返回内容："+name+"说:"+xx);//IP
				String string = name+ "说 : "+xx;
		
				//服务器输出
				for(Socket s1:list){
					PrintWriter printWriter = new PrintWriter(s1.getOutputStream());
					printWriter.write(string+"\n");
					printWriter.flush();
					//清空缓存
				}
		

			}catch(Exception e){
				e.printStackTrace();
			}
		}

	}
}