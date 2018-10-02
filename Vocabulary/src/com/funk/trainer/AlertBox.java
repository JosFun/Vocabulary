package com.funk.trainer;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.Scene;

/* Provides an AlertBox. */
public class AlertBox extends Stage {
	
	boolean answer = false; /* The answer the user has to provide when he exits the alert box. */

	/* @param mainStage - The mainStage the user was directed from to this AlertBox
	 * @param title - The title of this AlertBox
	 * @param message - The message being to be displayed on this AlertBox.*/
	public AlertBox( Stage mainStage, String title, String message ) {
		super ( );
		
		/* Communication with other windows is blocked until this one is taken care of. */
		this.initModality( Modality.APPLICATION_MODAL );
		this.setTitle ( title );
		this.setHeight( mainStage.getHeight() / 4 );
		this.setWidth( mainStage.getWidth() / 2 );
		
		/* Create a Label to display the message and a Button two buttons to interact with the Box.*/
		Label msg = new Label ( message );
		Button yes = new Button ( "Yes" );
		yes.setOnAction( e -> {
			this.answer = true;
			this.close ( );
		});
		Button no = new Button ( "No" );
		no.setOnAction( e -> {
			this.close ( );
		});
		System.out.println( "width " + this.getWidth ( ));
		HBox buttonContainer = new HBox ( this.getWidth( ) / 10 );
		buttonContainer.getChildren().addAll( no, yes );
		buttonContainer.setAlignment( Pos.CENTER );
		
		msg.setFont ( 
				new Font ( ProgStage.fontName, 
						ProgStage.calcFontBaseParam( this.getHeight ( ), this.getWidth ( ) ) / 20 ));
		yes.setFont( 
				new Font ( ProgStage.fontName,
						ProgStage.calcFontBaseParam( this.getHeight ( ), this.getWidth ( )) / 20 ));
		no.setFont ( 
				new Font ( 
						ProgStage.fontName, ProgStage.calcFontBaseParam( this.getHeight ( ), this.getWidth( )) / 20 ));
		
		/* Create the HBox to which all the control elements are to be added. */
		VBox box = new VBox ( this.getHeight ( ) / 10 );
		box.getChildren().addAll( msg, buttonContainer );
		box.setAlignment( Pos.CENTER );
		
		Scene scene = new Scene ( box, this.getWidth(), this.getHeight ( ) );
		
		this.setScene( scene );
		this.showAndWait();
	}
	
	boolean getAnswer ( ) {
		return ( this.answer );
	}

}
