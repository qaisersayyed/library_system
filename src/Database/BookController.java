/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author shubham
 */
public class BookController {
    
    public String name;
    public String isbn;
    public String author;
    public String publisher;

    public BookController(String name, String isbn, String author,String publisher) {
        this.name = name;
        this.isbn= isbn;
        this.author = author;
        this.publisher = publisher;
    }

public void insertbook(Connection con) throws SQLException {
     String sql ="insert into book values(null,?,?,?,?);";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1,this.name);
     ps.setString(2, this.isbn);
     ps.setString(3,this.author);
     ps.setString(4,this.publisher);
     ps.executeUpdate();
     ps.close();

    }
}

