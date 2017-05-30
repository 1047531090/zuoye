package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.FlatteningPathIterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Suijishu extends JFrame {
	int flag = 0;
	public Suijishu(){
		
		this.setLayout(null);
		//随机框
		JTextField jTextField = new JTextField();
		jTextField.setText("");
		jTextField.setBounds(200, 100, 150, 50);
		this.add(jTextField);
		
		JLabel jLabel = new JLabel();
		jLabel.setText("随机框");
		jLabel.setBounds(100,100,150,50);
		this.add(jLabel);
		
		//输入框
		JTextField jTextField1 = new JTextField();
		jTextField1.setText("");
		jTextField1.setBounds(200, 200, 150, 50);
		this.add(jTextField1);
		
		JLabel jLabel1 = new JLabel();
		jLabel1.setText("输入框");
		jLabel1.setBounds(100,200,150,50);
		this.add(jLabel1);
		
		//判断框
		JTextField jTextField2 = new JTextField();
		jTextField2.setText("");
		jTextField2.setBounds(200, 300, 150, 50);
		this.add(jTextField2);
		
		JLabel jLabel2 = new JLabel();
		jLabel2.setText("判断框");
		jLabel2.setBounds(100,300,150,50);
		this.add(jLabel2);
		
		//开始
		JButton jButton = new JButton();
		jButton.setText("开始");
		jButton.setBounds(200, 400, 150, 50);
		
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ee) {
				// TODO Auto-generated method stub
				flag = 2;
				jTextField2.setText("");
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						while(flag == 2){
							jTextField.setText((int)(Math.random()*100+5)+"");
						}
					}
				}).start();
			}
		});
		this.add(jButton);
		
		//结束
		JButton jButton1 = new JButton();
		jButton1.setText("结束");
		jButton1.setBounds(200, 500, 150, 50);
		
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				flag = 3;
				String a = jTextField.getText();
				String aa = jTextField1.getText();
				
				if(a.equals(aa)){
					jTextField2.setText("相同");
				}else{
					jTextField2.setText("不相同");
				}
			}
		});
		this.add(jButton1);
		
		
		
		this.setTitle("随机数出5-100");
		this.setBounds(100,100,600,600);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args){
		new Suijishu();
	}
	
}
