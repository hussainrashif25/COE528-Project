/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author blaze
 */
public class manager {
    
    String username;
    String password;

    public manager(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    ArrayList<customer> data = new ArrayList<customer>();
    File info = new File("info.txt");
    String line = null;
    
    //For the get response
    /*try {
            Scanner read = new Scanner(info);
        }   catch (FileNotFoundException qwerty){
                    System.out.println("Can't find file");
            }*/

    
    public void addCustomer(String u, String p, int b) {
        data.add(new customer(u, p, b));
        
        Iterator<customer> iter = data.iterator();
        
        while(iter.hasNext()) {
            customer ob = iter.next();
            if (ob.getName().equals(u)) {
                try {
                    FileWriter fw = new FileWriter("info.txt", true);
                    fw.write(u + "" + p + "" + b);
                    fw.write("\r\n");
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
        }
        
    }
    
    public boolean auth() {
        if (username.equals("admin") && password.equals("admin")) {
            return true;
        }
        else {
        return false;
        }
    }
    
}
