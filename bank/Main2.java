package bank;

public class Main2 {
	public static void main(String[] args){
		Zhanghu zhanghu = new Zhanghu("����",4000);
		QuQianThread ka = new QuQianThread(zhanghu,2000);
		QuQianThread zhe = new QuQianThread(zhanghu,3000);
		new Thread(ka).start();
		new Thread(zhe).start();
		
		
	}
}
