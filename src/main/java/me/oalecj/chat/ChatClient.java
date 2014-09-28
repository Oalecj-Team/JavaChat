package me.oalecj.chat;

import java.util.Scanner;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class ChatClient {
	
	private static String host = null;
	private static int port = 1;
	private Scanner input;
	static ClientUI ui = new ClientUI();
	
	public static void main(String[] args) {
		ui.InitUI();
	}
	
	public ChatClient(String host, int port) {
		ChatClient.setHost(host);
		ChatClient.setPort(port);
		ui.destroyUI();
		ui.dispose();
	}
	
	public void run() {
		EventLoopGroup group = new NioEventLoopGroup();
		
		try {
			Bootstrap bootstrap = new Bootstrap()
			.group(group)
			.channel(NioSocketChannel.class)
			.handler(new ChatClientInitializer());
			
			input = new Scanner(System.in);
			Channel channel = bootstrap.connect(getHost(), getPort()).sync().channel();
			
			String msg = "Hi!";
			String outpu = "Hi!";
			while (true) {
				System.out.print("[You]");
				msg = input.nextLine();
				outpu = msg + "\r\n";
				if (msg == "/help") {
					System.out.println("-------------------------------------------------------");
					System.out.println("NikhilChat Help v0.1");
					System.out.println("The help command is currently our only command!");
					System.out.println("-------------------------------------------------------");
				} else {
					channel.write(outpu);
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			group.shutdownGracefully();
		}
	}

	public static String getHost() {
		return host;
	}

	public static void setHost(String host) {
		ChatClient.host = host;
	}

	public static int getPort() {
		return port;
	}

	public static void setPort(int port) {
		ChatClient.port = port;
	}
	
}
