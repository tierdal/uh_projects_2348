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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import java.sql.*;

public class Controller_mainapp {

    @FXML public ComboBox<String> combo_mainapp_name;
    @FXML public Button btn_mainapp_adduser;
    @FXML public Label label_mainapp_age;
    @FXML public Label label_mainapp_weight;
    @FXML public Label label_mainapp_gender;


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

    @FXML public void combo_mainapp_name_update(){
        //update user info once combo box changes

        Connection conn = this.connect_db();
        ObservableList<String> combo_options = FXCollections.observableArrayList();

        try {
            ResultSet result_set;
            String return_age, return_weight, return_gender;

            String sql_age = "SELECT age FROM users WHERE name='" + combo_mainapp_name.getValue() + "'";
            String sql_weight = "SELECT weight FROM users WHERE name='" + combo_mainapp_name.getValue() + "'";
            String sql_gender = "SELECT gender FROM users WHERE name='" + combo_mainapp_name.getValue() + "'";
            //ResultSet result_set = conn.createStatement().executeQuery(sql);
            result_set = conn.createStatement().executeQuery(sql_age);
            label_mainapp_age.setText(result_set.getString("age"));
            result_set = conn.createStatement().executeQuery(sql_weight);
            label_mainapp_weight.setText(result_set.getString("weight"));
            result_set = conn.createStatement().executeQuery(sql_gender);
            label_mainapp_gender.setText(result_set.getString("gender"));

            //while (result_set.next()) {
            //    combo_options.add(result_set.getString("name"));
            //}
            //combo_mainapp_name.setItems(combo_options);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

    @FXML
    private void initialize() {
        select_user_list();
    }

    public void select_user_list(){
        Connection conn = this.connect_db();
        ObservableList<String> combo_options = FXCollections.observableArrayList();

        try {
            String sql = "SELECT name FROM users Order By name";
            ResultSet result_set = conn.createStatement().executeQuery(sql);

            while (result_set.next()) {
                combo_options.add(result_set.getString("name"));
            }
            combo_mainapp_name.setItems(combo_options);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

    @FXML public void btn_mainapp_adduser_action() throws IOException{
        Stage adduserStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("form_adduser.fxml"));
        adduserStage.setTitle("plift - Add User");
        adduserStage.setScene(new Scene(root, 300, 200));
        adduserStage.show();
    }

    @FXML public TextField desired_weight;

    @FXML public void setDesired_weight(){
        String w = desired_weight.getText();
        if (w.equals("")) {
            System.out.println("Please enter something!");
        } else {
            System.out.println("You've entered " + w);
            double attemptweight = Double.parseDouble(w);
            class_weightplate setweight = new class_weightplate();
            setweight.SetBarWeights(attemptweight);
        }
    }
}
