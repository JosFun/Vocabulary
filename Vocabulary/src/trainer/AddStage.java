package trainer;

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

public class AddStage extends ProgStage {
	public AddStage ( Stage window, Scene menu, BorderPane layout ) {
		super ( window, menu, layout );
		this.head.setText( "Add new vocabulary" );
		this.left.getGraphicsContext2D( ).setFill( Color.AQUAMARINE );
		this.right.getGraphicsContext2D( ).setFill( Color.AQUAMARINE );
		this.left.getGraphicsContext2D().fillRect(0, 0, this.left.getWidth(), this.left.getHeight ( ));
		this.right.getGraphicsContext2D().fillRect(0, 0, this.right.getWidth(), this.right.getHeight ( ));
	}
	
}
