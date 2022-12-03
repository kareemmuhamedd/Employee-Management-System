/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee_system;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Kareem_Muhamed
 */
public class UpdateDeleteController implements Initializable {

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
    TextField date;
    @FXML
    TextField age;
    @FXML
    TextField address;
     @FXML
    TextField id;
     
     
     public void getEmployeeById(ActionEvent e)throws IOException,ParseException{
         
         String sid = id.getText();
         int id = Integer.parseInt(sid);
         Employee emp = DBinfo.getEmployeeId(id);
         
         fname.setText(emp.getFname());
         lname.setText(emp.getLname());
         salary.setText(String.valueOf(emp.getSalary()));
         age.setText(String.valueOf(emp.getAge()));
         department.setText(emp.getDepartment());
         address.setText(emp.getAddress());
         natio.setText(emp.getNationality());
         gender.setText(emp.getGeder());
         education.setText(emp.getEducation());
         moth.setText(emp.getMother_language());
         oth.setText(emp.getOther_language());
         date.setText(emp.getDate_of_birth());
         exp.setText(emp.getExperience());
         
    }
     
     public void uPdateEmployee(ActionEvent e)throws IOException,ParseException{
         String sid = id.getText();
         int id = Integer.parseInt(sid);
         
        String firstName = fname.getText();
        String lastName = lname.getText();
        float textSalary = Float.parseFloat(salary.getText());
        int textAge = Integer.parseInt(age.getText());
        String textDepartment = department.getText();
        String textAddress = address.getText();
        String textNationality = natio.getText();
        String textGender = gender.getText();
        String textEducation = education.getText();
        String textExperience = exp.getText();
        String motherLanguage = moth.getText();
        String otherLanguage = oth.getText();
        String birth = date.getText();
        
        
        Employee emp = new Employee();
               emp.setId(id);
               emp.setFname(firstName);
               emp.setLname(lastName);
               emp.setSalary(textSalary);
               emp.setAge(textAge);
               emp.setDepartment(textDepartment);
               emp.setAddress(textAddress);
               emp.setDate_of_birth(birth);
               emp.setGeder(textGender);
               emp.setEducation(textEducation);
               emp.setExperience(textExperience);
               emp.setNationality(textNationality);
               emp.setMother_language(motherLanguage);
               emp.setOther_language(otherLanguage);
               
               int status = DBinfo.update(emp);
               if(status>0){ // like bool true or false
                   Alert alert = new Alert(AlertType.INFORMATION);
                   alert.setTitle("Data Update");
                   alert.setHeaderText("Information Dialog");
                   alert.setContentText("Record Updated successfully");
                   alert.showAndWait();
                   System.out.println("Record Updated successfully");
               }else{
                   Alert alert = new Alert(AlertType.ERROR);
                   alert.setTitle("Data Update");
                   alert.setHeaderText("ERROR Dialog");
                   alert.setContentText("Sorry! unable to Update record");
                   alert.showAndWait();
                   System.out.println("Sorry! unable to Update record");
               }
     }
     
     
     public void deleteEmployee(ActionEvent e)throws IOException,ParseException{
         
         String sid = id.getText();
         int id = Integer.parseInt(sid);
         int status = DBinfo.delete(id);
         if(status>0){
              Alert alert = new Alert(AlertType.INFORMATION);
              alert.setTitle("Data Delete");
              alert.setHeaderText("Information Dialog");
              alert.setContentText("Record Deleted successfully");
              alert.showAndWait();
              System.out.println("Record Deleted successfully");
         }else{
              Alert alert = new Alert(AlertType.ERROR);
              alert.setTitle("Data Delete");
              alert.setHeaderText("ERROR Dialog");
              alert.setContentText("Sorry! unable to Delete record");
              alert.showAndWait();
              System.out.println("Sorry! unable to Delete record");
         }
     }
     
     
     
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
