package com.sensei.EventListener;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame{
	
	public Frame( String title, int width, int height, JPanel panel ) {
		this.setSize( width, height );
	
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = new Dimension( toolkit.getScreenSize() );
		
		int xPos = (dimension.width/2) - (this.getWidth()/2);
		int yPos = (dimension.height/2) - (this.getHeight()/2);
		
		this.setTitle( title );
		this.setResizable( true );
		this.setLocation( xPos, yPos );
		this.add( panel );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

}
