package com.funk.vocables;

public enum Language {
	FRENCH;
	
	public String getName ( ) {
		if ( this == FRENCH ) {
			return ( "French Language" );
		}
		else return ( null );
	}
}
