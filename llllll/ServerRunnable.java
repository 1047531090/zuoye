package llllll;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class ServerRunnable implements Runnable{
	Socket t =null;
	List<Socket> li = null;
	Map<String,Socket> map = null;
	public ServerRunnable(Socket t,List<Socket> li,Map<String, Socket> map){
		this.t = t;
		this.li = li;
		this.map = map;
	}
	public void run(){
		while(true){
			try{
				//服务端输入流
				System.out.println("正在接收客户端发送数据");
				BufferedReader bf = new BufferedReader(new InputStreamReader(t.getInputStream()));
				String ss = null;
				ss = bf.readLine() ;
				Set<String> keys = map.keySet();
				String name = "";
				for(String s:keys){
					Socket so = map.get(s);
					if(t==so){
						name = s;
					}
				}
				
				
				System.out.println("服务器:你是");
				System.out.println("客户端:我是"+name);
				String cc = new String(t.getInetAddress().getHostAddress());
				System.out.println("地址是："+cc); 
				//服务端输出流
				System.out.println("正在客户端发送数据");
				String sss = name+":"+ss;
				
				PreparedStatement psql =  (PreparedStatement) Demo.getInstace().prepareStatement("insert into qq (xiaoxi) "+"values(?)");
				psql.setString(1, sss);		
				psql.executeUpdate(); 
				
				for(Socket l:li ){
					PrintWriter w = new PrintWriter(l.getOutputStream());
					w.write(sss+"\n");
					w.flush();
				}		
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
