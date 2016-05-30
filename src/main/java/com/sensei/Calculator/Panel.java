package com.sensei.Calculator;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Panel {
	
	ActionListener a; KeyListener k;
	JButton button1;
	JTextField textField1, textField2;
	JRadioButton rbutton1, rbutton2, rbutton3, rbutton4;
	JSlider slider1;
	
	JPanel inputPanel = new JPanel();
	JPanel settingsPanel = new JPanel();
	
	public Panel( ActionListener a, KeyListener k ) {
		this.a = a;
		this.k = k;
	}
	
	public JPanel[] getPanels() {
		JPanel[] panels = { inputPanel, settingsPanel };
		return panels;
	}
	
	public void init() {
		button1 = new JButton( "Calculate" );
		button1.addActionListener( a );
		
		textField1 = new JTextField( "", 5 );
		textField2 = new JTextField( "", 5 );
		
		rbutton1 = new JRadioButton( "Add" );
		rbutton2 = new JRadioButton( "Subtract" );
		rbutton3 = new JRadioButton( "Multiply" );
		rbutton4 = new JRadioButton( "Divide" );
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbutton1);
		group.add(rbutton2);
		group.add(rbutton3);
		group.add(rbutton4);
		
		inputPanel.add(button1);
		inputPanel.add(textField1);
		inputPanel.add(textField2);
		settingsPanel.add(rbutton1);
		settingsPanel.add(rbutton2);
		settingsPanel.add(rbutton3);
		settingsPanel.add(rbutton4);
	}

}
