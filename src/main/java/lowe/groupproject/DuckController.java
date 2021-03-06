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
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

/*
Name; Gavin Gunn & Ethan Lowe
Class; Grade 12 Com Studies
Date; 26/01/22
Assignment#; Final
Description; group Project/DuckHunt
 */

public class DuckController implements Initializable {

    @FXML
    private Label lblcount, lblTimer, lblPoints, lblLose,lblContinue,lblCountContinue;

    @FXML
    private ImageView imgBullet1, imgBullet2, imgBullet3, imgBullet4, imgBullet5;

    @FXML
    private Pane Duck1, Duck2, Duck3, Duck4, Duck5, Duck6;

    @FXML
    private Line wallRight, wallDown, wallLeft, wallUp;

    @FXML
    private ImageView imgDuck1, imgDuck2, imgDuck3, imgDuck4, imgDuck5, imgDuck6;

    @FXML
    private Polygon PDuck0, PDuck1, PDuck2, PDuck3, PDuck4, PDuck5;

    Timeline clock = new Timeline(new KeyFrame(Duration.millis(500), ae -> timer()));
    Timeline count = new Timeline(new KeyFrame(Duration.seconds(1), ae -> CountDown()));

    boolean Running = false;
    int points;
    int Bullets = 5;
    int Duck;
    int Duckup;
    boolean Side;
    boolean Up;
    int Time;
    boolean Continue = false;
    boolean cont = false;
    boolean DuckUse1= false;
    boolean DuckUse2= false;
    boolean DuckUse3= false;
    boolean DuckUse4= false;
    boolean DuckUse5= false;
    boolean DuckUse6= false;
    duck ducks[] = new duck[6];

    void timer() {
        pickDuck();
        checkTime();
        int play = Integer.parseInt(lblTimer.getText());
        if (Time % 2 == 0){
            int newtime = play +1;
            lblTimer.setText("" + newtime);
        }
        Time++;
        if (lblLose.getText().equals("YOU LOSE")){
            lblContinue.setVisible(true);
            lblCountContinue.setVisible(true);
            clock.stop();
            count.stop();
        }
        
    }

    void Backbtn(ActionEvent event) throws IOException {
        MainApp.setRoot("StartDuck");
    }

    @FXML
    void btnStart(ActionEvent event) {
        count.setCycleCount(Timeline.INDEFINITE);
        count.play();
    }
    
    void checkTime(){
    int endTime = MainApp.DuckTime;
    int lblTime = Integer.parseInt(lblTimer.getText());
    if (endTime == lblTime){
        clock.stop();
        lblLose.setText("TIME IS UP");
        lblLose.setVisible(true);
        lblContinue.setVisible(true);
        lblCountContinue.setVisible(true);
        Continue = true;
        count.play();
    }
    }
    
    @FXML
    void msnContinue(MouseEvent event) throws IOException {
        MainApp.setRoot("StartDuck");
    }
    
    void CountDown() {
        if (lblcount.getText().equals("") && !Continue) {
            lblcount.setVisible(true);
            lblcount.setText("3");
        } else if (lblcount.getText().equals("3") && !Continue) {
            lblcount.setText("2");
        } else if (lblcount.getText().equals("2") && !Continue) {
            lblcount.setText("1");
        } else if (lblcount.getText().equals("1") && !Continue) {
            lblcount.setText("GO!");
        } else if (lblcount.getText().equals("GO!") && !Continue) {
            lblcount.setText("  ");
            clock.setCycleCount(Timeline.INDEFINITE);
            clock.play();
            Running = true;
            lblcount.setVisible(false);
        }else if (Continue){
          continueCountDown();

        }
    }
    void continueCountDown(){
        if (lblCountContinue.getText().equals("5") && Continue){
            lblCountContinue.setText("4");
        }else if (lblCountContinue.getText().equals("4") && Continue){
            lblCountContinue.setText("3");
        }else if (lblCountContinue.getText().equals("3") && Continue){
            lblCountContinue.setText("2");
        }else if (lblCountContinue.getText().equals("2") && Continue){
            lblCountContinue.setText("1");
        }else if (lblCountContinue.getText().equals("1") && Continue){
            lblCountContinue.setText("0");
        }else if (lblCountContinue.getText().equals("0") && Continue){
            try{
             int newpoints = Integer.parseInt(lblPoints.getText());
             MainApp.money = MainApp.money +newpoints;
             MainApp.setRoot("StartDuck");   
            count.stop();
            }
            catch (Exception IOException){
            }
        }
    }
    
