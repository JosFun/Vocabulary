package com.funk.vocables;

public final class Adverb extends Vocable {
	
	private Comparation comparation;
	/*
	Order of execution:

		static initialization blocks of super classes

		static initialization blocks of the class

		instance initialization blocks of super classes

		constructors of super classes

		instance initialization blocks of the class

		constructor of the class.
	*/
	{
		this.nameOfType = "Adverb";
	}
	
	public Adverb(String word, Language lang, Comparation comparation ) {
		super(word, lang);
		// TODO Auto-generated constructor stub
	}

	public Adverb(String word, Language lang, Comparation comparation, Particularity particularity) {
		super(word, lang, particularity);
		// TODO Auto-generated constructor stub
	}

	public Adverb(String word, Language lang, Comparation comparation, Vocable v) {
		super(word, lang, v);
		// TODO Auto-generated constructor stub
	}

	public Adverb(String word, Language lang, Comparation comparation, Particularity particularity, Vocable v) {
		super(word, lang, particularity, v);
		// TODO Auto-generated constructor stub
	}

}
