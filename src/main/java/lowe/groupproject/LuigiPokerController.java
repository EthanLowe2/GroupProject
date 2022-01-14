/*
Luigi poker
 */
package lowe.groupproject;

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
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author g.gunn
 */
public class LuigiPokerController implements Initializable {

    @FXML
    private ImageView imgPointOrder, imgBetO, imgBetY, imgBoard, imgCoin1, imgCoin2, imgCoin3, imgCoin4, imgCoin5, imgDraw, imgHold, imgPlayerC1, imgPlayerC2, imgPlayerC3, imgPlayerC4, imgPlayerC5, imgLuigiC1, imgLuigiC2, imgLuigiC3, imgLuigiC4, imgLuigiC5, imgBlankLuigiImageView;

    @FXML
    private Label lblWallet, pTextBottom, pTextTop, textLose, textWLBase, textWin, lTextTop, lTextBottom;

    int pStarCount, pMarioCount, pLuigiCount, pFireFlowerCount, pMushroomCount, pCloudCount; //Ammount of each suit player holds

    int PC[] = new int[5]; //Array for players Cards

    int luigiHandCalc, luigiSuitCalc, luigiLowSuitCalc; // Variables used in calculating and dealing luigis hand

    int luigiHand, luigiSuit, luigiLowSuit; //Int of Luigi's hand to compare to Player's
    
    int playerHand, playerSuit, playerLowSuit; //Int of players's hand to compare to Luigi's

    int luigiHighWeight, luigiLowWeight; //Weighting system used in luigi hand calculation

    int tStarCount, tMarioCount, tLuigiCount, tFireFlowerCount, tMushroomCount, tCloudCount;//total card amounts in play

    int junk;

    int H = 0, L = 0; //ints for setting luigi Card images

    int d = 0;

    int i = 0;
    
    int twoKind = 0;

    int wallet = 2410;

    boolean spot = true;
    boolean repick = false;

    ImageView pCardImg[];
    ImageView lCardImg[];

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

