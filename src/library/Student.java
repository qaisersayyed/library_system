/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;


import Controller.StudentController;
import Database.Database;
import java.sql.Connection;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author qaiser
 */
public class Student extends Application {
    
    private void showAlert() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Alert");
 
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("successfully Registered");
 
        alert.showAndWait();
    }
     
    private void formalert(){
         Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Alert");
 
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Please Fill All The Details");
 
        alert.showAndWait();
    }
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Student");
        Button button1 = new Button("Submit");
        Label nameplate =new Label("ADD STUDENT");
        Label name = new Label("Name");
        Label email = new Label("Email");
        Label phone = new Label("phone");
        TextField name1 = new TextField();
        TextField email1 = new TextField();
        TextField phone1 = new TextField();
        
     
   

        GridPane gridPane = new GridPane();
        
        gridPane.add(nameplate,2,1);
        gridPane.add(name, 2, 2);
        gridPane.add(name1, 3, 2);
        gridPane.add(email, 2, 3);
        gridPane.add(email1, 3, 3);
        gridPane.add(phone, 2, 4);
        gridPane.add(phone1, 3, 4);
        gridPane.add(button1, 2, 5);
        
       

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
                    
                    if(name1.getText().isEmpty() || email1.getText().isEmpty() || phone1.getText().isEmpty()) {
                        formalert();
       }
                    
                    else{
                    String name = name1.getText();
                    String email = email1.getText();
                    String phone = phone1.getText();
                    
                    
                    
                    Database d = new Database();
                    Connection con = d.openConnection();
                    StudentController stu = new StudentController(name,email,phone);
                    stu.insertstudent(con);
                    
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

