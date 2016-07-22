package com.sensei.graphics2d;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Graphics2D_01 extends JPanel{
	
	@Override
	public void paintComponent( Graphics g ) {
		g.setColor( Color.ORANGE );
		g.fillRect(50, 50, 100, 100);
		g.drawLine( 34 , 34, 50, 50);
	}
	
}
