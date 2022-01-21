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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ehenr
 */
public class HorseRaceController implements Initializable {

    @FXML
    private ImageView Horse1, Horse2, Horse3, Horse4, Horse5, imgPersonLeft,imgArrow1,imgArrow2,imgArrow3,imgArrow4,imgArrow5,imgPersonRight,imgCrowd,imgiPad,imgHorseiPad1,imgHorseiPad2,imgHorseiPad3,imgHorseiPad4,imgHorseiPad5;

    @FXML
    private Button btnSitout,btnBet,btnCurrent,btnClose,btnConfirm;

    @FXML
    private Label lblRound, lblWel,lblHorse,lblRacer,lblBettingamount1,lblBettingamount2,lblBettingamount3,lblBettingamount4,lblBettingamount5,lblHorseNumber1,lblHorseNumber2,lblHorseNumber3,lblHorseNumber4,lblHorseNumber5,lblHorseiPad1,lblHorseiPad2,lblHorseiPad3,lblHorseiPad4,lblHorseiPad5,lblRate1,lblRate2,lblRate3,lblRate4,lblRate5,lblRateiPad1,lblRateiPad2,lblRateiPad3,lblRateiPad4,lblRateiPad5,lblReturniPad1,lblReturniPad2,lblReturniPad3,lblReturniPad4,lblReturniPad5,lblBetting;

    @FXML
    private Ellipse shpcirText,shpcirText2;

    @FXML
    private Polygon shptriText,shptriText2;
    
    @FXML
    private Line line;
    
