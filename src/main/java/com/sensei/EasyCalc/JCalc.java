package com.sensei.EasyCalc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JCalc extends JFrame implements ActionListener {

	private JTextField outputTF = null ;
	private JComboBox<String> modeCB = null ;
	
	public JCalc() {
		setUpUI() ;
	}
	
	private void setUpUI() {
		
		Container contentPane = super.getContentPane() ;
		contentPane.setLayout( new BorderLayout() );
		
		contentPane.add( getOutputPanel(), BorderLayout.NORTH ) ;
		contentPane.add( getControlsPanel(), BorderLayout.CENTER ) ;
		
		super.setSize( 400, 400 ) ;
		super.setDefaultCloseOperation( EXIT_ON_CLOSE );
	}
	
	private JPanel getOutputPanel() {
		JPanel panel = new JPanel() ;
		panel.setLayout( new BorderLayout( 20, 20 ) );
		panel.add( getOutputTF() ) ;
		return panel ;
	}
	
	private JPanel getControlsPanel() {
		JPanel panel = new JPanel() ;
		panel.setLayout( new BorderLayout() ) ;
		panel.add( getModePanel(), BorderLayout.NORTH ) ;
		panel.add( getButtonPanel(), BorderLayout.CENTER );
		return panel ;
	}
	
	private JTextField getOutputTF() {
		outputTF = new JTextField() ;
		outputTF.setFont( new Font( "Monospace", Font.PLAIN, 30 ) ) ;
		return outputTF ;
	}
	
	private JPanel getModePanel() {
		JPanel panel = new JPanel() ;
		panel.setLayout( new FlowLayout( FlowLayout.CENTER ) );
		panel.add( getModeCB() ) ;
		return panel ;
	}
	
	private JComboBox<String> getModeCB() {
		String[] modes = { "Arithmetic", "Time", "Currency" } ;
		modeCB = new JComboBox<String>( modes ) ;
		return modeCB ;
	}
	
	private JPanel getButtonPanel() {
		
		Font btnFont = new Font( "Helvetica", Font.PLAIN, 20 ) ;
		JPanel panel = new JPanel() ;
		panel.setLayout( new GridLayout( 4, 5 ) ) ;
		
		String[] buttonTexts = { 
				"C", "Del", ".", "+", "-",
				"7", "8", "9", "*", "/",
				"4", "5", "6", "(", ")",
				"1", "2", "3", "0", "Enter"
		} ;
		
		for( int i=0; i<buttonTexts.length; i++ ) {
			JButton btn = new JButton( buttonTexts[i] ) ;
			btn.setFont( btnFont ) ;
			btn.addActionListener( this ) ;
			panel.add( btn ) ;
		}
		
		return panel ;
	}
	
	public void actionPerformed(ActionEvent e) {
		String key = (( JButton )e.getSource()).getText() ;
		outputTF.setText( outputTF.getText() + key ) ; 
	}

	public static void main(String[] args) {
		new JCalc().setVisible( true );
	}
}
