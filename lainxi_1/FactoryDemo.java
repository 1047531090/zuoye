package lainxi_1;

public class FactoryDemo {
	public static void main(String[] args) {
		ICellPhone p = Factory.aaa("htc");
		p.sendMsg();
	}
}

//手机标准
interface ICellPhone {
	void sendMsg();
}

// HTC手机 
class HTC implements ICellPhone {
	public void sendMsg() {
		System.out.println("我是htc手机");
	}
}

// IPhone手机 
class IPhone implements ICellPhone {
	public void sendMsg() {
		System.out.println("我是iphone手机");
	}
}
// 华为手机 
class Huawei implements ICellPhone{
	public void sendMsg(){
		System.out.println("我是华为手机");
	}
}

// 手机工厂 
class Factory {
	public static ICellPhone aaa(String type){
		ICellPhone phone = null;
		if("htc".equals(type)){
			phone = new HTC();
		}else if("iphone".equals(type)){
			phone = new IPhone();
		}else if("华为".equals(type)){
			phone = new Huawei();
		}
		return phone;
	}
}

