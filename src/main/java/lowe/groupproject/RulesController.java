/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lowe.groupproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    void btnDuckA(ActionEvent event) {
        imgDuck.setVisible(false);
        imgHorse.setVisible(false);
        imgLuigi.setVisible(false);
        btnLuigi.setVisible(false);
        btnHorse.setVisible(false);
        btnDuck.setVisible(false);
    }

    @FXML
    void btnHorseA(ActionEvent event) {
        imgDuck.setVisible(false);
        imgHorse.setVisible(false);
        imgLuigi.setVisible(false);
        btnLuigi.setVisible(false);
        btnHorse.setVisible(false);
        btnDuck.setVisible(false);
    }

    @FXML
    void btnLuigiA(ActionEvent event) {
        imgDuck.setVisible(false);
        imgHorse.setVisible(false);
        imgLuigi.setVisible(false);
        btnLuigi.setVisible(false);
        btnHorse.setVisible(false);
        btnDuck.setVisible(false);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
