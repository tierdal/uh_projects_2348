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
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.TextField;

import java.sql.*;

public class Controller_mainapp {

    @FXML public ComboBox<String> combo_mainapp_name;
    @FXML public ComboBox<String> combo_mainapp_lifttype;
    @FXML public ComboBox<String> combo_mainapp_attempt;
    @FXML public Button btn_mainapp_adduser;
    @FXML public Button btn_mainapp_edituser;
    @FXML public TextField text_mainapp_desiredweight;
    @FXML public CheckBox checkbox_mainapp_success;
    @FXML public Label label_mainapp_age;
    @FXML public Label label_mainapp_weight;
    @FXML public Label label_mainapp_gender;

    private ObservableList<ObservableList> lift_data;
    @FXML TableView mainapp_tableview;

    public String user_name;
    public String user_gender;
    public String user_age;
    public String user_weight;
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
        user_name = combo_mainapp_name.getValue();
        if (combo_mainapp_name.getValue() == null) {
            System.out.println("No user selected.");
            label_mainapp_age.setText("##");
            label_mainapp_weight.setText("##");
            label_mainapp_gender.setText("##");
        } else {
            try {
                ResultSet result_set;
                String sql_age = "SELECT age FROM users WHERE name='" + user_name + "'";
                String sql_weight = "SELECT weight FROM users WHERE name='" + user_name + "'";
                String sql_gender = "SELECT gender FROM users WHERE name='" + user_name + "'";
                result_set = conn.createStatement().executeQuery(sql_age);
                user_age = result_set.getString("age");
                label_mainapp_age.setText(user_age);
                result_set = conn.createStatement().executeQuery(sql_weight);
                user_weight = result_set.getString("weight");
                label_mainapp_weight.setText(user_weight);
                result_set = conn.createStatement().executeQuery(sql_gender);
                user_gender = result_set.getString("gender");
                label_mainapp_gender.setText(user_gender);
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
        populateDataTable();
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
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error on Building Data");
            }
        }
        select_user_list();
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

    @FXML public void submit_attempt(){
        Statement ps_conn; //user_id

        String field_success = "Nn";
        String field_attemptnumber = String.valueOf(combo_mainapp_attempt.getValue());
        String field_attempttype = String.valueOf(combo_mainapp_lifttype.getValue());
        String field_attemptweight = String.valueOf(text_mainapp_desiredweight.getText());
        Boolean field_success_isselected = checkbox_mainapp_success.isSelected();
        if (field_success_isselected) {field_success = "Yes";}

        Connection conn = this.connect_db();
        try {
            ps_conn = conn.createStatement();
            String sql = "INSERT INTO lifts(user_name,user_gender,user_age,user_weight,attempt_number,attempt_type,attempt_weight,attempt_success) " +
                    "VALUES('"+user_name+"','"+user_gender+"','"+user_age+"',"+user_weight+","+field_attemptnumber+",'"+field_attempttype+"',"+field_attemptweight+",'"+field_success+"')";
            ps_conn.executeUpdate(sql);
            ps_conn.close();
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        combo_mainapp_attempt.setValue("");
        combo_mainapp_lifttype.setValue("");
        text_mainapp_desiredweight.setText("");
        checkbox_mainapp_success.setSelected(false);
    }

    private void populateDataTable() {

        Connection conn = this.connect_db();

        int lift_id;
        int name_id;

        String sql_main = "SELECT * FROM lifts ORDER BY id";
        //String sql_getname = "SELECT name_id FROM lifts WHERE lift_id="+lift_id;

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql_main);
            ResultSet tableValues = preparedStatement.executeQuery();

            while (tableValues.next()) {
                ObservableList<String> rows = FXCollections.observableArrayList();
                for (int counter = 1; counter <= tableValues.getMetaData().getColumnCount(); counter++) {
                    rows.add(tableValues.getString(counter));
                    System.out.println(tableValues.getString(counter));
                }
                //lift_data.add(unique_row);
            }
            //mainapp_tableview.getItems().addAll(lift_data);
            lift_data = null;
            tableValues.close();
            conn.close();
        } catch (SQLException tableQueryException) {
            System.err.println(tableQueryException.toString());
        }
    }

}
