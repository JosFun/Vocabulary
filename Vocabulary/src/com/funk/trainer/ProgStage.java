package com.funk.trainer;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Paint;
import javafx.stage.Screen;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.text.Font;

/* Prototype for all stages this program consists of. */
public abstract class ProgStage extends Scene {
	
	static String fontName = "Arial"; 
	
	BorderPane layout;
	Button leave;
	StackPane topStack;
	Label head;
	VBox center;
	SideStrip left, right;
	Strip top, bottom;
	/* The Stage this Scene is created on. */
	Stage window;
	/* The main menu scene. */
	Scene menu;
	
	/* Calculate a base value according to which every font gets adapted.
	 * The base value does just depends on the passed width and height
	 *  by taking respect to the current scale. */
	static double calcFontBaseParam ( double windowHeight, double windowWidth ) {
		double width = windowWidth;
		double height = windowHeight;
		
		if ( width / height >= 1.7 && width / height <= 1.84 ) {
			return ( width * 0.5 + height * 0.5 );
		}
		else if ( width / height > 1.84 && width / height <= 1.91 ){
			return ( height * 0.6 + width * 0.4 );
		}
		else if ( width / height > 1.91 ) {
			return ( height * 0.7 + width * 0.3 );
		}
		else if ( width / height < 1.7 && width / height >= 1.63 ) {
			return ( height * 0.4 + width * 0.6 );
		}
		else return ( height * 0.3 + width * 0.7 );
	}
	
	public ProgStage( Stage window, Scene menu, BorderPane layout ) {
		super ( layout, window.getWidth ( ), 
				window.getHeight ( ) );
		

		this.window = window;
		this.menu = menu;
		this.layout = layout;
		this.center = new VBox ( this.window.getHeight ( ) / 15 );
		this.center.setAlignment( Pos.CENTER );
		this.center.setMinWidth( this.window.getWidth ( ) *( 8.0 / 10 ) );
		this.center.setPrefWidth( this.window.getWidth ( ) * ( 8.0 / 10 ) );
		
		/* Create buttons and labels. */ 
		this.leave = new Button ( "Back to menu" );
		this.leave.setMinHeight( this.window.getHeight() / 24 );
		this.leave.setPrefHeight ( this.window.getHeight ( ) / 24 );
		this.leave.setMaxHeight( Double.MAX_VALUE );
		this.leave.setMinWidth( this.window.getWidth ( ) / 10 );
		this.leave.setPrefWidth( this.window.getWidth() / 10 );
		this.leave.setOnAction( e -> {
			this.window.setScene ( this.menu );
		});
				
		this.head = new Label ( );

		/* Create all canvas elements on the screen. */
		this.left = new SideStrip ( this.window, this.getWidth ( ) / 6, this.getHeight ( ) * ( 8.31 / 10 ) );
		this.right = new SideStrip (  this.window, this.getWidth ( ) / 6, this.getHeight ( ) * ( 8.31 / 10 ) );
		this.top = new Strip ( this.window, this.getWidth ( ), this.getHeight ( ) / 20 );
		this.bottom = new Strip ( this.window, this.getWidth ( ), this.getHeight ( ) / 20 );
	
		/* Create StackPane to put Leave button on top of a canvas on the top of the window. */
		this.topStack = new StackPane ( );
		this.topStack.getChildren ( ).addAll( this.top, this.leave );
		this.topStack.setPrefHeight( this.window.getHeight ( ) / 24 );
		this.topStack.setMinHeight ( this.window.getHeight ( ) / 24 );
		
		
		/* Add components to the center vbox. */
		this.center.getChildren().addAll( this.head );

		/* Add all subcomponents to the BoderPane */
		BorderPane.setAlignment ( this.center, Pos.CENTER );
		this.layout.setCenter( this.center );
		
		BorderPane.setAlignment ( this.left, Pos.CENTER_LEFT );
		this.layout.setLeft( this.left );
		
		BorderPane.setAlignment( this.right, Pos.CENTER_RIGHT );
		this.layout.setRight( this.right );
		
		BorderPane.setAlignment( this.topStack, Pos.TOP_CENTER );
		this.layout.setTop( this.topStack );
		
		BorderPane.setAlignment( this.bottom, Pos.BOTTOM_CENTER );
		this.layout.setBottom( this.bottom );
		
		
		/* Listen to changes of width and height of the stage and resize the elements, which do not do this 
		 * on their own already. */
		this.window.widthProperty().addListener( e -> {
			this.leave.setPrefWidth( this.window.getWidth() / 10 );
			this.topStack.setPrefWidth( this.window.getWidth ( ));
			/* This invocation let's automatically adapt the sizes of the nodes with text on it according
			 * to their new font sizes. So by just adapting the font sizes of the elements, they themselves 
			 * adapt their sizes to the now bigger screen. */
			this.adaptFonts ( );
		});
		
		this.window.heightProperty().addListener( e -> {
			this.leave.setPrefHeight( this.window.getHeight ( ) / 24 );
			this.topStack.setPrefHeight( this.window.getHeight ( ) / 24 );
			this.adaptFonts ( );
		});
		
		
	}
	
	/* Adapt the fonts of the displayed text elements according to the current size of the stage. */
	void adaptFonts ( ) {
		this.head.setFont( 
				new Font ( fontName, ( this.calcFontBase ( ) ) / 40 ));
		this.leave.setFont( new Font ( fontName, ( this.calcFontBase ( )) / 70 ));
	}

	/* Calculate a base font size value according to the current screenSize. Uses a static method of this class. */
	double calcFontBase ( ) {
		return ( calcFontBaseParam ( this.window.getHeight(), this.window.getWidth() ) );
	}
	
	
}
