package qunliaoshujuku2;

import java.io.*;
import java.util.Scanner;
import java.net.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
//服务器端
public class Sever {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket serversocket = null;
		Socket socket = null;
		try{
		serversocket = new ServerSocket(9600);
		System.out.println("服务器创建成功");
		List<Socket> list = new ArrayList<Socket>();
		//备注
		Map<String,Socket> socketHashMap = new HashMap<String,Socket>();
			while(true){
				socket = serversocket.accept();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String name = bufferedReader.readLine();
				socketHashMap.put(name,socket);//映射名字和客户端
				list.add(socket);
				//将数据库中的消息发送给刚连接的客户
				Statement statement = MysqlUtil.getInstance().createStatement();
				String sql = "select * from hh";
				ResultSet rs = statement.executeQuery(sql);
				String name2 = null;
				String xiaoxi2 = null;
				String rr = "";
				while(rs.next()){
					name2 = rs.getString("name");
					xiaoxi2 = rs.getString("xiaoxi");
					rr = name2+":"+xiaoxi2;
					PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
					printWriter.write(rr+"\n");
					printWriter.flush();
				}
				new Thread(new ServerRunnable(socket,list,socketHashMap)).start();
			}
		}catch(Exception e){
			System.out.println("服务器出现异常"+e);
		}
		
	}

}
