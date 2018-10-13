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
import java.sql.Time;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author shubham
 */
public class BorrowForm {
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

    public GridPane getGpborrow() {
        return gpborrow;
    }

    public void setGpborrow(GridPane gpborrow) {
        this.gpborrow = gpborrow;
    }

    public Button getButton1() {
        return button1;
    }

    public void setButton1(Button button1) {
        this.button1 = button1;
    }

    public Label getButton() {
        return button;
    }

    public void setButton(Label button) {
        this.button = button;
    }

    public Label getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Label student_id) {
        this.student_id = student_id;
    }

    public Label getBook_id() {
        return book_id;
    }

    public void setBook_id(Label book_id) {
        this.book_id = book_id;
    }

    public TextField getStudentid() {
        return studentid;
    }

    public void setStudentid(TextField studentid) {
        this.studentid = studentid;
    }

    public TextField getBookid() {
        return bookid;
    }

    public void setBookid(TextField bookid) {
        this.bookid = bookid;
    }

    public HBox getHb() {
        return hb;
    }

    public void setHb(HBox hb) {
        this.hb = hb;
    }
    
    
    
        GridPane gpborrow;
        Button button1;
        Label button;
        Label student_id;
        Label book_id;
        TextField studentid;
        TextField bookid;
        HBox hb;
        
        public BorrowForm() throws SQLException, ClassNotFoundException{
            
            button1 = new Button("Borrow");
            button =new Label("Borrow book");
            student_id = new Label("Student ID");
            book_id = new Label("Book ID");
            studentid = new TextField();
            bookid = new TextField();
            
        TableView t = new TableView();
        Database d = new Database();
        Connection con = d.openConnection();
        ObservableList<Borrow> borrowarray = Borrow.getborrow(con);
        
        
        TableColumn <Integer,Borrow> tid = new TableColumn("id");
        tid.setCellValueFactory(new PropertyValueFactory("id"));
        
        TableColumn <Integer,Borrow> tstudent = new TableColumn("student_id");
        tstudent.setCellValueFactory(new PropertyValueFactory("s_id"));
        
        TableColumn <Integer,Borrow> tbook = new TableColumn("book_id");
        tbook.setCellValueFactory(new PropertyValueFactory("b_id"));
        
        
        TableColumn <Timestamp,Borrow> tborrow = new TableColumn("borrowed on");
        tborrow.setCellValueFactory(new PropertyValueFactory("borrow"));
        
        
        t.setItems(borrowarray);
        t.getColumns().addAll(tid,tstudent,tbook,tborrow);
        t.setPrefSize(350,300);
            
            
            gpborrow= new GridPane();
        
            gpborrow.add(button,2,1);
            gpborrow.add(student_id, 2, 2);
            gpborrow.add(studentid, 3, 2);
            gpborrow.add(book_id, 2, 3);
            gpborrow.add(bookid, 3, 3);
            gpborrow.add(button1, 2, 4);
           
            
            hb = new HBox(gpborrow,t);
            hb.setSpacing(20);
            gpborrow.setHgap(10);
            gpborrow.setVgap(10);
            gpborrow.setAlignment(Pos.CENTER);
            
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
                    borrow.insertborrow(con);
                    
                    showAlert();
                    
                    con.close();
                } 
            }
                catch (SQLException ex) {
                    Logger.getLogger(StudentForm.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (ClassNotFoundException ex) {
                    Logger.getLogger(StudentForm.class.getName()).log(Level.SEVERE, null, ex);
                }
}   
             
            
        });
        }
        
    
    
}
