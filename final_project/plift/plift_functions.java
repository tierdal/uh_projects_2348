package plift;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class plift_functions {

    public void load_stage_two() throws Exception{
        Stage secondaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("mainapp.fxml"));
        secondaryStage.setTitle("plift - Lifting Calculator");
        secondaryStage.setScene(new Scene(root, 600, 575));
        secondaryStage.show();
    }
}
