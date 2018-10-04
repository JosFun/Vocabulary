package com.funk.trainer;

import java.lang.reflect.*;
import java.util.ArrayList;
import com.funk.vocables.*;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Screen;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.text.*;

public class AddStage extends ProgStage {
	
	private Label descr;
	private TextField newListName;
	private ChoiceBox<Language> chooseLang;
	private Button newListConfirm;
	private HBox listElements;
	private MenuButton chooseTypes; /* Choose the wordtypes you want to add to your list. */
	
	private ArrayList<Vocable> chosenTypes = new ArrayList<> ( );
	
	private ArrayList<VocList> listCollection; /* A collection of all the vocableList having been created so far. */
	
	/* Create an instance of a vocable object by specifying its name.*/
	private Vocable getVocableObject ( String vocableName ) {
		Class<?> clazz = null;
		try {
			clazz = Class.forName( "com.funk.vocables." + vocableName );
		}
		catch ( ClassNotFoundException e ) {
			
		}
		
		Constructor<?> constr = null;
		try {
			constr = clazz.getConstructor ( );
		}
		catch ( NoSuchMethodException n ) {
			
		}
		
		Object vocObj = null;
		try {
			vocObj = constr.newInstance( );
		}
		catch ( InstantiationException i ) {
			
		}
		catch ( IllegalAccessException il ) {
			
		}
		catch ( InvocationTargetException in ) {
			
		}
		
		return ( ( Vocable ) ( vocObj ) );
	}
	
	/* Create all the tools, buttons and labels you need to create new lists of vocables. */
	private void createListConfig ( ) {
		this.descr = new Label ( "Create a new list of vocables:" );
		
		this.newListName = new TextField ( );
		this.newListName.setFocusTraversable( false );
		this.newListName.setPromptText( "Your list's name..." );
		
		this.chooseLang = new ChoiceBox ( );
		this.chooseLang.getItems( ).addAll( Language.FRENCH );
		this.chooseLang.setValue( Language.FRENCH );
		
		this.chooseTypes = new MenuButton ( "Wordtypes" );
		this.chooseTypes.getItems ( ).addAll( new CheckMenuItem ( "Noun" ), new CheckMenuItem ( "Verb" ),
											  new CheckMenuItem ( "Adjective"), new CheckMenuItem ( "Adverb" ),
											  new CheckMenuItem ( "Article" ), new CheckMenuItem ( "Pronoun" ),
											  new CheckMenuItem ( "Conjunction"), new CheckMenuItem ( "Preposition" ),
											  new CheckMenuItem ( "Sentence" ));
		this.chooseTypes.setAlignment ( Pos.CENTER );
		
		/* Add a listener to each CheckMenuItem */
		for ( MenuItem ch: this.chooseTypes.getItems ( ) ) {
			//if ( ch.getClass ( ).getName() != "CheckMenuItem" ) continue;
			(( CheckMenuItem ) ( ch )).selectedProperty( ).addListener( ( o, oldVal, newVal )-> {
				/* If item is checked: Add WordType to the list of wordTypes. */
				if ( newVal ) {
					this.chosenTypes.ensureCapacity( this.chosenTypes.size() + 1 );
					/* Create new instance of selected wordType. */
					this.chosenTypes.add( this.getVocableObject( ch.getText( )));
					System.out.println( this.chosenTypes.get( this.chosenTypes.size ( ) - 1 ) );
				}
			});
		}
		
		this.newListConfirm = new Button ( "Confirm" );
		this.newListConfirm.setOnAction( e -> {
			/* If the user has provided the name of a new list: Ask him again, if the really wants to create it. */
			if ( !this.newListName.getText().equals( "" ) ) { 
				AlertBox alert = new AlertBox ( this.window, "Creation of a new list",
						"Would you really like to create a new list of vocables?" );
				/* User has confirmed that he wants to create a list with the name he provided in the text field. */
				if ( alert.getAnswer ( ) ) {
					
					/* Create a new list and add it to the list collection. */
					VocList vList = new VocList ( this.newListName.getText(), this.chooseLang.getValue ( ),
												  this.chosenTypes );
					
					System.out.println( vList );
					this.newListName.setPromptText( "Your list's name..." );
					this.chooseLang.setValue( Language.FRENCH );

				}
			}
		});
		
		this.listElements = new HBox ( this.window.getWidth ( ) / 40 );
		this.listElements.getChildren().addAll( this.descr, this.newListName,
												this.chooseLang, this.newListConfirm );
		this.listElements.setAlignment( Pos.CENTER );
		
	}
	
	/* Adapt fonts for all elements on both the ProgStage template and all exclusive addStage elements. */
	@Override
	void adaptFonts ( ) {
		super.adaptFonts();
		this.descr.setFont ( new Font ( fontName, this.calcFontBase() / 60 ));
		this.newListName.setFont ( new Font ( fontName, this.calcFontBase ( ) / 60 ));
		this.chooseTypes.setFont( new Font ( fontName, this.calcFontBase ( ) / 60 ));
		for ( MenuItem check: this.chooseTypes.getItems ( ) ) {
			(( CheckMenuItem ) ( check ) ).setStyle( 
					"-fx-font: "+ this.calcFontBase ( ) / 60 + "px \"" + fontName + "\";");
		}
		this.chooseLang.setStyle( "-fx-font: "+ this.calcFontBase ( ) / 60 + "px \"" + fontName + "\";");
		this.newListConfirm.setFont( new Font ( fontName, this.calcFontBase ( ) / 60 ));
		
	}
	
	public AddStage ( Stage window, Scene menu, BorderPane layout ) {
		super ( window, menu, layout );
		this.head.setText( "Add new vocabulary" );
		this.left.setColor ( Color.AQUAMARINE );
		this.right.setColor( Color.AQUAMARINE );
		
		this.createListConfig ( );
		/* Add the listElements */
		this.center.getChildren().addAll( this.listElements, this.chooseTypes );
		
		/* Adapt the font sizes according to the current screen size. */
		this.adaptFonts ( );
		
	}
	
}
