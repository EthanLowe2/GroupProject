/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lowe.groupproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ethanl82
 */
public class RulesController implements Initializable {

    @FXML
    private ImageView imgDuck;

    @FXML
    private Button btnLuigi;

    @FXML
    private Button btnDuck;

    @FXML
    private Button btnHorse;

    @FXML
    private ImageView imgLuigi;

    @FXML
    private ImageView imgHorse;

    @FXML
    private ImageView imgExplanation;
    @FXML
    private Button btnX;

    @FXML
    private Button btnContinue;

    @FXML
    private ImageView imgExplaneLui;
    
    String Game;

    @FXML
    void btnDuckA(ActionEvent event) {
        Disapeer();
        btnX.setVisible(true);
        imgExplanation.setVisible(true);
        imgExplanation.setImage(new Image(getClass().getResource("/DuckHuntExplane.PNG").toString()));
        Game = "Duck";
    }

    @FXML
    void btnHorseA(ActionEvent event) {
        Disapeer();
        btnX.setVisible(true);
        imgExplanation.setVisible(true);
        imgExplanation.setImage(new Image(getClass().getResource("/HorseRacingRules.PNG").toString()));
        Game = "Horse";
    }

    @FXML
    void btnLuigiA(ActionEvent event) {
        Disapeer();
        btnX.setVisible(true);
        imgExplaneLui.setVisible(true);
        imgExplaneLui.setImage(new Image(getClass().getResource("/LuigiRules.PNG").toString()));
        Game = "Luigi";
    }

    @FXML
    void btnXA(ActionEvent event) {
        imgDuck.setVisible(true);
        imgHorse.setVisible(true);
        imgLuigi.setVisible(true);
        btnLuigi.setVisible(true);
        btnHorse.setVisible(true);
        btnDuck.setVisible(true);
        imgExplanation.setVisible(false);
        btnX.setVisible(false);
        imgExplaneLui.setVisible(false);
    }

    void Disapeer() {
        imgDuck.setVisible(false);
        imgHorse.setVisible(false);
        imgLuigi.setVisible(false);
        btnLuigi.setVisible(false);
        btnHorse.setVisible(false);
        btnDuck.setVisible(false);
    }

    @FXML
    void btnContinueA(ActionEvent event) throws IOException {
        if (Game.equals("Luigi")){
            MainApp.setRoot("luigiPoker");
        }
        if (Game.equals("Horse")){
            MainApp.setRoot("HorseRace");
        }
        if (Game.equals("Duck")){
            MainApp.setRoot("StartDuck");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
