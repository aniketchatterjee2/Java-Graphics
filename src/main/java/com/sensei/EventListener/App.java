package com.sensei.EventListener;

import javax.swing.JPanel;

public class App {

	public static void main(String[] args) {
		
		Panel panel = new Panel();
		Frame frame = new Frame( "Event listener", 500, 500, panel );
		frame.setVisible( true );
	}

}
