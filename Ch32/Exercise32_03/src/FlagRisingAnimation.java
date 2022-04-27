import javafx.application.Application; 
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class FlagRisingAnimation extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();
	
		// Add an image view and add it to pane
		ImageView imageView = new ImageView("us.gif");
		pane.getChildren().add(imageView);

		new Thread(new TaskClass(imageView)).run();
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 250, 200); 
		primaryStage.setTitle("FlagRisingAnimation"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}

