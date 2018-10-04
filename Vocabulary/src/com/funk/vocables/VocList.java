package com.funk.vocables;

import java.util.ArrayList;
import java.util.Collection;

/* A list of vocables with some properties characterizing the vocables it contains, i.e. a common language,
 * and a common type of words. */
public class VocList extends ArrayList<Vocable> {
	private static final long serialVersionUID = 2216615026521308110L;
	
	private String name; /* The name of this vocable list. */
	private Language lang; /* The language of the vocables in this list. */
	private ArrayList<Vocable> wordTypes = new ArrayList <>( ); /* A list of all the word types you may add to this list. */
	
	/* Construct a new list with the specified name, language and wordtypes.*/
	public VocList( String name, Language lang, Vocable... wordtype  ) {
		this.name = name;
		this.lang = lang;
		this.addWordTypes( wordtype );
	}
	
	/* Constructs a new vocList with the specified initial capacity. */
	public VocList(int initialCapacity, String name, Language lang, Vocable... wordtype ) {
		super(initialCapacity);
		this.name = name;
		this.lang = lang;
		this.addWordTypes( wordtype );
	}
	
	/* Add new wordTypes to the list of wordTypes, this list can contain. */
	public void addWordTypes ( Vocable... wordType ) {
		for ( Vocable type : wordType ) {
			this.wordTypes.ensureCapacity( this.wordTypes.size ( ) + 1 );
			this.wordTypes.add( type );
		}
	}
	
	/* Getters */
	public String getName ( ) {
		return ( this.name );
	}
	
	public Language getLanguage ( ) {
		return ( this.lang );
	}
	
	public ArrayList<Vocable> getWordTypes ( ) {
		return ( this.wordTypes );
	}
	
	/* Setters */
	public void setName ( String name ) {
		this.name = name;
	}
	
	public void setLanguage ( Language lang ) {
		this.lang = lang;
	}

}
