package com.sensei.EasyCalc.core;

public class Evaluator {
	
	public Evaluator() {
	}
	
	public double evaluate( Lexer lexer ) throws Exception{
		double value = 0;
		value = calculateASOp( lexer );
		Token token = lexer.getNextToken();
		
		while ( token != null ) {
			
			if( token.getTokenValue().equals("+") ||
			    token.getTokenValue().equals("-") ) {
				
				double rightHandValue = calculateASOp( lexer );
				if( token.getTokenValue().equals( "+" ) ) {
					value += rightHandValue;
				}
				else if( token.getTokenValue().equals( "-" ) ) {
					value -= rightHandValue;
				}
				token = lexer.getNextToken() ;
			}
			else {
				lexer.pushBackToken( token );
				break ;
			}
		}
		return value;
	}
	
	private double calculateASOp( Lexer lexer ) throws Exception{
		double value = 0;
		value = calculateMDOp( lexer );
		Token token = lexer.getNextToken();
		
		while ( token != null ) {
			
			if( token.getTokenValue().equals("*") ||
			    token.getTokenValue().equals("/") ) {
				
				double rightHandValue = calculateMDOp( lexer );
				if( token.getTokenValue().equals( "*" ) ) {
					value *= rightHandValue;
				}
				else if( token.getTokenValue().equals( "/" ) ) {
					value /= rightHandValue;
				}
				token = lexer.getNextToken() ;
			}
			else {
				lexer.pushBackToken( token );
				break ;
			}
		}
		return value;
	}
	
	private double calculateMDOp( Lexer lexer ) throws Exception{
		double value = 0;
		Token token = lexer.getNextToken();
		
		if( token == null ) {
			throw new Exception( "Incomplete expression" ) ;
		}
		
		if( token.getTokenType() == Token.NUMERIC ) {
			value = Double.parseDouble( token.getTokenValue() );
		}
		else if( token.getTokenType() == Token.PARENTHESES ) {
			
			if( token.getTokenValue().equals( "(" ) ) {
				value = evaluate( lexer );
				token = lexer.getNextToken();
				if( !token.getTokenValue().equals( ")" ) ) {
					throw new Exception( "Right bracket missing" );
				}
			}
			else if( token.getTokenValue().equals( ")" ) ) {
				throw new Exception( "Invalid Input" );
			}
		}
		
		return value;
	}
}
