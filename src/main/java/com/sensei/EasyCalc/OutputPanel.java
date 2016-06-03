package com.sensei.EasyCalc;

import java.awt.Font;

import javax.swing.*;

@SuppressWarnings("serial")
public class OutputPanel extends JPanel {
	
	private JTextField outputTextField = null;
	
	public OutputPanel() {
		setUpUI();
	}
	
	private void setUpUI() {
		createComponents();
		putComponents();
	}
	
	private void createComponents() {
		outputTextField = new JTextField( 10 );
		Font f = new Font( "helvetica", Font.PLAIN, 30 );
		outputTextField.setFont( f );
		outputTextField.setText( "0" );
		outputTextField.setEditable( false );
	}
	
	private void putComponents() {
		super.add( outputTextField );
	}
	
	public void setOutputFieldText( String text, boolean clear ) {
		if( clear ) {
			outputTextField.setText( text );
		}
		else {
			outputTextField.setText( outputTextField.getText() + text );
		}
		
	}
}
