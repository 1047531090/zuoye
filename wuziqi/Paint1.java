package wuziqi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Paint1 extends JFrame implements MouseListener {
	
//	List<Point> pointList = new ArrayList<Point>();
	
	private boolean isHei = true;
	
	public Paint1() {
		this.addMouseListener(this);
	}
	
	
	//�������ݣ�������   �����ӣ�
	public void paint(Graphics g){
		//��������
		for(int i = -1 ; i<10; i++){
			g.drawLine(0, (i*50+50), 500, (i*50+50));
			g.drawLine((i*50+50), 0, (i*50+50), 500);
		}
		
		//��������
//		for(Point p:pointList){
//			g.setColor(p.getColor());
//			g.fillOval(p.getX(), p.getY(), Point.point_size, Point.point_size);
//		}
		
		
		//�ж���Ӯ
		
	}


//	@Override
//	public void mouseClicked(MouseEvent e) {
//		
//		int x = e.getX();
//		int y = e.getY();
//		
//		Point point = new Point(x,y);
//		if (isHei == true) {
//			//������
//			point.setColor(Color.black);
//			isHei = false;
//			
//		}else{
//			//������
//			point.setColor(Color.white);
//			isHei = true;
//		}
//		pointList.add(point);
//		
//	}


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


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
