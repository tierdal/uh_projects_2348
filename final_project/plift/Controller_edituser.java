//https://stackoverflow.com/questions/25037724/how-to-close-a-java-window-with-a-button-click-javafx-project
//https://o7planning.org/en/11533/opening-a-new-window-in-javafx
//http://www.sqlitetutorial.net/sqlite-java/insert/
//https://www.mkyong.com/java/java-convert-string-to-int/
//https://stackoverflow.com/questions/18361195/javafx-how-to-load-populate-values-at-start-up
//http://www.tutorialspoint.com/sqlite/sqlite_java.htm
//https://stackoverflow.com/questions/52085575/populating-the-combobox-from-database

package plift;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller_edituser {

    @FXML public Button btn_edituser_submit;
    @FXML public Button btn_edituser_cancel;
    @FXML public TextField field_edituser_name;
    @FXML public TextField field_edituser_age;
    @FXML public ComboBox field_edituser_gender;
    @FXML public TextField field_edituser_weight;

    @FXML public void btn_edituser_submit_action(){
        Stage stage = (Stage) btn_edituser_submit.getScene().getWindow();
        submit_user();
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

    @FXML public void submit_user(){
        Statement ps_conn;

        String field_edituser_name_value = field_edituser_name.getText();
        int field_edituser_age_value = Integer.parseInt(field_edituser_age.getText());
        String field_edituser_gender_value = String.valueOf(field_edituser_gender.getValue());
        double field_edituser_weight_value = Double.parseDouble(field_edituser_weight.getText());

        Connection conn = this.connect_db();

        try {
            ps_conn = conn.createStatement();
            String sql = "INSERT INTO users(name,age,gender,weight) VALUES('"+field_edituser_name_value+"',"+field_edituser_age_value+",'"+field_edituser_gender_value+"',"+field_edituser_weight_value+")";
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
