package lianxi;

public class IA {
	public void test(){
		final int a = 0;
		IA ia = new IA(){
			public int a(){
				int b = a;
				return 0;
			}
		};
	}
}
