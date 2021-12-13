/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private Pane Duck1,Duck2,Duck3,Duck4,Duck5,Duck6;

    Timeline clock = new Timeline(new KeyFrame(Duration.seconds(1), ae -> timer()));
    Timeline count = new Timeline(new KeyFrame(Duration.seconds(1), ae -> CountDown()));
    boolean Running = false;
    int points;
    int Bullets = 5;
    int Duck;
    int DuckX;
    int DuckY;
    boolean Side;

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
    
    void pickDuck(){
    Duck = ThreadLocalRandom.current().nextInt(1, 6 + 1);
    if (Duck == 1 || Duck == 2 || Duck == 3){
        Side = true;
    }if (Duck == 4 || Duck == 5 || Duck == 6){
        Side = false;
    }
    DuckX = ThreadLocalRandom.current().nextInt(1, 20 + 1);
    DuckY = ThreadLocalRandom.current().nextInt(1, 8 + 1);
        placeDuck(Duck, DuckX, DuckY,Side);
    }
    void placeDuck(int duck,int x,int y,boolean side){
        
        
        if (side==false){
            x = -x;
        }if (duck == 1){
            Duck1.setTranslateX(Duck1.getTranslateX() + x);
            Duck1.setTranslateY(Duck1.getTranslateY() + y);
        }if (duck == 2){
            Duck2.setTranslateX(Duck2.getTranslateX() + x);
            Duck2.setTranslateY(Duck2.getTranslateY() + y);
        }if (duck == 3){
            Duck3.setTranslateX(Duck3.getTranslateX() + x);
            Duck3.setTranslateY(Duck3.getTranslateY() + y);
        }if (duck == 4){
            Duck4.setTranslateX(Duck4.getTranslateX() + x);
            Duck4.setTranslateY(Duck4.getTranslateY() + y);
        }if (duck == 5){
            Duck5.setTranslateX(Duck5.getTranslateX() + x);
            Duck5.setTranslateY(Duck5.getTranslateY() + y);
        }if (duck == 6){
            Duck6.setTranslateX(Duck6.getTranslateX() + x);
            Duck6.setTranslateY(Duck6.getTranslateY() + y);
        }
    }

    @FXML
    void OnClick(MouseEvent event) {
        ImageView img = (ImageView) event.getSource();
        if (img.getAccessibleText().equals("1") || img.getAccessibleText().equals("2") || img.getAccessibleText().equals("3") || img.getAccessibleText().equals("4") || img.getAccessibleText().equals("5")) {
            Reload();
            ShowBull();
        }
        if (Running == true) {
            if (img.getAccessibleText().equals("red")) {
                points = points + 5;
                Bullets--;
                ShowBull();
            }
            if (img.getAccessibleText().equals("yellow")) {
                points = points + 3;
                Bullets--;
                ShowBull();
            }
            if (img.getAccessibleText().equals("green")) {
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
