package wuziqi1;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Wuziqi extends JFrame {
	
	public Wuziqi(){
		
		this.setLayout(null);
		
		//绘制棋盘
		TestPaint testPaint = new TestPaint();
		testPaint.setBounds(50,50,600,550);
		this.add(testPaint);
		
		//认输
		JButton jButton = new JButton();
		jButton.setBounds(70, 600, 100, 50);
		jButton.setText("认输");
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String s11="";
				//Point pp = testPaint.pointList.get(testPaint.pointList.size());
				/*if(testPaint.pointList.get(testPaint.pointList.size()-1).getColor()==Color.black){
					s11="白子";
				}else{
					s11="黑子";
				}*/
				if(testPaint.isHei == false){
					s11 = "白子";
				}else{
					s11 = "黑子";
				}
				System.out.println(s11+"认输");
				System.exit(0);
//				TestPaint testPaint = new TestPaint();
//				testPaint.paint1(gg);
			}
		});
		this.add(jButton);
		
		//重新开始
		JButton jButton2 = new JButton("重新开始");
		jButton2.setBounds(270,600,100,50);
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				testPaint.isWinNow = false;
				testPaint.pointList.clear();
				testPaint.isHei = true;
				testPaint.repaint();
			}
		});
		this.add(jButton2);
		
		JButton jButton3 = new JButton("退出");
		jButton3.setBounds(470,600,100,50);
		jButton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		this.add(jButton3);
		
		this.setTitle("五子棋");
		this.setBounds(300,200,650,750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new Wuziqi();
	}
}
