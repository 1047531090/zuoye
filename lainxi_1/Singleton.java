package lainxi_1;

public class Singleton {
//	private static Singleton instance = new Singleton();
//	
//	public static Singleton getInstance(){
//		return instance;
//	}
//	
//	private Singleton(){}
//	
//	public void show(){
//		System.out.println("Singleton");
//	}
	
//	public static Singleton iii = new Singleton();
//	public static Singleton getIii(){
//		return iii;
//	}
//	private Singleton(){}
//	public void show(){
//		System.out.println("haode");
//	}
	
//	public static Singleton yyy = new Singleton();
//	public static Singleton getYyy(){
//		return yyy;
//	}
//	private Singleton(){}
//	public void show(){
//		System.out.println("haode ");
//	}
	
//	private static Singleton instance = null;
//	public static Singleton getInstance(){
//		if(instance == null){
//			instance = new Singleton();
//		}
//		return instance;
//	}
//	private Singleton(){}
	
//	public static Singleton yyy = null;
//	public static Singleton Yyy(){
//		if(yyy == null){
//			yyy = new Singleton();
//		}
//		return yyy;
//	}
//	private Singleton(){}
	
//	public static Singleton iii = null;
//	public static Singleton getIii(){
//		if(iii == null){
//			iii = new Singleton();
//		}
//		return iii;
//	}
//	private Singleton(){}
	
	public static Singleton iii = null;
	public static Singleton getIii(){
		if(iii == null){
			iii = new Singleton();
		}
		return iii;
	}
	private Singleton(){}
	
}
