//https://stackoverflow.com/questions/25037724/how-to-close-a-java-window-with-a-button-click-javafx-project
//https://o7planning.org/en/11533/opening-a-new-window-in-javafx
//http://www.sqlitetutorial.net/sqlite-java/insert/
//https://www.mkyong.com/java/java-convert-string-to-int/

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.awt.*;
import java.io.IOException;

public class Controller {


    @FXML public Button start_button;

    @FXML public void setStart_button_action() throws IOException{
        Stage stage = (Stage) start_button.getScene().getWindow();
        stage.hide();
        Stage secondaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("mainapp.fxml"));
        secondaryStage.setTitle("plift - Lifting Calculator");
        secondaryStage.setScene(new Scene(root, 1200, 600));
        secondaryStage.show();
    }

    @FXML public Button btn_adduser_submit;
    @FXML public TextArea field_adduser_name;
    @FXML public TextArea field_adduser_age;
    @FXML public TextArea field_adduser_gender;
    @FXML public TextArea field_adduser_weight;

    @FXML public void btn_adduser_submit_action(){
        Stage stage = (Stage) btn_adduser_submit.getScene().getWindow();
        submit_user();
        stage.hide();
    }

    private Connection connect_db() {
        // SQLite connection string
        String url = "jdbc:sqlite:plift_db.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    @FXML public void submit_user(){
        String field_adduser_name_value = field_adduser_name.getText();
        int field_adduser_age_value = Integer.parseInt(field_adduser_age.getText());
        String field_adduser_gender_value = field_adduser_gender.getText();
        double field_adduser_weight_value = Double.parseDouble(field_adduser_weight.getText());
        String sql = "INSERT INTO users(name,age,gender,weight) VALUES(?,?,?,?)";
        try (Connection conn = this.connect_db();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, field_adduser_name_value);
            pstmt.setInt(2, field_adduser_age_value);;
            pstmt.setString(3, field_adduser_gender_value);;
            pstmt.setDouble(4, field_adduser_weight_value);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
