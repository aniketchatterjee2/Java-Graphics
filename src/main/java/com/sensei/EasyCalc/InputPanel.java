package com.sensei.EasyCalc;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import static com.sensei.EasyCalc.Logger.log;

@SuppressWarnings("serial")
public class InputPanel extends JPanel implements ActionListener{
	
	private String[] buttonTexts = { 
			"C", "Del", ".", "+", "-",
			"7", "8", "9", "*", "/",
			"4", "5", "6", "(", ")",
			"1", "2", "3", "0", "Enter"
	};
	private Font btnFont = new Font( "Helvetica", Font.PLAIN, 15 ) ;
	private String keyPressed = null;
	
	public InputPanel() {
		super.setLayout( new GridLayout( 4, 5 ) );
		
		for( int i=0; i<20; i++ ) {
			JButton btn = new JButton( buttonTexts[i] );
			btn.setFont( btnFont );
			btn.addActionListener( this );
			super.add( btn );
		}
	}

	public void actionPerformed( ActionEvent e ) {
			keyPressed = (( JButton )e.getSource()).getText();
			log( "Key pressed = " + keyPressed );
	}
	
	public String getKeyPressed() {
		return keyPressed;
	}

}
