/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee_system;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author Kareem_Muhamed
 */
public class LoginScreenUIController implements Initializable {
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
     int width = gd.getDisplayMode().getWidth();
     int height = gd.getDisplayMode().getHeight();
    
    @FXML
    Label dbCon;
    @FXML
    TextField username;
    @FXML
    TextField password;
    @FXML
    TextField newu;
    @FXML
    TextField newp;
    @FXML
    Label check;

    public void entred(Event e){
        ((Button)e.getSource()).setScaleX(1.1);
        ((Button)e.getSource()).setScaleY(1.1);
    }
    public void exited(Event e){
        ((Button)e.getSource()).setScaleX(1);
        ((Button)e.getSource()).setScaleY(1); 
    }
    
    public void statusDB(ActionEvent e)throws IOException,SQLException{
        if(!AdminsDB.getConnection().isClosed()){
            dbCon.setText("Connected");
        }else{
            dbCon.setText("Not Connected");
        }
    }
    
    
    
    public void enter(ActionEvent e)throws IOException,SQLException{
        
        List<Admins> list = AdminsDB.getAdmins(); // from mysql 
        Map<String,String> map = new HashMap<String,String>();
        // in this loop i put all valuse that i was get from database in my map
        for(Admins a:list){
            map.put(a.getUsername(), a.getPassword()); // key,value
        }
        // look username->key        password->value
        
        if(map.containsKey(username.getText())){
            
            String val2 = map.get(username.getText());
            
            if(val2.equals(password.getText())){
                //check.setText("Success");
                AdminsDB.getConnection();
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("Control Panel.fxml"));
                Scene secne = new Scene(root,width,height-60);
                primaryStage.setScene(secne);
                primaryStage.show();
                
            }
            else{
                //check.setText("Failed try again");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                   alert.setTitle("Login");
                   alert.setHeaderText("Information Dialog");
                   alert.setContentText("Make Sure the Login Name and Password Are Correct");
                   alert.showAndWait();
                   System.out.println("Record saved successfully");
            }
            
        }else{
                //check.setText("Failed try again");
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
                   alert.setTitle("Login");
                   alert.setHeaderText("Information Dialog");
                   alert.setContentText("Make Sure the Login Name and Password Are Correct");
                   alert.showAndWait();
                   System.out.println("Make Sure the Login Name and Password Are Correct");
            }
    }
    
    

        public void signUp(ActionEvent e)throws IOException{
        String name = newu.getText();
        String pass = newp.getText();
        Admins adm = new Admins();
        adm.setUsername(name);
        adm.setPassword(pass);
        int status = AdminsDB.signUp(adm);
        if(status>0){
                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                   alert.setTitle("Sign Up");
                   alert.setHeaderText("Information Dialog");
                   alert.setContentText("Signed Up successfully");
                   alert.showAndWait();
               }else{
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Sign Up");
                   alert.setHeaderText("ERROR");
                   alert.setContentText("Sorry! Can't Create New Account");
                   alert.showAndWait();
               }
    }
   
    
    
     
     
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
