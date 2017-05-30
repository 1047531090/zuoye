package qunliaoshujuku1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JTextArea;

public class Cin1 implements Runnable {
	Socket socket = null;
	JTextArea jTextArea;
	public Cin1(Socket socket , JTextArea jTextArea){
		this.socket = socket;
		this.jTextArea=jTextArea;
	}
	public void run(){
		while(true){
			try{
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String fanhui=null;
				fanhui = bufferedReader.readLine();
				
//				while((fanhui = bufferedReader.readLine())!=null){
//					jTextArea.setText(jTextArea.getText()+"\n"+fanhui);
//				}

				//jta2.setText(jta2.getText()+"\n"+fanhui);
			}catch(Exception e){
				System.out.println("客户端输入流出现异常"+e);
			}
		}
	}
}
