package shengchanshouji;

public class Storage {
	private final static int MAX_SIZE = 100;
	private int size;

	public Storage(int size) {
		this.size = size;
	}
	
	//存货
	
	public synchronized void push(int number){
		if(getSize()+number<=MAX_SIZE){
			setSize(getSize()+number);
		}else{
			try {
				this.wait();//让想获取该对象锁的线程等待状态
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notifyAll();
		
	}
	
	//取货
	
	public synchronized void pop(int number){
		if(getSize()-number<0){
//			System.out.println("bugou");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			
		}
	}
	
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
