package kehuyufuwu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Fuwu1 {
	
	/*
	public static void main(String[] args) {
		//创建服务端并开通注册窗口
		try {
			ServerSocket serversocket = new ServerSocket(9998);
			System.out.println("服务端创建成功");
			
			Socket socket = serversocket.accept();
			System.out.println("等待客户端并监听");
			InputStream inputStream = socket.getInputStream();
			byte[] bytes = new byte[1024];
			int len = 0;
			StringBuffer stringBuffer = new StringBuffer();
			while((len = inputStream.read(bytes)) != -1){
				stringBuffer.append(new String(bytes,0,len));
			}
			System.out.println("服务器端：你是干什么的");
			System.out.println("客户端："+stringBuffer.toString());
			
			inputStream.close();
			String string = new String(socket.getInetAddress().getHostName());
			System.out.println("地址:"+string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
	public static void main(String[] args) {
		try {
			//创建服务端
			ServerSocket serverSocket = new ServerSocket(9998);
			System.out.println("服务创建成功");
			//监听
			Socket socket = serverSocket.accept();
			System.out.println("等待客户端并监听");
			InputStream inputStream = socket.getInputStream();
			byte[] bytes = new byte[1024];
			int len= 0;
			StringBuffer stringBuffer = new StringBuffer();
			while((len = inputStream.read(bytes)) !=-1 ){
				stringBuffer.append(new String(bytes,0,len));
			}
			System.out.println("服务端：你是干什么的");
			System.out.println("客户端："+stringBuffer.toString());
			inputStream.close();
			String s = new String(socket.getInetAddress().getHostName());
			System.out.println("地址："+s);
			
			File file = new File("BBB.txt");
			
			OutputStream outputStream = new FileOutputStream(file,true);
			/*
			String ss = sb.toString();
			byte[] g = ss.getBytes();
			for (int i = 0; i < g.length; i++) {
				out.write(g[i]);
			}
			out.close();
			*/
			
			String string = new String();
			byte[] bytes1 = string.getBytes();
			for(int i = 0;i<bytes1.length;i++){
				outputStream.write(bytes1[i]);
			}
			outputStream.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
