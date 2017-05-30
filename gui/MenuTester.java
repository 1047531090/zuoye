package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
 
public class MenuTester extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L;
    private static final String FILE = "H:/eclipse/workspace/lianxi/src/gui/1.txt";
    JTextArea textArea;
    JScrollPane scrollPane;
 
    public MenuTester ()
    {
        setTitle ("MenuTester");
        setLayout (new BorderLayout ());
        JMenuBar menuBar = new JMenuBar ();
        JMenu[] menu = new JMenu[] { new JMenu ("文件"), new JMenu ("编辑") };
        JMenuItem[] menuItem1 = new JMenuItem[] { new JMenuItem ("新建"), new JMenuItem ("打开"), new JMenuItem ("保存"), new JMenuItem ("关闭") };
        JMenuItem[] menuItem2 = new JMenuItem[] { new JMenuItem ("复制"), new JMenuItem ("粘贴"), new JMenuItem ("剪切") };
        for ( int i = 0; i < menu.length; i++ )
        {
            menuBar.add (menu[i]);
        }
        for ( int i = 0; i < menuItem1.length; i++ )
        {
            menu[0].add (menuItem1[i]);
        }
        for ( int i = 0; i < menuItem2.length; i++ )
        {
            menu[1].add (menuItem2[i]);
        }
        menuItem1[0].addActionListener (this);
        menuItem1[1].addActionListener (this);
        menuItem1[2].addActionListener (this);
        menuItem1[3].addActionListener (this);
        setJMenuBar (menuBar);
        textArea = new JTextArea ();
        scrollPane = new JScrollPane (textArea);
        scrollPane.setVisible (false);
        add (scrollPane, BorderLayout.CENTER);
        setResizable (false);
        setSize (800, 600);
        setLocationRelativeTo (null);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setVisible (true);
    }
 
    public static void main ( String[] args )
    {
        SwingUtilities.invokeLater (new Runnable ()
        {
            @Override
            public void run ()
            {
                new MenuTester ();
            }
        });
    }
 
    @Override
    public void actionPerformed ( ActionEvent e )
    {
        String command = e.getActionCommand ();
        if ("新建".equals (command))
        {
            scrollPane.setVisible (true);
            validate ();
        }
        else if ("关闭".equals (command))
        {
            scrollPane.setVisible (false);
            textArea.setText ("");
            validate ();
        }
        else if ("打开".equals (command))
        {
            scrollPane.setVisible (true);
            validate ();
            try
            {
                FileReader fr = new FileReader (FILE);
                char[] cs = new char[1];
                while (-1 != ( fr.read (cs) ))
                {
                    textArea.append (new String (cs));
                }
                fr.close ();
            }
            catch (Exception e1)
            {
                e1.printStackTrace ();
            }
        }
        else if ("保存".equals (command))
        {
            try
            {
                FileWriter fw = new FileWriter (FILE);
                fw.write (textArea.getText ());
                fw.flush ();
                fw.close ();
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
            }
        }
    }
}