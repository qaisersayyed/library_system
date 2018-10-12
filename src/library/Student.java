/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;


import Database.Database;
import Database.StudentController;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 *
 * @author qaiser
 */
public class Student{

    
    
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

    public GridPane getGp() {
        return gp;
    }

    public void setGp(GridPane gp) {
        this.gp = gp;
    }

  
    public Button getButton1() {
        return button1;
    }

    public void setButton1(Button button1) {
        this.button1 = button1;
    }

    public Button getButton2() {
        return button2;
    }

    public void setButton2(Button button2) {
        this.button2 = button2;
    }

    public Label getNameplate() {
        return nameplate;
    }

    public void setNameplate(Label nameplate) {
        this.nameplate = nameplate;
    }

    public Label getName() {
        return name;
    }

    public void setName(Label name) {
        this.name = name;
    }

    public Label getEmail() {
        return email;
    }

    public void setEmail(Label email) {
        this.email = email;
    }

    public Label getPhone() {
        return phone;
    }

    public void setPhone(Label phone) {
        this.phone = phone;
    }

    public TextField getName1() {
        return name1;
    }

    public void setName1(TextField name1) {
        this.name1 = name1;
    }

    public TextField getEmail1() {
        return email1;
    }

    public void setEmail1(TextField email1) {
        this.email1 = email1;
    }

    public TextField getPhone1() {
        return phone1;
    }

    public void setPhone1(TextField phone1) {
        this.phone1 = phone1;
    }
    
    GridPane gp;
    Button button1 ;
    Button button2 ;
    Label nameplate;
    Label name;
    Label email;
    Label phone;
    TextField name1;
    TextField email1;
    TextField phone1;
                     
    public Student(){
       
        
        Button button1 = new Button("Submit");
        Button button2 = new Button("Display Student");
        Label nameplate =new Label("ADD STUDENT");
        Label name = new Label("Name");
        Label email = new Label("Email");
        Label phone = new Label("phone");
        TextField name1 = new TextField();
        TextField email1 = new TextField();
        TextField phone1 = new TextField();
        
     
        

        gp = new GridPane();
        
        gp.add(nameplate,2,1);
        gp.add(name, 2, 2);
        gp.add(name1, 3, 2);
        gp.add(email, 2, 3);
        gp.add(email1, 3, 3);
        gp.add(phone, 2, 4);
        gp.add(phone1, 3, 4);
        gp.add(button1, 2, 5);
        gp.add(button2, 3, 5);
        
        
       

        gp.setHgap(10);
        gp.setVgap(10);
        gp.setAlignment(Pos.CENTER_LEFT);
        //gridPane.setPadding(new Insets(40, 40, 40, 40));
   //   Scene gpscene = new Scene(gridPane,500,300);
       //test
     
   
        
        button2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                StudentTable table = new StudentTable();
            }
            
        });
       
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
   
}

