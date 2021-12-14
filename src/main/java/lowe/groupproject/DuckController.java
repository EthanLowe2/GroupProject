
package lowe.groupproject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

/**
 * Ethan Lowe 12/13/2021 Duck Hunt
 */
public class DuckController implements Initializable {

    @FXML
    private Label lblcount, lblTimer, lblPoints;

    @FXML
    private ImageView imgBullet1, imgBullet2, imgBullet3, imgBullet4, imgBullet5;

    @FXML
    private Pane Duck1, Duck2, Duck3, Duck4, Duck5, Duck6;
    
    @FXML
    private Line wallRight,wallDown,wallLeft,wallUp;
    
    Timeline clock = new Timeline(new KeyFrame(Duration.seconds(1), ae -> timer()));
    Timeline count = new Timeline(new KeyFrame(Duration.seconds(1), ae -> CountDown()));
    Timeline duckmove = new Timeline(new KeyFrame(Duration.seconds(1), ae -> pickDuck()));

    boolean Running = false;
    int points;
    int Bullets = 5;
    int Duck;
    int Duckup;
    boolean Side;
    boolean Up;
    duckMove ducks[]=new duckMove[6];
   
    void timer() {
        int play = Integer.parseInt(lblTimer.getText()) + 1;
        lblTimer.setText("" + play);
    }

    void Backbtn(ActionEvent event) throws IOException {
        MainApp.setRoot("primary");
    }

    @FXML
    void btnStart(ActionEvent event) {
        count.setCycleCount(Timeline.INDEFINITE);
        count.play();
    }
    
    void CountDown() {
        if (lblcount.getText().equals("")) {
            lblcount.setText("3");
        } else if (lblcount.getText().equals("3")) {
            lblcount.setText("2");
        } else if (lblcount.getText().equals("2")) {
            lblcount.setText("1");
        } else if (lblcount.getText().equals("1")) {
            lblcount.setText("GO!");
        } else {
            lblcount.setText("  ");
            clock.setCycleCount(Timeline.INDEFINITE);
            clock.play();
            Running = true;
        }

    }
 

    @FXML
    void btnDuck(ActionEvent event) {
       pickDuck();
    }
    
    void pickDuck() {
        Duck = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        if (Duck == 1 && Duck1.getTranslateX() == 0) {
            ducks[0]= new duckMove(Duck1, false,wallDown,wallLeft,wallRight,wallUp);
            ducks[0].start();
        }if (Duck == 2 && Duck2.getTranslateX() == 0) {
            ducks[1]= new duckMove(Duck2, false,wallDown,wallLeft,wallRight,wallUp);
            ducks[1].start();
        } if (Duck == 3 && Duck3.getTranslateX() == 0) {
            ducks[2]= new duckMove(Duck3, false,wallDown,wallLeft,wallRight,wallUp);
            ducks[2].start();
        }if (Duck == 4 && Duck4.getTranslateX() == 0) {
            ducks[3]= new duckMove(Duck4, true,wallDown,wallLeft,wallRight,wallUp);
            ducks[3].start();
        }if (Duck == 5 && Duck5.getTranslateX() == 0) {
            ducks[4]= new duckMove(Duck5, true,wallDown,wallLeft,wallRight,wallUp);
            ducks[4].start();
        }if (Duck == 6 && Duck6.getTranslateX() == 0) {
            ducks[5]= new duckMove(Duck6, true,wallDown,wallLeft,wallRight,wallUp);
            ducks[5].start();
        }
    }

    @FXML
    void OnClick(MouseEvent event) {
        Shape poly = (Shape) event.getSource();
        if (poly.getAccessibleText().equals("1")) {
            Reload();
            ShowBull();
        }
        if (Running == true) {
            if (poly.getAccessibleText().equals("green")) {
                points = points + 5;
                Bullets--;
                ShowBull();
            } else if (poly.getAccessibleText().equals("yellow")) {
                points = points + 3;
                Bullets--;
                ShowBull();
            } else if (poly.getAccessibleText().equals("green")) {
                points = points + 1;
                Bullets--;
                ShowBull();
            }
        }
    }

    void Points(int value) {
        int oldpoints;
        oldpoints = Integer.parseInt(lblPoints.getText());
        oldpoints = oldpoints + value;
        lblPoints.setText("" + oldpoints);
    }

    @FXML
    void btnReload(ActionEvent event) {
        Reload();
    }

    void Reload() {
        Bullets = 5;
        imgBullet1.setVisible(true);
        imgBullet2.setVisible(true);
        imgBullet3.setVisible(true);
        imgBullet4.setVisible(true);
        imgBullet5.setVisible(true);
    }

    void ShowBull() {
        if (Bullets == 5) {
            imgBullet1.setVisible(true);
            imgBullet2.setVisible(true);
            imgBullet3.setVisible(true);
            imgBullet4.setVisible(true);
            imgBullet5.setVisible(true);
        }
        if (Bullets == 4) {
            imgBullet1.setVisible(false);
        }
        if (Bullets == 3) {
            imgBullet1.setVisible(false);
            imgBullet2.setVisible(false);
        }
        if (Bullets == 2) {
            imgBullet1.setVisible(false);
            imgBullet2.setVisible(false);
            imgBullet3.setVisible(false);
        }
        if (Bullets == 1) {
            imgBullet1.setVisible(false);
            imgBullet2.setVisible(false);
            imgBullet3.setVisible(false);
            imgBullet4.setVisible(false);
        }
        if (Bullets == 0) {
            imgBullet1.setVisible(false);
            imgBullet2.setVisible(false);
            imgBullet3.setVisible(false);
            imgBullet4.setVisible(false);
            imgBullet5.setVisible(false);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }

}
