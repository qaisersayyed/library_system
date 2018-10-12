/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import Database.Database;
import Database.StudentController;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author qaiser
 */
public class StudentTable extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Database d = new  Database();
        Connection con = d.openConnection();
        StudentController.getstudent(con);
        ArrayList<StudentController> s=StudentController.getstudent(con);
        for (int i=0;i<s.size();i++){
            System.out.println(s.get(i).getName());
            System.out.println(s.get(i).getPhone());
            System.out.println(s.get(i).getEmail());
        }
        
        
    }
   
public static void main(String[] args) {
        launch(args);
    }
   
}   

