package qunliaoshujuku1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qunliaoshujuku.Mysql;

public class Sever1 {
	public static void main(String[] args){
			ServerSocket serverSocket = null;
			Socket socket = null;
		try {	
			serverSocket = new ServerSocket(9998);
			System.out.println("服务器创建成功");
			List<Socket> list = new ArrayList<Socket>();
			Map<String, Socket> socketMap = new HashMap<String , Socket>();
		
			while(true){
				socket = serverSocket.accept();
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String string = bufferedReader.readLine();
				socketMap.put(string, socket);
				list.add(socket);
//					Statement statement = Mysql1.getC().createStatement();
//					String stringsql = "select * from qunliao2";
//					ResultSet resultSet = statement.executeQuery(stringsql);
//					String name1 = null;
//					String xiaoxi1 = null;
//					String ss = "";
//					while(resultSet.next()){
//						name1 = resultSet.getString("name");
//						xiaoxi1 = resultSet.getString("xiaoxi");
//						ss = name1+":"+xiaoxi1;
//						PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
//						printWriter.write(ss + "\n");
//						printWriter.flush();
						
					//}
					new Thread(new ServerRunnable1(socket,list,socketMap)).start();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
