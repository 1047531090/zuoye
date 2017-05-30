package qunliaoshujuku2;

import java.io.*;
import java.net.*;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
//���Ͷ�
public class ServerRunnable implements Runnable{
	Socket socket = null;
	List<Socket> list;
	Map<String, Socket> socketHashMap = new HashMap<String,Socket>();
	public ServerRunnable(Socket socket,List<Socket> list,Map<String, Socket> socketHashMap2){
		this.socket = socket;
		this.list = list;
		this.socketHashMap = socketHashMap2;
	}
	public void run(){
		while(true){
			try{
				//����������
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String xiaoxi = null;
				xiaoxi = bufferedReader.readLine();
				//����ʱ˭���͵�
				
				Set<String> keys = socketHashMap.keySet();
				String name ="";
				for(String s:keys){
					Socket so = socketHashMap.get(s);
					if(socket==so){
						name=s;
					}
				}
				System.out.println(name+":"+xiaoxi);
				String s = name+":"+xiaoxi;
				//��������ӵ����ݿ�
				PreparedStatement preparedStatement = null;
				preparedStatement = MysqlUtil.getInstance().prepareStatement("insert into hh(name,xiaoxi)"+"values(?,?)");
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, xiaoxi);
				preparedStatement.executeUpdate();
				//���������
				for(Socket s1:list){
					PrintWriter printWriter = new PrintWriter(s1.getOutputStream());
					printWriter.write(s+"\n");
					printWriter.flush();
				}
			}catch(Exception e){
				
			}
		}
	}
}
