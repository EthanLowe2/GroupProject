/*
Name; Gavin Gunn & Ethan Lowe
Class; Grade 12 Com Studies
Date; 26/01/22
Assignment#; Final
Description; group Project/HorseRacing
 */
package lowe.groupproject;

import java.net.URL;
import java.text.DecimalFormat;
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
import static lowe.groupproject.MainApp.scene;

/**
 * FXML Controller class
 *
 * @author ehenr
 */
public class HorseRaceController implements Initializable {

    @FXML
    private ImageView Horse1, Horse2, Horse3, Horse4, Horse5, imgPersonLeft,imgArrow1,imgArrow2,imgArrow3,imgArrow4,imgArrow5,imgPersonRight,imgCrowd,imgiPad,imgHorseiPad1,imgHorseiPad2,imgHorseiPad3,imgHorseiPad4,imgHorseiPad5;

    @FXML
    private Button btnSitout,btnCurrent,btnClose,btnConfirm;

    @FXML
    private Label lblRound, lblWel,lblHorse,lblRacer,lblBettingamount1,lblBettingamount2,lblBettingamount3,lblBettingamount4,lblBettingamount5,lblHorseNumber1,lblHorseNumber2,lblHorseNumber3,lblHorseNumber4,lblHorseNumber5,lblHorseiPad1,lblHorseiPad2,lblHorseiPad3,lblHorseiPad4,lblHorseiPad5,lblRate1,lblRate2,lblRate3,lblRate4,lblRate5,lblRateiPad1,lblRateiPad2,lblRateiPad3,lblRateiPad4,lblRateiPad5,lblReturniPad1,lblReturniPad2,lblReturniPad3,lblReturniPad4,lblReturniPad5,lblBetting,lblFinish,lblDisplayWin,lblWinnerPoints;

    @FXML
    private Ellipse shpcirText,shpcirText2;

    @FXML
    private Polygon shptriText,shptriText2;
    
    @FXML
    private Line line;
    
    @FXML
    private TextField txtBetting1,txtBetting2,txtBetting3,txtBetting4,txtBetting5;
    
    @FXML
    private Label lblMoney;

        
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
    boolean Ready;
    double Bet1;
    double Bet2;
    double Bet3;
    double Bet4;
    double Bet5;
    int currentbet;
    int currenthorse;
    DecimalFormat myFormat = new DecimalFormat("0.00");
    DecimalFormat newFormat = new DecimalFormat("0");
    

