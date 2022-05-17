
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
//import javafx.scene.control.TabPane;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.geometry.*;

public class TabPaneDemo extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {

		RadioButton top = new RadioButton("Top");
		RadioButton left = new RadioButton("Left");
		RadioButton bottom = new RadioButton("Bottom");
		RadioButton right = new RadioButton("Right");

		ToggleGroup toggleButtons = new ToggleGroup();
		
		HBox buttons = new HBox();
		BorderPane bp = new BorderPane();	
		TabPane tabPane = new TabPane();
		
		Tab tab1 = new Tab("Line");
		Tab tab2 = new Tab("Rectangle");
		Tab tab3 = new Tab("Circle");
		Tab tab4 = new Tab("Ellipse");
		
		StackPane pane1 = new StackPane();
		pane1.getChildren().add(new Line(10, 10, 80, 80));
		tab1.setContent(pane1);
		tab2.setContent(new Rectangle(10, 10, 200, 200));
		tab3.setContent(new Circle(50, 50, 20));
		tab4.setContent(new Ellipse(10, 10, 100, 80));
		
		tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);
		

		top.setToggleGroup(toggleButtons);
		left.setToggleGroup(toggleButtons);
		bottom.setToggleGroup(toggleButtons);
		right.setToggleGroup(toggleButtons);
		
		top.setSelected(true);
		buttons.getChildren().addAll(top, left, bottom, right);
		buttons.setAlignment(Pos.CENTER);
		buttons.setPadding(new Insets(5,5,5,5));
		
		top.setOnAction(e -> tabPane.setSide(Side.TOP));
		left.setOnAction(e -> tabPane.setSide(Side.LEFT));
		bottom.setOnAction(e -> tabPane.setSide(Side.BOTTOM));
		right.setOnAction(e -> tabPane.setSide(Side.RIGHT));
		
		BorderPane.setAlignment(buttons, Pos.CENTER);

		bp.setCenter(tabPane);
		bp.setBottom(buttons);
		Scene scene = new Scene(bp, 300, 250);
		primaryStage.setTitle("DisplayFigure"); // Set the window title
		primaryStage.setScene(scene); // Place the scene in the window
		primaryStage.show(); // Display the window
	}

	/**
	 * The main method is only needed for the IDE with limited JavaFX support. Not
	 * needed for running from the command line. line.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
