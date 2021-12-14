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
    private ImageView imgPointOrder, imgBetO, imgBetY, imgBoard, imgCoin1, imgCoin2, imgCoin3, imgCoin4, imgCoin5, imgDraw, imgHold, imgPlayerC1, imgPlayerC2, imgPlayerC3, imgPlayerC4, imgPlayerC5, imgLuigiC1, imgLuigiC2, imgLuigiC3, imgLuigiC4, imgLuigiC5;

    @FXML
    private Label lblWallet;

    int pStarCount, pMarioCount, pLuigiCount, pFireFlowerCount, pMushroomCount, pCloudCount;

    int PC[] = new int[5];

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

    void pSuitCount() {
        for (int i = 0; i < 5; i++) {
            if (PC[i] == 0 || PC[i] == 1 || PC[i] == 2 || PC[i] == 3 || PC[i] == 4 || PC[i] == 5) {
                pCloudCount++;
                pCardImg[i].setImage(new Image(getClass().getResource("/Cloud.png").toString()));
            } else if (PC[i] == 6 || PC[i] == 7 || PC[i] == 8 || PC[i] == 9 || PC[i] == 10 || PC[i] == 11) {
                pMushroomCount++;
                pCardImg[i].setImage(new Image(getClass().getResource("/Mushroom.png").toString()));
            } else if (PC[i] == 12 || PC[i] == 13 || PC[i] == 14 || PC[i] == 15 || PC[i] == 16 || PC[i] == 17) {
                pFireFlowerCount++;
                pCardImg[i].setImage(new Image(getClass().getResource("/FireFlower.png").toString()));
            } else if (PC[i] == 18 || PC[i] == 19 || PC[i] == 20 || PC[i] == 21 || PC[i] == 22 || PC[i] == 23) {
                pLuigiCount++;
                pCardImg[i].setImage(new Image(getClass().getResource("/Luigi.png").toString()));
            } else if (PC[i] == 24 || PC[i] == 25 || PC[i] == 26 || PC[i] == 27 || PC[i] == 28 || PC[i] == 29) {
                pMarioCount++;
                pCardImg[i].setImage(new Image(getClass().getResource("/Mario.png").toString()));
            } else if (PC[i] == 30 || PC[i] == 31 || PC[i] == 32 || PC[i] == 33 || PC[i] == 34 || PC[i] == 35) {
                pStarCount++;
                pCardImg[i].setImage(new Image(getClass().getResource("/Star.png").toString()));
            }
        }
    }
/*
    void deckClear() {
        Deck.clear();
    }
*/

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImageView picArray[] = {imgPlayerC1, imgPlayerC2, imgPlayerC3, imgPlayerC4, imgPlayerC5};//Image array
        pCardImg = picArray; //Transfer the array to top
        //Opening ,method start
        pCardRandomizer();
        pSuitCount();

    }

}
