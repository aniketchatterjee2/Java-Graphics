package com.sensei.Calculator;

public class App {

	public static void main(String[] args) {
		
		EventListeners listener = new EventListeners();
		EventListeners.ButtonListener buttonListener = new EventListeners.ButtonListener();
		EventListeners.TextListener textListener = new EventListeners.TextListener();
		
		Panel panel = new Panel( buttonListener, textListener );
		Frame frame = new Frame( 500, 500, "Calculator", panel.getPanels() );
		listener.setPanel( panel );
		
		panel.init();
		frame.init();
	}

}
