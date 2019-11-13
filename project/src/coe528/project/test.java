/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

  
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class test extends Application {

    @Override
    public void start(Stage stage) {
        
        
        //New window for manager 
        GridPane m = new GridPane();
        m.setAlignment(Pos.CENTER);
        m.setHgap(10);
        m.setVgap(10);
        m.setPadding(new Insets(25, 25, 25, 25));
        Scene manageScene = new Scene(m, 640, 480);
        //Startup window
        GridPane container = new GridPane();
        container.setAlignment(Pos.CENTER);
        container.setHgap(10);
        container.setVgap(10);
        container.setPadding(new Insets(25, 25, 25, 25));
        
        //Welcome Text
        Text Welcome = new Text("Welcome to Royal Bank of Rashif");
        container.add(Welcome, 0, 0, 2, 1);
        
        Label user = new Label("Username:");
        container.add(user, 0, 1);
        //Input for user
        TextField userinput = new TextField();
        container.add(userinput, 1, 1);
        
        Label pass = new Label("Password:");
        container.add(pass, 0, 2);
        //Input for pass
        TextField passinput = new TextField();
        container.add(passinput, 1, 2);
        
        Button btn = new Button("Login");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        
        container.add(hbBtn, 1, 4);
        
        btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String u = userinput.getText();
                String p = passinput.getText();
                manager admin = new manager(u,p);
                if (admin.auth() == true) {
                    
                    
                    //Title
                    Text mtitle = new Text("Hello Manager");
                    m.add(mtitle, 0, 0, 2, 1);
                    
                    //Buttons
                    Button addCust = new Button("Add Customer");
                    Button delCust = new Button("Delete Customer");
                    Button logout = new Button("Logout");
                    HBox buttons = new HBox(10);
                    buttons.setAlignment(Pos.TOP_CENTER);
                    buttons.getChildren().add(addCust);
                    buttons.getChildren().add(delCust);
                    buttons.getChildren().add(logout);
                    m.add(buttons, 1, 0);
                    
                    //Textfields
                    TextField newuser = new TextField();
                    m.add(newuser, 2, 1);
                    
                    TextField newpass = new TextField();
                    m.add(newpass, 3, 1);
                    
                    addCust.setOnMouseClicked((new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            String cuser = newuser.getText();
                            String cpass = newpass.getText();
                            
                            admin.addCustomer(cuser, cpass, 0);
                        }
                    
                    }));
    
            
                    stage.setScene(manageScene);
                }
                else {
                    System.out.println("ay lmaoo");
                }
            }
        }));

        
        Scene scene = new Scene(container, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}