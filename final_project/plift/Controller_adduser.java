package plift;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import java.sql.*;

public class Controller_adduser {

    @FXML public Button btn_adduser_submit;
    @FXML public Button btn_adduser_cancel;
    @FXML public TextField field_adduser_name;
    @FXML public TextField field_adduser_age;
    @FXML public ComboBox field_adduser_gender;
    @FXML public TextField field_adduser_weight;


    @FXML public void btn_adduser_submit_action(){
        Stage stage = (Stage) btn_adduser_submit.getScene().getWindow();
        System.out.println("Add user button click.");
        submit_user();
        stage.hide();
    }
    @FXML public void btn_adduser_cancel_action(){
        Stage stage = (Stage) btn_adduser_cancel.getScene().getWindow();
        System.out.println("Cancel add user button click.");
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
