package shengchanshouji;

public class Producter implements Runnable {
	private Storage storage;
	private int number;
	public Producter(Storage storage,int number){
		this.storage = storage;
		this.number = number;
	}
	
	public void run(){
		storage.push(number);
	}
}
