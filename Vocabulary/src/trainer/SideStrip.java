package trainer;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

/* A resizable canvas element */
public class SideStrip extends Canvas {

	private Color color = Color.AQUA;
	private double monitorWidth = Screen.getPrimary().getBounds().getWidth();
	private double monitorHeight = Screen.getPrimary().getBounds().getHeight();
	private Stage window;
	
	public SideStrip( Stage window ) {
		this.window = window;
	}

	public SideStrip( Stage window, double width, double height) {
		super(width, height);
		this.window = window;
	}
	
	@Override
	public double minHeight ( double width ) {
		return ( this.window.getHeight ( ) * ( 8.35 / 10.0 ) );
	}
	
	@Override
	public double maxHeight ( double width ) {
		return ( this.window.getHeight ( ));
	}
	
	@Override
	public double prefHeight ( double width ) {
		return ( minHeight ( width ) );
	}

	
	@Override
	public double minWidth ( double height ) {
		return ( this.window.getWidth ( ) / 10 );
	}

	@Override
	public double prefWidth ( double height ) {
		return ( this.minWidth(height));
	}
	
	@Override
	public double maxWidth ( double height ) {
		return ( this.window.getWidth ( ) / 6 );
	}
	
	@Override 
	public boolean isResizable ( ) {
		return ( true );
	}
	
	@Override
	public void resize ( double width, double height ) {
		this.getGraphicsContext2D().setFill( Color.WHITE );
		this.getGraphicsContext2D().fillRect(0, 0, super.getWidth(), super.getHeight ( ));
		super.setWidth( width );
		super.setHeight( height );
		this.getGraphicsContext2D().setFill( this.color );
		this.getGraphicsContext2D( ).fillRect( 0, 0, width, height );
	}
	
	public void setColor ( Color c ) {
		this.color = c;
	}

}
