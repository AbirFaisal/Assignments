package com.COP2805C.AddressBook.Database;

import com.COP2805C.AddressBook.Main;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by abirfaisal on 6/10/15.
 */
public class Crypto {


    //TODO decide string or bytes[]
    public static String stringSHA(String string) {

        byte[] digest = new byte[0];
        String SHAkey = null;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(string.getBytes("UTF-8"));

            digest = messageDigest.digest();
            SHAkey = new HexBinaryAdapter().marshal(digest);

            //TODO TEST REMOVE
            //System.out.println("SHA256: " + SHAkey);

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return SHAkey;
    }


    public static boolean verifySHA(String input, String SHA) {

        //get SHA
        String inputSHA = stringSHA(input);

        //Return true or false
        return inputSHA.equals(SHA);
    }


    public static void edfasdfas() {

    }


    public static String encryptString(String string) {
        //TODO
        return string;
    }

    public static String decryptString(String string) {
        //TODO
        return string;
    }


    public static boolean authenticateUser(String[] credentials){

        //Check if user exsists
        if (Main.database.doesUserExist(credentials)) {

            //Check if password user entered matches the password from user in the database
            if (verifySHA(credentials[1], Main.database.getPassword(credentials))) {

                //Return True if username and password match the database
                return true;
            }
        }
        //else return false if any of the 2 checks above fail
        return false;
    }
}










