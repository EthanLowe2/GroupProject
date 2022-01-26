/*
Luigi poker
 */
package lowe.groupproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import static lowe.groupproject.MainApp.setRoot;

/**
 * FXML Controller class
 *
 * @author g.gunn
 */
public class LuigiPokerController implements Initializable {

    @FXML
    private ImageView imgPointOrder, imgBetO, imgBetY, imgBoard, imgCoin1, imgCoin2, imgCoin3, imgCoin4, imgCoin5, imgDraw, imgHold, imgPlayerC1, imgPlayerC2, imgPlayerC3, imgPlayerC4, imgPlayerC5, imgLuigiC1, imgLuigiC2, imgLuigiC3, imgLuigiC4, imgLuigiC5, imgBlankLuigi, exit;

    @FXML
    private Label lblWallet, pTextBottom, pTextTop, textLose, textLoseBase, textWin, lTextTop, lTextBottom, lblPool, textTie, textWinBase, textTieBase;

    @FXML
    private MediaView media;

    @FXML
    private AnchorPane paneVideo;

    int pStarCount, pMarioCount, pLuigiCount, pFireFlowerCount, pMushroomCount, pCloudCount; //Ammount of each suit player holds

    int PC[] = new int[5]; //Array for players Cards

    int luigiHandCalc, luigiSuitCalc, luigiLowSuitCalc; // Variables used in calculating and dealing luigis hand

    int luigiHand, luigiSuit, luigiLowSuit; //Int of Luigi's hand to compare to Player's

    int playerHand, playerSuit, playerLowSuit; //Int of players's hand to compare to Luigi's

    int luigiHighWeight, luigiLowWeight; //Weighting system used in luigi hand calculation

    int tStarCount, tMarioCount, tLuigiCount, tFireFlowerCount, tMushroomCount, tCloudCount;//total card amounts in play

    int junk;

    int junkMarkerOne = 45;
    int junkMarkerTwo = 45;

    boolean g = true;
    int H = 0, L = 0; //ints for setting luigi Card images

    int d = 0;

    int i = 0;

    int psOne, psTwo; //int for checking high and low when two of a kind is present in players hand

    int twoKind = 0;
    int Money;
    int pool;

    MediaPlayer player;

    boolean live = true;

    boolean fail = false;
    boolean betPhase = false;
    boolean spot = true;
    boolean repick = false;

    MediaPlayer vid;

    ImageView pCardImg[];
    ImageView lCardImg[];
    Timeline startDelay = new Timeline(new KeyFrame(Duration.millis(3000), ae -> video()));
    //Timeline Vid = new Timeline(new KeyFrame(Duration.millis(64000), ae -> video()));
    Timeline Reset = new Timeline(new KeyFrame(Duration.millis(5000), ae -> reset()));
    Timeline Bet = new Timeline(new KeyFrame(Duration.millis(1000), ae -> bet()));
    Timeline oBet = new Timeline(new KeyFrame(Duration.millis(1000), ae -> bet()));

    void reset() {
        Reset.stop();
        pool = 0;
        Money--;
        pool++;
        lblPool.setText("" + pool);
        lblWallet.setText("" + Money);
        d = 0;
        i = 0;
        live = true;
        repick = false;
        spot = true;
        twoKind = 0;
        psOne = 0;
        psTwo = 0;
        H = 0;
        L = 0;
        junkMarkerOne = 45;
        junkMarkerTwo = 45;
        tStarCount = 0;
        tMarioCount = 0;
        tLuigiCount = 0;
        tFireFlowerCount = 0;
        tMushroomCount = 0;
        tCloudCount = 0;
        pStarCount = 0;
        pMarioCount = 0;
        pLuigiCount = 0;
        pFireFlowerCount = 0;
        pMushroomCount = 0;
        pCloudCount = 0;
        pTextBottom.setVisible(false);
        pTextTop.setVisible(false);
        lTextBottom.setVisible(false);
        lTextTop.setVisible(false);
        textLoseBase.setVisible(false);
        textWinBase.setVisible(false);
        textTieBase.setVisible(false);
        textWin.setVisible(false);
        textLose.setVisible(false);
        textTie.setVisible(false);
        imgBlankLuigi.setVisible(true);
        lblPool.setText("1");

        pCardRandomizer();
        pSuitCount();
        luigiHandRandomizer();
    }

