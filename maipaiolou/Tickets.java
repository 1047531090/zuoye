package maipaiolou;

public class Tickets implements Runnable//extends Thread
{   

    //����������Ʊ���ڣ���һ����Ʊ�����ʵ�֣���static
    //����һ�㲻���徲̬����Ϊ������������̫����

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
                        //Ϊʲô������Ե���Thread�ķ����أ�
                        //��Ϊ��д�˽ӿڵ�run�������ײ���ȥ��һ�׾��Ǵ�
                        //��Ϊ��ʵ���˽ӿڣ��ӿڵ�run����ԭ����û�����쳣�����Ը��ǵķ���Ҳ�������쳣��ֻ���ڲ�����
                    try{Thread.sleep(60);} catch(Exception e){}  

                    //��Ϊ��Tickets����󴫸���Thread�߳��������������Ϳ���
                    //�����̵߳����֡�  
                    System.out.println(Thread.currentThread().getName()+
                                       "����һ��Ʊ�ˣ���ʣ"+sumOfTickets--);
                    }
            }
        }
    }

}