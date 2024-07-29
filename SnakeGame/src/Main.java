import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.concurrent.TimeUnit;
import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;

public class Main extends Application {
	Scene mainScene;
	double t;
	Pane root = new Pane();
	Point2D pos = new Point2D(10, 0);
	AnimationTimer timer;
	Rectangle apple;
	Board b = new Board();
	
	@Override
	public void start (Stage primaryStage) {
		b.setBoard();
		this.mainScene = b.scene;
		this.root = b.pane;
		this.apple = b.apple;
		this.mainScene.setOnKeyPressed(e -> {
        	switch(e.getCode()) {
        	case W:
        		this.pos = new Point2D(0,-10);
        		break;
        	case S:
        		this.pos = new Point2D(0,10);
        		break;
        	case D:
        		this.pos = new Point2D(10,0);
        		break;
        	case A:
        		this.pos = new Point2D(-10,0);
        		break;
        	}
        });
		
		timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                t += 0.016;

                if (t > 0.1) {
                    onUpdate();
                    t = 0;
                }
            }
        };

        timer.start();
		primaryStage.setTitle("Snake Game");
		primaryStage.setScene(this.mainScene);
		primaryStage.show();
	}
	
	public void onUpdate() {
		boolean play = b.snake.moveSnake(this.pos, this.apple);
		if (play) {
			this.root = b.gameOver();
			timer.stop();
		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}