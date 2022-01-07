package lowe.groupproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class StartDuckController implements Initializable {
    @FXML
    private TextField txtTime;

    @FXML
    void btnDown(ActionEvent event) {
    try {
        int newnumber = Integer.parseInt(txtTime.getText());
        txtTime.setText("" + (newnumber - 1));
    } catch (Exception ex) {
    }
    }

    @FXML
    void btnUp(ActionEvent event) {
    try {
        int newnumber = Integer.parseInt(txtTime.getText());
        txtTime.setText("" + (newnumber + 1));
    } catch (Exception ex) {
    }
    }
    
    @FXML
    void btncontunie(ActionEvent event) throws IOException {
        MainApp.setRoot("Duck");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
