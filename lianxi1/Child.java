package lianxi1;

class Parent{
	protected String value = "123";
	public String getValue(){
		return value;
	}
}

public class Child extends Parent {
	protected String value = "456";
	public static void main(String[] args) {
		Child child = new Child();
		System.out.println(child.getValue());
	}
}