    void pCardRandomizer() { //Chooses Random cards for the player and assures no overlap
        if (repick == true) {
            PC[d] = ThreadLocalRandom.current().nextInt(1, 36 + 1);
            i = d;
        } else if (repick == false) {
            PC[0] = ThreadLocalRandom.current().nextInt(1, 36 + 1);
            PC[1] = ThreadLocalRandom.current().nextInt(1, 36 + 1);
            PC[2] = ThreadLocalRandom.current().nextInt(1, 36 + 1);
            PC[3] = ThreadLocalRandom.current().nextInt(1, 36 + 1);
            PC[4] = ThreadLocalRandom.current().nextInt(1, 36 + 1);

            while (PC[0] == PC[1]) {
                PC[1] = ThreadLocalRandom.current().nextInt(1, 36 + 1);
            }
            while (PC[0] == PC[2] || PC[1] == PC[2]) {
                PC[2] = ThreadLocalRandom.current().nextInt(1, 36 + 1);
            }
            while (PC[0] == PC[3] || PC[1] == PC[3] || PC[2] == PC[3]) {
                PC[3] = ThreadLocalRandom.current().nextInt(1, 36 + 1);
            }
            while (PC[0] == PC[4] || PC[1] == PC[4] || PC[2] == PC[4] || PC[3] == PC[4]) {
                PC[4] = ThreadLocalRandom.current().nextInt(1, 36 + 1);
            }
        }

    }

    void pSuitCount() { //uses the random numbers from pCardRandomizer to add to the players counter and update the proper image
        for (; i < 5; i++) {

            if ((PC[i] == 1 || PC[i] == 2 || PC[i] == 3 || PC[i] == 4 || PC[i] == 5 || PC[i] == 6) && tCloudCount < 7) {
                pCloudCount++;
                pCardImg[i].setImage(new Image(getClass().getResource("/Cloud.png").toString()));
                pCardImg[i].setAccessibleText("Cloud");//Used for draw and hold
            } else if ((PC[i] == 7 || PC[i] == 8 || PC[i] == 9 || PC[i] == 10 || PC[i] == 11 || PC[i] == 12) && tMushroomCount < 7) {
                pMushroomCount++;
                pCardImg[i].setImage(new Image(getClass().getResource("/Mushroom.png").toString()));
                pCardImg[i].setAccessibleText("Mushroom");
            } else if ((PC[i] == 13 || PC[i] == 14 || PC[i] == 15 || PC[i] == 16 || PC[i] == 17 || PC[i] == 18) && tFireFlowerCount < 7) {
                pFireFlowerCount++;
                pCardImg[i].setImage(new Image(getClass().getResource("/FireFlower.png").toString()));
                pCardImg[i].setAccessibleText("FireFlower");
            } else if ((PC[i] == 19 || PC[i] == 20 || PC[i] == 21 || PC[i] == 22 || PC[i] == 23 || PC[i] == 24) && tLuigiCount < 7) {
                pLuigiCount++;
                pCardImg[i].setImage(new Image(getClass().getResource("/Luigi.png").toString()));
                pCardImg[i].setAccessibleText("Luigi");
            } else if ((PC[i] == 25 || PC[i] == 26 || PC[i] == 27 || PC[i] == 28 || PC[i] == 29 || PC[i] == 30) && tMarioCount < 7) {
                pMarioCount++;
                pCardImg[i].setImage(new Image(getClass().getResource("/Mario.png").toString()));
                pCardImg[i].setAccessibleText("Mario");
            } else if ((PC[i] == 31 || PC[i] == 32 || PC[i] == 33 || PC[i] == 34 || PC[i] == 35 || PC[i] == 36) && tStarCount < 7) {
                pStarCount++;
                pCardImg[i].setImage(new Image(getClass().getResource("/Star.png").toString()));
                pCardImg[i].setAccessibleText("Star");
            }
            if (repick == true) {
                i = 5;

            }

        }

    }

