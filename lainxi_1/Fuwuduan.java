package lainxi_1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Fuwuduan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//发送端（客户端）
		//接收端（服务端）
		try{
			//创建服务端并开通注册端口
			ServerSocket serversocket = new ServerSocket(8989);
			System.out.println("服务器创建成功");
			//监听对应端口
			Socket sockect = serversocket.accept();
			System.out.println("正在监听端口");
			InputStream inputStream = sockect.getInputStream();
			byte[] bytes = new byte[1024];
			int len = 0;
			StringBuffer stringBuffer = new StringBuffer();
			while((len = inputStream.read(bytes)) != -1){
				stringBuffer.append(new String(bytes,0,len));
			}
			System.out.println("服务器端：你是干什么的");
			System.out.println("客户端："+stringBuffer.toString());
			
			inputStream.close();
			
			String address1 = new String(sockect.getInetAddress().getHostName());
			System.out.println("有人来访问地址是："+address1);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
