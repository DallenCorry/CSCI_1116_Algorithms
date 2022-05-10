import java.io.*;
import java.net.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Exercise33_09Server extends Application {
  private TextArea taServer = new TextArea();
  private TextArea taClient = new TextArea();
  private ServerSocket serverSocket;
  private Socket clientSocket;
  private int port = 5000;
 
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    taServer.setWrapText(true);
    taServer.setEditable(false);
    taServer.setStyle("-fx-text-fill: Blue;");
    taClient.setWrapText(true);
    
//    taServer.setDisable(true);

    BorderPane pane1 = new BorderPane();
    pane1.setTop(new Label("History"));
    pane1.setCenter(new ScrollPane(taServer));
    BorderPane pane2 = new BorderPane();
    pane2.setTop(new Label("New Message"));
    pane2.setCenter(new ScrollPane(taClient));
    
    VBox vBox = new VBox(5);
    vBox.getChildren().addAll(pane1, pane2);
    
    taServer.prefWidthProperty().bind(vBox.widthProperty().subtract(20));
    taClient.prefWidthProperty().bind(vBox.widthProperty().subtract(20));
    taServer.prefHeightProperty().bind(vBox.heightProperty().divide(2).subtract(25));
    taClient.prefHeightProperty().bind(vBox.heightProperty().divide(2).subtract(25));

    // Create a scene and place it in the stage
    Scene scene = new Scene(vBox, 270, 270);
    primaryStage.setTitle("Exercise31_09Server"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    //Access data from the client.
    new Thread(() -> {
	    try {
	    	//create the server
			serverSocket = new ServerSocket(port);
			Platform.runLater(() -> taServer.appendText("Server Started"));
			clientSocket = serverSocket.accept();
			
			
			DataInputStream in = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
			System.out.println("created IO");
			
			//send the data
		    taClient.setOnKeyReleased(e -> {
		    	if (e.getCode().equals(KeyCode.ENTER)) {
					try {
						out.writeChars("S: "+taClient.getText());
						out.flush();
						taServer.appendText("S: "+taClient.getText());
						taClient.clear();
		    		} catch(IOException e1) {
		    			e1.printStackTrace();
		    		}
		    	}
		    });
	    	
		   
		    while(true) {
		    	String txt = in.readUTF();
		    	//txt += "\n";
		    	out.writeChars(txt);
		    	
		    	Platform.runLater(() -> {
		    		taServer.appendText(txt);
		    	});
	    	}

		} catch (IOException e) {
			e.printStackTrace();
		}
  	}).start();
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
