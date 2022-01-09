package lowe.groupproject;
/*
Ethan lowe
01/08/22
end screen
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FXMLController implements Initializable {
    
    @FXML
    void btnNo(ActionEvent event) throws IOException {
        MainApp.setRoot("StartDcukController");
    }

    @FXML
    void btnYes(ActionEvent event) {
        System.exit(0); //change to move to the title screen not exit :)
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