    void luigiHandRandomizer() {
        luigiHandCalc = ThreadLocalRandom.current().nextInt(1, 100 + 1); //Percentage based randomizer for the dealers hand type
        if (luigiHandCalc <= 100 && luigiHandCalc >= 96) { //Five kind, 5%
            luigiHand = 7;
            luigiHighWeight = 5;
            lTextTop.setText("5 of a Kind");
            lTextBottom.setText("5 of a Kind");
            luigiHighCalc();
            for (H = 0; H < 5; H++) {
                highWeightImgSet();
            }

        } else if (luigiHandCalc <= 95 && luigiHandCalc >= 89) { //Four kind, 7%
            luigiHand = 6;
            luigiHighWeight = 4;
            lTextTop.setText("4 of a Kind");
            lTextBottom.setText("4 of a Kind");
            luigiHighCalc();
            for (H = 0; H < 4; H++) {
                highWeightImgSet();
            }
            ljunkRoll();

        } else if (luigiHandCalc <= 88 && luigiHandCalc >= 79) { //Full house, 10%
            luigiHand = 5; //point system for luigi's hand type to compare to players later
            luigiHighWeight = 3; //point system for luigi's high suit quantity to use for finding an available suit that has enough cards
            luigiLowWeight = 2;//point system for luigi's low suit quantity to use for finding an available suit that has enough cards
            lTextTop.setText("Full House");
            lTextBottom.setText("Full House");
            luigiHighCalc();
            luigiLowCalc();
            for (H = 0; H < 3; H++) {
                highWeightImgSet();
            }
            for (L = 0; L < 2; L++) {
                LowWeightImgSet();
            }

        } else if (luigiHandCalc <= 78 && luigiHandCalc >= 51) { //Three kind, 23%
            luigiHand = 4;
            luigiHighWeight = 3;
            lTextTop.setText("3 of a Kind");
            lTextBottom.setText("3 of a Kind");
            luigiHighCalc();
            for (H = 0; H < 3; H++) {
                highWeightImgSet();
            }
            ljunkRoll();

        } else if (luigiHandCalc <= 50 && luigiHandCalc >= 31) { //Two pairs, 20%
            luigiHand = 3;
            luigiHighWeight = 2;
            luigiLowWeight = 2;
            lTextTop.setText("2 Pairs");
            lTextBottom.setText("2 Pairs");
            luigiHighCalc();
            luigiLowCalc();
            for (H = 0; H < 2; H++) {
                highWeightImgSet();
            }
            for (L = 0; L < 2; L++) {
                LowWeightImgSet();
            }
            ljunkRoll();

        } else if (luigiHandCalc <= 30 && luigiHandCalc >= 1) { //One pair, 30%
            luigiHand = 2;
            luigiHighWeight = 2;
            lTextTop.setText("1 Pair");
            lTextBottom.setText("1 Pair");
            luigiHighCalc();
            for (H = 0; H < 2; H++) {
                highWeightImgSet();
            }
            ljunkRoll();

        }

    }