    void moveHorse() {
        Horse1.setTranslateX(Horse1.getTranslateX() + x1);
        Horse2.setTranslateX(Horse2.getTranslateX() + x2);
        Horse3.setTranslateX(Horse3.getTranslateX() + x3);
        Horse4.setTranslateX(Horse4.getTranslateX() + x4);
        Horse5.setTranslateX(Horse5.getTranslateX() + x5);
        if (collision(Horse1, lblFinish)){
            int moneyEarn = (int) (currentbet*Bet1);
            horsemove.stop();
            lblDisplayWin.setText("HORSE 1 WINS");
            lblDisplayWin.setVisible(true);
            Horse1.setTranslateX(0);
            Horse2.setTranslateX(0);
            Horse3.setTranslateX(0);
            Horse4.setTranslateX(0);
            Horse5.setTranslateX(0);
            if (currenthorse == 1){
                lblWinnerPoints.setText("YOU WON" + " " +newFormat.format(moneyEarn)+ " Coins");
                lblWinnerPoints.setVisible(true);
                MainApp.money = MainApp.money + moneyEarn;
                lblMoney.setText("" + MainApp.money);
            }
            if (currenthorse == 2 || currenthorse == 3|| currenthorse == 4|| currenthorse == 5){
                lblWinnerPoints.setText("YOU LOST" + " " +newFormat.format(moneyEarn)+ " Coins");
                lblWinnerPoints.setVisible(true);
                MainApp.money = MainApp.money - moneyEarn;
                lblMoney.setText("" + MainApp.money);
            }
            
            shpcirText.setVisible(true);
            shptriText.setVisible(true);
            lblWel.setVisible(true);
            lblRound.setVisible(true);
             btnCurrent.setVisible(true);
            btnSitout.setVisible(true);
        }
        if (collision(Horse2, lblFinish)){
            int moneyEarn = (int) (currentbet*Bet2);
            horsemove.stop();
            lblDisplayWin.setText("HORSE 2 WINS");
            lblDisplayWin.setVisible(true);
            Horse1.setTranslateX(0);
            Horse2.setTranslateX(0);
            Horse3.setTranslateX(0);
            Horse4.setTranslateX(0);
            Horse5.setTranslateX(0);
            if (currenthorse == 2){
                lblWinnerPoints.setText("YOU WON" + " " +newFormat.format(moneyEarn)+ " Coins");
                lblWinnerPoints.setVisible(true);
                MainApp.money = MainApp.money + moneyEarn;
                lblMoney.setText("" + MainApp.money);
            }
            if (currenthorse == 1 || currenthorse == 3|| currenthorse == 4|| currenthorse == 5){
                lblWinnerPoints.setText("YOU LOST" + " " +newFormat.format(moneyEarn)+ " Coins");
                lblWinnerPoints.setVisible(true);
                MainApp.money = MainApp.money - moneyEarn;
                lblMoney.setText("" + MainApp.money);
            }
            shpcirText.setVisible(true);
            shptriText.setVisible(true);
            lblWel.setVisible(true);
            lblRound.setVisible(true);
            btnCurrent.setVisible(true);
            btnSitout.setVisible(true);
        }
        if (collision(Horse3, lblFinish)){
            int moneyEarn = (int) (currentbet*Bet3);
            horsemove.stop();
            lblDisplayWin.setText("HORSE 3 WINS");
            lblDisplayWin.setVisible(true);
            Horse1.setTranslateX(0);
            Horse2.setTranslateX(0);
            Horse3.setTranslateX(0);
            Horse4.setTranslateX(0);
            Horse5.setTranslateX(0);
            if (currenthorse == 3){
                lblWinnerPoints.setText("YOU WON" + " " +newFormat.format(moneyEarn)+ " Coins");
                lblWinnerPoints.setVisible(true);
                MainApp.money = MainApp.money + moneyEarn;
                lblMoney.setText("" + MainApp.money);
            }
            if (currenthorse == 2 || currenthorse == 1|| currenthorse == 4|| currenthorse == 5){
                lblWinnerPoints.setText("YOU LOST" + " " +newFormat.format(moneyEarn)+ " Coins");
                lblWinnerPoints.setVisible(true);
                MainApp.money = MainApp.money - moneyEarn;
                lblMoney.setText("" + MainApp.money);
            }
            shpcirText.setVisible(true);
            shptriText.setVisible(true);
            lblWel.setVisible(true);
            lblRound.setVisible(true);
            btnCurrent.setVisible(true);
            btnSitout.setVisible(true);
        }
        if (collision(Horse4, lblFinish)){
            int moneyEarn = (int) (currentbet*Bet4);
            horsemove.stop();
            lblDisplayWin.setText("HORSE 4 WINS");
            lblDisplayWin.setVisible(true);
            Horse1.setTranslateX(0);
            Horse2.setTranslateX(0);
            Horse3.setTranslateX(0);
            Horse4.setTranslateX(0);
            Horse5.setTranslateX(0);
            if (currenthorse ==4){
                lblWinnerPoints.setText("YOU WON" + " " +newFormat.format(moneyEarn)+ " Coins");
                lblWinnerPoints.setVisible(true);
                MainApp.money = MainApp.money + moneyEarn;
                lblMoney.setText("" + MainApp.money);
            }
            if (currenthorse == 2 || currenthorse == 3|| currenthorse == 1|| currenthorse == 5){
                lblWinnerPoints.setText("YOU LOST" + " " +newFormat.format(moneyEarn)+ " Coins");
                lblWinnerPoints.setVisible(true);
                MainApp.money = MainApp.money - moneyEarn;
                lblMoney.setText("" + MainApp.money);
            }
            shpcirText.setVisible(true);
            shptriText.setVisible(true);
            lblWel.setVisible(true);
            lblRound.setVisible(true);
             btnCurrent.setVisible(true);
            btnSitout.setVisible(true);
        }
        if (collision(Horse5, lblFinish)){
            int moneyEarn = (int) (currentbet*Bet5);
            horsemove.stop();
            lblDisplayWin.setText("HORSE 5 WINS");
            lblDisplayWin.setVisible(true);
            Horse1.setTranslateX(0);
            Horse2.setTranslateX(0);
            Horse3.setTranslateX(0);
            Horse4.setTranslateX(0);
            Horse5.setTranslateX(0);
            if (currenthorse == 5){
                lblWinnerPoints.setText("YOU WON" + " " +newFormat.format(moneyEarn)+ " Coins");
                lblWinnerPoints.setVisible(true);
                MainApp.money = MainApp.money + moneyEarn;
                lblMoney.setText("" + MainApp.money);
            }
            if (currenthorse == 2 || currenthorse == 3|| currenthorse == 4|| currenthorse == 1){
                lblWinnerPoints.setText("YOU LOST" + " " +newFormat.format(moneyEarn)+ " Coins");
                lblWinnerPoints.setVisible(true);
                MainApp.money = MainApp.money - moneyEarn;
                lblMoney.setText("" + MainApp.money);
            }
            shpcirText.setVisible(true);
            shptriText.setVisible(true);
            lblWel.setVisible(true);
            lblRound.setVisible(true);
             btnCurrent.setVisible(true);
            btnSitout.setVisible(true);
        }
        
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
        btnCurrent.setVisible(true);
        btnSitout.setVisible(true);
        
    }


