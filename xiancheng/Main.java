package xiancheng;



public class Main {
	public static void main(String[] args){
		//创建线程
		Mythread mythread = new Mythread();
		//启动线程
		mythread.start();
		/*try{
			Thread.sleep(10000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}*/
		
		
		
		//创见线程
		Myrunnable myrunnable = new Myrunnable();
		//启动线程
		new Thread(myrunnable).start();
		for(int i = 0;i<10000;i++){
				System.out.println("我是主线程"+i);
		}
		
		
//		int piao = 50;
//		Chuangkou chuangkou1 = new Chuangkou(piao,"窗口1");
//		Chuangkou chuangkou2 = new Chuangkou(piao,"窗口2");
//		Chuangkou chuangkou3 = new Chuangkou(piao,"窗口3");
//		
//		ChuangKouThread chuangkouThread1= new ChuangKouTread(); 
//		chuangkouThread1.start();
		
	}
}
