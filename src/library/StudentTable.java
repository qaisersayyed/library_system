/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author qaiser
 */
public class StudentTable {
   
    JFrame f;    
    StudentTable(){    
    // frame 
    JFrame f; 
    // Table 
    JTable j; 
  
    // Constructor 
   
  
        // Frame initiallization 
        f = new JFrame(); 
  
        // Frame Title 
        f.setTitle("JTable Example"); 
        
        
        // Data to be displayed in the JTable 
        String[][] data = { 
            { "Kundan Kumar Jha", "4031", "CSE" }, 
            { "Anand Jha", "6014", "IT" } 
        }; 
  
        // Column Names 
        String[] columnNames = { "Name", "Roll Number", "Department" }; 
  
        // Initializing the JTable 
        j = new JTable(data, columnNames); 
        j.setBounds(30, 40, 200, 300); 
  
        // adding it to JScrollPane 
        JScrollPane sp = new JScrollPane(j); 
        f.add(sp); 
        // Frame Size 
        f.setSize(500, 200); 
        // Frame Visible = true 
        f.setVisible(true); 
   
}   
public static void main(String[] args) {    
    new StudentTable();    
}    

    public StudentTable(String name, String email, String phone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
