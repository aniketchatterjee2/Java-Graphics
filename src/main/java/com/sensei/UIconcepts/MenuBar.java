package com.sensei.UIconcepts;

import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar{

	FileMenu fileMenu = null;
	
	public MenuBar() {
		fileMenu = new FileMenu();
		configureMenuBar();
	}
	
	private void configureMenuBar() {
		super.add( fileMenu );
	}
}
