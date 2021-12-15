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

/**
 * FXML Controller class
 *
 * @author g.gunn
 */
public class LuigiPokerController implements Initializable {

    @FXML
    private ImageView imgPointOrder, imgBetO, imgBetY, imgBoard, imgCoin1, imgCoin2, imgCoin3, imgCoin4, imgCoin5, imgDraw, imgHold, imgPlayerC1, imgPlayerC2, imgPlayerC3, imgPlayerC4, imgPlayerC5, imgLuigiC1, imgLuigiC2, imgLuigiC3, imgLuigiC4, imgLuigiC5, imgBlankLuigiImageView;

    @FXML
    private Label lblWallet;

    int pStarCount, pMarioCount, pLuigiCount, pFireFlowerCount, pMushroomCount, pCloudCount; //Ammount of each suit player holds

    int PC[] = new int[5]; //Array for players Cards

    int luigiHandCalc, luigiSuitCalc, luigiLowSuitCalc; // Variables used in calculating and dealing luigis hand

    int luigiHand, luigiSuit, luigiLowSuit; //Int of luigi's hand to compare to players

    int luigiHighWeight, luigiLowWeight;

    int tStarCount, tMarioCount, tLuigiCount, tFireFlowerCount, tMushroomCount, tCloudCount;

    ImageView pCardImg[];

    //ArrayList Deck = new ArrayList();

    /*
    void deckAdd() { //Card Deck
        Deck.add("Cloud");
        Deck.add("Cloud");
        Deck.add("Cloud");
        Deck.add("Cloud");
        Deck.add("Cloud");
        Deck.add("Cloud");
        Deck.add("Mushroom");
        Deck.add("Mushroom");
        Deck.add("Mushroom");
        Deck.add("Mushroom");
        Deck.add("Mushroom");
        Deck.add("Mushroom");
        Deck.add("FireFlower");
        Deck.add("FireFlower");
        Deck.add("FireFlower");
        Deck.add("FireFlower");
        Deck.add("FireFlower");
        Deck.add("FireFlower");
        Deck.add("Luigi");
        Deck.add("Luigi");
        Deck.add("Luigi");
        Deck.add("Luigi");
        Deck.add("Luigi");
        Deck.add("Luigi");
        Deck.add("Mario");
        Deck.add("Mario");
        Deck.add("Mario");
        Deck.add("Mario");
        Deck.add("Mario");
        Deck.add("Mario");
        Deck.add("Star");
        Deck.add("Star");
        Deck.add("Star");
        Deck.add("Star");
        Deck.add("Star");
        Deck.add("Star");
    }
     */
    void pCardRandomizer() { //Chooses Random cards for the player and assures no overlap
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

    void pSuitCount() { //uses the random numbers from pCardRandomizer to add to the players counter and update the proper image
        for (int i = 0; i < 5; i++) {
            if (PC[i] == 1 || PC[i] == 2 || PC[i] == 3 || PC[i] == 4 || PC[i] == 5 || PC[i] == 6) {
                pCloudCount++;
                pCardImg[i].setImage(new Image(getClass().getResource("/Cloud.png").toString()));
            } else if (PC[i] == 7 || PC[i] == 8 || PC[i] == 9 || PC[i] == 10 || PC[i] == 11 || PC[i] == 12) {
                pMushroomCount++;
                pCardImg[i].setImage(new Image(getClass().getResource("/Mushroom.png").toString()));
            } else if (PC[i] == 13 || PC[i] == 14 || PC[i] == 15 || PC[i] == 16 || PC[i] == 17 || PC[i] == 18) {
                pFireFlowerCount++;
                pCardImg[i].setImage(new Image(getClass().getResource("/FireFlower.png").toString()));
            } else if (PC[i] == 19 || PC[i] == 20 || PC[i] == 21 || PC[i] == 22 || PC[i] == 23 || PC[i] == 24) {
                pLuigiCount++;
                pCardImg[i].setImage(new Image(getClass().getResource("/Luigi.png").toString()));
            } else if (PC[i] == 25 || PC[i] == 26 || PC[i] == 27 || PC[i] == 28 || PC[i] == 29 || PC[i] == 30) {
                pMarioCount++;
                pCardImg[i].setImage(new Image(getClass().getResource("/Mario.png").toString()));
            } else if (PC[i] == 31 || PC[i] == 32 || PC[i] == 33 || PC[i] == 34 || PC[i] == 35 || PC[i] == 36) {
                pStarCount++;
                pCardImg[i].setImage(new Image(getClass().getResource("/Star.png").toString()));
            }
        }
    }

    void luigiHandRandomizer() {
        luigiHandCalc = ThreadLocalRandom.current().nextInt(1, 100 + 1); //Percentage based randomizer for the dealers hand type
        if (luigiHandCalc <= 100 && luigiHandCalc >= 96) { //Five kind, 5%
            luigiHand = 7;
            luigiHighWeight = 5;

            luigiHighCalc();

        } else if (luigiHandCalc <= 95 && luigiHandCalc >= 86) { //Four kind, 10%
            luigiHand = 6;
            luigiHighWeight = 4;

            luigiHighCalc();

        } else if (luigiHandCalc <= 85 && luigiHandCalc >= 71) { //Full house, 15%
            luigiHand = 5; //point system for luigi's hand type to compare to players later
            luigiHighWeight = 3; //point system for luigi's high suit quantity to use for finding an available suit that has enough cards
            luigiLowWeight = 2;//point system for luigi's low suit quantity to use for finding an available suit that has enough cards

            luigiHighCalc();
            luigiLowCalc();

        } else if (luigiHandCalc <= 70 && luigiHandCalc >= 41) { //Three kind, 30%
            luigiHand = 4;
            luigiHighWeight = 3;

            luigiHighCalc();

        } else if (luigiHandCalc <= 40 && luigiHandCalc >= 11) { //Two pairs, 30%
            luigiHand = 3;
            luigiHighWeight = 2;
            luigiLowWeight = 2;

            luigiHighCalc();
            luigiLowCalc();

        } else if (luigiHandCalc <= 10 && luigiHandCalc >= 1) { //One pair, 10%
            luigiHand = 2;
            luigiHighWeight = 2;

            luigiHighCalc();

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

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        ImageView picArray[] = {imgPlayerC1, imgPlayerC2, imgPlayerC3, imgPlayerC4, imgPlayerC5};//Image array
        pCardImg = picArray; //Transfer the array to top
        //Opening ,method start
        pCardRandomizer();
        pSuitCount();

    }

}
