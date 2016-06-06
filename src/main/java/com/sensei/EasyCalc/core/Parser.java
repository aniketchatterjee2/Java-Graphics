package com.sensei.EasyCalc.core;

import java.util.ArrayList;

public class Parser {
	
	private String[] expression = null;
	
	public void setExpression( ArrayList<Token> expression ) {
		this.expression = parseExpression( expression );
	}
	
	public String[] parseExpression( ArrayList<Token> tokens ) {
		String[] expr = new String[tokens.size()];
		
		for( int i=0; i<tokens.size(); i++ ) {
			expr[i] = tokens.get( i ).getTokenValue();
			System.out.println( expr[i] );
		}
		return expr;
	}
	
	public String[] parse( ArrayList<Token> tokens ) {
		setExpression( tokens );
		String[] expression = getExpression();
		return expression;
	}
	
	public String[] getExpression() {
		return expression;
	}
}
