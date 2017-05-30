package lianix_2;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class Chengyuneibulei {
	private String name = "will";
	private static int age = 17;
	
	static class StaticInner{
		private String s = "ooxx";
		private static int num = 13;
		
		public void show(){
			//System.out.println(name);//不能访问
			System.out.println(age);//可访
			System.out.println(new Chengyuneibulei().name);
		}
	}
	public void test(){
//		System.out.println(s);
		//System.out.println(num);
		System.out.println(StaticInner.num);
		System.out.println(new StaticInner().s);
		new StaticInner().show();
	}
}

