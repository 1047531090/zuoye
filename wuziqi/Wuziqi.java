package wuziqi;

import javax.swing.JFrame;

import liuliuliu.TestPaint;

public class Wuziqi extends JFrame {
	
	public Wuziqi(){
		
		this.setLayout(null);
		
		Wuziqi wuziqiPaint = new Wuziqi();
		wuziqiPaint.setBounds(0,0,800,800);
		this.add(wuziqiPaint);
		
		
		this.setBounds(100,100,800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	
	
	public static void main(String[] args) {
		new Wuziqi();
	}
}
