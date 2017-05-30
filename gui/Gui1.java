package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class Gui1 extends JFrame {
	public Gui1(){
		
		this.setLayout(null);//null是没有布局
		
		
		JLabel jlabel = new JLabel();
		jlabel.setText("123467890");//要实现的内容
		jlabel.setBounds(30,30,300,100);//设置控件的位置
//		jLabel.setIcon(icon);
		this.add(jlabel);//将其加入到窗口当中
	
		JButton jButton = new JButton();//定义控件
		jButton.setText("蓝无数");//设置显示
		jButton.setBounds(50, 50, 100, 20);//设置位置
		this.add(jButton);//添加到窗口中
//		
//		JTextArea jTextArea = new JTextArea();
//		jTextArea.setText("请输入内容");
//		jTextArea.setBounds(30,70,100,20);
//		this.add(jTextArea);
		
		//加入菜单
		JMenuBar jMenuBar = new JMenuBar();
		
		JMenu jMenu = new JMenu();
		jMenu.setText("文件");
		JMenu jMenu1 = new JMenu();
		jMenu1.setText("编译");
		
		
		JMenuItem jMenuItem = new JMenuItem();
		jMenuItem.setText("新建");
		JMenuItem jMenuItem1 = new JMenuItem();
		jMenuItem1.setText("新建1");

		jMenu.add(jMenuItem);
		jMenu.add(jMenuItem1);
		jMenuBar.add(jMenu);
		jMenuBar.add(jMenu1);
		this.setJMenuBar(jMenuBar);
		
		this.setBounds(100,200,300,300);//设置窗口的位置
		this.setVisible(true);//设置窗口的显示
	}
	
	public static void main(String[] args) {
		new Gui1();
	}
}
