package llllll;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JTextArea;

public class ClientRunnable implements Runnable{
	Socket t;
	JTextArea jTextArea;
	public ClientRunnable(Socket t,JTextArea jTextArea){
		this.t = t;
		this.jTextArea = jTextArea;
 	}
	public void run() {
		while(true){
			try{
				BufferedReader bf = new BufferedReader(new InputStreamReader(t.getInputStream()));
				String ss = bf.readLine();
				jTextArea.setText(jTextArea.getText()+"\n"+ss);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
