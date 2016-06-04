package com.sensei.EasyCalc;

import static com.sensei.EasyCalc.Logger.log;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.sensei.EasyCalc.core.Lexer;
import com.sensei.EasyCalc.core.Token;

@SuppressWarnings("serial")
public class EasyCalc extends JFrame {
	
	private OutputPanel   outputPanel   = null;
	private SettingsPanel settingsPanel = null;
	private InputPanel    inputPanel    = null;
	private ControlPanel  controlPanel  = null;
	private StringBuilder expression    = null;
	
	private static String   CMD_ENTER   = "Enter" ;
	private static String   CMD_CLEAR   = "C" ;
	private static String   CMD_DELETE  = "Del" ;
	private static String[] CMDS        = { CMD_ENTER, CMD_CLEAR, CMD_DELETE } ;
	
	public EasyCalc() {
		setUpUI();
		expression = new StringBuilder() ;
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
	
	public void appendToExpr( String text ) {
		expression.append( text );
	}
	
	public void deleteExpr( int start, int end ) {
		expression.delete( start, end );
	}
	
	public void inputEntered( String inputEntered ) {
		if( isCommandInput( inputEntered ) ) {
			processCommand( inputEntered ) ;
		}
		else {
			expression.append( inputEntered ) ;
			Lexer lexer = new Lexer( expression.toString() ) ;
			ArrayList<Token> tokens = lexer.getAllTokens() ;
			
			outputPanel.refreshOutput( tokens ) ;
		}
	}
	
	private boolean isCommandInput( String input ) {
		for( int i=0; i<CMDS.length; i++ ) {
			if( input.equals( CMDS[i] ) ) {
				return true ;
			}
		}
		return false ;
	}
	
	private void processCommand( String cmd ) {
		log( "Command entered = " + cmd ) ;
	}
	
}
