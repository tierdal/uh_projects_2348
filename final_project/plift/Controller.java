//https://stackoverflow.com/questions/25037724/how-to-close-a-java-window-with-a-button-click-javafx-project
//https://o7planning.org/en/11533/opening-a-new-window-in-javafx

package plift;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class Controller {


    @FXML
    public Button start_button;

    @FXML
    public void setStart_button_action() throws IOException{
        Stage stage = (Stage) start_button.getScene().getWindow();
        stage.hide();
        Stage secondaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("mainapp.fxml"));
        secondaryStage.setTitle("plift - Lifting Calculator");
        secondaryStage.setScene(new Scene(root, 600, 575));
        secondaryStage.show();
    }
}
