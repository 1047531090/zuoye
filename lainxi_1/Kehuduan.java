package lainxi_1;


import java.net.Socket;
import java.io.OutputStream;

public class Kehuduan {
	
	public static void main(String[] args){
		
		try {
			Socket socket = new Socket("192.168.199.143",9998);
			System.out.println("是否连接成功"+socket.isConnected());
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write("打酱油的上后面去，先来点千层饼".getBytes());
			outputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}





