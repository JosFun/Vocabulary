package com.funk.vocables;

public final class Preposition extends Vocable {

	{
		this.nameOfType = "Preposition";
	}
	
	public Preposition ( ) {
		super ( "Prepositon", Language.ENGLISH );
	}
	
	public Preposition(String word, Language lang) {
		super(word, lang);
		// TODO Auto-generated constructor stub
	}

	public Preposition(String word, Language lang, Particularity particularity) {
		super(word, lang, particularity);
		// TODO Auto-generated constructor stub
	}

	public Preposition(String word, Language lang, Vocable v) {
		super(word, lang, v);
		// TODO Auto-generated constructor stub
	}

	public Preposition(String word, Language lang, Particularity particularity, Vocable v) {
		super(word, lang, particularity, v);
		// TODO Auto-generated constructor stub
	}

}
