package xiancheng;

public class Mythread extends Thread {//�̳�Thread��
	
	
	public void run(){
		while(true){
			try{
				Thread.sleep(1000);
				System.out.println("�������߳�1"+System.currentTimeMillis());
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
			System.out.println(name+"������"+number+"��Ʊ");
			break;
		}
		
	}*/
	
	
}
