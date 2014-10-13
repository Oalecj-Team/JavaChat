package me.oalecj.chat;

import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ClientCH {
	public ClientCH() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JTextArea area = new JTextArea(25, 55);
		panel.add(area);
		frame.setSize(640, 480);
		frame.add(panel);
		frame.setVisible(true);
		PrintStream origOut = System.out;
		PrintStream interceptor = new Interceptor(origOut);
		System.setOut(interceptor);
		area.append(((Interceptor) interceptor).getTxt());
	}

}
