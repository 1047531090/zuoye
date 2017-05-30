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
	private int currentX = 0;//当前棋子X的位置
	private int currentY = 0;//当前棋子Y的位置
	public boolean isWinNow = false;
	
	public TestPaint() {
		this.addMouseListener(this);
	}
	
	//绘制内容（画棋盘，画棋子）
	public void paint(Graphics g) {
		//绘制棋盘
		for(int i=-1;i<10;i++){
			g.drawLine(20, (i*50+70),520,(i*50+70));
			g.drawLine((i*50+70),20, (i*50+70), 520);
		}
		
		//绘制棋子
		for(Point p:pointList){
			g.setColor(p.getColor());
			g.fillOval(p.getX(), p.getY(), Point.point_size, Point.point_size);
		}
		
		//判断输赢
		isWin();
		if(isWinNow==true){
			g.setFont(new Font("宋体",Font.BOLD,50));
			g.setColor(Color.black);
			String s ;
			if(isHei != true){
				s = "黑子";
			}else{
				s = "白子";
			}
			g.drawString(s+"赢了", 200, 200);
		}
	}
	
	public void paint1(Graphics gg){
				if(isWinNow==true){
					gg.setFont(new Font("宋体",Font.BOLD,50));
					gg.setColor(Color.black);
					String s ;
					if(isHei != true){
						s = "黑子";
					}else{
						s = "白子";
					}
					gg.drawString(s+"认输", 200, 200);
				}
	}
	
	//判断输赢的规则
	public void isWin(){
		int dongxi = 0;
		//东
		for(int nowX = currentX,i=0;i<5&&nowX<=520;nowX+=50,i++){
			Point point = findPoint(nowX,currentY);
			if(point!=null){
				//当前棋子时黑子
				if(isHei!=true){
					if(point.getColor()==Color.black){
						dongxi++;
					}else{
						break;
					}
				}
				//当前棋子时白子
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
		//西
		for(int nowX = currentX-50,i=0;i<5&&nowX>=0;nowX-=50,i++){
			Point point = findPoint(nowX,currentY);
			if(point!=null){
				//当前棋子是黑子
				if(isHei!=true){
					if(point.getColor()==Color.black){
						dongxi++;
					}else{
						break;
					}
				}
				//当前棋子是白子
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
			System.out.println("东西方向黑子个数"+dongxi);
		}else{
			System.out.println("东西方向白子个数"+dongxi);
		}
		
		if(dongxi>=5){
			isWinNow = true;
			if(isHei != true){
				System.out.println("黑子赢了");
			}else{
				System.out.println("白子赢了");
			}
		}
		//南
		int nanbei = 0;
		for(int nowY = currentY,i=0;i<5&&nowY<=520;nowY+=50,i++){
			Point point = findPoint(currentX,nowY);
			if(point!=null){
				//当前棋子时黑子
				if(isHei!=true){
					if(point.getColor()==Color.black){
						nanbei++;
					}else{
						break;
					}
				}
				//当前棋子时白子
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
		//北
		for(int nowY = currentY-50,i=0;i<5&&nowY>=0;nowY-=50,i++){
			Point point = findPoint(currentX,nowY);
			if(point!=null){
				//当前棋子时黑子
				if(isHei!=true){
					if(point.getColor()==Color.black){
						nanbei++;
					}else{
						break;
					}
				}
				//当前棋子时白子
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
			System.out.println("南北方向黑子个数"+nanbei);
		}else{
			System.out.println("南北方向白子个数"+nanbei);
		}
		if(nanbei>=5){
			isWinNow = true;
			if(isHei != true){
				System.out.println("黑子赢了");
//				iii = true;
			}else{
				System.out.println("白子赢了");
//				iii = false;
			}
		}
		//东北
		int dongbeixinan = 0;
		for(int nowX = currentX,nowY = currentY,i=0;nowY>=0&&nowX<=520&&i<5;nowX+=50,nowY-=50,i++){
			Point point = findPoint(nowX,nowY);
			if(point!=null){
				//当前棋子时黑子
				if(isHei!=true){
					if(point.getColor()==Color.black){
						dongbeixinan++;
					}else{
						break;
					}
				}
				//当前棋子时白子
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
		//西南
		for(int nowX = currentX-50,nowY = currentY+50,i=0;nowY<=520&&nowX>=0&&i<5;nowX-=50,nowY+=50,i++){
			Point point = findPoint(nowX,nowY);
			if(point!=null){
				//当前棋子时黑子
				if(isHei!=true){
					if(point.getColor()==Color.black){
						dongbeixinan++;
					}else{
						break;
					}
				}
				//当前棋子时白子
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
			System.out.println("东北西南方向黑子个数"+dongbeixinan);
		}else{
			System.out.println("东北西南方向白子个数"+dongbeixinan);
		}
		
		if(dongbeixinan>=5){
			isWinNow = true;
			if(isHei != true){
				System.out.println("黑子赢了");
//				iii = true;
			}else{
				System.out.println("白子赢了");
//				iii = false;
			}
		}
		//东南
		int dongnanxibei = 0;
		for(int nowX = currentX,nowY = currentY,i=0;nowY<=520&&nowX<=520&&i<5;nowX+=50,nowY+=50,i++){
			Point point = findPoint(nowX,nowY);
			if(point!=null){
				//当前棋子时黑子
				if(isHei!=true){
					if(point.getColor()==Color.black){
						dongnanxibei++;
					}else{
						break;
					}
				}
				//当前棋子时白子
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
		//西北
		for(int nowX = currentX-50,nowY = currentY-50,i=0;nowY>=0&&nowX>=0&&i<5;nowX-=50,nowY-=50,i++){
			Point point = findPoint(nowX,nowY);
			if(point!=null){
				//当前棋子时黑子
				if(isHei!=true){
					if(point.getColor()==Color.black){
						dongnanxibei++;
					}else{
						break;
					}
				}
				//当前棋子时白子
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
			System.out.println("东南西北方向黑子个数"+dongnanxibei);
		}else{
			System.out.println("东南西北方向白子个数"+dongnanxibei);
		}
		
		if(dongnanxibei>=5){
			isWinNow = true;
			if(isHei != true){
				System.out.println("黑子赢了");
//				iii = true;
			}else{
				System.out.println("白子赢了");
//				iii = false;
			}
			
		}
		
	}
	
	
	
	//找点
	public Point findPoint(int x,int y){
		for(Point p:pointList){
			if((p.getX()==x)&&(p.getY()==y)){
				//判断坐标是否有相同的
				return p;
			}
		}
		return null;
	}
	
	public void mouseClicked(MouseEvent e) {
		System.out.println("点了"+e.getX()+"  "+e.getY());
		int x = e.getX();
		int y = e.getY();
		//算出应该在那一条线上
		double xianX = Math.round((x-20)/50.0);
		double xianY = Math.round((y-20)/50.0);
		//System.out.println("第几根线"+xianY+" "+Math.round(xianY));
		x = ((int)xianX)*50;
		y = ((int)xianY)*50;
		//记录当前棋子位置
		currentX = x;
		currentY = y;
		//int x = e.getX()-Point.Point_size/2;
		//int y = e.getY()-Point.Point_size/2;
		//避免重复绘制棋子
		boolean isHave = false;
		for(Point p:pointList){
			if((p.getX()==x)&&(p.getY()==y)){
				isHave = true;
			}
		}
		if(!isHave){
			Point point = new Point(x,y);
			if(isHei==true){
				  //黑棋子
				point.setColor(Color.black);
				 isHei = false;
			  }else{
				  //白棋子
				  point.setColor(Color.white);
				 isHei = true;
			  }
			if(isWinNow==false){
				pointList.add(point);
			}
//			pointList.add(point);
			//用户触发请求重新绘制
			this.repaint();
		}
		System.out.println("目前棋子数为"+pointList.size());
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