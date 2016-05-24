package com.sensei.EventListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Panel extends JPanel{
	
	public Panel() {
		
		JButton button = new JButton( "Button test" );
		JTextField textField = new JTextField( 15 );
		JTextArea textArea = new JTextArea( 15, 20 );
		
		
		this.add( button );
		this.add( textField );
		this.add( textArea );
	}

}
