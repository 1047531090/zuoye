package shengchanshouji;

public class Main3 {
	public static void main(String[] args){
		Storage storage = new Storage(0);
		
		//创建消费者
		Cousrtem cousrtem1 = new Cousrtem(storage,20);
		Cousrtem cousrtem2 = new Cousrtem(storage,70);
		Cousrtem cousrtem3 = new Cousrtem(storage,40);
		
		//创建生产者
		Producter producter1 = new Producter(storage,60);
		Producter producter2 = new Producter(storage,20);
		Producter producter3 = new Producter(storage,80);
		
		//启动线程
		new Thread(cousrtem1).start();
		new Thread(cousrtem2).start();
		new Thread(cousrtem3).start();
		new Thread(producter1).start();
		new Thread(producter2).start();
		new Thread(producter3).start();
		
		
		
		
		
		
		
	}
	
}
