package com.sensei.EasyCalc;

import static com.sensei.EasyCalc.Logger.log;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class InputPanel extends JPanel implements ActionListener{
	
	private String[] buttonTexts = { 
			"C", "Del", "=", "+", 
			"7", "8", "9", "\u2212",
			"4", "5", "6", "\u00d7", 
			"1", "2", "3", "\u00f7",
			".", "0", "(", ")",
	};
	private Font btnFont = new Font( "Helvetica", Font.PLAIN, 17 ) ;
	private String keyPressed = null;
	EasyCalc calculator = null;
	
	public InputPanel( EasyCalc calculator ) {
		setUpUI();
		this.calculator = calculator;
	}
	
	private void setUpUI() {
		makeComponents();
	}
	
	private void makeComponents() {
		super.setLayout( new GridLayout( 5, 4 ) );
		
		for( int i=0; i<20; i++ ) {
			JButton btn = new JButton( buttonTexts[i] );
			btn.setFont( btnFont );
			super.add( btn );
			btn.addActionListener( this );
		}
	}
	
	private void handleKeyPressEvent( String keyPressed ) {
		if( keyPressed.equals( "\u00d7" ) ) {
			keyPressed = "*" ;
		}
		else if( keyPressed.equals( "\u2212" ) ) {
			keyPressed = "-" ;
		}
		else if( keyPressed.equals( "\u00f7" ) ) {
			keyPressed = "/" ;
		}
		calculator.inputEntered( keyPressed );
	}

	public void actionPerformed( ActionEvent e ) {
			keyPressed = (( JButton )e.getSource()).getText();
			log( "Key pressed = " + keyPressed );
			handleKeyPressEvent( keyPressed );
	}
	
	public String getKeyPressed() {
		return keyPressed;
	}
}
