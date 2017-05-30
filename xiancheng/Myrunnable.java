package xiancheng;

public class Myrunnable implements Runnable {//实现Runnable接口
	
	public void run(){
		while(true){
			try{
				Thread.sleep(1000);
				System.out.println("我是子线程2"+System.currentTimeMillis());
			}catch(Exception e){
				
			}
			
		}
	}

}
