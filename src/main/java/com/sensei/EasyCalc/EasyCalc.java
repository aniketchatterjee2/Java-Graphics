package com.sensei.EasyCalc;

import javax.swing.JFrame;
import static com.sensei.EasyCalc.Logger.log;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class EasyCalc extends JFrame {
	
	private OutputPanel   outputPanel   = null;
	private SettingsPanel settingsPanel = null;
	private InputPanel    inputPanel    = null;
	
	public EasyCalc() {
		setUpUI();
	}
	
	private void setUpUI() {
		log( "\tCreating Panels" );
		outputPanel   = new OutputPanel();
		settingsPanel = new SettingsPanel();
		inputPanel    = new InputPanel();
		
		log( "\tAdding Panels to frame" );
		Container container = super.getContentPane(); 
		container.setLayout( new BorderLayout() );
		super.add( outputPanel, BorderLayout.NORTH );
		super.add( settingsPanel, BorderLayout.CENTER );
		super.add( inputPanel, BorderLayout.SOUTH );
		
		log( "\tSetting frame attributes" );
		super.setTitle( "EasyCalc" );
		super.setLocationRelativeTo( null );
		super.setSize( 300, 300 );
		super.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	public static void main(String[] args) {
		log( "Creating EasyCalc main window" );
		
		EasyCalc calculator = new EasyCalc();
		calculator.setVisible( true );
		
		log( "EasyCalc main window now active" );
	}
}
