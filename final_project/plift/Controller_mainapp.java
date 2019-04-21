//https://stackoverflow.com/questions/25037724/how-to-close-a-java-window-with-a-button-click-javafx-project
//https://o7planning.org/en/11533/opening-a-new-window-in-javafx
//http://www.sqlitetutorial.net/sqlite-java/insert/
//https://www.mkyong.com/java/java-convert-string-to-int/
//https://stackoverflow.com/questions/18361195/javafx-how-to-load-populate-values-at-start-up
//http://www.tutorialspoint.com/sqlite/sqlite_java.htm
//https://stackoverflow.com/questions/52085575/populating-the-combobox-from-database

package plift;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.scene.control.TextField;

import java.sql.*;

public class Controller_mainapp {

    @FXML public ComboBox<String> combo_mainapp_name;
    @FXML public Button btn_mainapp_adduser;
    @FXML public Button btn_mainapp_edituser;
    @FXML public Label label_mainapp_age;
    @FXML public Label label_mainapp_weight;
    @FXML public Label label_mainapp_gender;


    public String mainapp_name;

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

    @FXML public void update_namelist(){
        select_user_list();
    }

    @FXML public void combo_mainapp_name_update(){
        //update user info once combo box changes

        Connection conn = this.connect_db();
        if (combo_mainapp_name.getValue() == null) {
            System.out.println("No user selected.");
            label_mainapp_age.setText("##");
            label_mainapp_weight.setText("##");
            label_mainapp_gender.setText("##");
        } else {
            try {
                ResultSet result_set;
                String sql_age = "SELECT age FROM users WHERE name='" + combo_mainapp_name.getValue() + "'";
                String sql_weight = "SELECT weight FROM users WHERE name='" + combo_mainapp_name.getValue() + "'";
                String sql_gender = "SELECT gender FROM users WHERE name='" + combo_mainapp_name.getValue() + "'";
                result_set = conn.createStatement().executeQuery(sql_age);
                label_mainapp_age.setText(result_set.getString("age"));
                result_set = conn.createStatement().executeQuery(sql_weight);
                label_mainapp_weight.setText(result_set.getString("weight"));
                result_set = conn.createStatement().executeQuery(sql_gender);
                label_mainapp_gender.setText(result_set.getString("gender"));
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error on Building Data");
            }
        }
    }

    @FXML
    private void initialize() {

        select_user_list();
    }

    public void select_user_list(){
        Connection conn = this.connect_db();
        ObservableList<String> combo_options = FXCollections.observableArrayList();
        combo_mainapp_name.getItems().clear();
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

    @FXML public void btn_mainapp_edituser_action() throws IOException {
        if (combo_mainapp_name.getValue() == null) {
            System.out.println("No user selected.");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cannot edit user!");
            alert.setHeaderText(null);
            alert.setContentText("No user selected!");
            alert.showAndWait();
        } else {
            mainapp_name = combo_mainapp_name.getValue();
            Stage edituserStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("form_edituser.fxml"));
            Parent root = loader.load();
            Controller_edituser edituser = loader.getController();
            edituserStage.setTitle("plift - Edit User");
            edituserStage.setScene(new Scene(root, 300, 200));
            edituser.setMainapp_name_edituser(mainapp_name);
            System.out.println(edituser.mainapp_name_edituser);
            edituser.edituser_pulldata();
            edituserStage.show();
        }
    }

    @FXML public void btn_mainapp_deleteuser_action(){
        if (combo_mainapp_name.getValue() == null) {
            System.out.println("No user selected.");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cannot edit user!");
            alert.setHeaderText(null);
            alert.setContentText("No user selected!");
            alert.showAndWait();
        } else {
            Connection conn = this.connect_db();
            mainapp_name = combo_mainapp_name.getValue();
            try {
                String sql = "DELETE FROM users WHERE name = '" + mainapp_name + "';";//DELETE FROM users WHERE name='test2';
                PreparedStatement sql_statement = conn.prepareStatement(sql);
                sql_statement.executeUpdate();
                conn.commit();
                System.out.println("User Deleted!");
                conn.close();
                select_user_list();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error on Building Data");
            }
        }
    }

    @FXML public TextField desired_weight;

    @FXML public void setDesired_weight(){
        String w = desired_weight.getText();
        class_weightplate setweight = new class_weightplate();
        if (w.equals("")) {
            System.out.println("Please enter something!");
        } else {
            System.out.println("You've entered " + w);
            double attemptweight = Double.parseDouble(w);
            setweight.SetBarWeights(attemptweight);
        }
    }
}
