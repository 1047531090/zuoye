package qunliaoshujuku2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JLabel;
import javax.swing.JTextArea;
//���ն�
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
				//���ܷ������˷��ص�����
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//��ʾ��jlabel��,����һ�ֽ�һ�ֽڵĶ�
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
