/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import Database.Book;
import Database.Database;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author shubham
 */
public class BookForm {
    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
 
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("successfully Registered");
 
        alert.showAndWait();
    }
     
    private void formalert(){
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
 
        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Please Fill All The Details");
 
        alert.showAndWait();
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

    public Label getIsbn() {
        return isbn;
    }

    public void setIsbn(Label isbn) {
        this.isbn = isbn;
    }

    public Label getAuthor() {
        return author;
    }

    public void setAuthor(Label author) {
        this.author = author;
    }

    public Label getPublisher() {
        return publisher;
    }

    public void setPublisher(Label publisher) {
        this.publisher = publisher;
    }

    public TextField getName1() {
        return name1;
    }

    public void setName1(TextField name1) {
        this.name1 = name1;
    }

    public TextField getIsbn1() {
        return isbn1;
    }

    public void setIsbn1(TextField isbn1) {
        this.isbn1 = isbn1;
    }

    public TextField getAuthor1() {
        return author1;
    }

    public void setAuthor1(TextField author1) {
        this.author1 = author1;
    }

    public TextField getPublisher1() {
        return publisher1;
    }

    public void setPublisher1(TextField publisher1) {
        this.publisher1 = publisher1;
    }
    
    public GridPane getGpb() {
        return gpb;
    }

    public void setGpb(GridPane gpb) {
        this.gpb = gpb;
    }

    public HBox getHb() {
        return hb;
    }

    public void setHb(HBox hb) {
        this.hb = hb;
    }
   
        GridPane gpb;
        Button button1;
        Label nameplate;
        Label name;
        Label isbn;
        Label author;
        Label publisher;
        TextField name1;
        TextField isbn1;
        TextField author1;
        TextField publisher1;
        HBox hb;

    
    
  public BookForm() throws ClassNotFoundException, SQLException{
        
        button1 = new Button("Submit");
        nameplate =new Label("ADD BOOK");
        name = new Label("Name");
        isbn = new Label("isbn");
        author = new Label("author");
        publisher = new Label("publisher");
        name1 = new TextField();
        isbn1 = new TextField();
        author1 = new TextField();
        publisher1 = new TextField();
        
        //Table
        TableView t = new TableView();
        Database d = new Database();
        Connection con = d.openConnection();
        ObservableList<Book> bookarray = Book.Getbook(con);
        
        TableColumn <String,Book> bname = new TableColumn("Name");
        bname.setCellValueFactory(new PropertyValueFactory("name"));
        
        TableColumn <String,Book> bisbn = new TableColumn("ISBN");
        bisbn.setCellValueFactory(new PropertyValueFactory("isbn"));
        
        TableColumn <Integer,Book> bauthor = new TableColumn("Author");
        bauthor.setCellValueFactory(new PropertyValueFactory("author"));
        
        TableColumn <Integer,Book> bpublisher = new TableColumn("Publisher");
        bpublisher.setCellValueFactory(new PropertyValueFactory("publisher"));
        
        t.setItems(bookarray);
        t.getColumns().addAll(bname,bisbn,bauthor,bpublisher);
        t.setPrefSize(350,300);
   

        gpb= new GridPane();
        
        gpb.add(nameplate,2,1);
        gpb.add(name, 2, 2);
        gpb.add(name1, 3, 2);
        gpb.add(isbn, 2, 3);
        gpb.add(isbn1, 3, 3);
        gpb.add(author, 2, 4);
        gpb.add(author1, 3, 4);
        gpb.add(publisher, 2, 5);
        gpb.add(publisher1,3,5);
        gpb.add(button1,2,6);
        
        hb = new HBox(gpb,t);
        hb.setSpacing(20);
       

        gpb.setHgap(10);
        gpb.setVgap(10);
     //   gpb.setAlignment(Pos.CENTER);
        //gp.setPadding(new Insets(40, 40, 40, 40));
        //Scene gpscene = new Scene(gridPane,500,300);
       
        
        
       
        button1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    
                    if(name1.getText().isEmpty() || isbn1.getText().isEmpty() || author1.getText().isEmpty() || publisher1.getText().isEmpty()) {
                        formalert();
       }
                    
                    else{
                    String name = name1.getText();
                    String isbn = isbn1.getText();
                    String author = author1.getText();
                    String publisher = publisher1.getText();
                    
                    
                    
                    Database d = new Database();
                    Connection con = d.openConnection();
                    Book book = new Book(name,isbn,author,publisher);
                    book.insertbook(con);
                    
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







