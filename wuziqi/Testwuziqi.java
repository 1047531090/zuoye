package wuziqi;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.*;
 
 
class wuziqi1 extends JFrame implements MouseListener
{
    int score_black=0;//�׷��ȷ�
    int score_white=0;//�ڷ��ȷ�
    int indexX=0;
    int indexY=0;
    boolean win=false;//�������һ����ʤ������������
    BufferedImage img=null;
    String info="�ڷ�����";
    String baifang="";
    String heifang="";
    int settime=10;
    int second_white=settime;
    int second_black=settime;
    int mouseX;//�������ӵ�X����
    int mouseY;//�������ӵ�Y����
    int[][] allchess=new int[19][19];
    boolean isBlack=true;
    Font font=new Font("����",Font.BOLD,25);
    wuziqi1()
    {
        try {
            img= ImageIO.read(new File("H:/eclipse/workspace/lianxi/src/wuziqi/wuziqi.jpg"));
        } catch (IOException e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        }
        setTitle("������");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addMouseListener(this);
        setResizable(false);
        setVisible(true);
         
    }
 
    public String setTime(int second)
    {
        String min=second/60+"";
        String sec=second%60+"";
        if(sec.length()==1)
        {
            sec="0"+sec;
        }
        return min+":"+sec;
         
    }
     
     
    @Override
    public void paint(Graphics g) {
         
        g.drawImage(img, 0, 25, null);
        for(int i=0;i<=(360/20);i++)
        {
            g.drawLine(10, 75+20*i, 370, 75+20*i);
            g.drawLine(10+20*i, 75, 10+20*i, 435);
        }
        g.setFont(font);
        g.drawString(info, 230, 60);
        baifang="�׷���"+setTime(second_white);
        heifang="�ڷ���"+setTime(second_black);
        g.drawString(baifang, 27, 480);
        g.drawString(heifang, 250, 480);
        g.drawString("��:��"+score_black+":"+score_white, 390, 255);
        /*
         * ���Ϊ1���ǰ�����
         * ���Ϊ2���Ǻ�����
         * ���Ϊ0���ǿ�λ
         */
         
        for(int i=0;i<19;i++)
        {
            for(int j=0;j<19;j++)
            {
                 
                if(allchess[i][j]==1)
                {
                    g.setColor(Color.BLACK);
                    g.fillOval(20*i+10-7, 20*j+75-7, 14, 14);
                     
                     
                }
                else if (allchess[i][j]==2)
                {
                    g.setColor(Color.WHITE);
                    g.fillOval(20*i+10-7, 20*j+75-7, 14, 14);
                     
                }
            }
        }
         
         
    }
//�׷��߳�
    Runnable r_white=new Runnable() {
         
        @Override
        public void run() {
            while(second_white>0 && !isBlack && !win)
            {
                second_black=settime;
                try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO �Զ����ɵ� catch ��
                e.printStackTrace();
            }
                second_white--;
                repaint();
            }
            if(second_white==0)
            {
                while(true)
                {
                int x=(int)(Math.random()*19);
                int y=(int)(Math.random()*19);
                if(allchess[x][y]==0)
                    {
                        info="�ڷ�����";
                        allchess[x][y]=2;
                        break;
                    }
                }
                isBlack=true;
                new Thread(r_black).start();
 
            }
             
        }
    };
    //�ڷ��߳�
        Runnable r_black=new Runnable() {
             
            @Override
            public void run() {
                while(second_black>0 && isBlack && !win)
                {
                    second_white=settime;
                    try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
                    second_black--;
                    repaint();
                }
                if(second_black==0)
                {
                    while(true)
                    {
                    int x=(int)(Math.random()*19);
                    int y=(int)(Math.random()*19);
                    if(allchess[x][y]==0)
                        {
                            info="�׷�����";
                            allchess[x][y]=1;
                            break;
                        }
                    }
                    isBlack=false;
                    new Thread(r_white).start();
                }
                 
                 
            }
        };
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO �Զ����ɵķ������
        mouseX=e.getX();
        mouseY=e.getY();
        System.out.println("X"+mouseX);
        System.out.println("Y"+mouseY);
        if(!win){
            if(mouseX>10 && mouseX<370 && mouseY>10 && mouseY<435 )
        {
            indexX=Math.round((mouseX-10)/20.0f);
            indexY=Math.round((mouseY-70)/20.0f);
            if(isBlack) {
                if(allchess[indexX][indexY]==0){
                    info="�׷�����";
                    allchess[indexX][indexY]=1;
                    if(isWin() || isWinShangxie() || isWinshu() || isWinXiaxie()){   win=true;   
                        JOptionPane.showMessageDialog(this, "�ڷ���ʤ");
                        score_black++;
                         
                    }
                    isBlack=false;
                    if(!win) //���û���ж�Ӯ���������
                    {
                    new Thread(r_white).start();
                    }
                }
            }
            else
            {
                if(allchess[indexX][indexY]==0)
                {
                    info="�ڷ�����";
                    allchess[indexX][indexY]=2;
                    if(isWin() || isWinShangxie() || isWinshu() || isWinXiaxie())
                    {
                        win=true;
                        JOptionPane.showMessageDialog(this, "�׷���ʤ");
                        score_white++;
                         
                         
                    }
                    isBlack=true;
                    if(!win)//���û���ж�Ӯ���������
                    {
                        new Thread(r_black).start();
                    }
                }
                 
            }
            this.repaint();
        }
             
        }//while����
            if(mouseX>400 && mouseX<470 && mouseY>76 && mouseY<106 )//���¿�ʼ
            {
                int choose=JOptionPane.showConfirmDialog(this, "ȷ�����¿�ʼô��");
                if(choose==0)
                {
                start();    
                }
                 
            }
            if(mouseX>400 && mouseX<470 && mouseY>126 && mouseY<155 )//����ʱ��
            {
                if(win)
                {
                String  resetTime=JOptionPane.showInputDialog("������Ҫ�����ʱ��:");
                settime=Integer.parseInt(resetTime);    
                second_black=settime;
                second_white=settime;
                this.repaint();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "��ǰ������Ϸ�в���������ʱ��");
         
                }
                 
            }
            if(mouseX>400 && mouseX<470 && mouseY>275 && mouseY<305  )//����
            {
                if(!win)
                {
                    int choose=JOptionPane.showConfirmDialog(this, "ȷ������ô��");
                    if(choose==0)
                    {
                        win=true;
                        if(isBlack)
                        {
                            score_white++;
                            int choose1=JOptionPane.showConfirmDialog(this, "�ڷ�����");
                                if(choose1==0)
                                {
                                    int choose2=JOptionPane.showConfirmDialog(this, "���¿��֣�");
                                    if(choose2==0)
                                    {
                                        start();
                                    }
                                }
                            }
                             
                         
                        else
                        {
                            score_black++;
                            int choose1=JOptionPane.showConfirmDialog(this, "�׷�����");
                            if(choose1==0)
                            {
                                int choose2=JOptionPane.showConfirmDialog(this, "���¿��֣�");
                                if(choose2==0)
                                {
                                    start();
                                }
                            }
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "��Ϸ��δ��ʼ");
                }
            }
     
        }
         
    //**************************************���¿�ʼ start*********************//   
    public void start()
    {
         
        win=false;
        isBlack=true;
        info="�ڷ�����";
        for(int i=0;i<19;i++)
        {
            for(int j=0;j<19;j++)
            {
                allchess[i][j]=0;
            }
        }
        second_white=settime;
        second_black=settime;
        this.repaint();
    }
    //**************************************���¿�ʼ end*********************//
     
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO �Զ����ɵķ������
         
    }
 
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO �Զ����ɵķ������
         
    }
 
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO �Զ����ɵķ������
         
    }
 
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO �Զ����ɵķ������
         
    }
    /*****************************�ж�����*****************************************/
    //�ж�����
    public boolean isWinshu()
    {
        int countY=1;//�ۼ���������
        int up=1;
        int down=1;
        //�ж�����
                 
                    while((indexY+up)<19 && allchess[indexX][indexY]==allchess[indexX][indexY+up])//�жϵ�ǰ����ϱߵĵ��ǲ���ͬһ��ɫ
                    {   
                        countY++;
                        up++;
     
                    }
     
                    while((indexY-down)>=0 && allchess[indexX][indexY]==allchess[indexX][indexY-down])//�жϵ�ǰ����±ߵĵ��ǲ���ͬһ��ɫ
                    {
                        countY++;
                        down++;
                         
                    }
                 
                if(countY>=5)
                {
                    return true;
                }
                 
                 
                return false;
         
    }
    //��б��
    public boolean isWinShangxie()
    {
        int countUp=1;//�ۼ��϶Խ�����
        //
        int sXieshangX=1;
        int sXiexiaX=1;
        int sXieshangY=1;
        int sXiexiaY=1;
        //�ж��϶Խ���
                 
                    while((indexX+sXiexiaX)<19 && (indexY+sXiexiaY)<19 && allchess[indexX][indexY]==allchess[indexX+sXiexiaX][indexY+sXiexiaY])//�жϵ�ǰ����ұߵĵ��ǲ���ͬһ��ɫ
                    {
                         
                         
                            System.out.println("�϶Խ���");
                        System.out.println(indexX+sXiexiaX);
                        System.out.println(indexY+sXiexiaY);
                        countUp++;
                        sXiexiaX++;
                        sXiexiaY++;
                         
                    }   
                    while((indexX-sXieshangX)>=0 && (indexY-sXieshangY)>=0 && allchess[indexX][indexY]==allchess[indexX-sXieshangX][indexY-sXieshangY])//�жϵ�ǰ�����ߵĵ��ǲ���ͬһ��ɫ
                    {   
                        System.out.println("�϶Խ���");
                        System.out.println(indexX-sXieshangX);
                        System.out.println(indexY-sXieshangY);
                        countUp++;
                        sXieshangX++;
                        sXieshangY++;
                    }
                 
                if(countUp>=5)
                {
                    return true;
                }
                 
                 
                return false;
     
    }
    //��б��
    public boolean isWinXiaxie()
    {
        int countDowm=1;//�ۼ��¶Խ�����
        int xXieshangX=1;
        int xXiexiaX=1;
        int xXieshangY=1;
        int xXiexiaY=1;
        //�ж��¶Խ���        
                    while((indexX-xXieshangX)>=0 && (indexY+xXieshangY)<19 && allchess[indexX][indexY]==allchess[indexX-xXieshangX][indexY+xXieshangY])//�жϵ�ǰ����ұߵĵ��ǲ���ͬһ��ɫ
                    {
                        System.out.println("�¶Խ���");
                        System.out.println(indexY-xXieshangX);
                        System.out.println(indexX+xXieshangY);
             
                        countDowm++;
                        xXieshangX++;
                        xXieshangY++;
                         
                    }
                    while((indexY-xXiexiaX)>=0 && (indexX+xXiexiaY)<19 && allchess[indexX][indexY]==allchess[indexX+xXiexiaY][indexY-xXiexiaX])//�жϵ�ǰ�����ߵĵ��ǲ���ͬһ��ɫ
                    {
                        countDowm++;
                        xXiexiaX++;
                        xXiexiaY++;
                          
                    }
                 
                if(countDowm>=5)
                {
                    return true;
                }
                 
                 
                return false;
    }
    //�жϺ���Ӯ
    public boolean isWin()
    {
        int countX=1;//�ۼƺ�������
        int right=1;
        int left=1;
     
        //�жϺ���
                while((indexX+right)<19 && allchess[indexX][indexY]==allchess[indexX+right][indexY])//�жϵ�ǰ����ұߵĵ��ǲ���ͬһ��ɫ
                {
             
                        countX++;
                        right++;
                                             
                }
 
            while((indexX-left)>=0 && allchess[indexX][indexY]==allchess[indexX-left][indexY])//�жϵ�ǰ�����ߵĵ��ǲ���ͬһ��ɫ
            {
                countX++;
                left++;
     
            }
         
         
         
         
        if(countX>=5)
        {
            return true;
        }
         
         
        return false;
    }
     
     
}
 
public class Testwuziqi{
 
    public static void main(String[] args) {
    	wuziqi1 f1=new wuziqi1();
 
    }
 
}
