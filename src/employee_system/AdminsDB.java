
package employee_system;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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
       // i created list to get all users from sql and put all in it
       List<Admins> list = new ArrayList<Admins>();
       try {
           String sql = "SELECT * FROM `user` WHERE 1";
           Connection con = AdminsDB.getConnection();
           PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
           // this line read the values from database that i was make connection to get 
           ResultSet resultSet = preparedStatement.executeQuery();
           
           // loop to add all valuse that i was get from database in my list i was created
           while(resultSet.next()){
               Admins adm = new Admins();
               adm.setId(resultSet.getInt(1));
               adm.setUsername(resultSet.getString(2));
               adm.setPassword(resultSet.getString(3));
               list.add(adm);
           }
           con.close();
       } catch (SQLException e) {
           System.out.println("Error in Connection");
       }
       return list;
       /*
       this function it will return  list like this
       
       1 kareem 123
       2 momo 1234
       3 user 8798
       
       */
   }
   
   public static int signUp(Admins adm){
       int st = 0;
       try {
           String sql = "INSERT INTO `user` (`username`, `password`) VALUES (?,?) ";
           Connection con = AdminsDB.getConnection();
           PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
           preparedStatement.setString(1, adm.getUsername());
           preparedStatement.setString(2, adm.getPassword());
            st = preparedStatement.executeUpdate(); // 0 error 1 no error all is good
            con.close();
       } catch (Exception e) {
           System.out.println("sorry i fail to insert in your database check your code !!!");
       }
       return st;
   }
   
   
}
