import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.Group;
import javafx.scene.text.*;
import javafx.scene.paint.Color;

public class Board {
	Scene scene;
	Group snakerect;
	Snake snake = new Snake();
	Pane pane = new Pane();
	static Rectangle apple;
	public void setBoard() {
		this.snakerect = this.snake.createSnake(3);
		this.apple = new Apple().createApple(100, 150);
		this.pane.getChildren().add(this.snakerect);
		this.pane.getChildren().add(this.apple);
		this.scene = new Scene(this.pane, 400, 400);
//		}
	}
	
	public Pane gameOver() {
		Text t = new Text();
		t.setText("GAME OVER");
		t.setFont(new Font(30));
		t.setSelectionFill(Color.RED);
		
		HBox hBox = new HBox();
        hBox.setTranslateX(150);
        hBox.setTranslateY(150);
        hBox.getChildren().add(t);
		this.pane.getChildren().clear();
		this.pane.getChildren().add(hBox);
		return pane;
	}
}