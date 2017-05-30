package wuziqi1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;


public  class TestPaint extends JComponent implements MouseListener{
	List<Point> pointList = new ArrayList<Point>();
	
	public boolean isHei = true;
	private int currentX = 0;//��ǰ����X��λ��
	private int currentY = 0;//��ǰ����Y��λ��
	public boolean isWinNow = false;
	
	public TestPaint() {
		this.addMouseListener(this);
	}
	
	//�������ݣ������̣������ӣ�
	public void paint(Graphics g) {
		//��������
		for(int i=-1;i<10;i++){
			g.drawLine(20, (i*50+70),520,(i*50+70));
			g.drawLine((i*50+70),20, (i*50+70), 520);
		}
		
		//��������
		for(Point p:pointList){
			g.setColor(p.getColor());
			g.fillOval(p.getX(), p.getY(), Point.point_size, Point.point_size);
		}
		
		//�ж���Ӯ
		isWin();
		if(isWinNow==true){
			g.setFont(new Font("����",Font.BOLD,50));
			g.setColor(Color.black);
			String s ;
			if(isHei != true){
				s = "����";
			}else{
				s = "����";
			}
			g.drawString(s+"Ӯ��", 200, 200);
		}
	}
	
	public void paint1(Graphics gg){
				if(isWinNow==true){
					gg.setFont(new Font("����",Font.BOLD,50));
					gg.setColor(Color.black);
					String s ;
					if(isHei != true){
						s = "����";
					}else{
						s = "����";
					}
					gg.drawString(s+"����", 200, 200);
				}
	}
	
