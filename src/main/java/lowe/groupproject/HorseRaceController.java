/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package lowe.groupproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ehenr
 */
public class HorseRaceController implements Initializable {
    @FXML
    private ImageView Horse1,Horse2,Horse3,Horse4,Horse5;

    @FXML
    private Button btnSitout;

    Timeline horsemove = new Timeline(new KeyFrame(Duration.millis(50), ae -> moveHorse()));
    
    void moveHorse(){
        
    }
    
    @FXML        
    void btnHorse(MouseEvent event) {

    }

    @FXML
    void btnSitOutA(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
