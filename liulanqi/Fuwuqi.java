package liulanqi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Fuwuqi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serverSocket = new ServerSocket(9999);
			
			Socket socket = serverSocket.accept();
			byte[] bytes = new byte[1024];
			//��ȡ��Ϣ����
			InputStream inputStream = socket.getInputStream();
			inputStream.read(bytes);
			System.out.println(""+socket.getInetAddress().getHostAddress());
			System.out.println(new String(bytes));
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String s = bufferedReader.readLine();
			String[] ss = s.split("");
			//ss[1] = /index.html?id=1&action=delete
			String[] sss = ss[1].split("[?]");
			String[] ssss = sss[1].split("&");
			if(ssss[1].equals("action=delete")){
				String sql = "delete from student where" +ssss[0];
				//.....ִ��sql���
			}
//			for(String ssss:sss){
//				System.out.println(ssss);
//			}
			
			//������Ӧ����
			FileInputStream fileInputStream = new FileInputStream(new File("src"+sss[0]));
			PrintStream writer = new PrintStream(socket.getOutputStream());
			writer.println("HTTP/1.1 200 OK");// ����Ӧ����Ϣ,������Ӧ��
			writer.println("Content-Type:text/html");
			writer.println();// ���� HTTP Э��, ���н�����ͷ��Ϣ
			byte[] buf1 = new byte[fileInputStream.available()];
			//��ȡ�ļ����ݵ�buf1���鵱��
			fileInputStream.read(buf1);
			//д�뵽����������
			writer.write("hahahahaha".getBytes());
			writer.flush();
			writer.close();
			//in.close();
			socket.close();
			
			socket.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}