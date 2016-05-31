package com.sensei.EasyCalc;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class InputPanel extends JPanel {
	
	private JButton button1 = new JButton( "1" );
	private JButton button2 = new JButton( "2" );
	private JButton button3 = new JButton( "3" );
	private JButton button4 = new JButton( "4" );
	private JButton button5 = new JButton( "5" );
	private JButton button6 = new JButton( "6" );
	private JButton button7 = new JButton( "7" );
	private JButton button8 = new JButton( "8" );
	private JButton button9 = new JButton( "9" );
	
	
	public InputPanel() {
		super.setLayout( new GridLayout( 3, 3 ) );
		super.add( button1 );
		super.add( button2 );
		super.add( button3 );
		super.add( button4 );
		super.add( button5 );
		super.add( button6 );
		super.add( button7 );
		super.add( button8 );
		super.add( button9 );
	}

}
