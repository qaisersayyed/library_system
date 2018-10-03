/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;


import Controller.Studentform;
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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
     
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Student");

          // Create MenuBar
        MenuBar menuBar = new MenuBar();
        
        // Create menus
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");
        
        // Create MenuItems
        /*MenuItem newItem = new MenuItem("New");
        MenuItem openFileItem = new MenuItem("Open File");
        MenuItem exitItem = new MenuItem("Exit");
        
        MenuItem copyItem = new MenuItem("Copy");
        MenuItem pasteItem = new MenuItem("Paste");
        
        // Add menuItems to the Menus
        fileMenu.getItems().addAll(newItem, openFileItem, exitItem);
        editMenu.getItems().addAll(copyItem, pasteItem);
        */
        
        // Add Menus to the MenuBar
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);
        
        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        Scene scene = new Scene(root, 350, 200);
        
        //primaryStage.setTitle("JavaFX Menu (o7planning.org)");
        primaryStage.setScene(scene);
        primaryStage.show();
        
     

        
      
        
        
        Button button1 = new Button("Submit");
        Label name = new Label("Name");
        Label email = new Label("Email");
        Label phone = new Label("phone");
        TextField name1 = new TextField();
        TextField email1 = new TextField();
        TextField phone1 = new TextField();
        
      
        
        
        button1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    String name = name1.getText();
                    String email = email1.getText();
                    String phone = phone1.getText();
                    
                    
                    
                    Database d = new Database();
                    Connection con = d.openConnection();
                    Studentform stu = new Studentform(name,email,phone);
                    stu.insertstudent(con);
                    
                    showAlert();
                    
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                }
}   
             
         
        });
   

        GridPane gridPane = new GridPane();
 
        gridPane.add(name, 1, 1);
        gridPane.add(name1, 2, 1);
        gridPane.add(email, 1, 2);
        gridPane.add(email1, 2, 2);
        gridPane.add(phone, 1, 3);
        gridPane.add(phone1, 2, 3);
        
        gridPane.add(button1, 1, 4, 1, 1);
        
       

        gridPane.setHgap(10);
        gridPane.setVgap(10);
    //    gridPane.setAlignment(Pos.CENTER);
//        gridPane.setPadding(new Insets(40, 40, 40, 40));
          Scene gpscene = new Scene(gridPane,500,300);
       
        primaryStage.setScene(gpscene);
        primaryStage.show();
       
    }
   
    public static void main (String args[]) throws Exception{
        
        Application.launch(args);
    }
}

