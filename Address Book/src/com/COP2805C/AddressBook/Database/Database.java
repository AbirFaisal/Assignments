package com.COP2805C.AddressBook.Database;

import com.COP2805C.AddressBook.Contacts.ContactInformation;
import com.COP2805C.AddressBook.Contacts.ContactInformationBuilder;
import com.COP2805C.AddressBook.UserInterface.OSUtils;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import org.sqlite.SQLiteConfig;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.time.chrono.Chronology;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by abirfaisal on 6/10/15.
 */
public class Database {
    private static final Database DATABASE = new Database();

    private Database() {
    }

    private static Connection connection = null;

    public static Database getDatabase() {
        return DATABASE;
    }

    public void initialize() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            SQLiteConfig sqLiteConfig = new SQLiteConfig();
            sqLiteConfig.enforceForeignKeys(true);
            this.connection = DriverManager.getConnection("jdbc:sqlite:accounts.db", sqLiteConfig.toProperties());
            System.out.println("DB Connection successful");
            Statement stat = connection.createStatement();
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

    public ArrayList<ContactInformation> populateContactList(String[] credentials, String group){

        ArrayList<Integer> contactID = new ArrayList<>();
        ArrayList<ContactInformation> contactInformationArrayList = new ArrayList<>();
        ContactInformationBuilder contactInformationBuilder = new ContactInformationBuilder();

        if(group != null){
            contactID = getContactIDS(credentials, group);
        }else throw new NullPointerException("populateContactList() in Database.java: null group string field");

        for(int i = 0; i < contactID.size(); i++){
            contactInformationArrayList.add(contactInformationBuilder.prepareContact(contactID.get(i)));
        }

        return contactInformationArrayList;
    }


    public int numberOfContacts(String[] credentials) {
        String query = "SELECT COUNT(ACCOUNT) AS NumberOfContacts FROM CONTACTS WHERE ACCOUNT=?";
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, credentials[0]);
            resultSet = preparedStatement.executeQuery();