	//�ж���Ӯ�Ĺ���
	public void isWin(){
		int dongxi = 0;
		//��
		for(int nowX = currentX,i=0;i<5&&nowX<=520;nowX+=50,i++){
			Point point = findPoint(nowX,currentY);
			if(point!=null){
				//��ǰ����ʱ����
				if(isHei!=true){
					if(point.getColor()==Color.black){
						dongxi++;
					}else{
						break;
					}
				}
				//��ǰ����ʱ����
				if(isHei!=false){
					if(point.getColor()==Color.white){
						dongxi++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		//��
		for(int nowX = currentX-50,i=0;i<5&&nowX>=0;nowX-=50,i++){
			Point point = findPoint(nowX,currentY);
			if(point!=null){
				//��ǰ�����Ǻ���
				if(isHei!=true){
					if(point.getColor()==Color.black){
						dongxi++;
					}else{
						break;
					}
				}
				//��ǰ�����ǰ���
				if(isHei!=false){
					if(point.getColor()==Color.white){
						dongxi++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		if(isHei!=true){
			System.out.println("����������Ӹ���"+dongxi);
		}else{
			System.out.println("����������Ӹ���"+dongxi);
		}
		
		if(dongxi>=5){
			isWinNow = true;
			if(isHei != true){
				System.out.println("����Ӯ��");
			}else{
				System.out.println("����Ӯ��");
			}
		}
		//��
		int nanbei = 0;
		for(int nowY = currentY,i=0;i<5&&nowY<=520;nowY+=50,i++){
			Point point = findPoint(currentX,nowY);
			if(point!=null){
				//��ǰ����ʱ����
				if(isHei!=true){
					if(point.getColor()==Color.black){
						nanbei++;
					}else{
						break;
					}
				}
				//��ǰ����ʱ����
				if(isHei!=false){
					if(point.getColor()==Color.white){
						nanbei++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		//��
		for(int nowY = currentY-50,i=0;i<5&&nowY>=0;nowY-=50,i++){
			Point point = findPoint(currentX,nowY);
			if(point!=null){
				//��ǰ����ʱ����
				if(isHei!=true){
					if(point.getColor()==Color.black){
						nanbei++;
					}else{
						break;
					}
				}
				//��ǰ����ʱ����
				if(isHei!=false){
					if(point.getColor()==Color.white){
						nanbei++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		if(isHei!=true){
			System.out.println("�ϱ�������Ӹ���"+nanbei);
		}else{
			System.out.println("�ϱ�������Ӹ���"+nanbei);
		}
		if(nanbei>=5){
			isWinNow = true;
			if(isHei != true){
				System.out.println("����Ӯ��");
//				iii = true;
			}else{
				System.out.println("����Ӯ��");
//				iii = false;
			}
		}
		//����
		int dongbeixinan = 0;
		for(int nowX = currentX,nowY = currentY,i=0;nowY>=0&&nowX<=520&&i<5;nowX+=50,nowY-=50,i++){
			Point point = findPoint(nowX,nowY);
			if(point!=null){
				//��ǰ����ʱ����
				if(isHei!=true){
					if(point.getColor()==Color.black){
						dongbeixinan++;
					}else{
						break;
					}
				}
				//��ǰ����ʱ����
				if(isHei!=false){
					if(point.getColor()==Color.white){
						dongbeixinan++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		//����
		for(int nowX = currentX-50,nowY = currentY+50,i=0;nowY<=520&&nowX>=0&&i<5;nowX-=50,nowY+=50,i++){
			Point point = findPoint(nowX,nowY);
			if(point!=null){
				//��ǰ����ʱ����
				if(isHei!=true){
					if(point.getColor()==Color.black){
						dongbeixinan++;
					}else{
						break;
					}
				}
				//��ǰ����ʱ����
				if(isHei!=false){
					if(point.getColor()==Color.white){
						dongbeixinan++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		if(isHei!=true){
			System.out.println("�������Ϸ�����Ӹ���"+dongbeixinan);
		}else{
			System.out.println("�������Ϸ�����Ӹ���"+dongbeixinan);
		}
		
		if(dongbeixinan>=5){
			isWinNow = true;
			if(isHei != true){
				System.out.println("����Ӯ��");
//				iii = true;
			}else{
				System.out.println("����Ӯ��");
//				iii = false;
			}
		}
		//����
		int dongnanxibei = 0;
		for(int nowX = currentX,nowY = currentY,i=0;nowY<=520&&nowX<=520&&i<5;nowX+=50,nowY+=50,i++){
			Point point = findPoint(nowX,nowY);
			if(point!=null){
				//��ǰ����ʱ����
				if(isHei!=true){
					if(point.getColor()==Color.black){
						dongnanxibei++;
					}else{
						break;
					}
				}
				//��ǰ����ʱ����
				if(isHei!=false){
					if(point.getColor()==Color.white){
						dongnanxibei++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		//����
		for(int nowX = currentX-50,nowY = currentY-50,i=0;nowY>=0&&nowX>=0&&i<5;nowX-=50,nowY-=50,i++){
			Point point = findPoint(nowX,nowY);
			if(point!=null){
				//��ǰ����ʱ����
				if(isHei!=true){
					if(point.getColor()==Color.black){
						dongnanxibei++;
					}else{
						break;
					}
				}
				//��ǰ����ʱ����
				if(isHei!=false){
					if(point.getColor()==Color.white){
						dongnanxibei++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		if(isHei!=true){
			System.out.println("��������������Ӹ���"+dongnanxibei);
		}else{
			System.out.println("��������������Ӹ���"+dongnanxibei);
		}
		
		if(dongnanxibei>=5){
			isWinNow = true;
			if(isHei != true){
				System.out.println("����Ӯ��");
//				iii = true;
			}else{
				System.out.println("����Ӯ��");
//				iii = false;
			}
			
		}
		
	}
	
	
	
	//�ҵ�
	public Point findPoint(int x,int y){
		for(Point p:pointList){
			if((p.getX()==x)&&(p.getY()==y)){
				//�ж������Ƿ�����ͬ��
				return p;
			}
		}
		return null;
	}
	
	public void mouseClicked(MouseEvent e) {
		System.out.println("����"+e.getX()+"  "+e.getY());
		int x = e.getX();
		int y = e.getY();
		//���Ӧ������һ������
		double xianX = Math.round((x-20)/50.0);
		double xianY = Math.round((y-20)/50.0);
		//System.out.println("�ڼ�����"+xianY+" "+Math.round(xianY));
		x = ((int)xianX)*50;
		y = ((int)xianY)*50;
		//��¼��ǰ����λ��
		currentX = x;
		currentY = y;
		//int x = e.getX()-Point.Point_size/2;
		//int y = e.getY()-Point.Point_size/2;
		//�����ظ���������
		boolean isHave = false;
		for(Point p:pointList){
			if((p.getX()==x)&&(p.getY()==y)){
				isHave = true;
			}
		}
		if(!isHave){
			Point point = new Point(x,y);
			if(isHei==true){
				  //������
				point.setColor(Color.black);
				 isHei = false;
			  }else{
				  //������
				  point.setColor(Color.white);
				 isHei = true;
			  }
			if(isWinNow==false){
				pointList.add(point);
			}
//			pointList.add(point);
			//�û������������»���
			this.repaint();
		}
		System.out.println("Ŀǰ������Ϊ"+pointList.size());
	}
	
	
	
	public void mousePressed(MouseEvent e) {
		
		
	}

	
	public void mouseReleased(MouseEvent e) {
		
		
	}

	
	public void mouseEntered(MouseEvent e) {
		
		
	}

	
	public void mouseExited(MouseEvent e) {
		
		
	}
}