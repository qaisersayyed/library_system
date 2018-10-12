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
import static javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE;
import static javafx.application.Application.launch;
import javafx.scene.paint.Color;
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
        
        tab1.setText("      Student     ");
        tab2.setText("      Books       ");
        tab3.setText("      Borrow      ");
        tab4.setText("      Return      ");
        
        
        
        tp.getTabs().add(tab1);
        tp.getTabs().add(tab2);
        tp.getTabs().add(tab3);
        tp.getTabs().add(tab4);
       
        
        
        StudentForm s = new StudentForm();
        HBox studenthb = s.getHb();
        
        BookForm b = new BookForm();
        HBox bookhb = b.getHb();
        
        BorrowForm bf = new BorrowForm();
        GridPane borrowgp = bf.getGpborrow();
        
        ReturnForm rf = new ReturnForm();
        GridPane returngp = rf.getGpreturn();
        
        
        tab1.setContent(studenthb);
        tab2.setContent(bookhb);
        tab3.setContent(borrowgp);
        tab4.setContent(returngp);
       
       Scene sc = new Scene(tp, 700,240,Color.DARKGRAY); 

       primaryStage.setTitle("LIBRARY-Qaiser_Shubham");
       tp.setTabClosingPolicy(UNAVAILABLE);
      
        primaryStage.setScene(sc); 
  
        primaryStage.show(); 
        
  }
    public static void main(String[] args) {
        launch(args);
    }
    
}
