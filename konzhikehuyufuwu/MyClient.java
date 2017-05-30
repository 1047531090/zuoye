package konzhikehuyufuwu;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient {
	public static void main(String[] args) {
		Socket s;
		try {
			s = new Socket("127.0.0.1", 9000);
			new Thread(new ClientThread(s)).start();
			PrintStream pStream = new PrintStream(s.getOutputStream());
			Scanner scanner = new Scanner(System.in);
			while (true) {
				pStream.println(scanner.nextLine());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
