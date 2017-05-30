//package soufa;
//
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class ObjectServer {
//	public static void main(String[] args){
//		ServerSocket serverSocket = null;
//		Socket socket = null;
//		try {
//			serverSocket = new ServerSocket(9999);
//			socket = serverSocket.accept();
//			ObjectInputStream onjectInputStream = new ObjectInputStream();
//			Student s = (Student) objectInputStream.read();
//			System.out.println("客户端发来对象"+s);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//}
