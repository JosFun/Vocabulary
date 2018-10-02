package com.funk.trainer;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

/* A resizable canvas which provides a strip you can set as top or bottom of your BorderPane. */
public class Strip extends Canvas {

	private double monitorWidth = Screen.getPrimary().getBounds().getWidth();
	private double monitorHeight = Screen.getPrimary().getBounds().getHeight();
	private Stage window;
	
	public Strip( Stage window ) {
		this.window = window;
	}

	public Strip( Stage window, double width, double height) {
		super(width, height);
		this.window = window;
	}
	
	@Override
	public double minHeight ( double width ) {
		return ( this.window.getHeight ( ) / 24 );
	}
	
	@Override
	public double maxHeight ( double width ) {
		return ( Double.MAX_VALUE );
	}
	
	@Override
	public double prefHeight ( double width ) {
		return ( this.minHeight ( width ) );
	}
	
	@Override
	public double prefWidth ( double height ) {
		return ( this.minWidth(height));
	}

	
	@Override
	public double minWidth ( double height ) {
		return ( this.window.getWidth ( ) );
	}
	
	@Override
	public double maxWidth ( double height ) {
		return ( Double.MAX_VALUE );
	}
	
	@Override 
	public boolean isResizable ( ) {
		return ( true );
	}
	
	@Override
	public void resize ( double width, double height ) {
		super.setWidth( width );
		super.setHeight( height );
		System.out.println( width + " " + height);
		this.getGraphicsContext2D().setFill( Color.GRAY );
		this.getGraphicsContext2D( ).fillRect( 0, 0, width, height );
	}
}
