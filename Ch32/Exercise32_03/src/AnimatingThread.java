import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class AnimatingThread implements Runnable{
	ImageView imageView;
	AnimatingThread(ImageView imageView) {
		this.imageView = imageView;
	}
	@Override
	public void run() {
		// Create a path transition
		PathTransition pt = new PathTransition(
									Duration.millis(1000),
									new Line(100, 200, 100, 0),
									imageView); 
		pt.setCycleCount(5); // Repeat the animation 5 times
		pt.play(); // Start animation
				
	}
}
