package com.sensei.EasyCalc.core;

public class Token {

	public static final int NUMERIC     = 0;
	public static final int OPERATOR    = 1;
	public static final int PARENTHESES = 2;
	public static final int COMMAND     = 3;
	
	private int    tokenType  = 0;
	private String tokenValue = null;
	
	public Token( int type, String value ) {
		this.tokenType  = type;
		this.tokenValue = value;
	}
	
	public int getTokenType() {
		return tokenType;
	}
	
	public void append( String str ) {
		tokenValue += str;  
	}
	
	public String getTokenValue() {
		return tokenValue;
	}
}
