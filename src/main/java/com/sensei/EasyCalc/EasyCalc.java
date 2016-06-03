package com.sensei.EasyCalc;

import javax.swing.JFrame;
import static com.sensei.EasyCalc.Logger.log;

import java.awt.BorderLayout;
import java.awt.Container;

@SuppressWarnings("serial")
public class EasyCalc extends JFrame {
	
	private static OutputPanel   outputPanel    = null;
	private        SettingsPanel settingsPanel  = null;
	private static InputPanel    inputPanel     = null;
	private        ControlPanel  controlPanel   = null;
	
	public EasyCalc() {
		setUpUI();
	}
	
	private void setUpUI() {
		log( "\tCreating Panels" );
		outputPanel   = new OutputPanel();
		settingsPanel = new SettingsPanel();
		inputPanel    = new InputPanel( this );
		controlPanel  = new ControlPanel( settingsPanel, inputPanel );
		
		log( "\tAdding Panels to frame" );
		Container container = super.getContentPane(); 
		container.setLayout( new BorderLayout() );
		super.add( outputPanel, BorderLayout.NORTH );
		super.add( controlPanel, BorderLayout.CENTER );
		
		log( "\tSetting frame attributes" );
		super.setTitle( "EasyCalc" );
		super.setLocationRelativeTo( null );
		super.setSize( 300, 350 );
		super.setResizable( false );
		super.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	public static void main(String[] args) {
		log( "Creating EasyCalc main window" );
		
		EasyCalc calculator = new EasyCalc();
		calculator.setVisible( true );
		
		log( "EasyCalc main window now active" );
		
	}
	
	public void outputToPanel( String text, boolean clear ) {
		outputPanel.setOutputFieldText( text, clear );
	}
}
