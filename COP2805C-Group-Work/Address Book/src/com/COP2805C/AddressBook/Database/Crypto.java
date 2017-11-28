package com.COP2805C.AddressBook.Database;

import com.COP2805C.AddressBook.Main;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * Copyright (c) 2015
 * Alex Truong-Mai
 * Will Herrin
 * Chris Buruchian
 * Abir Faisal
 *
 * COP2805C Valencia College
 * Professor Jeho Park
 */

/**
 * Created by abirfaisal on 6/10/15.
 */
public class Crypto {

    //Takes string and returns string SHA value
    public static String stringSHA(String string) {

        byte[] digest = new byte[0];
        String SHAkey = null;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(string.getBytes("UTF-8"));

            digest = messageDigest.digest();
            SHAkey = new HexBinaryAdapter().marshal(digest);

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return SHAkey;
    }

    //takes string and SHA string and compares them
    public static boolean verifySHA(String input, String SHA) {

        //get SHA
        String inputSHA = stringSHA(input);

        //Return true or false
        return inputSHA.equals(SHA);
    }

    //Authenticates the user, takes 2 element string array
    public static boolean authenticateUser(String[] credentials) {

        //Check if user exsists
        if (Main.getDatabase().doesUserExist(credentials)) {

            //Check if password user entered matches the password from user in the database
            if (verifySHA(credentials[1], Main.getDatabase().getPassword(credentials))) {

                //Return True if username and password match the database
                return true;
            }
        }
        //else return false if any of the 2 checks above fail
        return false;
    }

}










