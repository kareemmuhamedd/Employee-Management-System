/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee_system;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Kareem_Muhamed
 */
public class ViewEmpController implements Initializable {
    @FXML
    private TableView<Employee> table;
    @FXML
    private TableColumn<Employee,Integer> id;
    @FXML
    private TableColumn<Employee,String> fname;
    @FXML
    private TableColumn<Employee,String> lname;
    @FXML
    private TableColumn<Employee,Float> salary;
    @FXML
    private TableColumn<Employee,Integer> age;
    @FXML
    private TableColumn<Employee,String> department;
    @FXML
    private TableColumn<Employee,String> address;
    @FXML
    private TableColumn<Employee,String> date_of_birth;
    public ObservableList<Employee> data = FXCollections.observableArrayList();
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            String sql = "SELECT * FROM `emp` WHERE 1";
            Connection con = DBinfo.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                // i use the constructor that i was created in class Employee
                data.add(new Employee(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getFloat(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8)));
            }
            con.close();
        } catch (SQLException e) {
        }
        
        id.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("id"));
        fname.setCellValueFactory(new PropertyValueFactory<Employee,String>("fname"));
        lname.setCellValueFactory(new PropertyValueFactory<Employee,String>("lname"));
        salary.setCellValueFactory(new PropertyValueFactory<Employee,Float>("salary"));
        age.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("age"));
        department.setCellValueFactory(new PropertyValueFactory<Employee,String>("department"));
        address.setCellValueFactory(new PropertyValueFactory<Employee,String>("address"));
        date_of_birth.setCellValueFactory(new PropertyValueFactory<Employee,String>("date_of_birth"));
        table.setItems(data); // to show data that i was add to ObservableList
        
    }    
    
}
