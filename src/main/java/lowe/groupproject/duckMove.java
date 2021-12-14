/*

 */
package lowe.groupproject;

import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class duckMove {

    private int x;
    private int y;
    private Pane pnlMove;
    Timeline duckmove = new Timeline(new KeyFrame(Duration.millis(50), ae -> moveDuck()));

    public duckMove(Pane movePane, boolean side) {
        int DuckX = ThreadLocalRandom.current().nextInt(1, 20 + 1);
        int DuckY = ThreadLocalRandom.current().nextInt(1, 8 + 1);
        x = DuckX;
        y = DuckY;
        if (side == true) {
            x = -x;
        }
        pnlMove = movePane;
    }

    private void moveDuck() {
        pnlMove.setTranslateX(pnlMove.getTranslateX() + x);
        pnlMove.setTranslateY(pnlMove.getTranslateY() + y);
    }

    public void start() {
        duckmove.setCycleCount(Timeline.INDEFINITE);
        duckmove.play();
    }
}
