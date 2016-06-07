package com.sensei.EasyCalc.core;

import java.util.ArrayList;

public class Parser {
	
	private ArrayList<Token> expression = null;
	
	public void setExpression( ArrayList<Token> expression ) {
		this.expression =  expression ;
	}
	
	public ArrayList<Token> parse( ArrayList<Token> tokens ) {
		setExpression( tokens );
		ArrayList<Token> parsedExpr = new ArrayList<Token>();
		
		return parsedExpr;
	}
}
