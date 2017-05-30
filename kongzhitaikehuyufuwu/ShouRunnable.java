package kongzhitaikehuyufuwu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class ShouRunnable implements Runnable{
	Socket socket;
	JTextArea jTextArea;
	public ShouRunnable(Socket socket,JTextArea jTextArea){
		this.socket = socket;
		this.jTextArea = jTextArea;
	}
	
	public void run() {
		while(true){
			
			try {
				//接受服务端返回的内容
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String neirong = bufferedReader.readLine();
				System.out.println("收到内容"+neirong);
				//显示到Label当中
				jTextArea.setText(jTextArea.getText()+"\n"+neirong);//jTextArea.getText()：拿到以前内容以前的内容不覆盖
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
