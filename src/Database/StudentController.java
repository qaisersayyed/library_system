/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import library.Student;
import library.StudentTable;

/**
 *
 * @author qaiser
 */
public class StudentController {

    public int id;

    public String name;
    public String phone;
    public String email;

    public StudentController( String name,String email, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email =email;
    }

public void insertstudent(Connection con) throws SQLException {
     String sql ="insert into student values(null,?,?,?);";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1,this.name);
     ps.setString(2, this.email);
     ps.setString(3,this.phone);
     ps.executeUpdate();
     ps.close();

    }
//Student s = new Student();
public static ObservableList getstudent(Connection con) throws SQLException{
    ArrayList studentArray = new ArrayList();
    String sql = "select * from students;";
    PreparedStatement ps =con.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while (rs.next()){
        
        String name = rs.getString(1);
        String email = rs.getString(2);
        String phone = rs.getString(3);
        
       // studentArray.add(name,emailphone);
        
    }
    rs.close();
    ps.close();
    return (ObservableList<Student>) studentArray;
    
    }

}
