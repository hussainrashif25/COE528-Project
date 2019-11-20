/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.*;
import java.util.Scanner;
/**
 *
 * @author blaze
 */
public class customerauth {
    String username;
    String password;
    String u;
    String p;
    String b;
    String level;
    int amount; 

    public customerauth(String username, String password) throws FileNotFoundException {
        this.username = username;
        this.password = password;
        File file = new File(this.username+".txt");
        Scanner scan = new Scanner(file).useDelimiter("/");
        this.u = scan.next();
        this.p = scan.next();
        this.b = scan.next();
        this.amount = Integer.parseInt(b);
        scan.close();
    }
    
    public String getTier() {
        System.out.println(amount);
        if (amount < 10000) {
            level = "Silver, fee of 20$";
        }
        if(10000 < amount && amount < 20000) {
            level = "Gold, fee if 10$";
        }
        else if (20000 < amount) {
             level = "Platnium, no fee";
        }
        return level;
    }
    
    public void makePurchase(int money) throws IOException {
        if (getTier().equals("Silver, fee of 20$")) {
            System.out.println("Purchasing at Silver: " + money);
            amount = amount - money - 20;
            String s = Integer.toString(amount);
            updateData(s);
        }
        else if (getTier().equals("Gold, fee if 10$")) {
            System.out.println("Purchasing at Gold: " + money);
            amount = amount - money - 10;
            String s = Integer.toString(amount);
            updateData(s);
        } 
        else if (getTier().equals("Platnium, no fee")) {
            System.out.println("Purchasing at Plat: " + money);
            amount = amount - money;
            String s = Integer.toString(amount);
            updateData(s);
        }
    }
    
    public String getBalance() throws FileNotFoundException {
        String a, be, c;
        File file = new File(this.username+".txt");
        Scanner scan = new Scanner(file).useDelimiter("/");
        a = scan.next();
        be = scan.next();
        c = scan.next();
        scan.close();
        return c;
        
    }
    
    public void withdraw(int money) throws IOException {
        System.out.println("Withdrawing: " + money);
        amount = amount - money;
        String s = Integer.toString(amount);
        updateData(s);
    }
    
    public void deposit(int money) throws IOException {
        System.out.println("Depositing: " + money);
        amount = amount + money;
        String s = Integer.toString(amount);
        updateData(s);
    }
    
    public boolean custauth () throws FileNotFoundException {
        /*String usertest;
        String passtest;
        File file = new File(username+".txt"); 
        Scanner scan = new Scanner(file).useDelimiter("/");
        usertest = scan.next();
        passtest = scan.next();
        scan.close();*/
        if (username.equals(u) && password.equals(p)) {
            return true;
        }
        else {
            return false;
        }
        
    }
    
    public void updateData(String newAmount) throws IOException {
        FileWriter fw = new FileWriter(username+".txt");
        fw.write(u + "/" + p + "/" + newAmount);
        fw.close();
        System.out.println("New balance: " + newAmount);
    }
}
