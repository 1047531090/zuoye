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
			//读取信息内容
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
				//.....执行sql语句
			}
//			for(String ssss:sss){
//				System.out.println(ssss);
//			}
			
			//发送响应内容
			FileInputStream fileInputStream = new FileInputStream(new File("src"+sss[0]));
			PrintStream writer = new PrintStream(socket.getOutputStream());
			writer.println("HTTP/1.1 200 OK");// 返回应答消息,并结束应答
			writer.println("Content-Type:text/html");
			writer.println();// 根据 HTTP 协议, 空行将结束头信息
			byte[] buf1 = new byte[fileInputStream.available()];
			//读取文件内容到buf1数组当中
			fileInputStream.read(buf1);
			//写入到输入流当中
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