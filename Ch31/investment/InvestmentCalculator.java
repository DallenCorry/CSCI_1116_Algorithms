package investment;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;

public class InvestmentCalculator extends Application{
	TextField txtAmount = new TextField();
	TextField txtYears = new TextField();
	TextField txtRate = new TextField();
	TextField txtValue = new TextField();
	@Override
	public void start(Stage primaryStage) {
		GridPane grid = new GridPane();
		BorderPane bp = new BorderPane();
		MenuBar menuBar = new MenuBar();
		
		Menu menuOperation = new Menu("Operation");
		MenuItem calculate = new MenuItem("Calculate");
		MenuItem exit = new MenuItem("Exit");
		
		Label amount = new Label("Investment Amount:");
		Label years = new Label("Number of Years");
		Label rate = new Label("Annual Interest Rate:");
		Label value = new Label("Future Value:");
		
		Button btnCalculate = new Button("Calculate");
		
		txtValue.setEditable(false);
		
		grid.setVgap(5);
		grid.setHgap(10);
		grid.setPadding(new Insets(0,0,5,0));
		bp.setPadding(new Insets(5,5,5,5));
		btnCalculate.setPadding(new Insets(5,5,5,5));
		bp.setAlignment(btnCalculate, Pos.CENTER_RIGHT);
		
		menuOperation.getItems().addAll(calculate, exit);
		menuBar.getMenus().addAll(menuOperation);
		grid.addColumn(0, amount, years, rate, value);
		grid.addColumn(1, txtAmount, txtYears, txtRate, txtValue);
		bp.setTop(menuBar);
		bp.setCenter(grid);
		bp.setBottom(btnCalculate);
		
		calculate.setOnAction(e -> calculateInterest());
		calculate.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
		
		btnCalculate.setOnAction(e -> calculateInterest());
		
		exit.setOnAction(e -> System.exit(0));
		
		
		Scene scene = new Scene(bp);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Investment Value Calculator");
		primaryStage.show();
	}
	
	public void calculateInterest() {
		try {
			double investmentAmount = Double.parseDouble(txtAmount.getText());
			double monthlyInterestRate = Double.parseDouble(txtRate.getText())/12/100;
			int numberOfYears = Integer.parseInt(txtYears.getText());
			double futureValue = investmentAmount * Math.pow((1 + monthlyInterestRate),(numberOfYears*12));
			futureValue = (Math.round(futureValue*100));
			futureValue = futureValue/100;
			txtValue.setText("$" + futureValue);
		} catch(Exception E) {
			System.out.println( E.getMessage());
			txtValue.setText("Enter valid numbers");
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
