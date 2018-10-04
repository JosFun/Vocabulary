package com.funk.trainer;

import java.util.*;

import com.funk.vocables.*;

import java.math.*;

public class Randomizer {
	private VocList vocList;
	private Language lang;
	
	/* Constructor: Initialize the Randomizer with a list of vocabulary. */
	public Randomizer ( VocList vocList, Language lang ) {
		this.vocList = vocList;
		this.lang = lang;
	}
	
	/* Get a new random vocable from the vocList. */
	public Vocable getNext ( ) {
		try {
			int random = ( int ) ( Math.random ( ) * this.vocList.size ( ) );
			return ( this.vocList.get( random ));
		}
		catch ( IndexOutOfBoundsException e ) {
			return ( new Sentence ( "No more vocables left.", this.lang ));
		}
	}
	
	/* Remove the specified vocable from the randomizer's list so that it won't appear ever again. */
	public void remove ( Vocable toBeRemoved ) {
		this.vocList.remove( toBeRemoved );
	}
	
}
