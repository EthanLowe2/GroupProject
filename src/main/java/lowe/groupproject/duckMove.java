/*

 */
package lowe.groupproject;

import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class duckMove {

    private int x;
    private int y;
    private Pane pnlMove;
    public Polygon polDock;
    private ImageView imgDuck;
    private Line wall1;
    private Line wall2;
    private Line wall3;
    private Line wall4;
    public boolean inUse = false;
    Timeline duckmove = new Timeline(new KeyFrame(Duration.millis(50), ae -> moveDuck()));

    public duckMove() {

    }

    public duckMove(Pane movePane, boolean side, Line Twall1, Line Twall2, Line Twall3, Line Twall4, ImageView TimgDuck) {
        int DuckX = ThreadLocalRandom.current().nextInt(1, 12 + 1);
        int DuckY = ThreadLocalRandom.current().nextInt(-8, -2 + 1);
        x = DuckX;
        y = DuckY;
        imgDuck = TimgDuck;
        polDock = (Polygon) movePane.getChildren().get(1);
        //   polDock=pol;
        wall1 = Twall1;
        wall2 = Twall2;
        wall3 = Twall3;
        wall4 = Twall4;
        inUse = true;
        if (side == true) {
            x = -x;
            imgDuck.setImage(new Image(getClass().getResource("/DuckHuntL.png").toString()));
        }else{
            imgDuck.setImage(new Image(getClass().getResource("/GreenDuck.png").toString()));
        }
        pnlMove = movePane;
          
    }

    private void moveDuck() {
        if (y==3){
            imgDuck.setImage(new Image(getClass().getResource("/DuckFall.png").toString()));
        }
        pnlMove.setTranslateX(pnlMove.getTranslateX() + x);
        pnlMove.setTranslateY(pnlMove.getTranslateY() + y);
        if (collision(pnlMove, wall1)) {
            pnlMove.setTranslateX(0);
            pnlMove.setTranslateY(0);
            x = 0;
            y = 0;
            inUse = false;
        }
        if (collision(pnlMove, wall2)) {
            pnlMove.setTranslateX(0);
            pnlMove.setTranslateY(0);
            x = 0;
            y = 0;
            inUse = false;
        }
        if (collision(pnlMove, wall3)) {
            pnlMove.setTranslateX(0);
            pnlMove.setTranslateY(0);
            x = 0;
            y = 0;
            inUse = false;
        }
        if (collision(pnlMove, wall4)) {
            pnlMove.setTranslateX(0);
            pnlMove.setTranslateY(0);
            x = 0;
            y = 0;
            inUse = false;
        }
    }

    public boolean collision(Pane block1, Line block2) {
        return (block1.getBoundsInParent().intersects(block2.getBoundsInParent()));
    }

    public void shoot() {
        inUse = false;
        x = 0;
        y = 0;
        imgDuck.setImage(new Image(getClass().getResource("/DuckShot.png").toString()));
        duckmove.stop();
        duckmove.setDelay(Duration.seconds(1));
        y=3;
        duckmove.play();
    }

    public void start() {
        duckmove.setCycleCount(Timeline.INDEFINITE);
        duckmove.play();
    }
}