    void luigiHighCalc() { //Chooses suit for the dealers highest suit quantity in hand, and adds to the total card in suit amount, if the quantity of suit is too high it reruns method until an available suit is found
        luigiSuitCalc = ThreadLocalRandom.current().nextInt(1, 6 + 1); //Random number to selct high suit candidate
        if ((luigiHandCalc <= 50 && luigiHandCalc >= 21 || luigiHandCalc <= 88 && luigiHandCalc >= 75) && luigiSuitCalc == 1) {
            luigiSuitCalc = luigiSuitCalc + 1;
        }
        if (luigiSuitCalc == 6 && (pStarCount + luigiHighWeight) <= 6) { //condition of the selected number and that there is enough total cards in suit available (6 of each suit) for the required hand type
            luigiSuit = 6; //Sets luigi's Suit type for comparison
            tStarCount = pStarCount + luigiHighWeight; //adds to the total suit type for the player draw methiod down the line
        } else if (luigiSuitCalc == 5 && (pMarioCount + luigiHighWeight) <= 6) {
            luigiSuit = 5;
            tMarioCount = pMarioCount + luigiHighWeight;
        } else if (luigiSuitCalc == 4 && (pLuigiCount + luigiHighWeight) <= 6) {
            luigiSuit = 4;
            tLuigiCount = pLuigiCount + luigiHighWeight;
        } else if (luigiSuitCalc == 3 && (pFireFlowerCount + luigiHighWeight) <= 6) {
            luigiSuit = 3;
            tFireFlowerCount = pFireFlowerCount + luigiHighWeight;
        } else if (luigiSuitCalc == 2 && (pMushroomCount + luigiHighWeight) <= 6) {
            luigiSuit = 2;
            tMushroomCount = pMushroomCount + luigiHighWeight;
        } else if (luigiSuitCalc == 1 && (pCloudCount + luigiHighWeight) <= 6) {
            luigiSuit = 1;
            tCloudCount = pCloudCount + luigiHighWeight;
        } else {
            luigiHighCalc(); //rerolls if suit is full
        }

    }

    void luigiLowCalc() { //Chooses suit for the dealers highest suit quantity in hand, and adds to the total card in suit amount, if the quantity of suit is too high it reruns method until an available suit is found
        luigiLowSuitCalc = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        if (luigiLowSuitCalc == 6 && (tStarCount + luigiLowWeight) <= 6 && luigiSuitCalc > luigiLowSuitCalc) {
            luigiLowSuit = 6;
            tStarCount = tStarCount + luigiLowWeight;
        } else if (luigiLowSuitCalc == 5 && (tMarioCount + luigiLowWeight) <= 6 && luigiSuitCalc > luigiLowSuitCalc) {
            luigiLowSuit = 5;
            tMarioCount = tMarioCount + luigiLowWeight;
        } else if (luigiLowSuitCalc == 4 && (tLuigiCount + luigiLowWeight) <= 6 && luigiSuitCalc > luigiLowSuitCalc) {
            luigiLowSuit = 4;
            tLuigiCount = tLuigiCount + luigiLowWeight;
        } else if (luigiLowSuitCalc == 3 && (tFireFlowerCount + luigiLowWeight) <= 6 && luigiSuitCalc > luigiLowSuitCalc) {
            luigiLowSuit = 3;
            tFireFlowerCount = tFireFlowerCount + luigiLowWeight;
        } else if (luigiLowSuitCalc == 2 && (tMushroomCount + luigiLowWeight) <= 6 && luigiSuitCalc > luigiLowSuitCalc) {
            luigiLowSuit = 2;
            tMushroomCount = tMushroomCount + luigiLowWeight;
        } else if (luigiLowSuitCalc == 1 && (tCloudCount + luigiLowWeight) <= 6 && luigiSuitCalc > luigiLowSuitCalc) {
            luigiLowSuit = 1;
            tCloudCount = tCloudCount + luigiLowWeight;
        } else {
            luigiLowCalc();
        }
    }

    void highWeightImgSet() {
        if (luigiSuit == 6) {
            lCardImg[H].setImage(new Image(getClass().getResource("/Star.png").toString()));
        } else if (luigiSuit == 5) {
            lCardImg[H].setImage(new Image(getClass().getResource("/Mario.png").toString()));
        } else if (luigiSuit == 4) {
            lCardImg[H].setImage(new Image(getClass().getResource("/Luigi.png").toString()));
        } else if (luigiSuit == 3) {
            lCardImg[H].setImage(new Image(getClass().getResource("/FireFlower.png").toString()));
        } else if (luigiSuit == 2) {
            lCardImg[H].setImage(new Image(getClass().getResource("/Mushroom.png").toString()));
        } else if (luigiSuit == 1) {
            lCardImg[H].setImage(new Image(getClass().getResource("/Cloud.png").toString()));
        }
    }

