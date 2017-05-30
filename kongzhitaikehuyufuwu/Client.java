package kongzhitaikehuyufuwu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame{
	
	public Client(Socket socket){
		super();
		this.setLayout(null);
		
		JTextArea jTextArea = new JTextArea();
		jTextArea.setOpaque(true);//setOpaque(true);���ÿؼ���͸��,setOpaque(false);���ÿؼ�͸��
		jTextArea.setBackground(Color.WHITE);
		jTextArea.setBounds(0,0,500,300);
		this.add(jTextArea);
		
		JTextField jTextField = new JTextField();//�����ı���
		jTextField.setBounds(0, 300, 500, 20);
		this.add(jTextField);
		
		//��ť����
		JButton jButton = new JButton("����");
		jButton.setBounds(0,320,100,30);
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//1.��ȡ�û���������
				String neirong = jTextField.getText();
				if(!"".equals(neirong)){
					//2.�ҵ�socket
					try {
						PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
						printWriter.write(neirong+"\n");
						printWriter.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				jTextField.setText("");
				
				//3.����
				//4.�������
			}
		});
		this.add(jButton);
		
		new Thread(new ShouRunnable(socket, jTextArea)).start();//�����߳�
		
		this.setBounds(200,200,500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����Źرս���
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		Socket socket = null;
		try {
			socket = new Socket("192.168.199.145", 9999);
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.write("xfc\n");
			printWriter.flush();
			
			new Client(socket);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
