package bank;

public class QuQianThread implements Runnable {
	
	private Zhanghu zhanghu;
	private int money;
	
	public  QuQianThread(Zhanghu zhanghu,int money) {
		this.zhanghu = zhanghu;
		this.money = money;
	}


	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if(zhanghu.getNumber()>=money){
//			//�˻���
//			zhanghu.setNumber(zhanghu.getNumber()-money);
//			System.out.println("ȡǮ�ɹ���ȡ��"+money+"Ԫ������ǣ�"+zhanghu.getNumber());
//		}else{
//			System.out.println("����,��ǰ���"+zhanghu.getNumber()+"��"+(money-zhanghu.getNumber()));
//		}
		//ͬ�������
		//�൱�ڽ�zhanghu������ס�ˡ�ֻ��ִ�������飬�ſ����ͷŶ��������̲߳����õ�������󣬲�������ס
		//zhanghu���������ͬһ��
		//synchronized (zhanghu) {
			if(zhanghu.getNumber()>=money){
				//�˻���
				zhanghu.setNumber(zhanghu.getNumber()-money);
				System.out.println("ȡǮ�ɹ���ȡ��"+money+"Ԫ������ǣ�"+zhanghu.getNumber());
			}else{
				System.out.println("����,��ǰ���"+zhanghu.getNumber()+"��"+(money-zhanghu.getNumber()));
			}
		//}
		
	}
}
