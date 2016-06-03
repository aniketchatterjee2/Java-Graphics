package com.sensei.EasyCalc.core;

public class Lexer {
	
	private String input      = null;
	private int    currentPos = 0;
	
	public Lexer( String input ) {
		this.input = input;
	}
	
	public Token getNextToken() {
		if( currentPos >= input.length() ) {
			return null;
		}
		Token token = new Token( Token.NUMERIC, null );
		for( int i=currentPos; i<input.length(); i++ ) {
			char ch = input.charAt( i );
			if( ch == ' ' ) {
				continue;
			}
			else if( ch == '+' || ch == '\u2212' || ch == '\u00d7' || ch == '\u00f7' ) {
				return new Token( Token.OPERATOR, ch+"" );
			}
			else if( ch == '(' || ch == ')' ) {
				return new Token( Token.PARENTHESES, ch+"" );
			}
			else if( ch == '.' || Character.isDigit( ch ) ) {
				token.append( ch+"" );
				if( input.charAt( i+1 ) != '.' || !(Character.isDigit(input.charAt( i+1 )) ) ) {
					return token;
				}
			}
		}
		return null;
	}
}
