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
		jTextArea.setOpaque(true);//setOpaque(true);设置控件不透明,setOpaque(false);设置控件透明
		jTextArea.setBackground(Color.WHITE);
		jTextArea.setBounds(0,0,500,300);
		this.add(jTextArea);
		
		JTextField jTextField = new JTextField();//单行文本框
		jTextField.setBounds(0, 300, 500, 20);
		this.add(jTextField);
		
		//按钮发送
		JButton jButton = new JButton("发送");
		jButton.setBounds(0,320,100,30);
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//1.获取用户输入内容
				String neirong = jTextField.getText();
				if(!"".equals(neirong)){
					//2.找到socket
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
				
				//3.发送
				//4.清空内容
			}
		});
		this.add(jButton);
		
		new Thread(new ShouRunnable(socket, jTextArea)).start();//启动线程
		
		this.setBounds(200,200,500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击叉号关闭进程
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
