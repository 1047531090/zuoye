package konzhikehuyufuwu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread implements Runnable {
	private Socket socket;
	BufferedReader br = null;

	ClientThread(Socket socket) throws IOException {
		this.socket = socket;
		br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
	}

	@Override
	public void run() {
		String content = null;
		while ((content = read()) != null) {
			System.out.println("·þÎñÆ÷Ëµ£º" + content);
		}
	}

	public String read() {
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}