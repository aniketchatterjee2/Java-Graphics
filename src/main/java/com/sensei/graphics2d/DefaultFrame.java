package com.sensei.graphics2d;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class DefaultFrame extends JFrame{

	public DefaultFrame() {
		setUpUI() ;
		super.setSize( 400 , 400 );
		super.setVisible( true );
		super.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	private void setUpUI() {
		Container contentPane = super.getContentPane() ;
		contentPane.setLayout( new BorderLayout() ) ;
		contentPane.add( new Graphics2D_01() ) ;
	}
	
	public static void main(String[] args) {
		new DefaultFrame();
	}

}
