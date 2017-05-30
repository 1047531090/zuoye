package llllll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Client2 extends JFrame{ 
	public Client2(Socket t){
		
		this.setLayout(null);
		this.setTitle("客户端");
		
		//消息显示框
		JTextArea jTextArea = new JTextArea();
		jTextArea.setBounds(30,20,420,300);
		jTextArea.setEditable(false);
		
		//显示历史消息
		try {
			Connection con = Demo.getInstace();
	     	Statement statement = con.createStatement();
	     	String sql = "select * from qq";
	        ResultSet rs = statement.executeQuery(sql);
 	        while(rs.next()){
 	        	jTextArea.setText(rs.getString("xiaoxi")+"\n"+jTextArea.getText());
 	        }
		} catch(Exception e1) {   
	         	e1.printStackTrace();
	    }
		this.add(jTextArea);
		
		//输入要发送的消息
		JTextField jTextField = new JTextField();
		jTextField.setBounds(30,340,330,30);
		this.add(jTextField);
		//发送按钮
		JButton jButton = new JButton();
		jButton.setText("发送");
		jButton.setBounds(380,340,70,30);
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = jTextField.getText();
				if(!"".equals(s)){
					try {
						PrintWriter printWriter = new PrintWriter(t.getOutputStream());
						printWriter.write(s+"\n");
						printWriter.flush();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				jTextField.setText("");
			}
		});
		this.add(jButton);	
		
		JButton jButton2 = new JButton();
		jButton2.setText("查看聊天记录");
		jButton2.setBounds(30,380,120,30);
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFrame jFrame = new JFrame();
					jFrame.setLayout(null);
					jFrame.setTitle("聊天记录");
					
					JTextArea jTextArea2 = new JTextArea();
					jTextArea2.setBounds(0,0,400,300);
					//jTextArea2.setEditable(false);
					jFrame.add(jTextArea2);
					
					Connection con = Demo.getInstace();
			     	Statement statement = con.createStatement();
			     	String sql = "select * from qq";
			        ResultSet rs = statement.executeQuery(sql);
		 	        while(rs.next()){
		 	        	jTextArea2.setText(rs.getString("xiaoxi")+"\n"+jTextArea.getText());
		 	        }
		 	       jFrame.setBounds(0,200,400,300);
		 	       jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 	       jFrame.setVisible(true);
				} catch(Exception e1) {   
			         	e1.printStackTrace();
			    }
			}
		});
		this.add(jButton2);	
		
		//删除数据库中的记录
		JButton jButton3 = new JButton();
		jButton3.setText("清除历史消息");
		jButton3.setBounds(180,380,120,30);
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement psql = (PreparedStatement) Demo.getInstace().prepareStatement("truncate table qq");
					psql.executeUpdate();
			    } catch(Exception e1) {   
		         	e1.printStackTrace();
		        } 	  
			}
		});
		this.add(jButton3);	
		
		//只清除桌面显示记录，并不清除数据内容
		JButton jButton4 = new JButton();
		jButton4.setText("清除聊天消息");
		jButton4.setBounds(330,380,120,30);
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jTextArea.setText("");
//					PreparedStatement psql = (PreparedStatement) Demo.getInstace().prepareStatement("truncate table qq");
//					psql.executeUpdate();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		this.add(jButton4);	
		
		
		new Thread(new ClientRunnable(t, jTextArea)).start();
		this.setBounds(200,200,500,460);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(true);
	}
	public static void main(String[] args){
		Socket t = null;
		try {
			System.out.println("正在连接服务器");
			t = new Socket("127.0.0.1",9997); 
			PrintWriter printWriter = new PrintWriter(t.getOutputStream());
			printWriter.write("高维安\n");
			printWriter.flush();
			new Client2(t);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}