            luigiHighCalc();
            for (H = 0; H < 5; H++) {
                highWeightImgSet();
            }

        } else if (luigiHandCalc <= 95 && luigiHandCalc >= 89) { //Four kind, 7%
            luigiHand = 6;
            luigiHighWeight = 4;

            luigiHighCalc();
            for (H = 0; H < 4; H++) {
                highWeightImgSet();
            }
            ljunkRoll();

        } else if (luigiHandCalc <= 88 && luigiHandCalc >= 75) { //Full house, 13%
            luigiHand = 5; //point system for luigi's hand type to compare to players later
            luigiHighWeight = 3; //point system for luigi's high suit quantity to use for finding an available suit that has enough cards
            luigiLowWeight = 2;//point system for luigi's low suit quantity to use for finding an available suit that has enough cards

            luigiHighCalc();
            luigiLowCalc();
            for (H = 0; H < 3; H++) {
                highWeightImgSet();
            }
            for (L = 0; L < 2; L++) {
                LowWeightImgSet();
            }

        } else if (luigiHandCalc <= 74 && luigiHandCalc >= 51) { //Three kind, 20%
            luigiHand = 4;
            luigiHighWeight = 3;

            luigiHighCalc();
            for (H = 0; H < 3; H++) {
                highWeightImgSet();
            }
            ljunkRoll();

        } else if (luigiHandCalc <= 50 && luigiHandCalc >= 21) { //Two pairs, 30%
            luigiHand = 3;
            luigiHighWeight = 2;
            luigiLowWeight = 2;

            luigiHighCalc();
            luigiLowCalc();
            for (H = 0; H < 2; H++) {
                highWeightImgSet();
            }
            for (L = 0; L < 2; L++) {
                LowWeightImgSet();
            }
            ljunkRoll();

        } else if (luigiHandCalc <= 20 && luigiHandCalc >= 1) { //One pair, 20%
            luigiHand = 2;
            luigiHighWeight = 2;

            luigiHighCalc();
            for (H = 0; H < 2; H++) {
                highWeightImgSet();
            }
            ljunkRoll();

        }
    }

    void luigiHighCalc() { //Chooses suit for the dealers highest suit quantity in hand, and adds to the total card in suit amount, if the quantity of suit is too high it reruns method until an available suit is found
        luigiSuitCalc = ThreadLocalRandom.current().nextInt(1, 6 + 1); //Random number to selct high suit candidate
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
        if (luigiLowSuitCalc == 6 && (tStarCount + luigiLowWeight) <= 6) {
            luigiLowSuit = 6;
            tStarCount = tStarCount + luigiLowWeight;
        } else if (luigiLowSuitCalc == 5 && (tMarioCount + luigiLowWeight) <= 6) {
            luigiLowSuit = 5;
            tMarioCount = tMarioCount + luigiLowWeight;
        } else if (luigiLowSuitCalc == 4 && (tLuigiCount + luigiLowWeight) <= 6) {
            luigiLowSuit = 4;
            tLuigiCount = tLuigiCount + luigiLowWeight;
        } else if (luigiLowSuitCalc == 3 && (tFireFlowerCount + luigiLowWeight) <= 6) {
            luigiLowSuit = 3;
            tFireFlowerCount = tFireFlowerCount + luigiLowWeight;
        } else if (luigiLowSuitCalc == 2 && (tMushroomCount + luigiLowWeight) <= 6) {
            luigiLowSuit = 2;
            tMushroomCount = tMushroomCount + luigiLowWeight;
        } else if (luigiLowSuitCalc == 1 && (tCloudCount + luigiLowWeight) <= 6) {
            luigiLowSuit = 1;
            tCloudCount = tCloudCount + luigiLowWeight;
        } else {
            luigiLowCalc();
        }
    }

    
    vdubsuvhjdouhv== nusnc+4748 //ALERT.MUST FIX TWO OF A KIND SETTING FOR LUIGI, consider a for loop of randomized numbers 1-6 until low suit is less then high suit
    
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

    void ljunkRoll() {

        for (int J = 0; H + L + J < 5; J++) {
            junk = ThreadLocalRandom.current().nextInt(1, 6 + 1);
            if (junk == 6 && (tStarCount) < 6) {
                lCardImg[J + H + L].setImage(new Image(getClass().getResource("/Star.png").toString()));
                tStarCount++;
            } else if (junk == 5 && (tMarioCount) < 6) {
                lCardImg[J + H + L].setImage(new Image(getClass().getResource("/Mario.png").toString()));
                tMarioCount++;
            } else if (junk == 4 && (tLuigiCount) < 6) {
                lCardImg[J + H + L].setImage(new Image(getClass().getResource("/Luigi.png").toString()));
                tLuigiCount++;
            } else if (junk == 3 && (tFireFlowerCount) < 6) {
                lCardImg[J + H + L].setImage(new Image(getClass().getResource("/FireFlower.png").toString()));
                tFireFlowerCount++;
            } else if (junk == 2 && (tMushroomCount) < 6) {
                lCardImg[J + H + L].setImage(new Image(getClass().getResource("/Mushroom.png").toString()));
                tMushroomCount++;
            } else if (junk == 1 && (tCloudCount) < 6) {
                lCardImg[J + H + L].setImage(new Image(getClass().getResource("/Cloud.png").toString()));
                tCloudCount++;
            }
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

    @FXML
    void Draw(MouseEvent event) {
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

    void suitCheck() {

        if (pCardImg[d].getAccessibleText().equals("Star")) {
            tStarCount = tStarCount - 1;
            pStarCount = pStarCount - 1;
            //Need to add a pc randomizer link here before reroll method is run
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
    
    }
    
    @FXML
    void pHandFinal() {
        
        
    if(pCloudCount == 2){
     twoKind = twoKind + 2;
    }  
    if(pMushroomCount == 2){
     twoKind = twoKind + 2;
    }  
    if(pFireFlowerCount == 2){
     twoKind = twoKind + 2;
    }  
    if(pLuigiCount == 2){
     twoKind = twoKind + 2;
    }  
    if(pMarioCount == 2){
     twoKind = twoKind + 2;
    }  
    if(pStarCount == 2){
     twoKind = twoKind + 2;
    }  
        
        
     dzvsdv//   For two of kind plyaer fix consider using a greater variable to compare luigis high suit/variable
        
        
    if(pCloudCount == 5 || pMushroomCount == 5 || pFireFlowerCount == 5 || pLuigiCount == 5 || pMarioCount == 5 || pStarCount == 5){
      playerHand = 7;
    }
    else if(pCloudCount == 4 || pMushroomCount == 4 || pFireFlowerCount == 4 || pLuigiCount == 4 || pMarioCount == 4 || pStarCount == 4){
      playerHand = 6;
    }
    else if((pCloudCount == 3 || pMushroomCount == 3 || pFireFlowerCount == 3 || pLuigiCount == 3 || pMarioCount == 3 || pStarCount == 3) && (pCloudCount == 2 || pMushroomCount == 2 || pFireFlowerCount == 2 || pLuigiCount == 2 || pMarioCount == 2 || pStarCount == 2)){
      playerHand = 5;
    }
    else if(pCloudCount == 3 || pMushroomCount == 3 || pFireFlowerCount == 3 || pLuigiCount == 3 || pMarioCount == 3 || pStarCount == 3){
      playerHand = 4;
    }
    else if(twoKind == 4){
      playerHand = 3;
    }
    else if(pCloudCount == 2 || pMushroomCount == 2 || pFireFlowerCount == 2 || pLuigiCount == 2 || pMarioCount == 2 || pStarCount == 2){
      playerHand = 2;
    }
    else{
      playerHand = 1;
    }
    
    if(twoKind != 4){
    if(pCloudCount > pMushroomCount && pCloudCount > pFireFlowerCount && pCloudCount > pLuigiCount && pCloudCount > pMarioCount && pCloudCount > pStarCount){
    playerSuit = 1;
    }
    else if(pMushroomCount > pCloudCount && pMushroomCount > pFireFlowerCount && pMushroomCount > pLuigiCount && pMushroomCount > pMarioCount && pMushroomCount > pStarCount){
    playerSuit = 2;
    }
    else if(pFireFlowerCount> pCloudCount && pFireFlowerCount > pMushroomCount && pFireFlowerCount > pLuigiCount && pFireFlowerCount > pMarioCount && pFireFlowerCount > pStarCount){
    playerSuit = 3;
    }
    else if(pLuigiCount > pMushroomCount && pLuigiCount > pFireFlowerCount && pLuigiCount > pCloudCount && pLuigiCount > pMarioCount && pLuigiCount > pStarCount){
    playerSuit = 4;
    }
    else if(pMarioCount > pCloudCount && pMarioCount > pFireFlowerCount && pMarioCount > pLuigiCount && pMarioCount > pMushroomCount && pMarioCount > pStarCount){
    playerSuit = 5;
    }
    else if(pStarCount > pCloudCount && pStarCount > pFireFlowerCount && pStarCount > pLuigiCount && pStarCount > pMushroomCount && pStarCount > pMarioCount){
    playerSuit = 6;
    }
    
    // below is a copy to be used for low suit, however modifications may need to be made for two of a kind
    if(pCloudCount > pMushroomCount && pCloudCount > pFireFlowerCount && pCloudCount > pLuigiCount && pCloudCount > pMarioCount && pCloudCount > pStarCount){
    playerSuit = 1;
    }
    else if(pMushroomCount > pCloudCount && pMushroomCount > pFireFlowerCount && pMushroomCount > pLuigiCount && pMushroomCount > pMarioCount && pMushroomCount > pStarCount){
    playerSuit = 2;
    }
    else if(pFireFlowerCount> pCloudCount && pFireFlowerCount > pMushroomCount && pFireFlowerCount > pLuigiCount && pFireFlowerCount > pMarioCount && pFireFlowerCount > pStarCount){
    playerSuit = 3;
    }
    else if(pLuigiCount > pMushroomCount && pLuigiCount > pFireFlowerCount && pLuigiCount > pCloudCount && pLuigiCount > pMarioCount && pLuigiCount > pStarCount){
    playerSuit = 4;
    }
    else if(pMarioCount > pCloudCount && pMarioCount > pFireFlowerCount && pMarioCount > pLuigiCount && pMarioCount > pMushroomCount && pMarioCount > pStarCount){
    playerSuit = 5;
    }
    else if(pStarCount > pCloudCount && pStarCount > pFireFlowerCount && pStarCount > pLuigiCount && pStarCount > pMushroomCount && pStarCount > pMarioCount){
    playerSuit = 6;
    }
    }
    }
    
    @FXML
    void drawClick(MouseEvent event) {
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
        Judge();
    }

    @FXML
    void Hold(MouseEvent event) {
      Judge();
    }

    @FXML
    void betClick(MouseEvent event) {
        wallet = Integer.parseInt(lblWallet.getText());
        System.out.println(wallet);
        wallet = wallet - 1;
        lblWallet.setText("" + wallet);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        ImageView picArray[] = {imgPlayerC1, imgPlayerC2, imgPlayerC3, imgPlayerC4, imgPlayerC5};//Image array
        pCardImg = picArray; //Transfer the array to top
        ImageView picArrayLuigi[] = {imgLuigiC1, imgLuigiC2, imgLuigiC3, imgLuigiC4, imgLuigiC5};
        lCardImg = picArrayLuigi;

        pTextBottom.setVisible(false);
        pTextTop.setVisible(false);
        lTextBottom.setVisible(false);
        lTextTop.setVisible(false);
        textWLBase.setVisible(false);
        textWin.setVisible(false);
        textLose.setVisible(false);
        
        
        //Opening ,method start
        pCardRandomizer();
        pSuitCount();
        luigiHandRandomizer();
    }

}
