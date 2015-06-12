package com.COP2805C.AddressBook.Database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by abirfaisal on 6/10/15.
 */
public class Database {

    Connection conn = null;
    public static Connection dbConnector(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:accounts.db");
            System.out.println("Connection successful");
            Statement stat = conn.createStatement();
            //stat.executeUpdate("drop table if exists user");

            //creating table
            stat.executeUpdate("create table if not exists user(Username VARCHAR ,"
                    + "Password varchar,"
                    + "primary key (Username));");
            //stat.executeUpdate("insert into user VALUES('Bob','121212')");//For the createprompt
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
