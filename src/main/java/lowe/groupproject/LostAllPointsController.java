/*
 * 
 */
package lowe.groupproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class LostAllPointsController implements Initializable {
    
    @FXML
    void btnEntrance(ActionEvent event) throws IOException {
        MainApp.setRoot("opening"); //change to entrance fxml
    }

    @FXML
    void btnHome(ActionEvent event) {
        System.exit(0);
    }

        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
