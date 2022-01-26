/*
 /*
Name; Gavin Gunn & Ethan Lowe
Class; Grade 12 Com Studies
Date; 26/01/22
Assignment#; Final
Description; group Project/Opening
 */
package lowe.groupproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class OpeningController implements Initializable {

    MediaPlayer player;

    void theme() {
        // Plays main theme 

        MediaPlayer Oplayer;
        Oplayer = new MediaPlayer((new Media(getClass().getResource("/Opening.mp3").toString())));
        Oplayer.play();
        Oplayer.setAutoPlay(true);
        Oplayer.play();

    }

    @FXML
    void enterClick(ActionEvent event) throws IOException { // sends to Game select
        MainApp.money = 50;
        MainApp.setRoot("rules", "Galaxy Casino");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        theme();
    }

}
