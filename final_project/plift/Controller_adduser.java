//https://stackoverflow.com/questions/25037724/how-to-close-a-java-window-with-a-button-click-javafx-project
//https://o7planning.org/en/11533/opening-a-new-window-in-javafx
//http://www.sqlitetutorial.net/sqlite-java/insert/
//https://www.mkyong.com/java/java-convert-string-to-int/
//https://stackoverflow.com/questions/18361195/javafx-how-to-load-populate-values-at-start-up
//http://www.tutorialspoint.com/sqlite/sqlite_java.htm
//https://stackoverflow.com/questions/52085575/populating-the-combobox-from-database

package plift;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import java.sql.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.collections.FXCollections;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;

public class Controller_adduser {

    @FXML public Button btn_adduser_submit;
    @FXML public Button btn_adduser_cancel;
    @FXML public TextField field_adduser_name;
    @FXML public TextField field_adduser_age;
    @FXML public ComboBox field_adduser_gender;
    @FXML public TextField field_adduser_weight;

    @FXML public void btn_adduser_submit_action(){
        Stage stage = (Stage) btn_adduser_submit.getScene().getWindow();
        submit_user();
        stage.hide();
    }
    @FXML public void btn_adduser_cancel_action(){
        Stage stage = (Stage) btn_adduser_cancel.getScene().getWindow();
        stage.hide();
    }

    private Connection connect_db() {
        // SQLite connection string
        String url = "jdbc:sqlite:final_project/plift/plift_db.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            System.out.println("Opened database successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    @FXML public void submit_user(){
        Statement ps_conn;

        String field_adduser_name_value = field_adduser_name.getText();
        int field_adduser_age_value = Integer.parseInt(field_adduser_age.getText());
        String field_adduser_gender_value = String.valueOf(field_adduser_gender.getValue());
        double field_adduser_weight_value = Double.parseDouble(field_adduser_weight.getText());

        Connection conn = this.connect_db();

        try {
            ps_conn = conn.createStatement();
            String sql = "INSERT INTO users(name,age,gender,weight) VALUES('"+field_adduser_name_value+"',"+field_adduser_age_value+",'"+field_adduser_gender_value+"',"+field_adduser_weight_value+")";
            ps_conn.executeUpdate(sql);
            ps_conn.close();
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML private void initialize() {
    }

}
