package lainxi_1;

import java.net.ServerSocket;
import java.net.Socket;

public class Main2 {
	public static void main(String[] args){
		ServerSocket setversocket = null;
		Socket socket = new Socket();
		try{
			setversocket = new ServerSocket(8999);
		}catch(Exception e){
			e.printStackTarace();
		}
	}
}
