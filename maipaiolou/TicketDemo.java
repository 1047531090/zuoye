package maipaiolou;

public class TicketDemo {
    public static void main(String[] args)
    {

        Tickets sum = new Tickets();

        Thread Window1 = new Thread(sum);
        Thread Window2 = new Thread(sum);
        Thread Window3 = new Thread(sum);
        Window1.start();
        Window2.start();
        Window3.start();
        

//       �޷�ʵ������������ͬһ����Ʊ
//      Thread W1 =new TicketWindow("��Ʊ����1");
//      Thread W2 =new TicketWindow("��Ʊ����2");
//      Thread W3 =new TicketWindow("��Ʊ����3");
//      W1.start();//�߳�״ֻ̬��Ҫһ�������������Զ��ʹ��start����������
//      W2.start();
//      W3.start(); 
//      
    }
}