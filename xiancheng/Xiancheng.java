package xiancheng;

public class Xiancheng {
	public static void main(String[] args){
		run();
	}
	public static void run(){
		for(int a = 1 , b = 1; b < 10 ; a++,b++){
			for(int i = 0; i < a ; i++){
				System.out.printf("*");
			}
			System.out.println();
		}
	}
}
