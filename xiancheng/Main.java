package xiancheng;



public class Main {
	public static void main(String[] args){
		//�����߳�
		Mythread mythread = new Mythread();
		//�����߳�
		mythread.start();
		/*try{
			Thread.sleep(10000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}*/
		
		
		
		//�����߳�
		Myrunnable myrunnable = new Myrunnable();
		//�����߳�
		new Thread(myrunnable).start();
		for(int i = 0;i<10000;i++){
				System.out.println("�������߳�"+i);
		}
		
		
//		int piao = 50;
//		Chuangkou chuangkou1 = new Chuangkou(piao,"����1");
//		Chuangkou chuangkou2 = new Chuangkou(piao,"����2");
//		Chuangkou chuangkou3 = new Chuangkou(piao,"����3");
//		
//		ChuangKouThread chuangkouThread1= new ChuangKouTread(); 
//		chuangkouThread1.start();
		
	}
}
