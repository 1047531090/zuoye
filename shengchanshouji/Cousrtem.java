package shengchanshouji;

public class Cousrtem implements Runnable {
	
	private Storage storage;
	private int number;
	public Cousrtem(Storage storage,int number){
		this.storage = storage;
		this.number = number;
	}
	
	
	
	public void run(){
		storage.pop(number);
	}
}