    void pickDuck() {
        Duck = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        if (Duck == 1 && Duck1.getTranslateX() == 0 && DuckUse1 == false) {
            ducks[0] = new duck(Duck1, false, wallDown, wallLeft, wallRight, wallUp, imgDuck1, PDuck0,0,lblLose);
            ducks[0].start();
            DuckUse1= true;
        }
        if (Duck == 2 && Duck2.getTranslateX() == 0&& DuckUse1 == false) {
            ducks[1] = new duck(Duck2, false, wallDown, wallLeft, wallRight, wallUp, imgDuck2, PDuck1, 1,lblLose);
            ducks[1].start();
            DuckUse2= true;
        }
        if (Duck == 3 && Duck3.getTranslateX() == 0&& DuckUse1 == false) {
            ducks[2] = new duck(Duck3, false, wallDown, wallLeft, wallRight, wallUp, imgDuck3, PDuck2, 2,lblLose);
            ducks[2].start();
            DuckUse3= true;
        }
        if (Duck == 4 && Duck4.getTranslateX() == 0&& DuckUse1 == false) {
            ducks[3] = new duck(Duck4, true, wallDown, wallLeft, wallRight, wallUp, imgDuck4, PDuck3, 3,lblLose);
            ducks[3].start();
            DuckUse4= true;
        }
        if (Duck == 5 && Duck5.getTranslateX() == 0&& DuckUse1 == false) {
            ducks[4] = new duck(Duck5, true, wallDown, wallLeft, wallRight, wallUp, imgDuck5, PDuck4, 4,lblLose);
            ducks[4].start();
            DuckUse5= true;
        }
        if (Duck == 6 && Duck6.getTranslateX() == 0&& DuckUse1 == false) {
            ducks[5] = new duck(Duck6, true, wallDown, wallLeft, wallRight, wallUp, imgDuck6, PDuck5, 5,lblLose);
            ducks[5].start();
            DuckUse6= true;
        }
    }

    @FXML
    void OnClick(MouseEvent event) {
        Shape poly = (Shape) event.getSource();
        if (poly.getAccessibleText().equals("B")) {
            Reload();
            ShowBull();
            return;
        }
            if (Running == true) {
        int spot = Integer.parseInt("" + poly.getAccessibleText().charAt(0));
        if (Bullets != 0 && ducks[spot].inUse) {
            if (("" + poly.getAccessibleText().charAt(1)).equals("g")) {
                points = points + 1;
                ShowPoints();
                Bullets--;
                ShowBull();
                ducks[spot].shoot();
                if (spot == 0){
                    DuckUse1 = false;
                }
                if (spot == 1){
                    DuckUse2 = false;
                }
                if (spot == 2){
                    DuckUse3 = false;
                }
                if (spot == 3){
                    DuckUse4 = false;
                }
                if (spot == 4){
                    DuckUse5 = false;
                }
                if (spot == 5){
                    DuckUse6 = false;
                }
            } else if (("" + poly.getAccessibleText().charAt(1)).equals("y")) {
                points = points + 3;
                ShowPoints();
                Bullets--;
                ShowBull();
                ducks[spot].shoot();
                if (spot == 0){
                    DuckUse1 = false;
                }
                if (spot == 1){
                    DuckUse2 = false;
                }
                if (spot == 2){
                    DuckUse3 = false;
                }
                if (spot == 3){
                    DuckUse4 = false;
                }
                if (spot == 4){
                    DuckUse5 = false;
                }
                if (spot == 5){
                    DuckUse6 = false;
                }
            } else if (("" + poly.getAccessibleText().charAt(1)).equals("r")) {
                points = points + 5;
                ShowPoints();
                Bullets--;
                ShowBull();
                ducks[spot].shoot();
                if (spot == 0){
                    DuckUse1 = false;
                }
                if (spot == 1){
                    DuckUse2 = false;
                }
                if (spot == 2){
                    DuckUse3 = false;
                }
                if (spot == 3){
                    DuckUse4 = false;
                }
                if (spot == 4){
                    DuckUse5 = false;
                }
                if (spot == 5){
                    DuckUse6 = false;
                }
            }
        }
    }
     }
    
    @FXML
    void MousePic(MouseEvent event) {
             if (Running == true) {
                Bullets--;
                ShowBull();
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
    
    void ShowPoints() {
        lblPoints.setText(""+points);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ducks[0] = new duck();
        ducks[1] = new duck();
        ducks[2] = new duck();
        ducks[3] = new duck();
        ducks[4] = new duck();
        ducks[5] = new duck();

    }

}