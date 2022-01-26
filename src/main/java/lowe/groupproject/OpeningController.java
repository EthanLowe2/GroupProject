/*
 Opening controller
 */
package lowe.groupproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;


public class OpeningController implements Initializable {
       
    @FXML
    private Button btnEnter;
    
    MediaPlayer player;
    
    void theme() {
        // Plays main theme 
        
        
          MediaPlayer player;
        player = new MediaPlayer((new Media(getClass().getResource("/Opening.mp3").toString())));
        player.play(); 
        player.setAutoPlay(true);
        MediaView view = new MediaView(player);
        player.play();
        

    }
    
    @FXML
    void enterClick(ActionEvent event) throws IOException {
      
        
        MainApp.setRoot("rules","Galaxy Casino");
        
    }


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        theme();
    }    
    
}
