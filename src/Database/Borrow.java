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
import java.sql.Time;
import java.sql.Timestamp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static sun.rmi.transport.TransportConstants.Return;

/**
 *
 * @author shubham
 */
public class Borrow {
    
    public int s_id;
    public int b_id;
    public int id;
    public Timestamp borrow;
    public Timestamp returned;
    
    
    public Borrow(int s_id,int b_id){
        this.s_id=s_id;
        this.b_id=b_id;
        this.id=id;
        
    }
    public Borrow(int id,int s_id,int b_id,Timestamp borrow){
        this.s_id=s_id;
        this.b_id=b_id;
        this.id=id;
        this.borrow=borrow;
        
        
    }
    
    public void insertborrow(Connection con) throws SQLException {
     String sql ="insert into borrow (student_id,book_id) values(?,?);";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1,this.s_id);
     ps.setInt(2, this.b_id);
    // ps.setInt(3, this.status);
     ps.executeUpdate();
     ps.close();

    }
    public void insertreturn(Connection con) throws SQLException {
     String sql ="update borrow set status=2 where student_id=? and book_id=? and status=1;";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1,this.s_id);
     ps.setInt(2, this.b_id);
    // ps.setInt(3, this.status);
     ps.executeUpdate();
     ps.close();

    }
    
    public static ObservableList<Borrow> getborrow(Connection con) throws SQLException{
    ObservableList borrowArray = FXCollections.observableArrayList();
    String sql = "select * from borrow where status=1;";
    PreparedStatement ps =con.prepareStatement(sql);
    ResultSet rs1 = ps.executeQuery();
    while (rs1.next()){
        int id = rs1.getInt(1);
        int student_id = rs1.getInt(2);
        int book_id = rs1.getInt(3);
        Timestamp borrowed_on = rs1.getTimestamp(4);
        String returned_on = rs1.getString(5);
        Borrow b = new Borrow(id,student_id,book_id,borrowed_on);
        borrowArray.add(b);
        
       
        
    }
    rs1.close();
    ps.close();
    
    return borrowArray;
    }
    
    public static ObservableList<Borrow> getreturn(Connection con) throws SQLException{
    ObservableList returnArray = FXCollections.observableArrayList();
    String sql = "select * from borrow where status=2;";
    PreparedStatement ps =con.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    while (rs.next()){
        int id = rs.getInt(1);
        int student_id = rs.getInt(2);
        int book_id = rs.getInt(3);
        Timestamp returned_on = rs.getTimestamp(5);
        Borrow b = new Borrow(id,student_id,book_id,returned_on);
        returnArray.add(b);
        
       
        
    }
    rs.close();
    ps.close();
    
    return returnArray;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
