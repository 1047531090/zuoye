package gui;

import java.awt.Color;  
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;  
 
public class TrafficLight extends JFrame{    
    boolean flag = true;

    public TrafficLight(){  

        this.setLayout(null);
        this.setBounds(100,100,200,500);
        this.setVisible(true);
        
        JLabel jLabel = new JLabel();
        jLabel.setBounds(70,360,120,50);
        this.add(jLabel);
        
        JButton jButtony1 = new JButton();
        jButtony1.setText("");
        jButtony1.setBounds(70, 80, 60, 60);
        this.add(jButtony1);
        
        JButton jButtony2 = new JButton();
        jButtony2.setText("");
        jButtony2.setBounds(70, 150, 60, 60);
        this.add(jButtony2);
        
        JButton jButtony3 = new JButton();
        jButtony3.setText("");
        jButtony3.setBounds(70, 220, 60, 60);
        this.add(jButtony3);

        
        JButton jButton = new JButton();
        jButton.setText("开始");;
        jButton.setBounds(70, 300, 60, 50);
        
        jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						while(flag){
							try{
								jButtony1.setBackground(Color.red);
								jButtony3.setBackground(Color.white);
								jButtony2.setBackground(Color.white);
								jLabel.setText("红灯停");
								Thread.sleep(5000);
								jButtony2.setBackground(Color.yellow);
								jButtony1.setBackground(Color.white);
								jLabel.setText("黄灯亮了等一等");
								Thread.sleep(3000);
								jButtony3.setBackground(Color.green);
								jButtony2.setBackground(Color.white);
								jButtony1.setBackground(Color.white);
								jLabel.setText("绿灯行");
								Thread.sleep(5000);
							}catch(Exception e){
								e.printStackTrace();
							}
						}
					}
				}).start();
			}
		});
        this.add(jButton);
        
    }  

    public static void main(String[] args) {  
        new TrafficLight();  
    }  
  
}  