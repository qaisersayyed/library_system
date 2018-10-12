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
public class Borrow {
    
    public int s_id;
    public int b_id;

    public Borrow(int s_id,int b_id){
        this.s_id=s_id;
        this.b_id=b_id;
        
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
    
    
}
