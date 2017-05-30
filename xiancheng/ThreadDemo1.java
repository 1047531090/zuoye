package xiancheng;

//文件：程序 10.2  ThreadDemo1.java 描述：产生一个新的线程
class ThreadDemo1 extends Thread {
	
	// 声明 ThreadDemo1 构造方法
	ThreadDemo1() {
	}

	// 声明 ThreadDemo1 带参数的构造方法
	ThreadDemo1(String szName) {
		super(szName); // 调用父类的构造方法
	}

	// 重载 run 函数
	public void run() {
		for (int count = 1, row = 1; row < 10; row++, count++) // 循环计算输出的*数目
		{
			for (int i = 0; i < count; i++) // 循环输出指定的 count 数目的*
			{
				System.out.print('*'); // 输出*
			}
			System.out.println(); // 输出换行符
		}
	}

	public static void main(String argv[]) {
		ThreadDemo1 td = new ThreadDemo1(); // 创建，并初始化 ThreadDemo1 类型对象 td
		td.start(); // 调用 start()方法执行一个新的线程
	}
}
