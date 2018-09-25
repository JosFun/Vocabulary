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

/* Prototype for all stages this program consists of. */
public class ProgStage extends Scene {
		
	BorderPane layout;
	Button leave;
	Label head;
	VBox center;
	Canvas left, right;
	/* The Stage this Scene is created on. */
	Stage window;
	/* The main menu scene. */
	Scene menu;
	
	public ProgStage( Stage window, Scene menu, BorderPane layout ) {
		super ( layout, window.getWidth ( ) / 4, 
				window.getHeight ( ) / 4 );
		
		this.window = window;
		this.menu = menu;
		this.layout = layout;
		this.center = new VBox ( this.window.getHeight ( ) / 15 );
		
		this.left = new Canvas ( this.window.getWidth ( ) / 6, this.window.getHeight ( ) );
		this.right = new Canvas (  this.window.getWidth ( ) / 6, this.window.getHeight ( ) );
		
		/* Create buttons and labels. */
		this.leave = new Button ( "Back to menu" );
		this.leave.setOnAction( e -> {
			this.window.setScene ( this.menu );
		});
		
		this.head = new Label ( );
		
		/* Add components to the center vbox. */
		this.center.getChildren().addAll( this.head );
		
		BorderPane.setAlignment( this.leave, Pos.TOP_CENTER );
		this.layout.setTop( this.leave );
		
		BorderPane.setAlignment ( this.center, Pos.CENTER );
		this.layout.setCenter( this.center );
		
		BorderPane.setAlignment ( this.left, Pos.CENTER_LEFT );
		this.layout.setLeft( this.left );
		
		BorderPane.setAlignment( this.right, Pos.CENTER_RIGHT );
		this.layout.setRight( this.right );
		
	}
	
	
}
