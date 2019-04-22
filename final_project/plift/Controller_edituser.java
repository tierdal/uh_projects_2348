package plift;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class Controller_edituser {

    @FXML public Button btn_edituser_submit;
    @FXML public Button btn_edituser_cancel;
    @FXML public TextField field_edituser_name;
    @FXML public TextField field_edituser_age;
    @FXML public ComboBox field_edituser_gender;
    @FXML public TextField field_edituser_weight;

    public String mainapp_name_edituser;
    public String field_edituser_name_value_original;

    @FXML public void btn_edituser_submit_action(){
        Stage stage = (Stage) btn_edituser_submit.getScene().getWindow();
        update_user();
        stage.hide();
    }
    @FXML public void btn_edituser_cancel_action(){
        Stage stage = (Stage) btn_edituser_cancel.getScene().getWindow();
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

    @FXML public void update_user(){

        String field_edituser_name_value = field_edituser_name.getText();
        int field_edituser_age_value = Integer.parseInt(field_edituser_age.getText());
        String field_edituser_gender_value = String.valueOf(field_edituser_gender.getValue());
        double field_edituser_weight_value = Double.parseDouble(field_edituser_weight.getText());

        Connection conn = this.connect_db();

        try {
            String sql = "UPDATE users SET name='"+field_edituser_name_value+"',age="+field_edituser_age_value+",gender='"+field_edituser_gender_value+"',weight="+field_edituser_weight_value+" WHERE name='"+field_edituser_name_value_original+"'";
            PreparedStatement ps_conn = conn.prepareStatement(sql);
            ps_conn.executeUpdate();
            conn.commit();
            ps_conn.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML private void initialize() {
    }

    @FXML public void edituser_pulldata(){

        Connection conn = this.connect_db();

        field_edituser_name.setText(mainapp_name_edituser);
        field_edituser_name_value_original = mainapp_name_edituser;

        try {
            ResultSet result_set;
            String sql_age = "SELECT age FROM users WHERE name='" + mainapp_name_edituser + "'";
            String sql_gender = "SELECT gender FROM users WHERE name='" + mainapp_name_edituser + "'";
            String sql_weight = "SELECT weight FROM users WHERE name='" + mainapp_name_edituser + "'";
            result_set = conn.createStatement().executeQuery(sql_age);
            field_edituser_age.setText(result_set.getString("age"));
            result_set = conn.createStatement().executeQuery(sql_gender);
            field_edituser_gender.setValue(result_set.getString("gender"));
            result_set = conn.createStatement().executeQuery(sql_weight);
            field_edituser_weight.setText(result_set.getString("weight"));
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

    public void setMainapp_name_edituser(String mainapp_name){
        this.mainapp_name_edituser = mainapp_name;
    }

}
