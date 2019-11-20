/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author blaze
 */
public class customer {
    String name;
    String pass;
    String balance;
    

    public customer(String name, String pass, String balance) {
        this.name = name;
        this.pass = pass;
        this.balance = balance;
    }
    
   // int amount = Integer.parseInt(this.balance);

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