    void LowWeightImgSet() {
        if (luigiLowSuit == 6) {
            lCardImg[H + L].setImage(new Image(getClass().getResource("/Star.png").toString()));
        } else if (luigiLowSuit == 5) {
            lCardImg[H + L].setImage(new Image(getClass().getResource("/Mario.png").toString()));
        } else if (luigiLowSuit == 4) {
            lCardImg[H + L].setImage(new Image(getClass().getResource("/Luigi.png").toString()));
        } else if (luigiLowSuit == 3) {
            lCardImg[H + L].setImage(new Image(getClass().getResource("/FireFlower.png").toString()));
        } else if (luigiLowSuit == 2) {
            lCardImg[H + L].setImage(new Image(getClass().getResource("/Mushroom.png").toString()));
        } else if (luigiLowSuit == 1) {
            lCardImg[H + L].setImage(new Image(getClass().getResource("/Cloud.png").toString()));
        }
    }

    void ljunkRoll() {

        for (int J = 0; H + L + J < 5;) {
            junk = ThreadLocalRandom.current().nextInt(1, 6 + 1);
            if (junk != luigiSuit && junk != luigiLowSuit && junk != junkMarkerOne && junk != junkMarkerTwo) {
                if (junk == 6 && (tStarCount) < 6) {
                    lCardImg[J + H + L].setImage(new Image(getClass().getResource("/Star.png").toString()));
                    J = J + 1;
                    tStarCount++;
                    junkMarker();
                } else if (junk == 5 && (tMarioCount) < 6) {
                    lCardImg[J + H + L].setImage(new Image(getClass().getResource("/Mario.png").toString()));
                    J = J + 1;
                    tMarioCount++;
                    junkMarker();
                } else if (junk == 4 && (tLuigiCount) < 6) {
                    lCardImg[J + H + L].setImage(new Image(getClass().getResource("/Luigi.png").toString()));
                    J = J + 1;
                    tLuigiCount++;
                    junkMarker();
                } else if (junk == 3 && (tFireFlowerCount) < 6) {
                    lCardImg[J + H + L].setImage(new Image(getClass().getResource("/FireFlower.png").toString()));
                    J = J + 1;
                    tFireFlowerCount++;
                    junkMarker();
                } else if (junk == 2 && (tMushroomCount) < 6) {
                    lCardImg[J + H + L].setImage(new Image(getClass().getResource("/Mushroom.png").toString()));
                    J = J + 1;
                    tMushroomCount++;
                    junkMarker();
                } else if (junk == 1 && (tCloudCount) < 6) {
                    lCardImg[J + H + L].setImage(new Image(getClass().getResource("/Cloud.png").toString()));
                    J = J + 1;
                    tCloudCount++;
                    junkMarker();
                }

            }

        }

    }

    void junkMarker() { // blocks to assure that no random draw will affect the final hand
        if (junkMarkerOne == 45) {
            junkMarkerOne = junk;
        } else if (junkMarkerOne != 45 && junkMarkerTwo == 45) {
            junkMarkerTwo = junk;
        }

    }

    @FXML
    void Draw(MouseEvent event) {
        if (live == true) {
            ImageView img = (ImageView) event.getSource();
            if (img.getLayoutY() == 685) {

                img.setLayoutY(650);

            } else if (img.getLayoutY() == 650) {

                img.setLayoutY(685);

            }
            if (imgPlayerC1.getLayoutY() == 650 || imgPlayerC2.getLayoutY() == 650 || imgPlayerC3.getLayoutY() == 650 || imgPlayerC4.getLayoutY() == 650 || imgPlayerC5.getLayoutY() == 650) {
                imgHold.setVisible(false);
            } else if (imgPlayerC1.getLayoutY() == 685 && imgPlayerC2.getLayoutY() == 685 && imgPlayerC3.getLayoutY() == 685 && imgPlayerC4.getLayoutY() == 685 && imgPlayerC5.getLayoutY() == 685) {
                imgHold.setVisible(true);
            }
        }

    }

