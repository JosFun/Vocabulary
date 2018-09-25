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
		this.left.setColor ( Color.AQUAMARINE );
		this.right.setColor( Color.AQUAMARINE );
	}
	
}
