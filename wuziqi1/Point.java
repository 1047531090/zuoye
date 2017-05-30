package wuziqi1;

import java.awt.Color;

public class Point {
	private int x;//x������
	private int y;//y������
	private Color color ;//���ӵ���ɫ
	public static final int point_size = 40;//���ӵĴ�С
	
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public Point(int x,int y,Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	public String toString() {
		return "Point{" +
				"x=" + x +
				", y=" + y +
				", color=" + color +
				'}';
	}
}