    void suitCheck() {

        if (pCardImg[d].getAccessibleText().equals("Star")) {
            tStarCount = tStarCount - 1;
            pStarCount = pStarCount - 1;

        } else if (pCardImg[d].getAccessibleText().equals("Mario")) {
            tMarioCount = tMarioCount - 1;
            pMarioCount = pMarioCount - 1;
        } else if (pCardImg[d].getAccessibleText().equals("Luigi")) {
            tLuigiCount = tLuigiCount - 1;
            pLuigiCount = pLuigiCount - 1;
        } else if (pCardImg[d].getAccessibleText().equals("FireFlower")) {
            tFireFlowerCount = tFireFlowerCount - 1;
            pFireFlowerCount = pFireFlowerCount - 1;
        } else if (pCardImg[d].getAccessibleText().equals("Mushroom")) {
            tMushroomCount = tMushroomCount - 1;
            pMushroomCount = pMushroomCount - 1;
        } else if (pCardImg[d].getAccessibleText().equals("Cloud")) {
            tCloudCount = tCloudCount - 1;
            pCloudCount = pCloudCount - 1;
        }

    }

    @FXML
    void Judge(){
        imgBlankLuigi.setVisible(false);
        for (int g = 0; g < 5; g++) {
            pCardImg[g].setLayoutY(685);
        }

        pTextBottom.setVisible(true);
        pTextTop.setVisible(true);
        lTextBottom.setVisible(true);
        lTextTop.setVisible(true);

        if ((playerHand > luigiHand) || (playerHand == luigiHand && playerSuit > luigiSuit) || (playerHand == luigiHand && playerSuit == luigiSuit && playerLowSuit > luigiLowSuit)) {
            textWin.setVisible(true);
            textWinBase.setVisible(true);
            if (luigiHand == 7) {
                pool = pool * (16 + playerHand);

            } else if (luigiHand == 6) {
                pool = pool * (8 + playerHand);

            } else if (luigiHand == 5) {
                pool = pool * (6 + playerHand);

            } else if (luigiHand == 4) {
                pool = pool * (4 + playerHand);

            } else if (luigiHand == 3) {
                pool = pool * (3 + playerHand);

            } else if (luigiHand == 2) {
                pool = pool * (2 + playerHand);

            }
            Money = Money + pool;
            lblWallet.setText("" + Money);
            lblPool.setText("0");
            lblPool.setText("+" + pool);

        }
        if ((playerHand < luigiHand) || (playerHand == luigiHand && playerSuit < luigiSuit) || (playerHand == luigiHand && playerSuit == luigiSuit && playerLowSuit < luigiLowSuit)) {
            textLose.setVisible(true);
            textLoseBase.setVisible(true);
            lblPool.setText("0");

            lblPool.setText("-" + pool);
        }
        if ((playerHand == luigiHand && playerSuit == luigiSuit && playerLowSuit == luigiLowSuit)) {
            textTie.setVisible(true);
            textTieBase.setVisible(true);
            Money = Money + pool;
            lblWallet.setText("" + Money);
            lblPool.setText("0");
            lblPool.setText("+0");
            if (Money < 1) {
              //  setRoot("LostAllPoints", "What a loser");
            }
        }
        Reset.play();
    }

