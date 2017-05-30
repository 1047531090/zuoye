package qunliaoshujuku;

import java.io.*;
import java.util.Scanner;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;

public class Client extends JFrame{
	
	public Client(Socket socket){
		this.setLayout(null);
		this.setBounds(500,50,400,550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		JTextArea  jta = new JTextArea();
		jta.setBounds(10,400,250,100);
		this.add(jta);
		
		JTextArea jta2 = new JTextArea();
		jta2.setBounds(10,10,350,380);
		this.add(jta2);
		
		JButton ju = new JButton("发送");
		ju.setBounds(270,420,100,50);
		ju.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String us = jta.getText();
				if(!"".equals(us)){
					try{
						//客户端输出流
						PrintWriter p = new PrintWriter(socket.getOutputStream());
						p.write(us+"\n");
						p.flush();
					}catch(Exception eex){
						eex.printStackTrace();
					}
				}
				jta.setText("");
				//
			}
		});
		this.add(ju);
		
		new Thread(new Cin(socket,jta2)).start();
		
	}
	public static void main(String[] kl) throws IOException{
		Socket socket = null;
		try{
			socket = new Socket("192.168.199.144",9995);
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入你的网名:");
			String s = sc.next();
			PrintWriter p = new PrintWriter(socket.getOutputStream());
			p.write(s+"\n");
			p.flush();
			//new Thread(new Cout(socket)).start();
		
			new Client(socket);
			
		}catch(Exception e){
			System.out.println("客户端出现异常"+e);
		}
		
	}
}