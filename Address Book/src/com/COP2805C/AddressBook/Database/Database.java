package com.COP2805C.AddressBook.Database;

import javafx.scene.image.Image;
import org.sqlite.SQLiteConfig;

import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by abirfaisal on 6/10/15.
 */
public class Database {
    private static final Database DATABASE = new Database();

    private Database() {
    }

    private static Connection conn = null;

    public static Database getDatabase() {
        return DATABASE;
    }

    public void initialize() {
        try {
            Class.forName("org.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            this.conn = DriverManager.getConnection("jdbc:sqlite:accounts.db", config.toProperties());
            System.out.println("Connection successful");
            Statement stat = conn.createStatement();
            //Table to track user
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS ACCOUNTS(ACCOUNT VARCHAR," + "PASSWORD VARCHAR," + " PRIMARY KEY(ACCOUNT));");
            //Table for static data
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS CONTACTS(ACCOUNT VARCHAR ,"
                    + "CONTACT_ID INTEGER," + "F_NAME VARCHAR," + "M_NAME VARCHAR," + "L_NAME VARCHAR," + "N_NAME VARCHAR,"
                    + "ADDRESSLINE1 VARCHAR," + "ADDRESSLINE2 VARCHAR," + "CITY VARCHAR," + "STATE VARCHAR," + "ZIP VARCHAR," + "COUNTRY VARCHAR," + "NOTES VARCHAR,"
                    + "GROUP_ASSC VARCHAR," + "DOB INTEGER," + "PICTURE BLOB," + "PRIMARY KEY (CONTACT_ID), FOREIGN KEY(ACCOUNT) REFERENCES ACCOUNTS(ACCOUNT) ON DELETE CASCADE);");
            //Table for dynamic data
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS DYNAMIC_DATA(CONTACT_ID INTEGER NOT NULL ,"
                    + "PHONE_NUMBER VARCHAR," + "EMAIL VARCHAR," + "WORK_PLACE VARCHAR, " + "FOREIGN KEY(CONTACT_ID) "
                    + "REFERENCES CONTACTS(CONTACT_ID) ON DELETE CASCADE);");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int numberOfContacts(String[] credentials) {
        try {
            String query = "SELECT COUNT(ACCOUNT) AS NumberOfContacts FROM CONTACTS WHERE ACCOUNT=?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, credentials[0]);
            ResultSet rs = st.executeQuery();
            return rs.getInt("NumberOfContacts");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //Function that checks if provided column is empty, one for table, one for column.
    public boolean isColumnEmpty(String TABLE, String COLUMN) {

        try {

            String query = "SELECT " + COLUMN + " from " + TABLE;
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            if (rs.getString(COLUMN) == null) {
                //testing
                System.out.println("Working");
                return true;
            } else {
                return false;
            }
        } catch (NullPointerException | SQLException e) {
            System.out.println(e);
            return true;
        }
    }


    public boolean doesUserExist(String[] credentials) {

        try {
            String query = "SELECT ACCOUNT FROM ACCOUNTS WHERE ACCOUNT=?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, credentials[0]);
            ResultSet rs = pst.executeQuery();
            if (rs.getString("ACCOUNT") == null) {
                return false;
            } else {
                return true;
            }
        } catch (NullPointerException | SQLException e) {
            System.out.println(e);
            return false;

        }
    }

    public ArrayList<Integer> getContactIDS(String[] credentials) {
        ArrayList<Integer> contactIDS = new ArrayList<>();
        try {
            String query = "SELECT CONTACT_ID FROM CONTACTS WHERE ACCOUNT=?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, credentials[0]);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                contactIDS.add(rs.getInt("CONTACT_ID"));
            }
            return contactIDS;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }


    public static String getPassword(String[] credentials) {
        String password = new String();
        try {
            String query = "SELECT PASSWORD FROM ACCOUNTS WHERE ACCOUNT=?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, credentials[0]);
            ResultSet rs = pst.executeQuery();
            password = rs.getString("PASSWORD");
        } catch (SQLException e) {
            System.out.println(e);
        }

        return password;
    }

    //DELETES ALL OF THE CONTACTS RECORDS IF GIVEN THE CONTACT ID
    public void deleteCONTACTID(int CONTACT_ID) {
        try {
            String update = "DELETE FROM CONTACTS WHERE CONTACT_ID =?";
            PreparedStatement pst = conn.prepareStatement(update);
            System.out.println(CONTACT_ID);
            pst.setInt(1, CONTACT_ID);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //ADDs A USER TO THE DATABASE
    public void addAccount(String[] credentials) {

        try {
            String update = "INSERT INTO ACCOUNTS(ACCOUNT,PASSWORD) VALUES (?,?)";
            String encryptPassword = Crypto.stringSHA(credentials[1]);
            PreparedStatement pst = conn.prepareStatement(update);
            pst.setString(1, credentials[0]);
            pst.setString(2, encryptPassword);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //This method adds a CONTACT_ID for the listed account and returns the key for this contact. This key can then be used in the other functions to add the required fields.
    public int createContact(String ACCOUNT) throws SQLException {
        String update = "INSERT INTO CONTACTS(ACCOUNT) VALUES" + "(?);";
        PreparedStatement pst = conn.prepareStatement(update);
        pst.setString(1, ACCOUNT);
        pst.executeUpdate();
        int key = pst.getGeneratedKeys().getInt(1);
        pst.close();

        return key;
    }

    //Adds names to the provided CONTACT_KEY
    public void addNames(int CONTACT_ID, String F_NAME, String M_NAME, String L_NAME, String N_NAME) throws SQLException {
        String update = "UPDATE CONTACTS SET F_NAME =?," + "M_NAME =?," + "L_NAME =?," + "N_NAME =? WHERE CONTACT_ID =?";
        PreparedStatement pst = conn.prepareStatement(update);
        pst.setString(1, F_NAME);
        pst.setString(2, M_NAME);
        pst.setString(3, L_NAME);
        pst.setString(4, N_NAME);
        pst.setInt(5, CONTACT_ID);
        pst.executeUpdate();
        pst.close();
    }

    //adds address to the key provided
    public void addAddress(int CONTACT_ID, String ADDRESSLINE1, String ADDRESSLINE2, String CITY, String STATE, String ZIP, String COUNTRY) throws SQLException {
        String update = "UPDATE CONTACTS SET ADDRESSLINE1 =?," + "ADDRESSLINE2 = ?," + "CITY =?," + "STATE =?," + "ZIP =?," + "COUNTRY =? WHERE CONTACT_ID =?";
        PreparedStatement pst = conn.prepareStatement(update);
        pst.setString(1, ADDRESSLINE1);
        pst.setString(2, ADDRESSLINE2);
        pst.setString(3, CITY);
        pst.setString(4, STATE);
        pst.setString(5, ZIP);
        pst.setString(6, COUNTRY);
        pst.setInt(7, CONTACT_ID);
        pst.executeUpdate();
        pst.close();
    }

    //Adds image to the selected CONTACT_ID
    public void addPicture(int CONTACT_ID, String fileDirectory) throws SQLException {
        FileInputStream inputStream = null;

        try {
            File image = new File(fileDirectory);
            inputStream = new FileInputStream(image);
            String update = "UPDATE CONTACTS SET PICTURE =? WHERE CONTACT_ID =?";
            PreparedStatement pst = conn.prepareStatement(update);
            pst.setBinaryStream(1, inputStream, (int) (image.length()));
            pst.setInt(2, CONTACT_ID);
            pst.executeUpdate();
            pst.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: - " + e);
        } catch (SQLException e) {
            System.out.println("SQLExceptionL - " + e);
        }
    }

    public void addDate(int CONTACT_ID, Calendar calendar) throws SQLException {
        String update = "UPDATE CONTACTS SET DOB =? WHERE CONTACT_ID =?";
        PreparedStatement pst = conn.prepareStatement(update);
        pst.setLong(1, calendar.getTimeInMillis());
        pst.setInt(2, CONTACT_ID);
        pst.executeUpdate();
        pst.close();
    }
    public ArrayList<String> getDynamicData(int CONTACT_ID,String column){
        String query = "SELECT * FROM DYNAMIC_DATA WHERE CONTACT_ID = ?";
        return runDynamicStringQuery(CONTACT_ID, column, query);
    }

    public String getGroup(int CONTACT_ID, String GROUP_ASSC){
        String query = "SELECT GROUP_ASSC FROM CONTACTS WHERE CONTACT_ID = ?";
        return runContactStringQuery(CONTACT_ID, GROUP_ASSC, query);
    }

    public String getFName(int CONTACT_ID, String F_NAME) {
        String query = "SELECT F_NAME FROM CONTACTS WHERE CONTACT_ID = ?";
        return runContactStringQuery(CONTACT_ID, F_NAME, query);

    }

    public String getMName(int CONTACT_ID, String M_NAME) {
        String query = "SELECT M_NAME FROM CONTACTS WHERE CONTACT_ID = ?";
        return runContactStringQuery(CONTACT_ID, M_NAME, query);
    }

    public String getLName(int CONTACT_ID, String L_NAME) {
        String query = "SELECT L_NAME FROM CONTACTS WHERE CONTACT_ID = ?";
        return runContactStringQuery(CONTACT_ID, L_NAME, query);
    }
    public String getNName(int CONTACT_ID, String N_NAME) {
        String query = "SELECT N_NAME FROM CONTACTS WHERE CONTACT_ID = ?";
        return runContactStringQuery(CONTACT_ID, N_NAME, query);
    }

    public String getAddress1(int CONTACT_ID, String ADDRESSLINE1) {
        String query = "SELECT ADDRESSLINE1 FROM CONTACTS WHERE CONTACT_ID = ?";
        return runContactStringQuery(CONTACT_ID, ADDRESSLINE1, query);
    }
    public String getAddress2(int CONTACT_ID, String ADDRESSLINE2) {
        String query = "SELECT ADDRESSLINE2 FROM CONTACTS WHERE CONTACT_ID = ?";
        return runContactStringQuery(CONTACT_ID, ADDRESSLINE2, query);
    }

    public String getCity(int CONTACT_ID, String CITY) {
        String query = "SELECT CITY FROM CONTACTS WHERE CONTACT_ID = ?";
        return runContactStringQuery(CONTACT_ID, CITY, query);
    }
    public String getState(int CONTACT_ID, String STATE) {
        String query = "SELECT STATE FROM CONTACTS WHERE CONTACT_ID = ?";
        return runContactStringQuery(CONTACT_ID, STATE, query);
    }
    public String getZIP(int CONTACT_ID, String ZIP) {
        String query = "SELECT ZIP FROM CONTACTS WHERE CONTACT_ID = ?";
        return runContactStringQuery(CONTACT_ID, ZIP, query);
    }

    public String getNotes(int CONTACT_ID, String NOTES) {
        String query = "SELECT NOTES FROM CONTACTS WHERE CONTACT_ID = ?";
        return runContactStringQuery(CONTACT_ID, NOTES, query);
    }

    private String runContactStringQuery(int CONTACT_ID, String subject, String query) {
        try {
            String result;
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, CONTACT_ID);
            ResultSet rs = pst.executeQuery();
            result = rs.getString(subject);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }catch(NullPointerException e){
            System.out.println(e);
            return "";
        }
    }

    private ArrayList<String> runDynamicStringQuery(int CONTACT_ID, String subject, String query){
        try {
            ArrayList<String> list = new ArrayList<>();

            String result;
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, CONTACT_ID);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {

                result = rs.getString(subject);
                if(result!=null)list.add(result);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }catch(NullPointerException e){
            System.out.println(e);
            return null;
        }
    }


    public Calendar getDOB(int CONTACT_ID){
        Calendar birthday = null;
        try {
            String query = "SELECT DOB FROM CONTACTS WHERE CONTACT_ID =?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, CONTACT_ID);
            ResultSet rs = pst.executeQuery();
            birthday.setTimeInMillis(rs.getLong("DOB"));
            return birthday;
        }catch(NullPointerException|SQLException e){
            System.out.println(e+ " getBirthday");
            return birthday;
        }
    }
    //TODO test getPicture method.
    public Image getPicture(int CONTACT_ID) {
        Image profilePic;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            String query = "SELECT picture FROM CONTACTS WHERE CONTACT_ID =?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, CONTACT_ID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                inputStream = rs.getBinaryStream("picture");
            }
            outputStream = new FileOutputStream("profilePic" + CONTACT_ID + ".png");

            byte[] content = new byte[1024];
            int size = 0;
            while ((size = inputStream.read(content)) != -1) {
                outputStream.write(content, 0, size);
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(NullPointerException e){
            return new Image("file:///Address Book/src/picture.jpg");
        }

         profilePic = new Image("file:///Address Book/profilePic" + CONTACT_ID + ".png");
         return profilePic;
    }

    //TODO DECIDE IF WE WANT PHONE_NUMBER AS A LONG OR A STRING.
    public void addDynamicData(int CONTACT_ID, long PHONE_NUMBER, String EMAIL, String WORK_PLACE) throws SQLException {
        String update = "INSERT INTO DYNAMIC_DATA(CONTACT_ID,PHONE_NUMBER,EMAIL,WORK_PLACE) VALUES (?,?,?,?);";
        PreparedStatement pst = conn.prepareStatement(update);
        pst.setInt(1, CONTACT_ID);
        pst.setLong(2, PHONE_NUMBER);
        pst.setString(3, EMAIL);
        pst.setString(4, WORK_PLACE);
        pst.executeUpdate();
        pst.close();
    }

    public void addDynamicData(int CONTACT_ID, long PHONE_NUMBER) throws SQLException {
        String update = "INSERT INTO DYNAMIC_DATA(CONTACT_ID,PHONE_NUMBER,EMAIL,WORK_PLACE) VALUES (?,?,NULL,NULL);";
        PreparedStatement pst = conn.prepareStatement(update);
        pst.setInt(1, CONTACT_ID);
        pst.setLong(2, PHONE_NUMBER);
        pst.executeUpdate();
        pst.close();
    }

    public void addDynamicData(int CONTACT_ID, String EMAIL) throws SQLException {
        String update = "INSERT INTO DYNAMIC_DATA(CONTACT_ID,PHONE_NUMBER,EMAIL,WORK_PLACE) VALUES (?,NULL,?,NULL);";
        PreparedStatement pst = conn.prepareStatement(update);
        pst.setInt(1, CONTACT_ID);
        pst.setString(2, EMAIL);
        pst.executeUpdate();
        pst.close();
    }

    public void addDynamicData(String WORK_PLACE, int CONTACT_ID) throws SQLException {
        String update = "INSERT INTO DYNAMIC_DATA(CONTACT_ID,PHONE_NUMBER,EMAIL,WORK_PLACE) VALUES (?,NULL,NULL,?);";
        PreparedStatement pst = conn.prepareStatement(update);
        pst.setInt(1, CONTACT_ID);
        pst.setString(2, WORK_PLACE);
        pst.executeUpdate();
        pst.close();
    }

    public void closeDB() throws SQLException {
        conn.close();
    }
}
