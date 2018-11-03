package com.funk.vocables;

public abstract class Vocable {
	String nameOfType; /* The name of the word type. */
	String word;
	Language lang;
	Particularity particularity;
	boolean known;
	
	VocList translations; /* Translation of this vocable is another vocable*/
	Vocable specialForm = null; /* If this vocable has any kind of other word connected to it, add it here. */
	
	/* Decide whether or not the specified char is a vocal. */
	static boolean isVocal ( char c ) {
		c = Character.toLowerCase( c );
		return ( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' );
	}
	
	/* Constructor for a new vocable. Specify the vocable itself and its language. */
	public Vocable ( String word, Language lang ) {
		this.word = word;
		this.lang = lang;
	}
	
	/* Constructor for a new vocable. Specify the word itself, its language and a particularity of the vocable . */
	public Vocable ( String word, Language lang, Particularity particularity ) {
		this ( word, lang );
		this.particularity = particularity;
	}
	
	/* Constructor for a new vocable. Specify the word itself, its language and another vocable ( f.e. when special forms exist )*/
	public Vocable ( String word, Language lang, Vocable v ) {
		this ( word, lang );
		
	}
	
	public Vocable ( String word, Language lang, Particularity particularity, Vocable v ) {
		this ( word, lang, particularity );
	}
	
	/* Add translations to the vocable depending on the languages of the voclist you are currently using
	 * to study this vocable. */
	public void setTranslations ( VocList translations ) {
		this.translations = translations;
	}
	
	/* This method edits the content of the boolean known.
	 * Before studying, you want to set this status to false for all vocables in your list. */
	public void setKnownStatus ( boolean knownStatus ) {
		this.known = knownStatus;
	}
	
	/* Give a translation for this vocable. Depending on its correctness, the field this.known
	 * will be set. Afterwards, this field's value is returned. */
	public boolean testForTranslations ( String yourInput ) {
		for ( Vocable translation : this.translations ) {
			if ( yourInput.equals ( translation.toString ( ) ) ) {
				return ( this.known = true );
			}
		}
		
		return ( false );
	}
	
	public VocList getTranslations ( ) {
		return ( this.translations );
	}
	
	public String getTypeName ( ) {
		return ( this.nameOfType );
	}
	
	
	@Override
	public boolean equals ( Object o ) {
		if ( o == this ) return ( true );
		else if ( o.getClass() == this.getClass ( ) ) {
			return ( this.word.toLowerCase().equals ( ( ( Vocable ) o ).toString ( ).toLowerCase() ) );
		}
		else return ( false );
	}
	
	@Override
	public String toString ( ) {
		return ( this.word );
	}
}
