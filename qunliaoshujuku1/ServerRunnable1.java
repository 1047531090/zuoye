package qunliaoshujuku1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;
import java.util.Set;

import qunliaoshujuku.Mysql;

public class ServerRunnable1 implements Runnable {
	Socket socket = null ;
	List<Socket> list;
	Map<String, Socket> map;
	
	public ServerRunnable1(Socket socket,List<Socket> list,Map<String, Socket> map){
		this.socket = socket;
		this.list = list;
		this.map = map;
		
	}
	
	@Override
	public synchronized void run() {
		while(true){
			BufferedReader bufferedReader;
			try {
				//����������
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String xiaoxi = null;
				xiaoxi = bufferedReader.readLine();
				//��������
				Set<String> keys = map.keySet();
				String name = "";
				for(String k : keys){
					Socket so = map.get(k);
					if(socket==so){
						name=k;
						//break;
					}
				}
				System.out.println(socket.getInetAddress()+" "+name+" ��"+xiaoxi);
				String s = name+":"+xiaoxi;
				//��������ӵ����ݿ�
			
					
					PreparedStatement psql= Mysql.getC().prepareStatement("insert into qianliai2 (name,xiaoxi)"+ "values(?,?)");
					psql.setString(1,name);
					psql.setString(2,xiaoxi); 
					psql.executeUpdate();
				
				//���������
				for(Socket s1:list){
					PrintWriter printWriter = new PrintWriter(s1.getOutputStream());
					printWriter.write(s+"\n");
					printWriter.flush();
				}
				
				
			} catch (Exception e) {
				System.out.println("�����������쳣");
			}
		}
		
	}
	
}
