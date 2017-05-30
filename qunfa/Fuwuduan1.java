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
				//����������
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String xx = null;
				
				xx = bufferedReader.readLine();//��ȡһ���ַ�
				
				Set<String> keys = socketHashMap.keySet();
				String name = "";
				for(String s:keys){
					Socket so = socketHashMap.get(s);
					if(socket==so){
						name = s;
					}
				}
				
				System.out.println("�ͻ��������ݣ�"+name+"˵:"+xx);//IP
				String string = name+ "˵ : "+xx;
		
				//���������
				for(Socket s1:list){
					PrintWriter printWriter = new PrintWriter(s1.getOutputStream());
					printWriter.write(string+"\n");
					printWriter.flush();
					//��ջ���
				}
		

			}catch(Exception e){
				e.printStackTrace();
			}
		}

	}
}