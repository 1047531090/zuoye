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
		//�����
		JTextField jTextField = new JTextField();
		jTextField.setText("");
		jTextField.setBounds(200, 100, 150, 50);
		this.add(jTextField);
		
		JLabel jLabel = new JLabel();
		jLabel.setText("�����");
		jLabel.setBounds(100,100,150,50);
		this.add(jLabel);
		
		//�����
		JTextField jTextField1 = new JTextField();
		jTextField1.setText("");
		jTextField1.setBounds(200, 200, 150, 50);
		this.add(jTextField1);
		
		JLabel jLabel1 = new JLabel();
		jLabel1.setText("�����");
		jLabel1.setBounds(100,200,150,50);
		this.add(jLabel1);
		
		//�жϿ�
		JTextField jTextField2 = new JTextField();
		jTextField2.setText("");
		jTextField2.setBounds(200, 300, 150, 50);
		this.add(jTextField2);
		
		JLabel jLabel2 = new JLabel();
		jLabel2.setText("�жϿ�");
		jLabel2.setBounds(100,300,150,50);
		this.add(jLabel2);
		
		//��ʼ
		JButton jButton = new JButton();
		jButton.setText("��ʼ");
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
		
		//����
		JButton jButton1 = new JButton();
		jButton1.setText("����");
		jButton1.setBounds(200, 500, 150, 50);
		
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				flag = 3;
				String a = jTextField.getText();
				String aa = jTextField1.getText();
				
				if(a.equals(aa)){
					jTextField2.setText("��ͬ");
				}else{
					jTextField2.setText("����ͬ");
				}
			}
		});
		this.add(jButton1);
		
		
		
		this.setTitle("�������5-100");
		this.setBounds(100,100,600,600);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args){
		new Suijishu();
	}
	
}
