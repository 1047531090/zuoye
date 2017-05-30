package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;

public class TrafficLight2 extends JFrame {
	JRadioButton jrbYellow, jrbGreen, jrbRed;
	int flag = 0;
	jpNewPanel jpNewPanel;

	public static void main(String[] args) {
		TrafficLight2 frame = new TrafficLight2();
		frame.setSize(500, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("TrafficLight");
		frame.setVisible(true);
	}

	public TrafficLight2() {
		jpNewPanel = new jpNewPanel();
		add(jpNewPanel, BorderLayout.CENTER);
		JPanel jpRadioButtons = new JPanel();
		jpRadioButtons.setLayout(new GridLayout(1, 3));
		jpRadioButtons.add(jrbYellow = new JRadioButton("Yellow"));
		jpRadioButtons.add(jrbGreen = new JRadioButton("Green"));
		jpRadioButtons.add(jrbRed = new JRadioButton("Red"));
		add(jpRadioButtons, BorderLayout.SOUTH);
		ButtonGroup group = new ButtonGroup();
		group.add(jrbYellow);
		group.add(jrbGreen);
		group.add(jrbRed);

		jrbYellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = 2;
				jpNewPanel.repaint();
			}
		});
		jrbGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = 1;
				jpNewPanel.repaint();
			}
		});
		jrbRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = 3;
				jpNewPanel.repaint();
			}
		});
	}

	class jpNewPanel extends JPanel {
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawRect(0, 0, 40, 100);
			g.drawOval(10, 10, 20, 20);
			g.drawOval(10, 40, 20, 20);
			g.drawOval(10, 70, 20, 20);
			if (flag == 1) {
				g.setColor(Color.GREEN);
				g.fillOval(10, 70, 20, 20);
			} else if (flag == 2) {
				g.setColor(Color.YELLOW);
				g.fillOval(10, 40, 20, 20);
			} else if (flag == 3) {
				g.setColor(Color.RED);
				g.fillOval(10, 10, 20, 20);
			}
		}
	}
}