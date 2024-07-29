import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;
import java.util.Random;

public class Snake {
	Group snakearr = new Group();
	Point2D nextpos = new Point2D(0, 0);
	Random random = new Random();
	boolean collisionWall = false;
	boolean collisionApple = false;
	public Group createSnake(int length_) {
		for (int i=0; i<length_; i++) {
			Rectangle r1 = new Rectangle(20,10);
			if (i==0) r1.setFill(Color.BLACK);
			else r1.setFill(Color.GREEN);
			this.snakearr.getChildren().add(r1);
		}
		return this.snakearr;
	}
	
    public boolean moveSnake(Point2D pos, Rectangle apple) {
    	this.nextpos = this.nextpos.add(pos);
    	Rectangle r = (Rectangle) this.snakearr.getChildren().remove(0);
    	r.setTranslateX(this.nextpos.getX());
    	r.setTranslateY(this.nextpos.getY());
    	this.snakearr.getChildren().add(r);
    	checkCollision(apple);
    	if (this.collisionApple) {
    		apple.setTranslateX(random.nextInt(100)+5);
    		apple.setTranslateY(random.nextInt(100)+5);
    		Rectangle nextr = new Rectangle(20,10);
    		nextr.setTranslateX(this.nextpos.add(pos).getX());
        	nextr.setTranslateY(this.nextpos.add(pos).getY());
    		nextr.setFill(Color.GREEN);
    		this.snakearr.getChildren().add(nextr);
    		this.collisionApple = false;
    	}
    	if (this.collisionWall) return true;
    	return false;
	}
    
    public void checkCollision(Rectangle apple) {
    	for (int i=0; i<this.snakearr.getChildren().size(); i++) {
    		if (this.collisionApple==true) break;
    		Rectangle curr = (Rectangle) this.snakearr.getChildren().get(i);
    		System.out.println("x:"+curr.getTranslateX()+" y:"+curr.getTranslateY());
    		System.out.println("Ax:"+(curr.getTranslateX()+20)+" Ay:"+(curr.getTranslateY()+10));
    		System.out.println("Applex:"+apple.getX()+" Appley:"+apple.getY());
    		if (curr.getTranslateX() == apple.getX()  && curr.getTranslateY() == apple.getY()) this.collisionApple = true;
    		if (this.snakearr.getChildren().get(i).getTranslateX()<0 || this.snakearr.getChildren().get(i).getTranslateY()<0 ||
    				this.snakearr.getChildren().get(i).getTranslateX()>400 || this.snakearr.getChildren().get(i).getTranslateY()>400) this.collisionWall = true;
    	}
    	
    }
}