package soufa;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ObjectClient {
	public static void main(String[] args) {
		
		Socket socket = null;
		
		try {
			socket = new Socket("192.168.199.143",9999);
			OutputStream outputStream = socket.getOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(new Student("xufu",11));
			
//			ObjectInputStream ob
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
