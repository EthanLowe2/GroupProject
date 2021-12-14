/*

 */
package lowe.groupproject;

import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class duckMove {

    private int x;
    private int y;
    private Pane pnlMove;
    private Line wall1; 
    private Line wall2; 
    private Line wall3; 
    private Line wall4;
    Timeline duckmove = new Timeline(new KeyFrame(Duration.millis(50), ae -> moveDuck()));

    public duckMove(Pane movePane, boolean side, Line Twall1, Line Twall2, Line Twall3, Line Twall4) {
        int DuckX = ThreadLocalRandom.current().nextInt(1, 20 + 1);
        int DuckY = ThreadLocalRandom.current().nextInt(1, 8 + 1);
        x = DuckX;
        y = DuckY;
        wall1 = Twall1;
        wall2 = Twall2;
        wall3 = Twall3;
        wall4 = Twall4;
        if (side == true) {
            x = -x;
        }
        pnlMove = movePane;
    }

    private void moveDuck() {
        pnlMove.setTranslateX(pnlMove.getTranslateX() + x);
        pnlMove.setTranslateY(pnlMove.getTranslateY() + y);
        if (collision(pnlMove, wall1)){
        pnlMove.setTranslateX(0);
        pnlMove.setTranslateY(0);
        x = 0;
        y = 0;
        }
        if (collision(pnlMove, wall2)){
        pnlMove.setTranslateX(0);
        pnlMove.setTranslateY(0);
        x = 0;
        y = 0;
        }
        if (collision(pnlMove, wall3)){
        pnlMove.setTranslateX(0);
        pnlMove.setTranslateY(0);
        x = 0;
        y = 0;
        }
        if (collision(pnlMove, wall4)){
        pnlMove.setTranslateX(0);
        pnlMove.setTranslateY(0);
        x = 0;
        y = 0;
        }
    }
    public boolean collision(Pane block1, Line block2) {
        return (block1.getBoundsInParent().intersects(block2.getBoundsInParent()));
    }

    public void start() {
        duckmove.setCycleCount(Timeline.INDEFINITE);
        duckmove.play();
    }
}
