package kongzhidanliao;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("127.0.0.1", 9999);
		new Thread(new ClientThread(s)).start();
		PrintStream pStream = new PrintStream(s.getOutputStream());
		Scanner scanner = new Scanner(System.in);
		while (true) {
			pStream.println(scanner.nextLine());
		}
	}

}