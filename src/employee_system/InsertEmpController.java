/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee_system;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


public class InsertEmpController implements Initializable {

    
    @FXML
    TextField salary;
    @FXML
    TextField oth;
    @FXML
    TextField natio;
    @FXML
    TextField moth;
    @FXML
    TextField lname;
    @FXML
    TextField fname;
    @FXML
    TextField gender;
    @FXML
    TextField exp;
    @FXML
    TextField education;
    @FXML
    TextField department;
    @FXML
    DatePicker date;
    @FXML
    TextField age;
    @FXML
    TextField address;
    
    public void insertData(ActionEvent e)throws IOException{
        LocalDate datebirth = date.getValue();
        
        String firstName = fname.getText();
        String lastName = lname.getText();
        String textSalary = salary.getText();
        String textAge = age.getText();
        String textDepartment = department.getText();
        String textAddress = address.getText();
        String textGender = gender.getText();
        String textEducation = education.getText();
        String textExperience = exp.getText();
        String textNationality = natio.getText();
        String motherLanguage = moth.getText();
        String otherLanguage = oth.getText();
        String dateOfBirth = datebirth.toString();
        float fSalary = Float.parseFloat(textSalary);
        int iAge = Integer.parseInt(textAge);
        Employee emp = new Employee();
               emp.setFname(firstName);
               emp.setLname(lastName);
               emp.setSalary(fSalary);
               emp.setAge(iAge);
               emp.setDepartment(textDepartment);
               emp.setAddress(textAddress);
               emp.setDate_of_birth(dateOfBirth);
               emp.setGeder(textGender);
               emp.setEducation(textEducation);
               emp.setExperience(textExperience);
               emp.setNationality(textNationality);
               emp.setMother_language(motherLanguage);
               emp.setOther_language(otherLanguage);
               
               
               int status = DBinfo.save(emp);
               if(status>0){
                   Alert alert = new Alert(AlertType.INFORMATION);
                   alert.setTitle("Data Insert");
                   alert.setHeaderText("Information Dialog");
                   alert.setContentText("Record saved successfully");
                   alert.showAndWait();
                   System.out.println("Record saved successfully");
               }else{
                   Alert alert = new Alert(AlertType.ERROR);
                   alert.setTitle("Data Insert");
                   alert.setHeaderText("ERROR Dialog");
                   alert.setContentText("Sorry! unable to save record");
                   alert.showAndWait();
                   System.out.println("Sorry! unable to save record");
               }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
