package lainxi_1;

import java.net.Socket;

public class Kehuduan_M2 {
	public static void main(String[] args){
		Socket socket = null;
		try {
			socket = new Socket("192.168.199.143",8999);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(serverSocket!==null){
				if(socket.isConnected()){
					try{
						socket.close();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
	}
}
