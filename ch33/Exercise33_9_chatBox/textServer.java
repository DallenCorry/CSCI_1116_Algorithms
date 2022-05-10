import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class textServer extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		TextArea taServerField = new TextArea();
		Button btReset = new Button("Reset Server");
		VBox pane = new VBox(taServerField, btReset);

		taServerField.setEditable(false);
		taServerField.setStyle("-fx-text-fill: Blue;");
		taServerField.appendText("test out multiple clients and one server");
		pane.setAlignment(Pos.CENTER);
		
		btReset.setOnAction(e -> {
			taServerField.setStyle("-fx-text-fill: Red;");
			taServerField.clear();
		});

		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
