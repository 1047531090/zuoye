package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class MyText	extends JFrame
{
	public MyText(){
		this.setLayout(null);
		
		JMenuBar jb = new JMenuBar();//菜单条
		/*JMenu jm = new JMenu();//菜单
		jm.setText("文件");
		JMenuItem jt = new JMenuItem();//下拉项
		jt.setText("新建");
		jm.add(jt);
		jb.add(jm);*/
		JMenu caidan = new JMenu();
		caidan.setText("文件");
		JMenu bianji = new JMenu();
		bianji.setText("编辑");
		JMenu chakan = new JMenu();
		chakan.setText("查看");
		JMenuItem xinjian = new JMenuItem();
		xinjian.setText("新建");
		JMenuItem baocun = new JMenuItem();
		baocun.setText("保存");
		caidan.add(xinjian);
		caidan.add(baocun);
		jb.add(caidan);
		jb.add(bianji);
		jb.add(chakan);
		this.setJMenuBar(jb);
		
		JTextArea wenben = new JTextArea();
		wenben.setBounds(0,0,500,500);
		wenben.setLineWrap(true);
		//this.add(wenben);

		xinjian.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e2){
				MyText.this.add(wenben);
				MyText.this.repaint();//刷新界面
			}
		});
		
		baocun.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//wenben.getText();
				File file = new File("2.txt");
				try{
					file.createNewFile();
					//char[] cc = new char[10];
					String s = wenben.getText();
					FileWriter fw = new FileWriter(file);
					fw.write(s);
					fw.close();
					System.out.println(s);
				}catch(Exception e1){
					e1.printStackTrace();
				}
				
			}
		});


		this.setTitle("我的记事本");
		this.setBounds(100,100,500,500);
		this.setVisible(true);
	}

	public static void main(String[] args){
		new MyText();
	}
}
