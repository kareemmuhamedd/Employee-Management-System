
package employee_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kareem_Muhamed
 */
public class DBinfo {
   static String username = "root";
   static String password = "";
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
   
   public static int save(Employee emp) {
       int st = 0;
       try {
            String sql = "INSERT INTO `emp` (`fname`, `name`, `salary`, `age`, `department`, `address`, `date of birth`, `gender`, `education`, `experience`, `nationality`, `mother language`, `other language`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) ";
            Connection con = DBinfo.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
            preparedStatement.setString(1, emp.getFname());
            preparedStatement.setString(2, emp.getLname());
            preparedStatement.setFloat(3, emp.getSalary());
            preparedStatement.setInt(4, emp.getAge());
            preparedStatement.setString(5, emp.getDepartment());
            preparedStatement.setString(6, emp.getAddress());
            preparedStatement.setString(7, emp.getDate_of_birth());
            preparedStatement.setString(8, emp.getGeder());
            preparedStatement.setString(9, emp.getEducation());
            preparedStatement.setString(10, emp.getExperience());
            preparedStatement.setString(11, emp.getNationality());
            preparedStatement.setString(12, emp.getMother_language());
            preparedStatement.setString(13, emp.getOther_language());
            st = preparedStatement.executeUpdate();
            con.close();
       } catch (SQLException e) {
       }
       return st;
   }
   public static int update(Employee emp){
       int st = 0;
       try {
            String sql = "UPDATE `emp` SET `fname`=?,`name`=?,`salary`=?,`age`=?,`department`=?,`address`=?,`date of birth`=?,`gender`=?,`education`=?,`experience`=?,`nationality`=?,`mother language`=?,`other language`=? WHERE id=?";
            Connection con = DBinfo.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
            preparedStatement.setString(1, emp.getFname());
            preparedStatement.setString(2, emp.getLname());
            preparedStatement.setFloat(3, emp.getSalary());
            preparedStatement.setInt(4, emp.getAge());
            preparedStatement.setString(5, emp.getDepartment());
            preparedStatement.setString(6, emp.getAddress());
            preparedStatement.setString(7, emp.getDate_of_birth());
            preparedStatement.setString(8, emp.getGeder());
            preparedStatement.setString(9, emp.getEducation());
            preparedStatement.setString(10, emp.getExperience());
            preparedStatement.setString(11, emp.getNationality());
            preparedStatement.setString(12, emp.getMother_language());
            preparedStatement.setString(13, emp.getOther_language());
            preparedStatement.setInt(14, emp.getId());
            st = preparedStatement.executeUpdate();
            con.close();
       } catch (SQLException e) {
       }
       return st;
   }
   public static int delete(int id){
       int st = 0;
       try {
           String sql = "DELETE FROM `emp` WHERE id=?";
           Connection con = DBinfo.getConnection();
           PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
           preparedStatement.setInt(1,id);
           st = preparedStatement.executeUpdate();
           con.close();
       } catch (SQLException e) {
       }
       return st;
   }
   public static Employee getEmployeeId(int id){
       Employee emp = new Employee();
       try {
           String sql = "SELECT * FROM `emp` WHERE id=?";
           Connection con = DBinfo.getConnection();
           PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
           preparedStatement.setInt(1,id);
           ResultSet resultSet = preparedStatement.executeQuery();
           if(resultSet.next()){
               emp.setId(resultSet.getInt(1));
               emp.setFname(resultSet.getString(2));
               emp.setLname(resultSet.getString(3));
               emp.setSalary(resultSet.getFloat(4));
               emp.setAge(resultSet.getInt(5));
               emp.setDepartment(resultSet.getString(6));
               emp.setAddress(resultSet.getString(7));
               emp.setDate_of_birth(resultSet.getString(8));
               emp.setGeder(resultSet.getString(9));
               emp.setEducation(resultSet.getString(10));
               emp.setExperience(resultSet.getString(11));
               emp.setNationality(resultSet.getString(12));
               emp.setMother_language(resultSet.getString(13));
               emp.setOther_language(resultSet.getString(14));
           }
           con.close();
       } catch (SQLException e) {
       }
       return emp;
   }
   public static List<Employee> getEmployee(){
       List<Employee> list = new ArrayList<Employee>();
       try {
           String sql = "SELECT * FROM `emp` WHERE 1";
           Connection con = DBinfo.getConnection();
           PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
           ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next()){
               Employee emp = new Employee();
               emp.setId(resultSet.getInt(1));
               emp.setFname(resultSet.getString(2));
               emp.setLname(resultSet.getString(3));
               emp.setSalary(resultSet.getFloat(4));
               emp.setAge(resultSet.getInt(5));
               emp.setDepartment(resultSet.getString(6));
               emp.setAddress(resultSet.getString(7));
               emp.setDate_of_birth(resultSet.getString(8));
               emp.setGeder(resultSet.getString(9));
               emp.setEducation(resultSet.getString(10));
               emp.setExperience(resultSet.getString(11));
               emp.setNationality(resultSet.getString(12));
               emp.setMother_language(resultSet.getString(13));
               emp.setOther_language(resultSet.getString(14));
               list.add(emp);
           }
       } catch (SQLException e) {
       }
       return list;
   }
}

