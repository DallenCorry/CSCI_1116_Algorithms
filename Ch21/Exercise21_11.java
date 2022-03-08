import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise21_11 extends Application {
  
  private Map<String, Integer>[] mapForBoy = new HashMap[10];
  private Map<String, Integer>[] mapForGirl = new HashMap[10];
    
  private Button btFindRanking = new Button("Find Ranking");
  private ComboBox<Integer> cboYear = new ComboBox<>();
  private ComboBox<String> cboGender = new ComboBox<>();
  private TextField tfName = new TextField();
  private Label lblResult = new Label();
  
  /**
   * Generates a set of hash maps using the files from Pearson.org, and 
   * stores the rankings in a hash map of String and Integer.
   * These maps are stored in an array of size 10 for the 10 years.
   */
  public void generateMaps () {
	  try {
		  for(int i=1; i<=10; i++) {
			  HashMap<String, Integer> boyNames = new HashMap<String, Integer>();
			  HashMap<String, Integer> girlNames = new HashMap<String, Integer>();
			  URL url;
			  if (i==10) {//names for 2010
				  url = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking20"+i+".txt");
			  } else {//names for 2001-2009
				  url = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking200"+i+".txt");
			  }
			  Scanner s = new Scanner(url.openStream());
			  while (s.hasNext()) {
				  String[] str = s.nextLine().split("\t");
				  boyNames.put(str[1].toLowerCase().trim(), Integer.valueOf(str[0].trim()));
				  girlNames.put(str[3].toLowerCase().trim(), Integer.valueOf(str[0].trim()));
			  }
			  mapForBoy[i-1] = boyNames;
			  mapForGirl[i-1] = girlNames;
		  }
		  System.out.println("Maps Generated");
	  } catch(Exception e) {
		  System.out.println(e);
	  }
  }
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    GridPane gridPane = new GridPane();
    gridPane.add(new Label("Select a year:"), 0, 0);
    gridPane.add(new Label("Boy or girl?"), 0, 1);
    gridPane.add(new Label("Enter a name:"), 0, 2);
    gridPane.add(cboYear, 1, 0);
    gridPane.add(cboGender, 1, 1);
    gridPane.add(tfName, 1, 2);
    gridPane.add(btFindRanking, 1, 3);
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setHgap(5);
    gridPane.setVgap(5);
  
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(gridPane);
    borderPane.setBottom(lblResult);
    BorderPane.setAlignment(lblResult, Pos.CENTER);
    lblResult.setPadding(new Insets(5,5,5,5));

    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 370, 200);
    primaryStage.setTitle("Exercise21_11"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    for (int year = 2001; year <= 2010; year++) {
      cboYear.getItems().add(year);
    }
    cboYear.setValue(2001);
        
    cboGender.getItems().addAll("Male", "Female");
    cboGender.setValue("Male");
    
	generateMaps();
    
    btFindRanking.setOnAction(e -> {
    	String name = tfName.getText().toLowerCase();
    	int index = cboYear.getValue()-2001;
    	if (name.equals("")) {
    		lblResult.setText("Enter a Name");
    	}
    	else {
    		//male
    		if (cboGender.getValue().equals("Male")) {
    			//check for null
	    		if (mapForBoy[index].get(name) != null){	
	    			lblResult.setText("Ranking: "+mapForBoy[index].get(name)+" out of "+mapForBoy[index].size());
	    		} else {
	    			lblResult.setText("No such name found");
	    		}
	    	//female	
    		} else {
    			//check for null
    			if (mapForGirl[index].get(name) != null){	
    				lblResult.setText("Ranking: "+mapForGirl[index].get(name)+" out of "+mapForGirl[index].size());
	    		} else {
	    			lblResult.setText("No such name found");
	    		}
    		}
    	}
    });
    
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
