package com.sensei.EasyCalc;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sensei.EasyCalc.core.Token;

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
		outputTextField.setEditable( false );
	}
	
	private void putComponents() {
		super.add( outputTextField );
	}
	
	private void appendToOutput( String text ) {
		outputTextField.setText( outputTextField.getText() + text ) ;
	}
	
	public void setText( String text ) {
		outputTextField.setText( text );
	}

	public void refreshOutput( ArrayList<Token> tokens ) {
		outputTextField.setText( "" ) ;
		for( Token token : tokens ) {
			outputToken( token );
		}
	}
	
	private void outputToken( Token token ) {
		if( token.getTokenValue().equals( "*" ) ) {
			appendToOutput( "\u00d7" + " " ) ;
		}
		else if( token.getTokenValue().equals( "/" ) ) {
			appendToOutput( "\u00f7" + " " );
		}
		else if( token.getTokenValue().equals( "-" ) ) {
			appendToOutput( "\u2212" + " " );
		}
		else {
			appendToOutput( token.getTokenValue() + " " ) ;
		}
	}
}
