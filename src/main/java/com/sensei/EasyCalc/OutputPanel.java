package com.sensei.EasyCalc;

import java.awt.Font;

import javax.swing.*;

@SuppressWarnings("serial")
public class OutputPanel extends JPanel {
	
	private JTextField outputTextField = null;
	
	public OutputPanel() {
		
		Font f = new Font( "helvetica", Font.PLAIN, 30 );
		outputTextField = new JTextField( 10 );
		outputTextField.setFont( f );
		outputTextField.setEditable( false );
		
		super.add( outputTextField );
	}

}
