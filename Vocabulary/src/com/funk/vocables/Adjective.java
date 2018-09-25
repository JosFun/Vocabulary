package com.funk.vocables;

public final class Adjective extends Vocable {

	private Comparation comparation;
	
	public Adjective(String word, Language lang, Comparation comparation ) {
		super(word, lang);
	}

	public Adjective(String word, Language lang, Comparation comparation, Particularity particularity) {
		super(word, lang, particularity);
	}

	public Adjective(String word, Language lang, Comparation comparation, Vocable v) {
		super(word, lang, v);
	}

	public Adjective(String word, Language lang, Comparation comparation, Particularity particularity, Vocable v) {
		super(word, lang, particularity, v);
	}

}
