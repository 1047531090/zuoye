package lianxi1;


class A{
	public static void prt(){
		System.out.println("1");
	}
	public A(){
		System.out.println("A");
	}
}

public class B extends A{
	public static void prt(){
		System.out.println("2");
	}
	public B(){
		System.out.println("B");
	}
	public static void main(String[] args){
		A a = new B();
		a = new A();
	}
}