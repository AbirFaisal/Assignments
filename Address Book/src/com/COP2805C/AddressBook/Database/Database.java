package com.COP2805C.AddressBook.Database;

import org.sqlite.SQLiteConfig;

import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.util.Calendar;
/**
 * Created by abirfaisal on 6/10/15.
 */
public class Database {
    private static final Database DATABASE = new Database();
    private Database(){}
    private Connection conn = null;

    public static Database getDatabase(){
        return DATABASE;
    }

    public void innitialize(){
        try{
            Class.forName("org.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            this.conn = DriverManager.getConnection("jdbc:sqlite:accounts.db",config.toProperties());
            System.out.println("Connection successful");
            Statement stat = conn.createStatement();
            //Table to track user
            stat.executeUpdate("create table if not exists ACCOUNTS(ACCOUNT VARCHAR, primary key(ACCOUNT));");
            //Table for generic data
            stat.executeUpdate("create table if not exists CONTACTS(ACCOUNT VARCHAR ,"
                    + "CONTACT_ID INTEGER," + "F_Name VARCHAR," + "M_NAME VARCHAR," + "L_NAME VARCHAR," + "N_NAME VARCHAR,"
                    + "StreetName VARCHAR," + "CITY VARCHAR," + "STATE VARCHAR," + "ZIP VARCHAR," + "COUNTRY VARCHAR," + "NOTES TEXT,"
                    + "GROUP_ASSC VARCHAR," + "DOB INTEGER," + "PICTURE BLOB," + "primary key (CONTACT_ID), FOREIGN KEY(ACCOUNT) REFERENCES ACCOUNTS(ACCOUNT) ON DELETE CASCADE);");
            //Table for dynamic data
            stat.executeUpdate("CREATE TABLE DYNAMIC_DATA(ROW_ID INTEGER NOT NULL," + "CONTACT_ID INTEGER NOT NULL ,"
                    + "PHONE_NUMBER INTEGER," + "EMAIL VARCHAR," + "WORK_PLACE VARCHAR, "+ "FOREIGN KEY(CONTACT_ID) "
                    + "REFERENCES CONTACTS(CONTACT_ID) ON DELETE CASCADE);");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //DELETES ALL OF THE CONTACTS RECORDS IF GIVEN THE CONTACT ID
    public void deleteCONTACTID(int CONTACT_ID){
        try{
            String update = "DELETE from CONTACTS where CONTACT_ID =?";
            PreparedStatement pst = conn.prepareStatement(update);
            System.out.println(CONTACT_ID);
            pst.setInt(1,CONTACT_ID);
            pst.executeUpdate();
            pst.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    //ADDs A USER TO THE DATABASE
    public void addAccount(String ACCOUNT) throws SQLException{

            String update = "INSERT into ACCOUNTS(ACCOUNT) values (?)";
            PreparedStatement pst = conn.prepareStatement(update);
            pst.setString(1, ACCOUNT);
            pst.executeUpdate();
            pst.close();
    }


    //This method adds a CONTACT_ID for the listed account and returns the key for this contact. This key can then be used in the other functions to add the required fields.
    public int createContact(String ACCOUNT) throws SQLException{
        String update = "INSERT into CONTACTS(ACCOUNT) values" + "(?);";
        PreparedStatement pst = conn.prepareStatement(update);
        pst.setString(1, ACCOUNT);
        pst.executeUpdate();
        int key = pst.getGeneratedKeys().getInt(1);
        pst.close();

        return key;
    }
    //Adds names to the provided CONTACT_KEY
    public void addNames(int CONTACT_ID, String F_NAME, String M_NAME, String L_NAME, String N_NAME) throws SQLException{
        String update = "UPDATE CONTACTS SET F_NAME =?," + "M_NAME =?," +"L_NAME =?," + "N_NAME =? WHERE CONTACT_ID =?";
        PreparedStatement pst = conn.prepareStatement(update);
        pst.setString(1,F_NAME);
        pst.setString(2,M_NAME);
        pst.setString(3,L_NAME);
        pst.setString(4,N_NAME);
        pst.setInt(5,CONTACT_ID);
        pst.executeUpdate();
        pst.close();
    }
    //adds address to the key provided
    public void addAddress(int CONTACT_ID, String StreetName, String CITY, String STATE, String ZIP, String COUNTRY)throws SQLException{
        String update = "UPDATE CONTACTS SET StreetName =?," + "CITY =?," +"STATE =?," + "ZIP =?," + "COUNTRY =? WHERE CONTACT_ID =?";
        PreparedStatement pst = conn.prepareStatement(update);
        pst.setString(1,StreetName);
        pst.setString(2,CITY);
        pst.setString(3,STATE);
        pst.setString(4,ZIP);
        pst.setString(5,COUNTRY);
        pst.setInt(6,CONTACT_ID);
        pst.executeUpdate();
        pst.close();
    }
    //Adds image to the selected CONTACT_ID
    public void addPicture(int CONTACT_ID, String fileDirectory)throws SQLException{
        FileInputStream inputStream= null;

        try{
            File image = new File(fileDirectory);
            inputStream = new FileInputStream(image);
            String update = "UPDATE CONTACTS SET PICTURE =? WHERE CONTACT_ID =?";
            PreparedStatement pst = conn.prepareStatement(update);
            pst.setBinaryStream(1, inputStream,(int)(image.length()));
            pst.setInt(2, CONTACT_ID);
            pst.executeUpdate();
            pst.close();
        }catch(FileNotFoundException e){
            System.out.println("FileNotFoundException: - " + e);
        }catch(SQLException e){
            System.out.println("SQLExceptionL - "+ e);
        }
    }

    //TODO BUILD A METHOD FOR IMAGE RETRIEVAL
    public void addDate(int CONTCT_ID, Calendar calender){

    }

    public void retrievePicture(int CONTACT_ID){
        OutputStream outputStream = null;
        InputStream inputStream = null;

        try{
            // File image = new File()
            String query = "SELECT picture from CONTACTS where CONTACT_ID =?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, CONTACT_ID);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                inputStream = rs.getBinaryStream("picture");
            }
            inputStream = new FileInputStream(new File("Student_img.jpg"));
            outputStream = new FileOutputStream("std_img.jpg");
            byte[] content = new byte[1024];
            int size = 0;
            while((size = inputStream.read(content))!= -1){
                outputStream.write(content,0,size);
            }
        }catch(ClassCastException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    //To add multiple phoneNumbers, Emails etc. Just call this method additional times with the same CONTACT_ID.
    public void createDynamicData(int CONTACT_ID, int phoneNumber, String EMAIL,String WORK_PLACE){

    }

    public void closeDB() throws SQLException{
        conn.close();
    }
}
