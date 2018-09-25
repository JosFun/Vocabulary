package trainer;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Screen;
import javafx.scene.layout.*;
import javafx.stage.*;

public class TrainStage extends ProgStage {
	
	public TrainStage ( Stage window, Scene menu, BorderPane layout ) {
		super ( window, menu, layout );
		this.head.setText( "Train your vocabulary" );
		this.left.setColor( Color.ORANGE );
		this.right.setColor( Color.ORANGE );

	}
	
}
