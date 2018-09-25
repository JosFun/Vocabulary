package com.funk.vocables;

/* This class represents a noun. A type of vocable with a gender, a number, and an article. */
public final class Noun extends Vocable {
	
	private Gender genus;
	private NounNumber numerus;
	private Article article;
	
	private void determineArticle ( ) {
		if ( this.lang == Language.FRENCH ) {
			/* In French, an singular article transforms to l' in front of nouns beginning with a vocal or a muted h.*/
			char c = this.word.toCharArray() [ 0 ]; /* get first char in the array*/
			if ( this.numerus == NounNumber.SINGULAR && 
				( Vocable.isVocal( c ) || ( ( FrenchParticularity ) this.particularity ) == FrenchParticularity.NOUN_MUTED_H ) ) {
				this.article = new Article ( "l'", this.lang );
			}
			else if ( this.numerus == NounNumber.SINGULAR ) {
				if ( this.genus == Gender.MASCULINE ) {
					this.article = new Article ( "le", this.lang );
				}
				else {
					this.article = new Article ( "la", this.lang );
				}
			}
			else {
				this.article = new Article ( "les", this.lang );
			}
		}
	}
	
	public Noun ( String word, Language lang, Gender genus, NounNumber numerus, Particularity particularity ) {
		super ( word, lang, particularity );
		this.genus = genus;
		this.numerus = numerus;
		
		/* Determine this word's article according to the details specified above. */
		this.determineArticle();
	}
	
	public Noun ( String word, Language lang, Gender genus, NounNumber numerus ) {
		super ( word, lang );
		this.genus = genus;
		this.numerus = numerus;
		
		this.determineArticle ( );
	}
	
	public Noun ( String word, Language lang, Gender genus, NounNumber numerus, Vocable v ) {
		super ( word, lang, v );
		this.genus = genus;
		this.numerus = numerus;
		
		this.determineArticle ( );
	}
	
	public Noun ( String word, Language lang, Gender genus, NounNumber numerus, Particularity particularity, Vocable v ) {
		super ( word, lang, particularity, v );
		this.genus = genus;
		this.numerus = numerus;
		
		this.determineArticle( );
	}
	
	@Override
	public String toString ( ) {
		return ( this.article.toString ( ) + " " + this.word );
	}
}
