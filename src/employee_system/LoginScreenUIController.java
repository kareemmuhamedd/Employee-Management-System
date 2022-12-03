/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee_system;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Kareem_Muhamed
 */
public class LoginScreenUIController implements Initializable {
    
    @FXML
    Label dbCon;
    @FXML
    TextField username;
    @FXML
    TextField password;
    @FXML
    Label check;

    /**
     * Initializes the controller class.
     */
    
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
        for(Admins a:list){
            map.put(a.getUsername(), a.getPassword()); // key,value
        }
        
        if(map.containsKey(username.getText())){
            
            String val2 = map.get(username.getText());
            
            if(val2.equals(password.getText())){
                check.setText("Success");
                AdminsDB.getConnection();
                Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("Control Panel.fxml"));
                Scene secne = new Scene(root,1224,831);
                primaryStage.setScene(secne);
                primaryStage.show();
                
            }
            else{
                check.setText("Failed try again");
            }
            
        }else{
                check.setText("Failed try again");
            }
    }
     
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
