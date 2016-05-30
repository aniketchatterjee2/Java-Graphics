package com.sensei.Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventListeners {
	
	Panel panel;
	
	public void setPanel( Panel panel ) {
		this.panel = panel;
	}
	
	public static class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public static class TextListener implements KeyListener {
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
		}
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}
	}
	
}
