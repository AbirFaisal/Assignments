package com.COP2805C.AddressBook;

import java.awt.*;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * Created by abirfaisal on 5/28/15.
 */
public class Contact {

    Image contactPhoto; //Contact Photo 256x256 16bit color

    String first, middle, last; //First Middle and Last Name
    String nickname;            //Nickname


    //Stored as 2 element arrays first element is label second element is the data
    //example phone[0] = Label, phone[1] = Phone Number
    List<String[]> phone; //List of phone numbers
    List<String[]> email;  //List of Email addresses
    List<String[]> workplaces; // List of workplaces



    Calendar birthday; //Birthday

}