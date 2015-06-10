package com.COP2805C.AddressBook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by EpiphX on 6/8/2015.
 */
public class SaveLoadData {

    public static void saveData(List<Object> object){
        try {
            FileOutputStream fout = new FileOutputStream("C:\\objects.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(object);
            oos.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static List<Object> loadData(){

        List<Object> objects = new ArrayList<>();

        try{
            FileInputStream fis = new FileInputStream("C:\\objects.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            objects = (List<Object>) ois.readObject();
            ois.close();

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return objects;
    }
}
