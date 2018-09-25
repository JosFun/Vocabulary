package com.funk.vocables;

public final class Verb extends Vocable {

	private VerbNumber numerus;
	private VerbPerson person;
	private Tempus tempus;
	private VerbGender gender;
	private Modus modus;
	
	public Verb(String word, Language lang, 
				VerbNumber numerus, VerbPerson person, Tempus tempus, VerbGender gender, Modus modus ) {
		super(word, lang);
		
	}

	public Verb(String word, Language lang,
			VerbNumber numerus, VerbPerson person, Tempus tempus, VerbGender gender, Modus modus, Particularity particularity ) {
		super(word, lang, particularity);
	}

	public Verb(String word, Language lang, VerbNumber numerus, VerbPerson person, Tempus tempus, VerbGender gender,
				Modus modus, Vocable v) {
		super(word, lang, v);
	}

	public Verb(String word, Language lang, VerbNumber numerus, VerbPerson person, Tempus tempus, VerbGender gender,
				Particularity particularity, Vocable v) {
		super(word, lang, particularity, v);
	}

}
