package com.sensei.Calculator;

import javax.swing.*;

public class Frame{
	
	int width; int height;
	String title;
	JPanel[] panels;
	JFrame mainFrame = new JFrame();
	
	public Frame( int width, int height, String title, JPanel[] panels ) {
		this.width = width;
		this.height = height;
		this.title = title;
		this.panels = panels;
	}
	
	public JFrame[] getFrames() {
		JFrame[] frames = { mainFrame };
		return frames;
	}
	
	public void init() {
		mainFrame.setSize( width, height );
		mainFrame.setTitle( title );
		
		for( int i=0; i<panels.length; i++ ) {
			mainFrame.add(panels[i]);
		}
		mainFrame.add( panels[0] );
		mainFrame.setLocationRelativeTo( null );
		mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		mainFrame.setVisible( true );
	}
}
