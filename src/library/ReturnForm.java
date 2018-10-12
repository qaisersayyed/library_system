/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import Database.Borrow;
import Database.Database;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author shubham
 */
public class ReturnForm {
     public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
 
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("successfully Registered");
 
        alert.showAndWait();
    }
     
    private void formalert(){
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
 
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Please Fill All The Details");
 
        alert.showAndWait();
    }
    
        GridPane gpreturn;
        Button button1;
        Label button;
        Label student_id;
        Label book_id;
        TextField studentid;
        TextField bookid;
    
    public ReturnForm(){
        
        button1 = new Button("Submit");
        button =new Label("ADD Record");
        student_id = new Label("Student ID");
        book_id = new Label("Book ID");
        studentid = new TextField();
        bookid = new TextField();


        gpreturn= new GridPane();

        gpreturn.add(button,2,1);
        gpreturn.add(student_id, 2, 2);
        gpreturn.add(studentid, 3, 2);
        gpreturn.add(book_id, 2, 3);
        gpreturn.add(bookid, 3, 3);
        gpreturn.add(button1, 2, 4);

        gpreturn.setHgap(10);
        gpreturn.setVgap(10);
        gpreturn.setAlignment(Pos.CENTER);
        
          button1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    
                    if(studentid.getText().isEmpty() || bookid.getText().isEmpty()) {
                        formalert();
                }
                    
                    else{
                    String student= null;
                    student=studentid.getText();
                    int s_id;
                    s_id= Integer.parseInt(student);
                    String book= null;
                    book=bookid.getText();
                    int b_id;
                    b_id= Integer.parseInt(book);
                    
                    
                    
                    
                    
                    Database d = new Database();
                    Connection con = d.openConnection();
                    Borrow borrow = new Borrow(s_id,b_id);
                    borrow.insertreturn(con);
                    
                    showAlert();
                    
                    con.close();
                } 
            }
                catch (SQLException ex) {
                    Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (ClassNotFoundException ex) {
                    Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                }
}   
             
            
        });
        }
        
        
    }
