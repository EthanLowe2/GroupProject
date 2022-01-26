package lowe.groupproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class StartDuckController implements Initializable {
    @FXML
    private TextField txtTime;
    
    @FXML
    private Label lblMoney;
    
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
    void btnX(ActionEvent event) throws IOException {
        MainApp.setRoot("Rules");
    }
    @FXML
    void btncontunie(ActionEvent event) throws IOException {
        int time = Integer.parseInt(txtTime.getText());
        
        if (time >=5 && MainApp.money > time){
            int newtime = Integer.parseInt(txtTime.getText());
            MainApp.money = MainApp.money - newtime;
            MainApp.DuckTime = newtime;        
            MainApp.setRoot("Duck");
        }
        if (time <5){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("You must buy at least 5 seconds");
            alert.showAndWait();
        }
        if (MainApp.money <time){
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("You do not have enough coins");
            alert.showAndWait();
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lblMoney.setText("" + MainApp.money);
    }    
    
}
