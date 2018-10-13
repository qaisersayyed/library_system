/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



/**
 *
 * @author qaiser
 */
public class Student {

    public int id;

    public String name;
    public String phone;
    public String email;

    public Student(String name,String email, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email =email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
//Student s = new StudentForm();
public static ObservableList<Student> getstudent(Connection con) throws SQLException{
    ObservableList studentArray = FXCollections.observableArrayList();
    String sql = "select * from student;";
    PreparedStatement ps =con.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while (rs.next()){
        int id = rs.getInt(1);
        String name = rs.getString(2);
        String email = rs.getString(3);
        String phone = rs.getString(4);
        Student s = new Student(name,email,phone);
        studentArray.add(s);
        
       // studentArray.add(name,emailphone);
        
    }
    rs.close();
    ps.close();
    //return (ObservableList<Student>) studentArray;
    return studentArray;
    }

    

}
