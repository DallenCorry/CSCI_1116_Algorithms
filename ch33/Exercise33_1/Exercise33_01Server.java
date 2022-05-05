// Exercise31_01Server.java: The server can communicate with
// multiple clients concurrently using the multiple threads
import java.io.*;
import java.net.*;
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Exercise33_01Server extends Application {
  // Text area for displaying contents
  private TextArea ta = new TextArea();
  ServerSocket serverSocket;
  Socket socket;
  DataInputStream in;
  DataOutputStream out;

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
   	ta.setWrapText(true);

	
    // Create a scene and place it in the stage
    Scene scene = new Scene(new ScrollPane(ta), 400, 200);
    primaryStage.setTitle("Exercise31_01Server"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
	
    new Thread(() -> {
		try {
			serverSocket = new ServerSocket(4000);
			Platform.runLater(() ->
				ta.appendText("Server started\n"));
			socket = serverSocket.accept();
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			while(true) {
				double rate = in.readDouble();
				int years = in.readInt();
				double amount = in.readDouble();
				
				Loan loan = new Loan(rate, years, amount);
				
				double monthly = loan.getMonthlyPayment();
				double total = loan.getTotalPayment();
				out.writeDouble(monthly);
				out.writeDouble(total);
				
				Platform.runLater(() ->
						ta.appendText("Annual Interest Rate from client: " + rate+
										"\nNumber of rears: "+ years +
										"\nLoan Amount:" + amount +
										"\nMonthly Payment: " + monthly+
										"\nTotal Payment: " + total)
						);
			}
	
		} catch(Exception e) {
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
