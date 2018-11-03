package com.funk.vocables;

public class Article extends Vocable {

	private ArticleDefinity definity;
	{
		this.nameOfType = "Article";
	}
	
	public Article ( ) {
		super ( "Article", Language.ENGLISH );
	}
	public Article( String word, Language lang, Particularity particularity, ArticleDefinity definity ) {
		super(word, lang, particularity );
		this.definity = definity;
	}
	
	public Article ( String word, Language lang, ArticleDefinity definity ) {
		super ( word, lang );
		this.definity = definity;
	}

}
