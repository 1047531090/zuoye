package liuliuliu;

import javax.swing.JFrame;

public class TestMain extends JFrame {
	public TestMain(){
		this.setLayout(null);
		
		TestPaint testPaint = new TestPaint("��ͼ������");//"��ͼ������"���û��Զ��������
		testPaint.setBounds(0,0,300,300);
//		this.addMouseListener(testPaint);//��TestPaint�е�this.addMouseListener(this);��������Լ� ע����һ��
		this.add(testPaint);
		
		this.setBounds(100,100,300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new TestMain();
	}
	
}
