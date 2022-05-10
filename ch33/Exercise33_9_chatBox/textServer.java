import java.io.*;
import java.net.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class textServer extends Application {
	TextArea taServerField;
	private int clientID = 0;
	private int port = 8000;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		taServerField = new TextArea();
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
		
		new Thread(() -> {
			try {
				ServerSocket serverSocket = new ServerSocket(port);
				taServerField.appendText("MultiThreadServer started at "+ System.nanoTime());
				while (true) {
					Socket socket = serverSocket.accept();
					clientID++;
					Platform.runLater( () -> {
						taServerField.appendText("Starting thread for client " + clientID);
						InetAddress inetAddress = socket.getInetAddress();
						taServerField.appendText("Client " + clientID + "'s host name is "+ inetAddress.getHostName() + "\n");
						taServerField.appendText("Client " + clientID + "'s IP Address is"+ inetAddress.getHostAddress() + "\n");
					});
					new Thread(new ThreadClass(socket)).start();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	class ThreadClass implements Runnable {
		private Socket socket;
		ThreadClass(Socket socket) {
			this.socket = socket;
		}
		
		//Override
		public void run() {
            try {
            	DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
            	DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

            	while (true) {
            		String txt = inputFromClient.readUTF();
    		    	
    		    	Platform.runLater(() -> {
    		    		taServerField.appendText(txt);
    		    	});
            	}
            }
            catch(IOException ex) {
            	ex.printStackTrace();
            }
		}
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
