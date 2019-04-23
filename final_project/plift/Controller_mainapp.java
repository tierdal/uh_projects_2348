package plift;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.ResultSet;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import java.sql.*;

public class Controller_mainapp {

    @FXML public ComboBox<String> combo_mainapp_name,combo_mainapp_lifttype,combo_mainapp_attempt;
    @FXML public Button btn_mainapp_adduser,btn_mainapp_edituser;
    @FXML public TextField text_mainapp_desiredweight;
    @FXML public CheckBox checkbox_mainapp_success;
    @FXML public Label label_mainapp_age,label_mainapp_weight,label_mainapp_gender;
    @FXML public TableColumn col_1,col_2,col_3,col_4,col_5,col_6,col_7,col_8,col_9;

    private ObservableList<LiftDataTableModel> lift_data;
    @FXML TableView mainapp_tableview;

    public String user_name,user_gender,user_age,user_weight,mainapp_name;

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

    @FXML private void initialize() {

        col_1.setCellValueFactory(new PropertyValueFactory<LiftDataTableModel,String>("id"));
        col_2.setCellValueFactory(new PropertyValueFactory<LiftDataTableModel,String>("name"));
        col_3.setCellValueFactory(new PropertyValueFactory<LiftDataTableModel,String>("age"));
        col_4.setCellValueFactory(new PropertyValueFactory<LiftDataTableModel,String>("gender"));
        col_5.setCellValueFactory(new PropertyValueFactory<LiftDataTableModel,String>("weight"));
        col_6.setCellValueFactory(new PropertyValueFactory<LiftDataTableModel,String>("atype"));
        col_7.setCellValueFactory(new PropertyValueFactory<LiftDataTableModel,String>("anumber"));
        col_8.setCellValueFactory(new PropertyValueFactory<LiftDataTableModel,String>("aweight"));
        col_9.setCellValueFactory(new PropertyValueFactory<LiftDataTableModel,String>("success"));

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
                String sql = "DELETE FROM users WHERE name = '" + mainapp_name + "';";
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

    @FXML public void setDesired_weight(){
        String w = text_mainapp_desiredweight.getText();
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
        Statement ps_conn;

        String field_success = "No";
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
        populateDataTable();
    }

    private void populateDataTable() {

        Connection conn = this.connect_db();
        lift_data = FXCollections.observableArrayList();

        String sql_main = "SELECT * FROM lifts ORDER BY id";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql_main);
            ResultSet result_set = preparedStatement.executeQuery();
            while (result_set.next()) {
                lift_data.add(new LiftDataTableModel(result_set.getString(1),result_set.getString(2),result_set.getString(3),result_set.getString(4),result_set.getString(5),result_set.getString(6),result_set.getString(7),result_set.getString(8),result_set.getString(9)));
                //System.out.println(lift_data);
            }
            mainapp_tableview.setItems(lift_data);
            //System.out.println(mainapp_tableview.getItems());
            result_set.close();
            conn.close();
        } catch (SQLException tableQueryException) {
            System.err.println(tableQueryException.toString());
        }
    }

    public class LiftDataTableModel{
        private final StringProperty id = new SimpleStringProperty();
        private final StringProperty name = new SimpleStringProperty();
        private final StringProperty gender = new SimpleStringProperty();
        private final StringProperty age = new SimpleStringProperty();
        private final StringProperty weight = new SimpleStringProperty();
        private final StringProperty anumber = new SimpleStringProperty();
        private final StringProperty atype = new SimpleStringProperty();
        private final StringProperty aweight = new SimpleStringProperty();
        private final StringProperty success = new SimpleStringProperty();

        public LiftDataTableModel(String id_i, String name_n, String gender_g, String age_a, String weight_w, String attempt_a, String attempt_type_a, String attempt_weight_a, String success_s){
            id.set(id_i);
            name.set(name_n);
            gender.set(gender_g);
            age.set(age_a);
            weight.set(weight_w);
            anumber.set(attempt_a);
            atype.set(attempt_type_a);
            aweight.set(attempt_weight_a);
            success.set(success_s);
        }

        public String getId() {
            return id.get();
        }

        public StringProperty idProperty() {
            return id;
        }
        public void setId(String id_i){
            id.set(id_i);
        }

        public String getName() {
            return name.get();
        }

        public StringProperty nameProperty() {
            return name;
        }
        public void setName(String name_n){
            name.set(name_n);
        }

        public String getGender() {
            return gender.get();
        }

        public StringProperty genderProperty() {
            return gender;
        }
        public void setGender(String gender_g){
            gender.set(gender_g);
        }

        public String getAge() {
            return age.get();
        }

        public StringProperty ageProperty() {
            return age;
        }
        public void setAge(String age_a){
            gender.set(age_a);
        }

        public String getWeight() {
            return weight.get();
        }

        public StringProperty weightProperty() {
            return weight;
        }
        public void setWeight(String weight_w){
            weight.set(weight_w);
        }

        public String getAnumber() {
            return anumber.get();
        }

        public StringProperty anumberProperty() {
            return anumber;
        }
        public void setAnumber(String attempt_a){
            anumber.set(attempt_a);
        }

        public String getAtype() {
            return atype.get();
        }

        public StringProperty atypeProperty() {
            return atype;
        }
        public void setAtype(String attempt_type_a){
            atype.set(attempt_type_a);
        }

        public String getAweight() {
            return aweight.get();
        }

        public StringProperty aweightProperty() {
            return aweight;
        }
        public void setAweight(String attempt_weight_a){
            aweight.set(attempt_weight_a);
        }

        public String getSuccess() {
            return success.get();
        }

        public StringProperty successProperty() {
            return success;
        }
        public void setSuccess(String success_s){
            success.set(success_s);
        }
    }

}
