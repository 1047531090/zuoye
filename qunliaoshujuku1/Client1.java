package qunliaoshujuku1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class Client1 extends JFrame {
	public Client1(Socket socket){
		this.setLayout(null);
		
		JTextArea jTextArea = new JTextArea();
		jTextArea.setBounds(5,0,570,350);
		this.add(jTextArea);
		
		JTextArea jTextArea1 = new JTextArea();
		jTextArea1.setBounds(5,355,360,190);
		this.add(jTextArea1);
		
		JButton jButton = new JButton("发送");
		jButton.setBounds(420,400,100,50);
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String string = jTextArea1.getText();
				if(!"".equals(string)){
					PrintWriter printWriter;
					try {
						printWriter = new PrintWriter(socket.getOutputStream());
						printWriter.write(string + "\n");
						printWriter.flush();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				jTextArea1.setText("");
			}
		});
		this.add(jButton);
		
		this.setBounds(200,200,600,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		new Thread(new Cin1(socket,jTextArea)).start();
	}
	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket("192.168.199.144", 9998);
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入你的网名");
			String string = scanner.next();
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.write(string+"\n");
			printWriter.flush();
			
			new Client1(socket);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("客户端异常");
			e.printStackTrace();
		}
		
	}
}
