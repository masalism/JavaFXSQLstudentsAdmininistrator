package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML private TableView<Student> table;

    @FXML private TableColumn<Student, Integer> id;

    @FXML private TableColumn<Student, String> name;

    @FXML private TableColumn<Student, String> surname;

    @FXML private TableColumn<Student, String> phone;

    @FXML private TableColumn<Student, String> email;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //createDummyData();

        //sumapinamas
        id.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<Student,String>("surname"));
        phone.setCellValueFactory(new PropertyValueFactory<Student,String>("phone"));
        email.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));

        Connection connection = MyDatabaseConnectionHandler.getConnection();

        if (connection != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Prisijungete sekmingai prie DB");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Neprisijungete!!!");
            alert.show();
        }
    }

    private void pullDataFromDb (Connection connection) {
        if(connection != null){
            try {
                Statement st = connection.createStatement();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //studentu sukurimas ir idejimas
    /*private void createDummyData(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Mantas", "Masalis", "+37067813392", "mantasmasalis@gmail.com"));
        students.add(new Student(2, "Petras", "Bukauskas", "+3543654756", "bukas@gmail.com"));
        ObservableList<Student> mockStudents = FXCollections.observableList(students);
        table.setItems(mockStudents);
    }*/
}