    @FXML
    void btnHorse(MouseEvent event) {
        if (Ready == true){
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
        imgPersonLeft.setVisible(true);
        }
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
        lblDisplayWin.setVisible(false);
        lblWinnerPoints.setVisible(false);
        txtBetting1.setText("");
        txtBetting2.setText("");
        txtBetting3.setText("");
        txtBetting4.setText("");
        txtBetting5.setText("");
        lblRate1.setText(""+myFormat.format(Bet1));
        lblRate2.setText(""+myFormat.format(Bet2));
        lblRate3.setText(""+myFormat.format(Bet3));
        lblRate4.setText(""+myFormat.format(Bet4));
        lblRate5.setText(""+myFormat.format(Bet5));
        
    }
    public boolean collision(ImageView block1, Label block2) {
        return (block1.getBoundsInParent().intersects(block2.getBoundsInParent()));
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
        Ready = true;
        if (!txtBetting1.getText().equals("") && txtBetting2.getText().equals("") && txtBetting3.getText().equals("") && txtBetting4.getText().equals("") && txtBetting5.getText().equals("")){
            currentbet = Integer.parseInt(txtBetting1.getText());
            currenthorse = 1;
            MainApp.money = MainApp.money - currentbet;
        }
        if (txtBetting1.getText().equals("") && !txtBetting2.getText().equals("") && txtBetting3.getText().equals("") && txtBetting4.getText().equals("") && txtBetting5.getText().equals("")){
            currentbet = Integer.parseInt(txtBetting2.getText());
            currenthorse = 2;
            MainApp.money = MainApp.money - currentbet;
        }
        if (txtBetting1.getText().equals("") && txtBetting2.getText().equals("") && !txtBetting3.getText().equals("") && txtBetting4.getText().equals("") && txtBetting5.getText().equals("")){
            currentbet = Integer.parseInt(txtBetting3.getText());
            currenthorse = 3;
            MainApp.money = MainApp.money - currentbet;
        }
        if (txtBetting1.getText().equals("") && txtBetting2.getText().equals("") && txtBetting3.getText().equals("") && !txtBetting4.getText().equals("") && txtBetting5.getText().equals("")){
            currentbet = Integer.parseInt(txtBetting4.getText());
            currenthorse = 4;
            MainApp.money = MainApp.money - currentbet;
        }
        if (txtBetting1.getText().equals("") && txtBetting2.getText().equals("") && txtBetting3.getText().equals("") && txtBetting4.getText().equals("") && !txtBetting5.getText().equals("")){
            currentbet = Integer.parseInt(txtBetting5.getText());
            currenthorse = 5;
            MainApp.money = MainApp.money - currentbet;
        }
        MainApp.scene.getRoot().requestFocus();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblMoney.setText("" + MainApp.money);
        Bet1 = ThreadLocalRandom.current().nextDouble(1, 2 + 1);
        Bet2 = ThreadLocalRandom.current().nextDouble(1, 2 + 1);
        Bet3 = ThreadLocalRandom.current().nextDouble(1, 2 + 1);
        Bet4 = ThreadLocalRandom.current().nextDouble(1, 2 + 1);
        Bet5 = ThreadLocalRandom.current().nextDouble(1, 2 + 1);
    }

}
