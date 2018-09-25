package trainer;

import javafx.scene.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class Display extends Application {

	private Stage window;
	private Scene welcome, trainVoc, addVoc;
	private Button train, add;
	private Label header;
	private BorderPane layout;
	private HBox subLayout;
	
	public Display() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void start ( Stage primary ) {
		this.window = primary;
		
		Screen monitor = Screen.getPrimary();
		double monitorWidth = monitor.getBounds( ).getWidth( );
		double monitorHeight = monitor.getBounds( ).getHeight( );
		
		this.window.setWidth( monitorWidth / 2 );
		this.window.setHeight( monitorHeight / 2 );
		
		this.layout = new BorderPane ( );		
		this.welcome = new Scene ( this.layout, monitorWidth / 2, monitorHeight / 2 );
		this.welcome.setFill( null );

		this.train = new Button ( "Train" );
		this.add = new Button ( "Add" );
		this.header = new Label ( "Vocabulary Trainer" );
		
		this.subLayout = new HBox ( );
		this.subLayout.getChildren( ).addAll( this.train, this.add );
		
		BorderPane.setAlignment( this.header, Pos.TOP_CENTER );
		this.layout.setTop( this.header );
		BorderPane.setAlignment( subLayout, Pos.CENTER );
		this.layout.setCenter( subLayout );
		
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
	    this.window.setX((primScreenBounds.getWidth() - this.window.getWidth()) / 2); 
	    this.window.setY((primScreenBounds.getHeight() - this.window.getHeight()) / 4);  
		
		this.window.setScene( this.welcome );
		this.window.setTitle( "Vocabulary trainer" );
		this.window.show ( );
		
		this.setButtonActions( );
	}
	
	private void setButtonActions ( ) {
		this.addVoc = new AddStage ( this.window, this.welcome, new BorderPane ( ) );
		this.trainVoc = new TrainStage ( this.window, this.welcome, new BorderPane ( ) );
		this.train.setOnAction ( e -> {
			this.window.setScene( this.trainVoc );
		});
		this.add.setOnAction( e -> {
			this.window.setScene( this.addVoc );
		});
	}
	
	public static void main ( String [ ] args ) {
		Application.launch( args );
	}

}
