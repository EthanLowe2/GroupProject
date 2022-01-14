/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package lowe.groupproject;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ehenr
 */
public class HorseRaceController implements Initializable {

    @FXML
    private ImageView Horse1, Horse2, Horse3, Horse4, Horse5, imgPersonLeft,imgArrow1,imgArrow2,imgArrow3,imgArrow4,imgArrow5;

    @FXML
    private Button btnSitout,btnBet;

    @FXML
    private Label lblRound, lblWel;

    @FXML
    private Ellipse shpcirText;

    @FXML
    private Polygon shptriText;

    Timeline horsemove = new Timeline(new KeyFrame(Duration.millis(50), ae -> moveHorse()));
    double x1;
    double x2;
    double x3;
    double x4;
    double x5;
    int Rx1;
    int Rx2;
    int Rx3;
    int Rx4;
    int Rx5;

    void moveHorse() {
        Horse1.setTranslateX(Horse1.getTranslateX() + x1);
        Horse2.setTranslateX(Horse2.getTranslateX() + x2);
        Horse3.setTranslateX(Horse3.getTranslateX() + x3);
        Horse4.setTranslateX(Horse4.getTranslateX() + x4);
        Horse5.setTranslateX(Horse5.getTranslateX() + x5);
    }

    @FXML
    void pressSpace(KeyEvent event) {
        if ((event.getCode() == KeyCode.A)) {
            if (Horse1.getAccessibleText().equals("C")) {
                x1 = x1 + 0.25;
            }
            else if (Horse2.getAccessibleText().equals("C")) {
                x2 = x2 + 0.25;
            }
            else if (Horse3.getAccessibleText().equals("C")) {
                x3 = x3 + 0.25;
            }
            else if (Horse4.getAccessibleText().equals("C")) {
                x4 = x4 + 0.25;
            }
            else if (Horse5.getAccessibleText().equals("C")) {
                x5 = x5 + 0.25;
            }

        }
    }

    @FXML
    void btnBetA(ActionEvent event) {
        btnBet.setVisible(false);
        btnSitout.setVisible(false);
        shpcirText.setVisible(false);
        shptriText.setVisible(false);
        imgPersonLeft.setVisible(false);
        lblRound.setVisible(false);
        lblWel.setVisible(false);
        imgArrow1.setVisible(true);
        imgArrow2.setVisible(true);
        imgArrow3.setVisible(true);
        imgArrow4.setVisible(true);
        imgArrow5.setVisible(true);
    }
    

    @FXML
    void btnHorse(MouseEvent event) {
        ImageView img = (ImageView) event.getSource();
        img.setAccessibleText("C");
        x1 = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        x2 = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        x3 = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        x4 = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        x5 = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        horsemove.setCycleCount(Timeline.INDEFINITE);
        horsemove.play();
    }

    @FXML
    void btnSitOutA(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
