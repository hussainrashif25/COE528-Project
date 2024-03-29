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
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.application.Platform;
import java.util.Timer;
import java.util.TimerTask;

public class test extends Application {

    @Override
    public void start(Stage stage) {
        
        //Customer Window
        GridPane c = new GridPane();
        c.setAlignment(Pos.CENTER);
        c.setHgap(10);
        c.setVgap(10);
        c.setPadding(new Insets(25, 25, 25, 25));
        Scene customerScene = new Scene(c, 640, 480);
        
        //Manager Window
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
        Scene scene = new Scene(container, 640, 480);
        
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
                try {   
                    
                    String u = userinput.getText();
                    String p = passinput.getText();
                    manager admin = new manager(u,p);

                    //Goto Manager Window
                    if (admin.auth() == true) {


                        //Title
                        Text mtitle = new Text("Hello Manager");
                        m.add(mtitle, 0, 0);

                        //Buttons
                        Button addCust = new Button("Add");
                        Button delCust = new Button("Delete");
                        Button logout = new Button("Logout");
                        VBox mbuttons = new VBox(10);
                        mbuttons.setAlignment(Pos.CENTER);
                        mbuttons.getChildren().add(addCust);
                        mbuttons.getChildren().add(delCust);
                        mbuttons.getChildren().add(logout);
                        m.add(mbuttons, 1, 0);

                        //New User Label
                        Label newuserlabel = new Label("USERNAME:");
                        m.add(newuserlabel, 2, 0);
                        Label newpasslabel = new Label("PASSWORD:");
                        m.add(newpasslabel, 3, 0);
                        Label moneylabel = new Label("MONEY:");
                        m.add(moneylabel, 4, 0);

                        //New User TextFields
                        TextField newuser = new TextField();
                        m.add(newuser, 2, 1);
                        TextField newpass = new TextField();
                        m.add(newpass, 3, 1);
                        TextField money = new TextField();
                        m.add(money, 4, 1);
                        
                        //Event: add customer
                        addCust.setOnMouseClicked((new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                String cuser = newuser.getText();
                                String cpass = newpass.getText();
                                String cmoney = money.getText();

                                admin.addCustomer(cuser, cpass, cmoney);
                            }
                        }));
                        
                        //Event: delete customer
                        delCust.setOnMouseClicked((new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                String cuser = newuser.getText();
                                String cpass = newpass.getText();


                                admin.delCustomer(cuser, cpass);
                            }
                        }));

                        //Event: Logout
                        logout.setOnMouseClicked((new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                stage.setScene(scene);
                            }

                        }));

                        stage.setScene(manageScene);
                    }
                    customerauth user = new customerauth(u,p);
                    //Goto customer Window
                    if (user.custauth() == true) {
                        
                        //Title
                        Text mtitle = new Text("Hello "+ u);
                        c.add(mtitle, 0, 0);
                        
                        
                        //Current Balance & Rewards
                        Text rewards = new Text(user.getTier());
                        Text balance = new Text("Your balance: " + user.getBalance());
                        c.add(rewards,0 , 1);
                        c.add(balance, 0, 2);
                        
                        //Buttons
                        Button withdraw = new Button("Withdraw");
                        Button deposit = new Button("Deposit");
                        Button logout = new Button("Logout");
                        Button online = new Button("Online");
                        Button refresh = new Button("Get Balance");
                        VBox mbuttons = new VBox(10);
                        mbuttons.setAlignment(Pos.CENTER);
                        mbuttons.getChildren().add(withdraw);
                        mbuttons.getChildren().add(deposit);
                        mbuttons.getChildren().add(logout);
                        mbuttons.getChildren().add(online);
                        mbuttons.getChildren().add(refresh);
                        c.add(mbuttons, 1, 0);
                        
                        //Label: Amount of Money
                        Label amount = new Label("Amount:");
                        c.add(amount, 2, 0);
                        
                        //TextField: amount of money
                        TextField amountText = new TextField();
                        c.add(amountText, 2, 1);
                        
                        //Event: Online
                        online.setOnMouseClicked((new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                               try {
                                    String m = amountText.getText();
                                    int money = Integer.parseInt(m);
                                    user.makePurchase(money);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                } 
                               /* GridPane o = new GridPane();
                                Stage stage = new Stage();
                                stage.setTitle("Online Purchase");
                                stage.setScene(new Scene(o, 480, 480));
                                
                                
                                
                                
                                stage.show();*/
                            }
                        }));
                        
                        //Event: Get Balance
                        refresh.setOnMouseClicked((new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                try {
                                    balance.setText("Your new balance: " + user.getBalance());
                                    rewards.setText(user.getTier());
                                } catch (Exception e)  {
                                    e.printStackTrace();
                                }
                            }
                        }));
                        
                        //Event: Logout
                        logout.setOnMouseClicked((new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                stage.setScene(scene);
                            }
                        }));
                        
                        //Event: Withdraw
                        withdraw.setOnMouseClicked((new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                try {
                                    String m = amountText.getText();
                                    int money = Integer.parseInt(m);
                                    user.withdraw(money);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }));
                        
                        //Event: Deposit
                        deposit.setOnMouseClicked((new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                try {
                                    String m = amountText.getText();
                                    int money = Integer.parseInt(m);
                                    user.deposit(money);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }));
                        
                        stage.setScene(customerScene);
                        
                    } 
                    else{
                        System.out.println("ay lmaoo");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }));

        
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}