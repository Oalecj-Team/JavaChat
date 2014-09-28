package me.oalecj.chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ClientUI extends JFrame{

	private static final long serialVersionUID = -8624443117390706490L;
	JFrame myFrame = new JFrame("This is my frame");
	private JTextField host = new JTextField("localhost",50);
	private JTextField port = new JTextField("8080",50);
	private JButton submit = new JButton("Connect");
	private static String hosts = null;
	private static int ports = 1;
	JPanel panel = new JPanel();
	
	public void InitUI() {
		myFrame.setTitle("NikhilChat 0.5");
		myFrame.setSize(620,130);
		myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		panel.add(host);
		host.setVisible(true);
		panel.add(port);
		port.setVisible(true);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				hosts = host.getText();
				ports = Integer.parseInt(port.getText());
				new ChatClient(hosts, ports).run();
			}
		});
		panel.add(submit);
		myFrame.add(panel);
		submit.setVisible(true);
	}
	
	public String getHost() {
		return hosts;
	}
	
	public int getPort() {
		return ports;
	}
	
	public void destroyUI() {
		host.setVisible(false);
		port.setVisible(false);
		submit.setVisible(false);
		panel.setVisible(false);
		myFrame.setVisible(false);
	}
}
