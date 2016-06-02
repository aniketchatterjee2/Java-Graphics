package com.sensei.EasyCalc;

import javax.swing.*;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SettingsPanel extends JPanel {

	private JComboBox<String> NumTypeComboBox = null;
	private static String[] numTypes = { "Arithmetic", "Time" };
	
	public SettingsPanel() {
		setUpUI(); 
	}
	
	private void setUpUI() {
		createComponents();
		putComponents();
	}
	
	private void createComponents() {
		NumTypeComboBox = new JComboBox<String>( numTypes );
	}
	
	private void putComponents() {
		super.add( NumTypeComboBox );
	}
}
