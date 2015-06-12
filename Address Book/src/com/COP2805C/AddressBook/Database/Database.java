package com.COP2805C.AddressBook.Database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by abirfaisal on 6/10/15.
 */
public class Database {

    public static void initializeDatabase(){
        //TODO
    }

    //TODO fix spelling cant spell exsist properly
    public static boolean doesDatabaseExsist(String databaseFileName){
        //TODO
        return false;
    }

    public static void createDefaultDatabase(){

    }

    public static void addTable(String tableName){
        //TODO
    }

    //TODO fix spelling i cnat spell comumnl
    public static void addColumn(String columnName){
        //TODO
    }

    public static void addRow(){
        //TODO
    }

    public static void deleteRow(){
        //TODO
    }

    public static void getRow(){
        //TODO
    }

    public static void getRecord(String username){
        //TODO
    }





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
