package liuliuliu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

public class TestPaint extends JComponent implements MouseListener {
	
	//�Զ���ؼ�
	private String s ;
	Graphics gg;
	private boolean flag = true;
	int i = 0;
	int[] xs = new int[100];
	int[] ys = new int[100];
	
	public TestPaint(String s){
		this.addMouseListener(this);//
		this.s = s;
	}
	
	public void paint(Graphics g) {//�Զ���ؼ�
		gg = g ;
		for(int i = 0; i<10;i++){
			g.drawLine(0, (i*30+30),300, (i*30+30));
			g.drawLine((i*30+30), 0, (i*30+30), 300);
		}
		//����
		for(int i = 0; i<100;i++){
			if(xs[i] != 0){
				g.fillOval(xs[i], ys[i], 15, 15);
			}
		}
		
		/*g.drawLine(0, 0, 100, 100);//��һ����
		g.drawString(s, 100, 100);//s:�û��Զ���
		g.drawOval(100, 100, 100, 100);//��һ��Բ
		g.drawRect(100, 100, 100, 100);//��һ���ı���
		g.setColor(Color.green);//����һ�в�����Ϊ��ɫ
		g.fillOval(100,100,100,100);//�ѱ�������
*/		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {//�ҵ�
		// TODO Auto-generated method stub
		System.out.println("����"+e.getX()+" "+e.getY());
		int x = i++;
		xs[x] = e.getX();
		ys[x] = e.getY();
		
		this.repaint();//�������µ���TestPaint����
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
