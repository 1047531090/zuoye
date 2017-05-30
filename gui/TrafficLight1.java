package gui;


import java.awt.Color;  
import java.awt.Graphics;  
import java.awt.event.ItemEvent;  
import java.awt.event.ItemListener;  
  
import javax.swing.ButtonGroup;  
import javax.swing.JFrame;  
import javax.swing.JRadioButton;  
/** 
 * 类：红绿灯 
 * @author Abe 
 * 点击按钮改变颜色 
 */  
@SuppressWarnings("serial")  
public class TrafficLight1 extends JFrame implements ItemListener{  
    private JRadioButton[] lights = new JRadioButton[3];  
    private String[] lightColor = {"红灯","黄灯","绿灯"};  
    private Color[] colors = {Color.red,Color.yellow,Color.green};  
    private int n = 0;  
      
    /** 
     * 构造器  
     */  
    public TrafficLight1(){  
        //窗口构造  
        this.setSize(200, 400);  
        this.setResizable(false);  
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
        this.setLocationRelativeTo(null);  
        this.setLayout(null);  
          
        //按钮组构造  
        ButtonGroup group = new ButtonGroup();  
        for(int i = 0 ; i < lights.length; i++){  
        lights[i] = new JRadioButton(lightColor[i],true);  
        group.add(lights[i]);  
        this.add(lights[i]);  
        lights[i].addItemListener(this);  
        lights[i].setBounds(10  + 60 * i, 280, 60, 100);  
        }  
    }  
      
    /** 
     * 重写：paint回调方法 
     */  
    @Override  
    public void paint(Graphics g) {  
        super.paint(g);  
          
        g.setColor(colors[n]);  
        g.fillOval(70, 80 + n * 70, 60, 60);  
          
        g.setColor(Color.BLACK);  
        g.drawRect(45, 60, 110, 240);  
        for(int i = 0; i < 3;i++){  
        g.drawOval(70, 80 + i * 70, 60, 60);  
        }  
    }  
      
    /** 
     * main方法：设置窗口可见 
     */  
    public static void main(String[] args) {  
        new TrafficLight1().setVisible(true);  
    }  
  
    /** 
     * 方法：监听按钮改变 
     */  
    @Override  
    public void itemStateChanged(ItemEvent e) {  
        Object obj = e.getSource();  
        if(obj == lights[0]){  
            n = 0;  
        }else if(obj == lights[1]){  
            n = 1;  
        }else if(obj == lights[2]){  
            n = 2;  
        }  
        repaint();  
    }  
}  