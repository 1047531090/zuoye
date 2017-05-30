package kehuyufuwu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Kehu1 {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("192.168.199.143",9998);
//			Socket socket = new Socket("192.168.199.143",8989);
			System.out.println("是否连接成功"+socket.isConnected());
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write("11111111".getBytes());
			outputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	
	public static void main(String[] args){
		try {
			Socket socket = new Socket("192.168.199.144",9999);
			System.out.println("是否连接成功"+socket.isConnected());
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write("1111111".getBytes());
			outputStream.close();
			
			File file = new File("aaa.txt");
			
			InputStream inputStream = new FileInputStream(file);
			byte[] bytes = new byte[1024];
			int len = 0;
			StringBuffer stringBuffer = new StringBuffer();
			while((len = inputStream.read(bytes)) != -1){
				stringBuffer.append(new String(bytes,0,len));
			}
			inputStream.close();
			
			OutputStream outputStream1 = socket.getOutputStream();
			outputStream.write(bytes);
			outputStream.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
