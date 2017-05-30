package maipaiolou;

public class Tickets implements Runnable//extends Thread
{   

    //创建三个售票窗口，卖一百张票。如何实现，用static
    //但是一般不定义静态，因为它的生命周期太长？

    private   int sumOfTickets = 50;
//          
//  
//  public TicketWindow(String WinNum)
//  {
//      super(WinNum);
//  }
    Object obj =new Object(); 
    public void run()
    {
        while(true)
        {
            synchronized(obj)
            {
                    if(sumOfTickets >=0)
                    {
                        //为什么这里可以调用Thread的方法呢？
                        //因为复写了接口的run方法，抛不出去，一抛就是错。
                        //因为是实现了接口，接口的run方法原来就没有抛异常，所以覆盖的方法也不能抛异常，只能内部处理。
                    try{Thread.sleep(60);} catch(Exception e){}  

                    //因为把Tickets类对象传给了Thread线程类对象，所以这里就可以
                    //调用线程的名字。  
                    System.out.println(Thread.currentThread().getName()+
                                       "卖完一张票了，还剩"+sumOfTickets--);
                    }
            }
        }
    }

}