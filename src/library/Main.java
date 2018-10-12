/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.layout.*; 
import javafx.scene.control.*; 
import javafx.stage.Stage; 

import static javafx.application.Application.launch;
/**
 *
 * @author qaiser
 */
public class Main extends Application {
    
    
      @Override
    public void start(Stage primaryStage) throws Exception {
        
        TabPane tp = new TabPane();
        Tab tab1 = new Tab();
        Tab tab2 = new Tab();
        Tab tab3 = new Tab();
        Tab tab4 = new Tab();
        
        tab1.setText("Student");
        tab2.setText("Books");
        tab3.setText("Borrow");
        tab4.setText("Return");
        
        
        
        tp.getTabs().add(tab1);
        tp.getTabs().add(tab2);
        tp.getTabs().add(tab3);
        tp.getTabs().add(tab4);
       
        
        
        Student ss = new Student();
        GridPane gridPane = ss.getGp();
        
        //Label test = new Label("testtt");
        tab1.setContent(gridPane);
        // create a scene 
     //   Scene s = new Scene(gridPane, 500, 300);
       Scene sc = new Scene(tp, 500, 300); 
  
        // set the scene 
        primaryStage.setScene(sc); 
  
        primaryStage.show(); 
        
  }
    public static void main(String[] args) {
        launch(args);
    }
    
}
