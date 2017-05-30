package qunliaoshujuku2;
//�ͻ���
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame{
	public Client(Socket socket){
		super();
		this.setLayout(null);
		//�������
		JTextArea Label = new JTextArea();
		Label.setBounds(0, 0, 500, 250);
		Label.setOpaque(false);
		Label.setEditable(false);
		Label.setForeground(Color.BLACK);
		Label.setBackground(Color.black);
		this.add(Label);
		//�����
		JTextField jTextField = new JTextField();
		jTextField.setBounds(0, 250, 500, 30);
		this.add(jTextField);
		//��ť
		JButton jButton = new JButton();
		jButton.setText("����");
		jButton.setBounds(0, 300, 100, 40);
		jButton.setBackground(Color.blue);
		jButton.setForeground(Color.white);
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1.��ȡ�û���������
				String neirong = jTextField.getText();
				if(!"".equals(neirong)){
				//2.�ҵ�socket
					try {
						PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
						printWriter.write(neirong+"\n");
						printWriter.flush();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				jTextField.setText("");
				//3.����
				//4.�������
			}
		});
		this.add(jButton); 
		new Thread(new ShouRunnable(socket,Label)).start();;
		
		//������
		this.setBounds(200, 200, 500, 500);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		Socket socket = null;
		 try {
			 socket = new Socket("192.168.199.144",9600);
				Scanner sc = new Scanner(System.in);
				System.out.println("�������������:");
				String s = sc.next();
				PrintWriter p = new PrintWriter(socket.getOutputStream());
				p.write(s+"\n");
				p.flush();
				new Client(socket);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
