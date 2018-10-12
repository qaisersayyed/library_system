/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import Database.Database;
import Database.Student;
import static com.mysql.jdbc.StringUtils.getBytes;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static com.mysql.jdbc.StringUtils.getBytes;

/**
 *
 * @author qaiser
 */
public class StudentTable extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Database d = new  Database();
        Connection con = d.openConnection();
        Student.getstudent(con);
        ArrayList<Student> s=Student.getstudent(con);
        Label l =new Label("null");
        for (int i=0;i<s.size();i++){
            System.out.println(s.get(i).getName());
            System.out.println(s.get(i).getPhone());
            System.out.println(s.get(i).getEmail());
            
        }
    //Label l =new Label("null");
    //l.setText(name);
    Scene sc = new Scene(l, 500, 300); 
    stage.setScene(sc); 
    stage.show(); 
        
    }
   
public static void main(String[] args) {
        launch(args);
    }
   
}   

