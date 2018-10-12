/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;


import Database.Database;
import Database.Student;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

/**
 *
 * @author qaiser
 */
public class StudentForm{
    
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
    public HBox getHb() {
        return hb;
    }

    public void setHb(HBox hb) {
        this.hb = hb;
    }
    GridPane gp;
    Button button1 ;
    Label nameplate;
    Label name;
    Label email;
    Label phone;
    TextField name1;
    TextField email1;
    TextField phone1;
    HBox hb;

    
                     
    public StudentForm() throws ClassNotFoundException, SQLException{
       
        
        button1 = new Button("Submit");
       
        nameplate =new Label("ADD STUDENT");
        name = new Label("Name");
        email = new Label("Email");
        phone = new Label("phone");
        name1 = new TextField();
        email1 = new TextField();
        phone1 = new TextField();
        
     
        //Table
        TableView t = new TableView();
        Database d = new Database();
        Connection con = d.openConnection();
        ObservableList<Student> studentarray = Student.getstudent(con);
        
        TableColumn <String,Student> tname = new TableColumn("name");
        tname.setCellValueFactory(new PropertyValueFactory("name"));
        
        TableColumn <Integer,Student> temail = new TableColumn("email");
        temail.setCellValueFactory(new PropertyValueFactory("email"));
        
        TableColumn <Integer,Student> tphone = new TableColumn("phone");
        tphone.setCellValueFactory(new PropertyValueFactory("phone"));
        
        t.setItems(studentarray);
        t.getColumns().addAll(tname,temail,tphone);
        t.setPrefSize(350,300);
        
     //   HBox hb= new HBox();
        gp = new GridPane();
        
        gp.add(nameplate,2,1);
        gp.add(name, 2, 2);
        gp.add(name1, 3, 2);
        gp.add(email, 2, 3);
        gp.add(email1, 3, 3);
        gp.add(phone, 2, 4);
        gp.add(phone1, 3, 4);
        gp.add(button1, 2, 5);

       // gp.add(t, 7, 1);
        hb = new HBox(gp,t);
       
        hb.setSpacing(20);
        
        
       

        gp.setHgap(10);
        gp.setVgap(10);
      //gp.setAlignment(Pos.TOP_LEFT);
       
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
                    Student stu = new Student(name,email,phone);
                    stu.insertstudent(con);
                    
                    showAlert();
                    
                    con.close();
                } 
            }
                catch (SQLException ex) {
                    Logger.getLogger(StudentForm.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (ClassNotFoundException ex) {
                    Logger.getLogger(StudentForm.class.getName()).log(Level.SEVERE, null, ex);
                }
}   
             
            
        });
        
        
    }
   
}

