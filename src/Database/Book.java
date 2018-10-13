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
 * @author shubham
 */
public class Book {
    
    public String name;
    public String isbn;
    public String author;
    public String publisher;

    public Book(String name, String isbn, String author,String publisher) {
        this.name = name;
        this.isbn= isbn;
        this.author = author;
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
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
public static ObservableList<Book> Getbook(Connection con) throws SQLException{
    ObservableList bookArray = FXCollections.observableArrayList();
    String sql = "select * from book;";
    PreparedStatement ps =con.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while (rs.next()){
        int id = rs.getInt(1);
        String name = rs.getString(2);
        String isbn = rs.getString(3);
        String author = rs.getString(4);
        String publisher = rs.getString(5);
        Book s = new Book(name,isbn,author,publisher);
        bookArray.add(s);
        
       // studentArray.add(name,emailphone);
        
    }
    rs.close();
    ps.close();
    //return (ObservableList<Student>) studentArray;
    return bookArray;
}
}