    @FXML
    void pHandFinal() { //Final calculations for players hand

        //used for multi pair sets such as full house and two pairs
        if (pCloudCount == 2) {
            twoKind = twoKind + 2;
            if (psOne == 0) {
                psOne = 1;
            } else {
                psTwo = 1;
            }
        }
        if (pMushroomCount == 2) {
            twoKind = twoKind + 2;
            if (psOne == 0) {
                psOne = 2;
            } else {
                psTwo = 2;
            }
        }
        if (pFireFlowerCount == 2) {
            twoKind = twoKind + 2;
            if (psOne == 0) {
                psOne = 3;
            } else {
                psTwo = 3;
            }
        }
        if (pLuigiCount == 2) {
            twoKind = twoKind + 2;
            if (psOne == 0) {
                psOne = 4;
            } else {
                psTwo = 4;
            }
        }
        if (pMarioCount == 2) {
            twoKind = twoKind + 2;
            if (psOne == 0) {
                psOne = 5;
            } else {
                psTwo = 5;
            }
        }
        if (pStarCount == 2) {
            twoKind = twoKind + 2;
            if (psOne == 0) {
                psOne = 6;
            } else {
                psTwo = 6;
            }
        }
        //Figures players hand
        if (pCloudCount == 5 || pMushroomCount == 5 || pFireFlowerCount == 5 || pLuigiCount == 5 || pMarioCount == 5 || pStarCount == 5) {
            playerHand = 7;
            pTextTop.setText("5 of a Kind");
            pTextBottom.setText("5 of a Kind");
        } else if (pCloudCount == 4 || pMushroomCount == 4 || pFireFlowerCount == 4 || pLuigiCount == 4 || pMarioCount == 4 || pStarCount == 4) {
            playerHand = 6;
            pTextTop.setText("4 of a Kind");
            pTextBottom.setText("4 of a Kind");
        } else if ((pCloudCount == 3 || pMushroomCount == 3 || pFireFlowerCount == 3 || pLuigiCount == 3 || pMarioCount == 3 || pStarCount == 3) && (pCloudCount == 2 || pMushroomCount == 2 || pFireFlowerCount == 2 || pLuigiCount == 2 || pMarioCount == 2 || pStarCount == 2)) {
            playerHand = 5;
            pTextTop.setText("Full House");
            pTextBottom.setText("Full House");
        } else if (pCloudCount == 3 || pMushroomCount == 3 || pFireFlowerCount == 3 || pLuigiCount == 3 || pMarioCount == 3 || pStarCount == 3) {
            playerHand = 4;
            pTextTop.setText("3 of a Kind");
            pTextBottom.setText("3 of a Kind");
        } else if (twoKind == 4) {
            playerHand = 3;
            pTextTop.setText("2 Pairs");
            pTextBottom.setText("2 Pairs");
        } else if (pCloudCount == 2 || pMushroomCount == 2 || pFireFlowerCount == 2 || pLuigiCount == 2 || pMarioCount == 2 || pStarCount == 2) {
            playerHand = 2;
            pTextTop.setText("1 Pair");
            pTextBottom.setText("1 Pair");
        } else {
            playerHand = 1;
            pTextTop.setText("Junk");
            pTextBottom.setText("Junk");
        }

        if (twoKind != 4) { //sets high suit unless it is two of a kind
            if (pCloudCount > pMushroomCount && pCloudCount > pFireFlowerCount && pCloudCount > pLuigiCount && pCloudCount > pMarioCount && pCloudCount > pStarCount) {
                playerSuit = 1;
            } else if (pMushroomCount > pCloudCount && pMushroomCount > pFireFlowerCount && pMushroomCount > pLuigiCount && pMushroomCount > pMarioCount && pMushroomCount > pStarCount) {
                playerSuit = 2;
            } else if (pFireFlowerCount > pCloudCount && pFireFlowerCount > pMushroomCount && pFireFlowerCount > pLuigiCount && pFireFlowerCount > pMarioCount && pFireFlowerCount > pStarCount) {
                playerSuit = 3;
            } else if (pLuigiCount > pMushroomCount && pLuigiCount > pFireFlowerCount && pLuigiCount > pCloudCount && pLuigiCount > pMarioCount && pLuigiCount > pStarCount) {
                playerSuit = 4;
            } else if (pMarioCount > pCloudCount && pMarioCount > pFireFlowerCount && pMarioCount > pLuigiCount && pMarioCount > pMushroomCount && pMarioCount > pStarCount) {
                playerSuit = 5;
            } else if (pStarCount > pCloudCount && pStarCount > pFireFlowerCount && pStarCount > pLuigiCount && pStarCount > pMushroomCount && pStarCount > pMarioCount) {
                playerSuit = 6;
            }

        }

        if (twoKind == 4) {
            if (twoKind == 4) {
                if (psOne > psTwo) {
                    playerSuit = psOne;
                    playerLowSuit = psTwo;

                }
                if (psOne < psTwo) {
                    playerSuit = psTwo;
                    playerLowSuit = psOne;

                }
            }
        }
        if (twoKind == 2 && playerHand == 5) {
            playerLowSuit = psOne;
        }

        Judge();
    }

