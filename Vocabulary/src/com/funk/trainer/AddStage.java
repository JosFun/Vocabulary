package com.funk.trainer;

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
	private Button newListConfirm;
	private HBox listElements;
	/* Create all the tools, buttons and labels you need to create new lists of vocables. */
	private void createListConfig ( ) {
		this.descr = new Label ( "Create a new list of vocables:" );
		
		this.newListName = new TextField ( );
		this.newListName.setFocusTraversable( false );
		this.newListName.setPromptText( "Your list's name.." );
		
		this.newListConfirm = new Button ( "Confirm" );
		this.newListConfirm.setOnAction( e -> {
			/* If the user has provided the name of a new list: Ask him again, if the really wants to create it. */
			if ( !this.newListName.getText().equals( "" ) ) { 
				AlertBox alert = new AlertBox ( this.window, "Creation of a new list",
						"Would you really like to create a new list of vocables?" );
				/* User has confirmed that he wants to create a list with the name he provided in the text field. */
				if ( alert.getAnswer ( ) ) {
					
				}
			}
		});
		
		this.listElements = new HBox ( this.window.getWidth ( ) / 40 );
		this.listElements.getChildren().addAll( this.descr, this.newListName, this.newListConfirm );
		this.listElements.setAlignment( Pos.CENTER );
		
	}
	
	@Override
	void adaptFonts ( ) {
		super.adaptFonts();
		this.descr.setFont ( new Font ( fontName, this.calcFontBase() / 60 ));
		this.newListName.setFont ( new Font ( fontName, this.calcFontBase ( ) / 70 ));
		this.newListConfirm.setFont( new Font ( fontName, this.calcFontBase ( ) / 60 ));
		
	}
	
	public AddStage ( Stage window, Scene menu, BorderPane layout ) {
		super ( window, menu, layout );
		this.head.setText( "Add new vocabulary" );
		this.left.setColor ( Color.AQUAMARINE );
		this.right.setColor( Color.AQUAMARINE );
		
		this.createListConfig ( );
		this.center.getChildren().addAll( this.listElements );
		
		/* Adapt the font sizes according to the current screen size. */
		this.adaptFonts ( );
		
	}
	
}
