import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Apple {
	public Rectangle createApple(int x, int y) {
		Rectangle apple = new Rectangle(x, y,20,10);
		apple.setFill(Color.RED);
		return apple;
	}
}