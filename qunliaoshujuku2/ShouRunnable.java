package qunliaoshujuku2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JLabel;
import javax.swing.JTextArea;
//接收端
public class ShouRunnable implements Runnable{
	Socket socket;
	JTextArea Label;
	public ShouRunnable(Socket socket,JTextArea Label){
		this.socket = socket;
		this.Label = Label;
	}
	public void run() {
		while(true){
			BufferedReader bufferedReader;
			try {
				//接受服务器端返回的内容
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//显示到jlabel中,并且一字节一字节的读
				String neirong = null;
				while((neirong = bufferedReader.readLine())!=null){
					Label.setText(Label.getText()+"\n"+neirong);
				}	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

}
