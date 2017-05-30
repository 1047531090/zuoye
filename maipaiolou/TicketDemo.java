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
        

//       无法实现三个窗口卖同一百张票
//      Thread W1 =new TicketWindow("售票窗口1");
//      Thread W2 =new TicketWindow("售票窗口2");
//      Thread W3 =new TicketWindow("售票窗口3");
//      W1.start();//线程状态只需要一次启动，不可以多次使用start（）方法。
//      W2.start();
//      W3.start(); 
//      
    }
}