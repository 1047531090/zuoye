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
				//���ܷ���˷��ص�����
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String neirong = bufferedReader.readLine();
				System.out.println("�յ�����"+neirong);
				//��ʾ��Label����
				jTextArea.setText(jTextArea.getText()+"\n"+neirong);//jTextArea.getText()���õ���ǰ������ǰ�����ݲ�����
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
