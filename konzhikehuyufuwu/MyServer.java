package konzhikehuyufuwu;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
	static ServerSocket serverSocket;
	static Socket socket;

	public static void main(String[] args) throws IOException {
		serverSocket = new ServerSocket(9000);
		socket = serverSocket.accept();
		new Thread(new ServerThread(socket)).start();
		PrintStream pStream = new PrintStream(socket.getOutputStream());
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("·şÎñÆ÷¶ËÊäÈë£º");
			pStream.println(scanner.nextLine());
		}

	}
}