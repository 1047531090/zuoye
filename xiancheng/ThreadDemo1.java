package xiancheng;

//�ļ������� 10.2  ThreadDemo1.java ����������һ���µ��߳�
class ThreadDemo1 extends Thread {
	
	// ���� ThreadDemo1 ���췽��
	ThreadDemo1() {
	}

	// ���� ThreadDemo1 �������Ĺ��췽��
	ThreadDemo1(String szName) {
		super(szName); // ���ø���Ĺ��췽��
	}

	// ���� run ����
	public void run() {
		for (int count = 1, row = 1; row < 10; row++, count++) // ѭ�����������*��Ŀ
		{
			for (int i = 0; i < count; i++) // ѭ�����ָ���� count ��Ŀ��*
			{
				System.out.print('*'); // ���*
			}
			System.out.println(); // ������з�
		}
	}

	public static void main(String argv[]) {
		ThreadDemo1 td = new ThreadDemo1(); // ����������ʼ�� ThreadDemo1 ���Ͷ��� td
		td.start(); // ���� start()����ִ��һ���µ��߳�
	}
}