            return resultSet.getInt("NumberOfContacts");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //Function that checks if provided column is empty, one for table, one for column.
    public boolean isColumnEmpty(String TABLE, String COLUMN) {
        String query = "SELECT " + COLUMN + " from " + TABLE;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.getString(COLUMN) == null) {
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
        String query = "SELECT ACCOUNT FROM ACCOUNTS WHERE ACCOUNT=?";
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, credentials[0]);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.getString("ACCOUNT") == null) {
                return false;
            } else {
                return true;
            }
        } catch (NullPointerException | SQLException e) {
            System.out.println(e);
            return false;
        }
    }


    public ArrayList<Integer> getContactIDS(String[] credentials, String group) {
        String query = "SELECT CONTACT_ID FROM CONTACTS WHERE ACCOUNT=? AND GROUP_ASSC=?";
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Integer> contactIDS;


        try {
            contactIDS = new ArrayList<>();

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, credentials[0]);
            preparedStatement.setString(2,group);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                contactIDS.add(resultSet.getInt("CONTACT_ID"));
            }
            return contactIDS;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public ArrayList<Integer> getContactIDS(String[] credentials) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<Integer> contactIDS;

        try {
            contactIDS = new ArrayList<>();

            String query = "SELECT CONTACT_ID FROM CONTACTS WHERE ACCOUNT=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, credentials[0]);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                contactIDS.add(resultSet.getInt("CONTACT_ID"));
            }
            return contactIDS;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }


    public static String getPassword(String[] credentials) {
        String query = "SELECT PASSWORD FROM ACCOUNTS WHERE ACCOUNT=?";
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String password = "";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, credentials[0]);
            resultSet = preparedStatement.executeQuery();
            password = resultSet.getString("PASSWORD");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return password;
    }

    public ArrayList<String> getGroups(String[] credentials){
        String query = "SELECT DISTINCT GROUP_ASSC FROM CONTACTS WHERE ACCOUNT=?";
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ArrayList<String> groups = new ArrayList<String>();

        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, credentials[0]);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                System.out.println(resultSet.getString("GROUP_ASSC"));
                if(resultSet.getString("GROUP_ASSC")!=null) {
                    groups.add(resultSet.getString("GROUP_ASSC"));
                }
            }
            return groups;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }



    //DELETES ALL OF THE CONTACTS RECORDS IF GIVEN THE CONTACT ID
    public void deleteCONTACTID(int CONTACT_ID) {
        try {
            String update = "DELETE FROM CONTACTS WHERE CONTACT_ID =?";
            PreparedStatement pst = connection.prepareStatement(update);
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
            PreparedStatement pst = connection.prepareStatement(update);
            pst.setString(1, credentials[0]);
            pst.setString(2, encryptPassword);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //TODO edit createContact method to submit a contactInformation object to the database.
    //This method adds a CONTACT_ID for the listed account and returns the key for this contact. This key can then be used in the other functions to add the required fields.
    public int createContactID(String ACCOUNT) throws SQLException {
        String update = "INSERT INTO CONTACTS(ACCOUNT) VALUES" + "(?);";
        PreparedStatement pst = connection.prepareStatement(update);
        pst.setString(1, ACCOUNT);
        pst.executeUpdate();
        int key = pst.getGeneratedKeys().getInt(1);
        pst.close();

        return key;
    }
    //TODO Decide later if we want to return key in order to minimize resource overhead.
    public void createContact(String[] credentials, ContactInformation contact){

        try {
            int key = createContactID(credentials[0]);
            addNames(key, contact.getFirstName(), contact.getMiddleName(), contact.getLastName(), contact.getNickname());
            addAddress(key, contact.getAddressLine1(), contact.getAddressLine2(), contact.getCity(), contact.getState(), contact.getZip(), contact.getCountry());
            //TODO fix addDate method to take in a chronological object.
            //addDate(key, contact.getBirthday());
            addGroup(key, contact.getGroup());
            addNotes(key, contact.getNotes());
            addPicture(key, contact.getProfileImage());
            //return key;
        }catch(SQLException e){
            System.out.println(e);
            //return 0;
        }
        //contactObject.setKey(createContact(credentials,contactObject));
    }

    //Adds names to the provided CONTACT_KEY
    public void addNames(int CONTACT_ID, String F_NAME, String M_NAME, String L_NAME, String N_NAME)  {
        try {
            String update = "UPDATE CONTACTS SET F_NAME =?," + "M_NAME =?," + "L_NAME =?," + "N_NAME =? WHERE CONTACT_ID =?";
            PreparedStatement pst = connection.prepareStatement(update);
            pst.setString(1, F_NAME);
            pst.setString(2, M_NAME);
            pst.setString(3, L_NAME);
            pst.setString(4, N_NAME);
            pst.setInt(5, CONTACT_ID);
            pst.executeUpdate();
            pst.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    //adds address to the key provided
    public void addAddress(int CONTACT_ID, String ADDRESSLINE1, String ADDRESSLINE2, String CITY, String STATE, String ZIP, String COUNTRY) {
        try {
            String update = "UPDATE CONTACTS SET ADDRESSLINE1 =?," + "ADDRESSLINE2 = ?," + "CITY =?," + "STATE =?," + "ZIP =?," + "COUNTRY =? WHERE CONTACT_ID =?";
            PreparedStatement pst = connection.prepareStatement(update);
            pst.setString(1, ADDRESSLINE1);
            pst.setString(2, ADDRESSLINE2);
            pst.setString(3, CITY);
            pst.setString(4, STATE);
            pst.setString(5, ZIP);
            pst.setString(6, COUNTRY);
            pst.setInt(7, CONTACT_ID);
            pst.executeUpdate();
            pst.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    //Adds image to the selected CONTACT_ID
    public void addPicture(int CONTACT_ID, Image image) throws SQLException {


        BufferedImage bImage = SwingFXUtils.fromFXImage(image,null);
        ByteArrayOutputStream s = new ByteArrayOutputStream();
        ByteArrayInputStream in;
        try {
            ImageIO.write(bImage, "png", s);
            byte[] res = s.toByteArray();
            in = new ByteArrayInputStream(res);
            String update = "UPDATE CONTACTS SET PICTURE =? WHERE CONTACT_ID =?";
            PreparedStatement pst = connection.prepareStatement(update);
            pst.setBinaryStream(1, in,res.length);
            pst.setInt(2, CONTACT_ID);
            pst.executeUpdate();
            pst.close();
        }catch(SQLException|IOException e){
            System.out.println(e + "\nTesting addPicture");
        }
        }

    public void addDate(int CONTACT_ID, Chronology chronology){
        try {
            String update = "UPDATE CONTACTS SET DOB =? WHERE CONTACT_ID =?";
            PreparedStatement pst = connection.prepareStatement(update);
            //pst.setLong(1, chronology) //TODO adjust this thanks chris
            pst.setInt(2, CONTACT_ID);
            pst.executeUpdate();
            pst.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public void addGroup(int CONTACT_ID, String GROUP_ASSC) {
        try {
            String update = "UPDATE CONTACTS SET GROUP_ASSC=? WHERE CONTACT_ID =?";
            PreparedStatement pst = connection.prepareStatement(update);
            pst.setString(1, GROUP_ASSC);
            pst.setInt(2, CONTACT_ID);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void addNotes(int CONTACT_ID, String NOTES){
        try {
            String update = "UPDATE CONTACTS SET NOTES=? WHERE CONTACT_ID =?";
            PreparedStatement pst = connection.prepareStatement(update);
            pst.setString(1, NOTES);
            pst.setInt(2, CONTACT_ID);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
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

    public String getCountry(int CONTACT_ID, String COUNTRY){
        String query = "SELECT COUNTRY FROM CONTACTS WHERE CONTACT_ID = ?";
        return runContactStringQuery(CONTACT_ID, COUNTRY, query);
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
            PreparedStatement pst = connection.prepareStatement(query);
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
            PreparedStatement pst = connection.prepareStatement(query);
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
            PreparedStatement pst = connection.prepareStatement(query);
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
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, CONTACT_ID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                inputStream = rs.getBinaryStream("picture");
            }
            outputStream = new FileOutputStream("src/res/profilePic"+CONTACT_ID+".png");
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
            if(OSUtils.isWindows()){
                return new Image("res/defaultProfileImage.png");
            }
            return new Image("res/defaultProfileImage.png");
        }

        if(OSUtils.isWindows()){
            profilePic = new Image("c://Address Book/profilePic" + CONTACT_ID + ".png");
        }else {
            String workingDir = System.getProperty("user.dir");
            profilePic = new Image("file://"+workingDir+"/src/res/profilePic"+CONTACT_ID+".png");
        }
         return profilePic;
    }


    public void addDynamicData(int CONTACT_ID, long PHONE_NUMBER, String EMAIL, String WORK_PLACE) throws SQLException {
        String update = "INSERT INTO DYNAMIC_DATA(CONTACT_ID,PHONE_NUMBER,EMAIL,WORK_PLACE) VALUES (?,?,?,?);";
        PreparedStatement pst = connection.prepareStatement(update);
        pst.setInt(1, CONTACT_ID);
        pst.setLong(2, PHONE_NUMBER);
        pst.setString(3, EMAIL);
        pst.setString(4, WORK_PLACE);
        pst.executeUpdate();
        pst.close();
    }

    public void addDynamicData(int CONTACT_ID, long PHONE_NUMBER) throws SQLException {
        String update = "INSERT INTO DYNAMIC_DATA(CONTACT_ID,PHONE_NUMBER,EMAIL,WORK_PLACE) VALUES (?,?,NULL,NULL);";
        PreparedStatement pst = connection.prepareStatement(update);
        pst.setInt(1, CONTACT_ID);
        pst.setLong(2, PHONE_NUMBER);
        pst.executeUpdate();
        pst.close();
    }

    public void addDynamicData(int CONTACT_ID, String EMAIL) throws SQLException {
        String update = "INSERT INTO DYNAMIC_DATA(CONTACT_ID,PHONE_NUMBER,EMAIL,WORK_PLACE) VALUES (?,NULL,?,NULL);";
        PreparedStatement pst = connection.prepareStatement(update);
        pst.setInt(1, CONTACT_ID);
        pst.setString(2, EMAIL);
        pst.executeUpdate();
        pst.close();
    }

    public void addDynamicData(String WORK_PLACE, int CONTACT_ID) throws SQLException {
        String update = "INSERT INTO DYNAMIC_DATA(CONTACT_ID,PHONE_NUMBER,EMAIL,WORK_PLACE) VALUES (?,NULL,NULL,?);";
        PreparedStatement pst = connection.prepareStatement(update);
        pst.setInt(1, CONTACT_ID);
        pst.setString(2, WORK_PLACE);
        pst.executeUpdate();
        pst.close();
    }

    public void closeDB() throws SQLException {
        connection.close();
    }


    private byte[] toBytes(Object object) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeObject(object);
            return bos.toByteArray();
        }
    }

    private Object fromBytes(byte[] bytes) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
             ObjectInput in = new ObjectInputStream(bis)) {
            return in.readObject();
        }
    }


}
