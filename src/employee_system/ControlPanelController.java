/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee_system;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kareem_Muhamed
 */
public class ControlPanelController implements Initializable {

     GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
     int width = gd.getDisplayMode().getWidth();
     int height = gd.getDisplayMode().getHeight();
     
     
    public void entred(Event e){
        ((Button)e.getSource()).setScaleX(1.1);
        ((Button)e.getSource()).setScaleY(1.1);
    }
    public void exited(Event e){
        ((Button)e.getSource()).setScaleX(1);
        ((Button)e.getSource()).setScaleY(1); 
    }
    public void viewEmployee(ActionEvent e) throws IOException{
         Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("ViewEmp.fxml"));
                Scene secne = new Scene(root,width,height-60);
                primaryStage.setScene(secne);
                primaryStage.show();
    }
    
    
    public void insertEmployee(ActionEvent e) throws IOException{
         Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("InsertEmp.fxml"));
                Scene secne = new Scene(root,width,height-60);
                primaryStage.setScene(secne);
                primaryStage.show();
    }
    
    
    public void UpdateDeleteEmployee(ActionEvent e) throws IOException{
         Stage primaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("UpdateDelete.fxml"));
                Scene secne = new Scene(root,width,height-60);
                primaryStage.setScene(secne);
                primaryStage.show();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
