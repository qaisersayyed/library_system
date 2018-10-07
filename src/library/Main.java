/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;
import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.*; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.scene.control.*; 
import javafx.stage.Stage; 
import javafx.scene.control.Alert.AlertType; 
import java.time.LocalDate; 
import java.util.logging.Level;
import java.util.logging.Logger;
import library.Student;
/**
 *
 * @author qaiser
 */
public class Main extends  Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        // create a menu 
        Menu menu = new Menu("Students"); 
        Menu menu2 = new Menu("Books");
        Menu menu3 = new Menu("Borrow");
        Menu menu4 = new Menu("Return");
  
        // create menuitems 
        MenuItem m1 = new MenuItem("Add Student"); 
        MenuItem m2 = new MenuItem("View Students");
        MenuItem m3 = new MenuItem("Add Books");
        MenuItem m4 = new MenuItem("View Books");
        MenuItem m5 = new MenuItem("Borrow Book");
        MenuItem m6 = new MenuItem("View Borrowed Books");
        MenuItem m7 = new MenuItem("View Returned Books");
        MenuItem m8 = new MenuItem("View Book");
        
        
        
  
        // add menu items to menu 
        menu.getItems().add(m1); 
        menu.getItems().add(m2); 
        
        menu2.getItems().add(m3);
        menu2.getItems().add(m4);
        
        menu3.getItems().add(m5);
        menu3.getItems().add(m6);
        
        menu4.getItems().add(m7);
        menu4.getItems().add(m8);
  
  
        // create events for menu items 
       m1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                    System.out.println("clicked");
                   
            }
       });
    
    
       
  
        // create a menubar 
        MenuBar mb = new MenuBar(); 
  
        // add menu to menubar 
        mb.getMenus().add(menu);
        mb.getMenus().add(menu2);
        mb.getMenus().add(menu3);
        mb.getMenus().add(menu4);

        // create a scene 
        Scene sc = new Scene(mb, 500, 300); 
  
        // set the scene 
        stage.setScene(sc); 
  
        stage.show(); 
    } 
     public static void main(String args[]) 
    { 
        // launch the application 
        launch(args); 
    } 
    }
   

