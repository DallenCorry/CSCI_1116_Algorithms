
// Exercise31_01Client.java: The client sends the input to the server and receives
// result back from the server
import java.io.*;
import java.net.Socket;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise33_01Client extends Application {
	// Text field for receiving radius
	private TextField tfAnnualInterestRate = new TextField();
	private TextField tfNumOfYears = new TextField();
	private TextField tfLoanAmount = new TextField();
	private Button btSubmit = new Button("Submit");

	// Text area to display contents
	private TextArea ta = new TextArea();
	Socket socket;
	DataInputStream in = null;
	DataOutputStream out = null;

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
	
		ta.setWrapText(true);

		GridPane gridPane = new GridPane();
		gridPane.add(new Label("Annual Interest Rate"), 0, 0);
		gridPane.add(new Label("Number Of Years"), 0, 1);
		gridPane.add(new Label("Loan Amount"), 0, 2);
		gridPane.add(tfAnnualInterestRate, 1, 0);
		gridPane.add(tfNumOfYears, 1, 1);
		gridPane.add(tfLoanAmount, 1, 2);
		gridPane.add(btSubmit, 2, 1);

		tfAnnualInterestRate.setAlignment(Pos.BASELINE_RIGHT);
		tfNumOfYears.setAlignment(Pos.BASELINE_RIGHT);
		tfLoanAmount.setAlignment(Pos.BASELINE_RIGHT);

		tfLoanAmount.setPrefColumnCount(5);
		tfNumOfYears.setPrefColumnCount(5);
		tfLoanAmount.setPrefColumnCount(5);

		BorderPane pane = new BorderPane();
		pane.setCenter(new ScrollPane(ta));
		pane.setTop(gridPane);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 400, 250);
		primaryStage.setTitle("Exercise31_01Client"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
		btSubmit.setOnAction(e -> {
			try {
				double rate = Double.parseDouble(tfAnnualInterestRate.getText());
				int years =Integer.parseInt(tfNumOfYears.getText());
				double amount = Double.parseDouble(tfLoanAmount.getText());
				
				out.writeDouble(rate);
				out.writeInt(years);
				out.writeDouble(amount);
				out.flush();
				
				double monthlyPayment = in.readDouble();
				double totalPayment = in.readDouble();
				
				ta.appendText("\nAnnual Interest Rate: " + rate+
						"\nNumber of rears: "+ years +
						"\nLoan Amount:" + amount +
						"\nMonthly Payment: " + monthlyPayment+
						"\nTotal Payment: " + totalPayment
					);
				
				socket = new Socket("serverSocket", 4000);
				in = new DataInputStream(socket.getInputStream());
		    	out = new DataOutputStream(socket.getOutputStream());
			} catch(IOException ex) {
				ex.getStackTrace();
			}
		});
		
		try {
			socket = new Socket("localhost", 4000);
			in = new DataInputStream(socket.getInputStream());
	    	out = new DataOutputStream(socket.getOutputStream());
		} catch(Exception Ex) {
			System.out.println(Ex.toString()+"\n");
		}
//			new Thread(() -> {
//				try {
////			socket = new Socket("serverSocket", 4000);
////			in = new DataInputStream(socket.getInputStream());
////	    	out = new DataOutputStream(socket.getOutputStream());
////	    	out.writeDouble(20);
////	    	System.out.println(in.readDouble());
//			
//				} catch(Exception e) {
//					
//				}
//			}).start();
	}

		/**
		 * The main method is only needed for the IDE with limited JavaFX support. Not
		 * needed for running from the command line.
		 */
		public static void main(String[] args) {
			launch(args);
		}
	}
