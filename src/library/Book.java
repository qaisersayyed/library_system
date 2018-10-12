/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import Controller.BookController;
import Database.StudentController;
import Database.Database;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author shubham
 */
public class Book extends Application {

   private void showAlert() {
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
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Book");
        Button button1 = new Button("Submit");
        Label nameplate =new Label("ADD BOOK");
        Label name = new Label("Name");
        Label isbn = new Label("isbn");
        Label author = new Label("author");
        Label publisher = new Label("publisher");
        TextField name1 = new TextField();
        TextField isbn1 = new TextField();
        TextField author1 = new TextField();
        TextField publisher1 = new TextField();
        
     
   

        GridPane gridPane = new GridPane();
        
        gridPane.add(nameplate,2,1);
        gridPane.add(name, 2, 2);
        gridPane.add(name1, 3, 2);
        gridPane.add(isbn, 2, 3);
        gridPane.add(isbn1, 3, 3);
        gridPane.add(author, 2, 4);
        gridPane.add(author1, 3, 4);
        gridPane.add(publisher, 2, 5);
        gridPane.add(publisher1,3,5);
        gridPane.add(button1,2,6);
        
        
       

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(40, 40, 40, 40));
        Scene gpscene = new Scene(gridPane,500,300);
       
        primaryStage.setScene(gpscene);
        primaryStage.show();
        
        
       
        button1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    
                    if(name1.getText().isEmpty() || isbn1.getText().isEmpty() || author1.getText().isEmpty() || publisher1.getText().isEmpty()) {
                        formalert();
       }
                    
                    else{
                    String name = name1.getText();
                    String isbn = isbn1.getText();
                    String author = author1.getText();
                    String publisher = publisher1.getText();
                    
                    
                    
                    Database d = new Database();
                    Connection con = d.openConnection();
                    BookController book = new BookController(name,isbn,author,publisher);
                    book.insertbook(con);
                    
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
   
    public static void main (String args[]) throws Exception{
        
        Application.launch(args);
    }
}






