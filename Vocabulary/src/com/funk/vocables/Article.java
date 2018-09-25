package com.funk.vocables;

public class Article extends Vocable {

	public Article( String word, Language lang, Particularity particularity ) {
		super(word, lang, particularity );
	}
	
	public Article ( String word, Language lang ) {
		super ( word, lang );
	}

}
