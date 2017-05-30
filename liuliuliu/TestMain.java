package liuliuliu;

import javax.swing.JFrame;

public class TestMain extends JFrame {
	public TestMain(){
		this.setLayout(null);
		
		TestPaint testPaint = new TestPaint("大图帮派你");//"大图帮派你"：用户自定义的内容
		testPaint.setBounds(0,0,300,300);
//		this.addMouseListener(testPaint);//把TestPaint中的this.addMouseListener(this);放在这把自己 注册上一样
		this.add(testPaint);
		
		this.setBounds(100,100,300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new TestMain();
	}
	
}
