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
import javafx.scene.control.TabPane.TabClosingPolicy;
import static javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE;
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
       
        
        
        Student s = new Student();
        GridPane studentgp = s.getGp();
        
        BookForm b = new BookForm();
        GridPane bookgp = b.getGp();
        
        BorrowForm bf = new BorrowForm();
        GridPane borrowgp = bf.getGpborrow();
        
        tab1.setContent(studentgp);
        tab2.setContent(bookgp);
        tab3.setContent(borrowgp);
       
       Scene sc = new Scene(tp, 500, 300); 
       // tp.tabClosingPolicyProperty(TabClosingPolicy.UNAVAILABLE);
       
        tab1.setOnCloseRequest(e -> e.consume());
        tab2.setOnCloseRequest(e -> e.consume());
        tab3.setOnCloseRequest(e -> e.consume());
        tab4.setOnCloseRequest(e -> e.consume());
        // set the scene 
        primaryStage.setScene(sc); 
  
        primaryStage.show(); 
        
  }
    public static void main(String[] args) {
        launch(args);
    }
    
}
