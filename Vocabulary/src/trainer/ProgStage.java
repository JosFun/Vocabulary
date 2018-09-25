package trainer;

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

/* Prototype for all stages this program consists of. */
public class ProgStage extends Scene {
		
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
	
	public ProgStage( Stage window, Scene menu, BorderPane layout ) {
		super ( layout, window.getWidth ( ), 
				window.getHeight ( ) );
		

		this.window = window;
		this.menu = menu;
		this.layout = layout;
		this.center = new VBox ( this.window.getHeight ( ) / 15 );
		this.center.setMinWidth( this.window.getWidth ( ) *( 8.0 / 10 ) );
		this.center.setPrefWidth( this.window.getWidth ( ) * ( 8.0 / 10 ) );
		
		/* Create buttons and labels. */ 
		this.leave = new Button ( "Back to menu" );
		this.leave.setMinHeight( this.window.getHeight() / 27 );
		this.leave.setPrefHeight ( this.window.getHeight ( ) / 20 );
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
		this.topStack.setPrefHeight( this.window.getHeight ( ) / 20 );
		
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
		
		this.window.heightProperty().addListener( o -> {
			this.topStack.setPrefHeight( this.window.getHeight ( ) / 20 );
			this.leave.setPrefHeight( this.window.getHeight ( ) / 20 );
		});
		
		this.window.widthProperty().addListener( o -> {
			this.topStack.setPrefWidth( this.window.getWidth ( ) );
			this.leave.setPrefWidth( this.window.getWidth ( ) / 10 );
		});
		
	}
	
	
}
