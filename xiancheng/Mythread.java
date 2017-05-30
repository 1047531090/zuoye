package xiancheng;

public class Mythread extends Thread {//继承Thread类
	
	
	public void run(){
		while(true){
			try{
				Thread.sleep(1000);
				System.out.println("我是子线程1"+System.currentTimeMillis());
			}catch(Exception e){
				
			}
			
		}
		
	}
	
	
	
	
	
/*	private static int number = 50;
	private String name;
	
	public ChuangKouThread1(int number,String name){
		this.number = number;
		this.name = name;
		
	}
	
	
	public void sale(){
		while(true){
			number--;
			System.out.println(name+"卖出第"+number+"张票");
			break;
		}
		
	}*/
	
	
}
