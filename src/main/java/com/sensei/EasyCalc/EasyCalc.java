package com.sensei.EasyCalc;

import static com.sensei.EasyCalc.Logger.log;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.sensei.EasyCalc.core.*;

@SuppressWarnings("serial")
public class EasyCalc extends JFrame {
	
	private OutputPanel   outputPanel   = null;
	private SettingsPanel settingsPanel = null;
	private InputPanel    inputPanel    = null;
	private ControlPanel  controlPanel  = null;
	private StringBuilder expression    = null;
	private Lexer         lexer         = null;
	private Evaluator     evaluator     = null;
	
	private static String   CMD_ENTER   = "Enter" ;
	private static String   CMD_CLEAR   = "C" ;
	private static String   CMD_DELETE  = "Del" ;
	private static String[] CMDS        = { CMD_ENTER, CMD_CLEAR, CMD_DELETE } ;
	
	public EasyCalc() {
		expression = new StringBuilder() ;
		createCoreComponents( expression );
		setUpUI();
	}
	
	private void setUpUI() {
		createPanels();
		addPanelsToFrame();
		setFrameAttributes();
	}
	
	private void createPanels() {
		log( "\tCreating Panels" );
		outputPanel   = new OutputPanel();
		settingsPanel = new SettingsPanel();
		inputPanel    = new InputPanel( this );
		controlPanel  = new ControlPanel( settingsPanel, inputPanel );
	}
	
	private void createCoreComponents( StringBuilder input ) {
		lexer     = new Lexer ( input.toString() );
		evaluator = new Evaluator();
	}
	
	private void addPanelsToFrame() {
		log( "\tAdding Panels to frame" );
		Container container = super.getContentPane(); 
		container.setLayout( new BorderLayout() );
		super.add( outputPanel, BorderLayout.NORTH );
		super.add( controlPanel, BorderLayout.CENTER );
	}
	
	private void setFrameAttributes() {
		log( "\tSetting frame attributes" );
		super.setTitle( "EasyCalc" );
		super.setLocationRelativeTo( null );
		super.setSize( 300, 350 );
		super.setResizable( false );
		super.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	private void refreshOutput() {
		lexer.reset( expression.toString() );
		ArrayList<Token> tokens = lexer.getAllTokens() ;
		outputPanel.refreshOutput( tokens ) ;
	}
	
	private void calculateAndShowAnswer() {
		Double answer;
		
		lexer.reset( expression.toString() );
		try {
			answer = evaluator.evaluate( lexer );
			expression.delete( 0, expression.length() );
			expression.append( answer.toString() );
			refreshOutput();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void inputEntered( String inputEntered ) {
		if( isCommandInput( inputEntered ) ) {
			processCommand( inputEntered ) ;
		}
		else {
			expression.append( inputEntered ) ;
			refreshOutput();
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
		if( cmd.equals( "C" ) ) {
			expression.delete( 0, expression.length() );
			refreshOutput();
		}
		else if( cmd.equals( "Del" ) ) {
			expression.delete( expression.length()-1, expression.length() );
			refreshOutput();
		}
		else if( cmd.equals( "Enter" ) ) {
			calculateAndShowAnswer();
		}
	}
	
	public static void main(String[] args) {
		log( "Creating EasyCalc main window" );
		
		EasyCalc calculator = new EasyCalc();
		calculator.setVisible( true );
		
		log( "EasyCalc main window now active" );
	}
}
