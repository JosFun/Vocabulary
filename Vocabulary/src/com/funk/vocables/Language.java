package com.funk.vocables;

public enum Language {
	FRENCH, ENGLISH;
	
	public String toString ( ) {
		if ( this == FRENCH ) {
			return ( "French Language" );
		}
		else if ( this == ENGLISH ) {
			return ( "English Language" );
		}
		else return ( null );
	}
}
