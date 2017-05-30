package liuliuliu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

public class TestPaint extends JComponent implements MouseListener {
	
	//自定义控件
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
	
	public void paint(Graphics g) {//自定义控件
		gg = g ;
		for(int i = 0; i<10;i++){
			g.drawLine(0, (i*30+30),300, (i*30+30));
			g.drawLine((i*30+30), 0, (i*30+30), 300);
		}
		//画点
		for(int i = 0; i<100;i++){
			if(xs[i] != 0){
				g.fillOval(xs[i], ys[i], 15, 15);
			}
		}
		
		/*g.drawLine(0, 0, 100, 100);//划一道线
		g.drawString(s, 100, 100);//s:用户自定义
		g.drawOval(100, 100, 100, 100);//画一个圆
		g.drawRect(100, 100, 100, 100);//画一个四边形
		g.setColor(Color.green);//把下一行操作改为绿色
		g.fillOval(100,100,100,100);//把背景填满
*/		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {//找点
		// TODO Auto-generated method stub
		System.out.println("点了"+e.getX()+" "+e.getY());
		int x = i++;
		xs[x] = e.getX();
		ys[x] = e.getY();
		
		this.repaint();//让其重新调用TestPaint方法
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
