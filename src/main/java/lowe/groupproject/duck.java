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
import javafx.scene.control.Label;

public class duck {

    private int x;
    private int y;
    private Pane pnlMove;
    public Polygon polDock;
    private ImageView imgDuck;
    private Line wall1;
    private Line wall2;
    private Line wall3;
    private Line wall4;
    private int DuckCol;
    private Polygon PolyDuck;
    private boolean side;
    public boolean inUse = false;
    private int duckswitch;
    private int duckswitchs;
    private boolean isShot;
    private Label Loselbl;
    Timeline duckmove = new Timeline(new KeyFrame(Duration.millis(50), ae -> moveDuck()));

    public duck() {

    }

    public duck(Pane movePane, boolean Side, Line Twall1, Line Twall2, Line Twall3, Line Twall4, ImageView TimgDuck, Polygon TempPoly, int DuckNum, Label TLoseLabel ) {
        int DuckX = ThreadLocalRandom.current().nextInt(5, 15 + 1);
        int DuckY = ThreadLocalRandom.current().nextInt(-6, -2 + 1);
        x = DuckX;
        y = DuckY;
        imgDuck = TimgDuck;
        polDock = (Polygon) movePane.getChildren().get(1);
        //   polDock=pol;
        wall1 = Twall1;
        wall2 = Twall2;
        wall3 = Twall3;
        wall4 = Twall4;
        side = Side;
        Loselbl = TLoseLabel;
        PolyDuck = TempPoly;
        inUse = true;
        if (side == true) {
            x = -x;
            imgDuck.setImage(new Image(getClass().getResource("/DuckHuntL.png").toString()));
        } else {
            imgDuck.setImage(new Image(getClass().getResource("/GreenDuck.png").toString()));
        }
        pnlMove = movePane;
        DuckCol = ThreadLocalRandom.current().nextInt(1, 50 + 1);
        if (DuckCol <= 50 && DuckCol > 40) {
            PolyDuck.setAccessibleText(DuckNum + "r");
            if (side == true) {
                imgDuck.setImage(new Image(getClass().getResource("/DuckRL.png").toString()));
            }
            if (side == false) {
                imgDuck.setImage(new Image(getClass().getResource("/DuckR.png").toString()));
            }
        }
        if (DuckCol <= 40 && DuckCol > 25) {
            PolyDuck.setAccessibleText(DuckNum + "y");
            if (side == true) {
                imgDuck.setImage(new Image(getClass().getResource("/DuckPL.png").toString()));
            }
            if (side == false) {
                imgDuck.setImage(new Image(getClass().getResource("/DuckP.png").toString()));
            }
        }
        if (DuckCol <= 25 && DuckCol >= 0) {
            PolyDuck.setAccessibleText(DuckNum + "g");
        }
        pnlMove.setVisible(true);
    }

    private void moveDuck() {
        if (y == 9 && DuckCol <= 50 && DuckCol > 40 && duckswitch % 2 == 0) {
            imgDuck.setImage(new Image(getClass().getResource("/DuckRFall.png").toString()));
        }
        if (y == 9 && DuckCol <= 50 && DuckCol > 40 && duckswitch % 2 == 1) {
            imgDuck.setImage(new Image(getClass().getResource("/DuckRFallO.png").toString()));
        }
        if (y == 9 && DuckCol <= 40 && DuckCol > 25 && duckswitch % 2 == 0) {
            imgDuck.setImage(new Image(getClass().getResource("/DuckPFall.png").toString()));
        }
        if (y == 9 && DuckCol <= 40 && DuckCol > 25 && duckswitch % 2 == 1) {
            imgDuck.setImage(new Image(getClass().getResource("/DuckPFallO.png").toString()));
        }
        if (y == 9 && DuckCol <= 25 && DuckCol >= 0 && duckswitch % 2 == 0) {
            imgDuck.setImage(new Image(getClass().getResource("/DuckFall.png").toString()));
        }
        if (y == 9 && DuckCol <= 25 && DuckCol >= 0 && duckswitch % 2 == 1) {
            imgDuck.setImage(new Image(getClass().getResource("/DuckFallO.png").toString()));
        }
        pnlMove.setTranslateX(pnlMove.getTranslateX() + x);
        pnlMove.setTranslateY(pnlMove.getTranslateY() + y);
        if (collision(pnlMove, wall1)) {
            if (isShot == false){
             Loselbl.setVisible(true);
             Loselbl.setText("YOU LOSE");
            }
            pnlMove.setTranslateX(0);
            pnlMove.setTranslateY(0);
            x = 0;
            y = 0;
            inUse = false;
            duckmove.stop();
            pnlMove.setVisible(false);
        }
        if (collision(pnlMove, wall2)) {
            if (isShot == false){
             Loselbl.setVisible(true);
             Loselbl.setText("YOU LOSE");
            }
            pnlMove.setTranslateX(0);
            pnlMove.setTranslateY(0);
            x = 0;
            y = 0;
            inUse = false;
            duckmove.stop();
            pnlMove.setVisible(false);
        }
        if (collision(pnlMove, wall3)) {
            if (isShot == false){
             Loselbl.setVisible(true);
             Loselbl.setText("YOU LOSE");
            }
            pnlMove.setTranslateX(0);
            pnlMove.setTranslateY(0);
            x = 0;
            y = 0;
            inUse = false;
            duckmove.stop();
            pnlMove.setVisible(false);
        }
        if (collision(pnlMove, wall4)) {
            if (isShot == false){
             Loselbl.setVisible(true);
             Loselbl.setText("YOU LOSE");
            }
            pnlMove.setTranslateX(0);
            pnlMove.setTranslateY(0);
            x = 0;
            y = 0;
            inUse = false;
            duckmove.stop();
            pnlMove.setVisible(false);
        }
        if (duckswitchs % 2 == 0) {
            duckswitch++;
        }
        duckswitchs++;
    }

    public boolean collision(Pane block1, Line block2) {
        return (block1.getBoundsInParent().intersects(block2.getBoundsInParent()));
    }

    public void shoot() {
        inUse = true;
        x = 0;
        y = 0;
        if (DuckCol <= 50 && DuckCol > 40) {
            imgDuck.setImage(new Image(getClass().getResource("/DuckRShot.png").toString()));
        }
        if (DuckCol <= 40 && DuckCol > 25) {
            imgDuck.setImage(new Image(getClass().getResource("/DuckPShot.png").toString()));
        }
        if (DuckCol <= 25 && DuckCol >= 0) {
            imgDuck.setImage(new Image(getClass().getResource("/DuckShot.png").toString()));
        }
        x = 0;
        duckmove.stop();
        duckmove.setDelay(Duration.seconds(1));
        y = 9;
        isShot = true;
        duckmove.play();
        x = 0;  
    }

    public void start() {
        duckmove.setCycleCount(Timeline.INDEFINITE);
        duckmove.play();
    }
}
