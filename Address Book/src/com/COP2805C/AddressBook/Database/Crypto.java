package com.COP2805C.AddressBook.Database;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by abirfaisal on 6/10/15.
 */
public class Crypto {


    public static void stringSHA(String string){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(string.getBytes("UTF-8"));

            byte[] digest = messageDigest.digest();


            //TODO TEST REMOVE
            System.out.println("SHA256: " + );

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    public static void verifySHA(){



    }


    public static void encrypt(){

    }

    public static void decrypt(){

    }





}
