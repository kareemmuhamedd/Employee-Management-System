/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee_system;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kareem_Muhamed
 */
public class AdminsDB {
   static String username = "root";
   static String password = "";
   //static String con_string = "jdbc:mysql://localhost/emp";
   
   static Connection con = null;
   public static Connection getConnection(){
       try {
           Class.forName("com.mysql.jdbc.Driver");
           String url = "jdbc:mysql://localhost/employee";
           con = DriverManager.getConnection(url, username, password);
           System.out.println("Connected Successfuly");
       } catch (ClassNotFoundException | SQLException e) {
           System.out.println("Connected faile");
       }
       return con;
   }
   
   public static List<Admins> getAdmins(){
       List<Admins> list = new ArrayList<Admins>();
       try {
           String sql = "SELECT * FROM `user` WHERE 1";
           Connection con = AdminsDB.getConnection();
           PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
           ResultSet resultSet = preparedStatement.executeQuery();
           
           while(resultSet.next()){
               Admins adm = new Admins();
               adm.setId(resultSet.getInt(1));
               adm.setUsername(resultSet.getString(2));
               adm.setPassword(resultSet.getString(3));
               list.add(adm);
           }
           con.close();
       } catch (SQLException e) {
       }
       return list;
   }
   
}
