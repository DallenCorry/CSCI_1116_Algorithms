package ballBounce;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.collections.*;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import java.util.*;


public class Exercise20_09 extends Application {
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    MultipleBallPane ballPane = new MultipleBallPane();
    ballPane.setStyle("-fx-border-color: yellow");

    Button btAdd = new Button("+");
    Button btSubtract = new Button("-");
    HBox hBox = new HBox(10);
    hBox.getChildren().addAll(btAdd, btSubtract);
    hBox.setAlignment(Pos.CENTER);

    // Add or remove a ball
    btAdd.setOnAction(e -> ballPane.add());
    btSubtract.setOnAction(e -> ballPane.subtract());

    // Pause and resume animation
    ballPane.setOnMousePressed(e -> ballPane.pause());
    ballPane.setOnMouseReleased(e -> ballPane.play());

    // Use a scroll bar to control animation speed
    ScrollBar sbSpeed = new ScrollBar();
    sbSpeed.setMax(20);
    sbSpeed.setValue(10);
    ballPane.rateProperty().bind(sbSpeed.valueProperty());
    
    BorderPane pane = new BorderPane();
    pane.setCenter(ballPane);
    pane.setTop(sbSpeed);
    pane.setBottom(hBox);

    // Create a scene and place the pane in the stage
    Scene scene = new Scene(pane, 250, 150);
    primaryStage.setTitle("MultipleBounceBall"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  private class MultipleBallPane extends Pane {
    private Timeline animation;

    public MultipleBallPane() {
      // Create an animation for moving the ball
      animation = new Timeline(
        new KeyFrame(Duration.millis(50), e -> moveBall()));
      animation.setCycleCount(Timeline.INDEFINITE);
      animation.play(); // Start animation
    }

    public void add() {
      Color color = new Color(Math.random(), 
        Math.random(), Math.random(), 0.5);
      double radius = Math.random()*20;
      getChildren().add(new Ball(30, 30, radius, color)); 
    }
    
    public void subtract() {
      if (getChildren().size() > 0) { 
    	  double biggestSize = 0;
    	  int biggestIndex = 0;
    	  for (int i=0; i<getChildren().size(); i++) {
    		  double ballRadius = ((Ball)(getChildren().get(i))).getRadius();
    		  if (ballRadius > biggestSize) {
    			  biggestSize = ballRadius;
    			  biggestIndex = i;
    		  }
    	  }
        getChildren().remove(biggestIndex);//getChildren().size() - 1); 
      }
    }

	public void play() {
      animation.play();
    }

    public void pause() {
      animation.pause();
    }

    public void increaseSpeed() {
      animation.setRate(animation.getRate() + 0.1);
    }

    public void decreaseSpeed() {
      animation.setRate(
        animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
    }

    public DoubleProperty rateProperty() {
      return animation.rateProperty();
    }

    protected void moveBall() {
      for (Node node: this.getChildren()) {
        Ball ball = (Ball)node;
        // Check boundaries
        if (ball.getCenterX() < ball.getRadius() || 
            ball.getCenterX() > getWidth() - ball.getRadius()) {
          ball.dx *= -1; // Change ball move direction
        }
        if (ball.getCenterY() < ball.getRadius() || 
            ball.getCenterY() > getHeight() - ball.getRadius()) {
          ball.dy *= -1; // Change ball move direction
        }

        // Adjust ball position
        ball.setCenterX(ball.dx + ball.getCenterX());
        ball.setCenterY(ball.dy + ball.getCenterY());
      }
    }
  }

  class Ball extends Circle {
	  public double rad;
    private double dx = 1, dy = 1;
    /**
    * @param x Initial x Position of the ball
    * @param y Initial y Position of the ball
    * @param radius Initial radius of the ball
    * @param color the color of the ball
    */
    Ball(double x, double y, double radius, Color color) {
      super(x, y, radius);
      setFill(color); // Set ball color
      rad = radius;
    }
  }
  
  class myComparator implements Comparator<Ball>{
    @Override
    public int compare(Ball o1, Ball o2) {
      System.out.println(o1);
      if(o1.getRadius()>o2.getRadius()) {
    	return 1;  
      } else if(o1.getRadius()==o2.getRadius()) {
    	  return 0;
      } else {
          return -1;
      }
    }
  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
