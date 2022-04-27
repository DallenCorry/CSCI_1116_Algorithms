import javafx.scene.image.ImageView;
import javafx.application.Platform;

public class TaskClass implements Runnable{
	ImageView imageView;

	public TaskClass(ImageView imageView) {
		this.imageView = imageView;
	}
	public void run() {
		Platform.runLater(new AnimatingThread(imageView));
	}
}

