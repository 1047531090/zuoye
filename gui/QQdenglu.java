package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QQdenglu extends JFrame {
	public QQdenglu(){
		
		this.setLayout(null);
		Icon icont = new ImageIcon("src/gui/image/1.png");
		Icon iconwt = new ImageIcon("src/gui/image/2.png");
		Icon icondl = new ImageIcon("src/gui/image/3.png");
		
		//qq顶部图片
		JLabel jLabelt = new JLabel();
		jLabelt.setIcon(icont);
		jLabelt.setBounds(0,0,539,228);
		this.add(jLabelt);
		
		//qq网名图片
		JLabel jLabelwt = new JLabel();
		jLabelwt.setIcon(iconwt);
		jLabelwt.setBounds(30,240,115,110);
		this.add(jLabelwt);
		
		//用户名框
		JTextField jTextField = new JTextField();
		jTextField.setText("");
		jTextField.setBounds(160,240,150,20);
		this.add(jTextField);
		
		//注册账号
		JLabel jLabel = new JLabel();
		jLabel.setText("注册账号");
		jLabel.setBounds(320,240,100,20);
		this.add(jLabel);
		
		//密码框
		JPasswordField jPasswordField = new JPasswordField();
		jPasswordField.setText("");
		jPasswordField.setBounds(160, 265, 150, 20);
		this.add(jPasswordField);
		
		//忘记密码
		JLabel jLabel1 = new JLabel();
		jLabel1.setText("忘记密码");
		jLabel1.setBounds(320,265, 100, 20);
		this.add(jLabel1);
		
		//记住密码
		JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem();
		jCheckBoxMenuItem.setText("记住密码");
		jCheckBoxMenuItem.setBounds(160,300,100,20);
		this.add(jCheckBoxMenuItem);
				
		//自动登录
		JCheckBoxMenuItem jCheckBoxMenuItem1 = new JCheckBoxMenuItem();
		jCheckBoxMenuItem1.setText("自动登录");
		jCheckBoxMenuItem1.setBounds(260,300,100,20);
		this.add(jCheckBoxMenuItem1);
		
		//登录
		JButton jButton = new JButton();
		jButton.setText("安全登录");
		jButton.setBounds(160, 330, 150, 30);
		jButton.setBackground(Color.blue);
		jButton.setForeground(Color.white);
		this.add(jButton);
		
		
		//密码验证
		JLabel jLabelmmcg = new JLabel();
		jLabelmmcg.setText("");
		jLabelmmcg.setBounds(210,370,150,30);
		this.add(jLabelmmcg);
		
		//登录确认
		String zh = "1047531090";//你的账号
		String ma = "123123";//你的密码
		
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String zh1 = jTextField.getText();
				String ma1 = jPasswordField.getText();
				if((zh1.equals(zh))&&(ma1.equals(ma))){
					jLabelmmcg.setText("登陆成功");
				}else{
					jLabelmmcg.setText("密码错误");
				}
				
			}
		});
		
		this.setBounds(100,100,539,464);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new QQdenglu();
	}
	
}