    @FXML
    void drawClick(MouseEvent event) {
        if (live == true) {
            for (d = 0; d < 5; d++) {
                if (pCardImg[d].getLayoutY() == 650) {
                    suitCheck();
                    repick = true;
                    i = 0;
                    pCardRandomizer();
                    pSuitCount();

                } else {
                    d++;
                }
            }
            live = false;
            pHandFinal();

        }

    }

    @FXML
    void holdClick(MouseEvent event) {
        if (live == true) {
            live = false;
            pHandFinal();

        }

    }

    @FXML
    void betClick(MouseEvent event) {
        if (live == true) {
            if (pool < 10 && Money > 0) {
                Money = Integer.parseInt(lblWallet.getText());
                pool = pool + 1;
                lblPool.setText("" + pool);
                Money = Money - 1;
                lblWallet.setText("" + Money);

            }
            if (Money == 1) {
                //Send to game over screen
            }

        }

    }

    void theme() {
        // Plays main theme 

        player = new MediaPlayer((new Media(getClass().getResource("/Main Theme.mp3").toString())));
        player.play();
        //Theme.play();

        player.setAutoPlay(true);
        player.seek(Duration.ZERO);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        MediaView view = new MediaView(player);

        player.play();

    }

    @FXML
    void video() {
        vid = new MediaPlayer((new Media(getClass().getResource("/Casino.mp4").toString())));
        media.setMediaPlayer(vid);
        vid.setAutoPlay(true);
        vid.seek(Duration.ZERO);
        vid.setCycleCount(MediaPlayer.INDEFINITE);

        //Plays luigi video feed
        /*
        int i = 0;
        if (i == 0) {
            vid = new MediaPlayer((new Media(getClass().getResource("/Casino.mp4").toString())));
            media.setMediaPlayer(vid);
            
            vid.play();
            Vid.play();
            i++;
        }
        if (i == 1) {
            
            
            vid.play();
            Vid.play();
            i=0;
        }
         */
    }

    void bet() { //flashes bet button
        if (betPhase == false) {
            imgBetY.setVisible(false);
            betPhase = true;
            oBet.play();
        } else if (betPhase == true) {
            imgBetY.setVisible(true);
            betPhase = false;
            Bet.play();
        }

    }

    @FXML
    void exitClick(MouseEvent event) throws IOException {
        MainApp.money = Money;
        setRoot("Rules", "Rules");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources
    ) {
        ImageView picArray[] = {imgPlayerC1, imgPlayerC2, imgPlayerC3, imgPlayerC4, imgPlayerC5};//Image array
        pCardImg = picArray; //Transfer the array to top
        ImageView picArrayLuigi[] = {imgLuigiC1, imgLuigiC2, imgLuigiC3, imgLuigiC4, imgLuigiC5};
        lCardImg = picArrayLuigi;

        Money = MainApp.money;
        lblWallet.setText("" + Money);
        pTextBottom.setVisible(false);
        pTextTop.setVisible(false);
        lTextBottom.setVisible(false);
        lTextTop.setVisible(false);
        textLoseBase.setVisible(false);
        textWinBase.setVisible(false);
        textTieBase.setVisible(false);
        textWin.setVisible(false);
        textLose.setVisible(false);
        textTie.setVisible(false);
        imgBlankLuigi.setVisible(true);
        live = true;
        //Opening method start
        pool = pool + 1;
        Money = Money - 1;
        lblPool.setText("" + pool);
        lblWallet.setText("" + Money);
        theme();
        video();
        //Vid.play();
        pCardRandomizer();
        pSuitCount();
        luigiHandRandomizer();
        Bet.play();

    }

}
