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
		
		this.setLayout(null);//null��û�в���
		
		
		JLabel jlabel = new JLabel();
		jlabel.setText("123467890");//Ҫʵ�ֵ�����
		jlabel.setBounds(30,30,300,100);//���ÿؼ���λ��
//		jLabel.setIcon(icon);
		this.add(jlabel);//������뵽���ڵ���
	
		JButton jButton = new JButton();//����ؼ�
		jButton.setText("������");//������ʾ
		jButton.setBounds(50, 50, 100, 20);//����λ��
		this.add(jButton);//��ӵ�������
//		
//		JTextArea jTextArea = new JTextArea();
//		jTextArea.setText("����������");
//		jTextArea.setBounds(30,70,100,20);
//		this.add(jTextArea);
		
		//����˵�
		JMenuBar jMenuBar = new JMenuBar();
		
		JMenu jMenu = new JMenu();
		jMenu.setText("�ļ�");
		JMenu jMenu1 = new JMenu();
		jMenu1.setText("����");
		
		
		JMenuItem jMenuItem = new JMenuItem();
		jMenuItem.setText("�½�");
		JMenuItem jMenuItem1 = new JMenuItem();
		jMenuItem1.setText("�½�1");

		jMenu.add(jMenuItem);
		jMenu.add(jMenuItem1);
		jMenuBar.add(jMenu);
		jMenuBar.add(jMenu1);
		this.setJMenuBar(jMenuBar);
		
		this.setBounds(100,200,300,300);//���ô��ڵ�λ��
		this.setVisible(true);//���ô��ڵ���ʾ
	}
	
	public static void main(String[] args) {
		new Gui1();
	}
}
