package qunliaoshujuku;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.sql.PreparedStatement;

class ServerRunnable implements Runnable{
	//Connection con = Mysql.getC();
	Socket socket = null;
	List<Socket> list;
	Map<String,Socket> socketMap;
	public ServerRunnable(Socket socket,List<Socket> list,Map<String,Socket> socketMap){
		this.socket = socket;
		this.list = list;
		this.socketMap = socketMap;
	}
	public synchronized void run(){
		
		while(true){
			try{
				//����������
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String xiaoxi = null;
				xiaoxi = bufferedReader.readLine();
				//��������
				Set<String> keys = socketMap.keySet();
				String name = "";
				for(String k : keys){
					Socket so = socketMap.get(k);
					if(socket==so){
						name=k;
						//break;
					}
				}
				System.out.println(socket.getInetAddress()+" "+name+" ��"+xiaoxi);
				String s = name+":"+xiaoxi;
				//��������ӵ����ݿ�
				try{
					PreparedStatement psql;
					psql = Mysql.getC().prepareStatement("insert into qunliao2(name,xiaoxi)"+ "values(?,?)");
					psql.setString(1,name);
					psql.setString(2,xiaoxi); 
					psql.executeUpdate();
				}catch(Exception ee){
					ee.printStackTrace();
				}
				//���������
				for(Socket s1:list){
					PrintWriter printWriter = new PrintWriter(s1.getOutputStream());
					printWriter.write(s+"\n");
					printWriter.flush();
				}
				
			}catch(Exception e){
				System.out.println("�����������쳣"+e);
			}
			
		}
		
	}
}