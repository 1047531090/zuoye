package gui;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.TextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Scrollable;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class Guibaocun extends JFrame {
	
	private static final String xfc = "H:/eclipse/workspace/lianxi/src/gui/xfc.txt";
	JTextArea textArea;
	JScrollPane scrollPane;
	
	
	public Guibaocun(){
		
		this.setLayout(null);
		
		JMenuBar jMenuBar = new JMenuBar();
		
		JMenu jMenu = new JMenu();
		jMenu.setText("文件");
		
		
		JMenuItem jMenuItem = new JMenuItem();
		jMenuItem.setText("新建");
		JMenuItem jMenuItem1 = new JMenuItem();
		jMenuItem1.setText("保存");
		
		JMenu jMenu2 = new JMenu();
		jMenu2.setText("编译");
		
		jMenu.add(jMenuItem);
		jMenu.add(jMenuItem1);
		
		jMenuBar.add(jMenu);
		jMenuBar.add(jMenu2);
		this.setJMenuBar(jMenuBar);
		
		JTextArea jTextArea = new JTextArea();
		jTextArea.setBounds(0,0,300,300);
		jTextArea.setLineWrap(true);
		
		jMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Guibaocun.this.add(jTextArea);
				
			}
		});
		
		jMenuItem1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e1) {
				// TODO Auto-generated method stub
				String s = jTextArea.getText();
				try {
					FileWriter fw = new FileWriter(xfc);
					fw.write(s);
					fw.close();
					System.out.println(s);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
		
		this.setBounds(100,200,300,300);
		this.setVisible(true);
		
		
	}

	
	public static void main(String[] args){
		new Guibaocun();
		
	}
	
}
