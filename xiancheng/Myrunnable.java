package xiancheng;

public class Myrunnable implements Runnable {//ʵ��Runnable�ӿ�
	
	public void run(){
		while(true){
			try{
				Thread.sleep(1000);
				System.out.println("�������߳�2"+System.currentTimeMillis());
			}catch(Exception e){
				
			}
			
		}
	}

}
