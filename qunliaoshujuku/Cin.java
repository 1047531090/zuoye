package qunliaoshujuku;

import java.io.*;

import javax.swing.JTextArea;

import java.net.*;


class Cin implements Runnable{
	Socket socket = null;
	JTextArea jta2;
	public Cin(Socket socket , JTextArea jta2){
		this.socket = socket;
		this.jta2=jta2;
	}
	public void run(){
		while(true){
			try{
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String fanhui=null;
				//fanhui = bufferedReader.readLine();
				
				while((fanhui = bufferedReader.readLine())!=null){
					jta2.setText(jta2.getText()+"\n"+fanhui);
				}
				//jta2.setText(jta2.getText()+"\n"+fanhui);
			}catch(Exception e){
				System.out.println("客户端输入流出现异常"+e);
			}
		}
	}
}