    @FXML
    private TextField txtBetting1,txtBetting2,txtBetting3,txtBetting4,txtBetting5;
    
    
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
        btnCurrent.setVisible(false);
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
        imgPersonRight.setVisible(true);
        lblHorse.setVisible(true);
        lblRacer.setVisible(true);
        shpcirText2.setVisible(true);
        shptriText2.setVisible(true);
    }
    
    
    @FXML
    void btnCloseA(ActionEvent event) {
        lblBettingamount1.setVisible(false);
        lblBettingamount2.setVisible(false);
        lblBettingamount3.setVisible(false);
        lblBettingamount4.setVisible(false);
        lblBettingamount5.setVisible(false);
        lblHorseNumber1.setVisible(false);
        lblHorseNumber2.setVisible(false);
        lblHorseNumber3.setVisible(false);
        lblHorseNumber4.setVisible(false);
        lblHorseNumber5.setVisible(false);
        lblHorseiPad1.setVisible(false);
        lblHorseiPad2.setVisible(false);
        lblHorseiPad3.setVisible(false);
        lblHorseiPad4.setVisible(false);
        lblHorseiPad5.setVisible(false);
        lblRate1.setVisible(false);
        lblRate2.setVisible(false);
        lblRate3.setVisible(false);
        lblRate4.setVisible(false);
        lblRate5.setVisible(false);
        lblRateiPad1.setVisible(false);
        lblRateiPad2.setVisible(false);
        lblRateiPad3.setVisible(false);
        lblRateiPad4.setVisible(false);
        lblRateiPad5.setVisible(false);
        lblReturniPad1.setVisible(false);
        lblReturniPad2.setVisible(false);
        lblReturniPad3.setVisible(false);
        lblReturniPad4.setVisible(false);
        lblReturniPad5.setVisible(false);
        imgHorseiPad1.setVisible(false);
        imgHorseiPad2.setVisible(false);
        imgHorseiPad3.setVisible(false);
        imgHorseiPad4.setVisible(false);
        imgHorseiPad5.setVisible(false);
        imgiPad.setVisible(false);
        txtBetting1.setVisible(false);
        txtBetting2.setVisible(false);
        txtBetting3.setVisible(false);
        txtBetting4.setVisible(false);
        txtBetting5.setVisible(false);
        lblBetting.setVisible(false);
        btnClose.setVisible(false);
        btnConfirm.setVisible(false);
        imgCrowd.setVisible(true);
        line.setVisible(true);
        Horse1.setVisible(true);
        Horse2.setVisible(true);
        Horse3.setVisible(true);
        Horse4.setVisible(true);
        Horse5.setVisible(true);
        imgPersonLeft.setVisible(true);
        lblRound.setVisible(true);
        lblWel.setVisible(true);
        shpcirText.setVisible(true);
        shptriText.setVisible(true);
        btnBet.setVisible(true);
        btnCurrent.setVisible(true);
        btnSitout.setVisible(true);
        
    }


    @FXML
    void btnHorse(MouseEvent event) {
        imgArrow1.setVisible(false);
        imgArrow2.setVisible(false);
        imgArrow3.setVisible(false);
        imgArrow4.setVisible(false);
        imgArrow5.setVisible(false);
        imgPersonRight.setVisible(false);
        lblHorse.setVisible(false);
        lblRacer.setVisible(false);
        shpcirText2.setVisible(false);
        shptriText2.setVisible(false);
        ImageView img = (ImageView) event.getSource();
        img.setAccessibleText("C");
        x1 = ThreadLocalRandom.current().nextInt(3, 5 + 1);
        x2 = ThreadLocalRandom.current().nextInt(3, 5 + 1);
        x3 = ThreadLocalRandom.current().nextInt(3, 5 + 1);
        x4 = ThreadLocalRandom.current().nextInt(3, 5 + 1);
        x5 = ThreadLocalRandom.current().nextInt(3, 5 + 1);
        horsemove.setCycleCount(Timeline.INDEFINITE);
        horsemove.play();
    }
    
    @FXML
    void btnCurrentA(ActionEvent event) {
        imgArrow1.setVisible(false);
        imgArrow2.setVisible(false);
        imgArrow3.setVisible(false);
        imgArrow4.setVisible(false);
        imgArrow5.setVisible(false);
        imgPersonRight.setVisible(false);
        lblHorse.setVisible(false);
        lblRacer.setVisible(false);
        shpcirText2.setVisible(false);
        shptriText2.setVisible(false);
        imgCrowd.setVisible(false);
        line.setVisible(false);
        Horse1.setVisible(false);
        Horse2.setVisible(false);
        Horse3.setVisible(false);
        Horse4.setVisible(false);
        Horse5.setVisible(false);
        imgPersonLeft.setVisible(false);
        lblRound.setVisible(false);
        lblWel.setVisible(false);
        shpcirText.setVisible(false);
        shptriText.setVisible(false);
        btnBet.setVisible(false);
        btnCurrent.setVisible(false);
        btnSitout.setVisible(false);
        imgiPad.setVisible(true);
        lblBettingamount1.setVisible(true);
        lblBettingamount2.setVisible(true);
        lblBettingamount3.setVisible(true);
        lblBettingamount4.setVisible(true);
        lblBettingamount5.setVisible(true);
        lblHorseNumber1.setVisible(true);
        lblHorseNumber2.setVisible(true);
        lblHorseNumber3.setVisible(true);
        lblHorseNumber4.setVisible(true);
        lblHorseNumber5.setVisible(true);
        lblHorseiPad1.setVisible(true);
        lblHorseiPad2.setVisible(true);
        lblHorseiPad3.setVisible(true);
        lblHorseiPad4.setVisible(true);
        lblHorseiPad5.setVisible(true);
        lblRate1.setVisible(true);
        lblRate2.setVisible(true);
        lblRate3.setVisible(true);
        lblRate4.setVisible(true);
        lblRate5.setVisible(true);
        lblRateiPad1.setVisible(true);
        lblRateiPad2.setVisible(true);
        lblRateiPad3.setVisible(true);
        lblRateiPad4.setVisible(true);
        lblRateiPad5.setVisible(true);
        lblReturniPad1.setVisible(true);
        lblReturniPad2.setVisible(true);
        lblReturniPad3.setVisible(true);
        lblReturniPad4.setVisible(true);
        lblReturniPad5.setVisible(true);
        imgHorseiPad1.setVisible(true);
        imgHorseiPad2.setVisible(true);
        imgHorseiPad3.setVisible(true);
        imgHorseiPad4.setVisible(true);
        imgHorseiPad5.setVisible(true);
        imgiPad.setVisible(true);
        txtBetting1.setVisible(true);
        txtBetting2.setVisible(true);
        txtBetting3.setVisible(true);
        txtBetting4.setVisible(true);
        txtBetting5.setVisible(true);
        lblBetting.setVisible(true);
        btnClose.setVisible(true);
        btnConfirm.setVisible(true);
        
    }

    @FXML
    void btnSitOutA(ActionEvent event) {
        
    }
    @FXML
    void btnConfirmA(ActionEvent event) {
        lblBettingamount1.setVisible(false);
        lblBettingamount2.setVisible(false);
        lblBettingamount3.setVisible(false);
        lblBettingamount4.setVisible(false);
        lblBettingamount5.setVisible(false);
        lblHorseNumber1.setVisible(false);
        lblHorseNumber2.setVisible(false);
        lblHorseNumber3.setVisible(false);
        lblHorseNumber4.setVisible(false);
        lblHorseNumber5.setVisible(false);
        lblHorseiPad1.setVisible(false);
        lblHorseiPad2.setVisible(false);
        lblHorseiPad3.setVisible(false);
        lblHorseiPad4.setVisible(false);
        lblHorseiPad5.setVisible(false);
        lblRate1.setVisible(false);
        lblRate2.setVisible(false);
        lblRate3.setVisible(false);
        lblRate4.setVisible(false);
        lblRate5.setVisible(false);
        lblRateiPad1.setVisible(false);
        lblRateiPad2.setVisible(false);
        lblRateiPad3.setVisible(false);
        lblRateiPad4.setVisible(false);
        lblRateiPad5.setVisible(false);
        lblReturniPad1.setVisible(false);
        lblReturniPad2.setVisible(false);
        lblReturniPad3.setVisible(false);
        lblReturniPad4.setVisible(false);
        lblReturniPad5.setVisible(false);
        imgHorseiPad1.setVisible(false);
        imgHorseiPad2.setVisible(false);
        imgHorseiPad3.setVisible(false);
        imgHorseiPad4.setVisible(false);
        imgHorseiPad5.setVisible(false);
        imgiPad.setVisible(false);
        txtBetting1.setVisible(false);
        txtBetting2.setVisible(false);
        txtBetting3.setVisible(false);
        txtBetting4.setVisible(false);
        txtBetting5.setVisible(false);
        lblBetting.setVisible(false);
        btnClose.setVisible(false);
        btnConfirm.setVisible(false);
        btnBet.setVisible(false);
        btnSitout.setVisible(false);
        btnCurrent.setVisible(false);
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
        imgPersonRight.setVisible(true);
        lblHorse.setVisible(true);
        lblRacer.setVisible(true);
        shpcirText2.setVisible(true);
        shptriText2.setVisible(true);
        imgCrowd.setVisible(true);
        line.setVisible(true);
        Horse1.setVisible(true);
        Horse2.setVisible(true);
        Horse3.setVisible(true);
        Horse4.setVisible(true);
        Horse5.setVisible(true);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
