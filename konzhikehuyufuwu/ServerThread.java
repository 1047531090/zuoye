package konzhikehuyufuwu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread implements Runnable {
	Socket socket = null;
	BufferedReader br = null;

	ServerThread(Socket socket) throws IOException {
		this.socket = socket;
		br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
	}

	@Override
	public void run() {
		String content = null;
		while ((content = read()) != null) {
			System.out.println("¿Í»§¶ËËµ£º" + content);
		}
	}

	public String read() {
		try {
			return br.readLine();
		} catch (IOException e) {
		}
		return null;

	}
}
