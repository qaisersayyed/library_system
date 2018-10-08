/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author qaiser
 */
public class StudentController {

  
    public String name;
    public String phone;
    public String email;

    public StudentController(String email, String name, String phone) {
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
}
