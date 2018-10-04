package com.funk.vocables;

public final class Pronoun extends Vocable {
	
	private PronounKind kind;
	
	{
		this.nameOfType = "Pronoun";
	}
	
	public Pronoun ( ) {
		super ( "Pronoun", Language.ENGLISH );
	}
	public Pronoun(String word, Language lang) {
		super(word, lang);
		// TODO Auto-generated constructor stub
	}

	public Pronoun(String word, Language lang, Particularity particularity) {
		super(word, lang, particularity);
		// TODO Auto-generated constructor stub
	}

	public Pronoun(String word, Language lang, Vocable v) {
		super(word, lang, v);
		// TODO Auto-generated constructor stub
	}

	public Pronoun(String word, Language lang, Particularity particularity, Vocable v) {
		super(word, lang, particularity, v);
		// TODO Auto-generated constructor stub
	}

}
