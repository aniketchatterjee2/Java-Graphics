package com.sensei.graphics2d;

import javax.swing.JFrame;

public class DefaultFrame extends JFrame{

	private static Graphics2D_01 g1 = null;
	
	public DefaultFrame() {
		g1 = new Graphics2D_01();
		super.setSize( 400 , 400 );
		super.setVisible( true );
		super.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		super.add( g1 );
	}
	
	public static void main(String[] args) {
		new DefaultFrame().add(g1);
	}

}
