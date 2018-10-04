package com.funk.vocables;

/* Representing a sentence. It will be seen as a vocable in the educational context of this program. */
public class Sentence extends Vocable {

	{
		this.nameOfType = "Adverb";
	}
	
	public Sentence(String word, Language lang) {
		super(word, lang);
	}

	public Sentence(String word, Language lang, Particularity particularity) {
		super(word, lang, particularity);
		
	}

}
