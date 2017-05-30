package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Suijishu111 extends JFrame{
	int flag = 0;
	public Suijishu111(){
		this.setLayout(null);
		
		//随机数框
		JTextArea jtextarea = new JTextArea();
		//jtextarea.setText("");
		jtextarea.setBounds(100,50,200,30);
		this.add(jtextarea);
		
		JLabel jlabel = new JLabel();
		jlabel.setText("随机数框");
		jlabel.setBounds(30, 50, 100, 30);
		this.add(jlabel);
		
		//用户输入框
		JTextArea jtextarea1 = new JTextArea();
		//jtextarea1.setText("");
		jtextarea1.setBounds(100,100,200,30);
		this.add(jtextarea1);
		
		JLabel jlabe2 = new JLabel();
		jlabe2.setText("用户输入框");
		jlabe2.setBounds(30, 100, 100, 30);
		this.add(jlabe2);
		
		//判断框
		JTextArea jtextarea2 = new JTextArea();
		jtextarea2.setText("");
		jtextarea2.setBounds(100,150,200,30);
		this.add(jtextarea2);
		
		JLabel jlabe3 = new JLabel();
		jlabe3.setText("判断框");
		jlabe3.setBounds(30, 150, 100, 30);
		this.add(jlabe3);
		
		//开始按钮
				JButton jButton = new JButton();
				jButton.setText("开始");
				jButton.setBounds(100, 200, 200, 30);
				//监听器
				jButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						flag=2;
						jtextarea2.setText("");
				          new Thread(new Runnable(){
							public void run() {
								while(flag==2){
									jtextarea.setText((int)(Math.random()*5+1)+"");
								}
							}
						}).start();
					}
				});
				this.add(jButton);
		//结束按钮
				JButton jButton1 = new JButton();
				jButton1.setText("结束");
				jButton1.setBounds(100, 250, 200, 30);
				//监听器
				jButton1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ee) {
//						flag=1;
						String a = jtextarea.getText();
						String aa = jtextarea1.getText();
						if(a.equals(aa)){
							jtextarea2.setText("相同");
						}else{
							jtextarea2.setText("不相同");
						}
					}
				});
				this.add(jButton1);
				
		
		//总窗口
		this.setBounds(200,200,435,400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Suijishu111();
	}

}