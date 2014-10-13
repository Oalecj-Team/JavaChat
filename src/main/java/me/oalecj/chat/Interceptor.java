package me.oalecj.chat;

import java.io.OutputStream;
import java.io.PrintStream;

public class Interceptor extends PrintStream {
	private static String txt;
	public Interceptor(OutputStream out) {
		super(out, true);
	}
	
	public String getTxt() {
		return txt;
	}
	
	@Override
	public void print(String s) {
		if (txt == s) {
			//Do nothing!
		} else {
			txt = s;
		}
	}
}