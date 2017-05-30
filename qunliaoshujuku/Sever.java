package qunliaoshujuku;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import java.sql.ResultSet;
import java.sql.Statement;

public class Sever{
	public static void main(String[] kl) throws IOException{
		ServerSocket serverSocket = null;
		Socket socket = null;
		try{
			serverSocket = new ServerSocket(9995);
			System.out.println("服务器建立成功");
			List<Socket> list = new ArrayList<Socket>();
			Map<String,Socket> socketMap = new HashMap<String,Socket>();
			while(true){
				socket = serverSocket.accept();
				
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String sr = bufferedReader.readLine();
				socketMap.put(sr,socket);
				list.add(socket);
				//将数据库中的消息纪录发送给刚连接的客户
					Statement statement = Mysql.getC().createStatement();
					String sql = "select * from qunliao2";
					ResultSet rs = statement.executeQuery(sql);
					String name2 = null;
					String xiaoxi2 = null;
					String sss = "";
					while(rs.next()){
						name2 = rs.getString("name");
						xiaoxi2 = rs.getString("xiaoxi");
						sss =name2+":"+xiaoxi2;
						PrintWriter p = new PrintWriter(socket.getOutputStream());
						p.write(sss+"\n");
						p.flush();
					}
					new Thread(new ServerRunnable(socket,list,socketMap)).start();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
