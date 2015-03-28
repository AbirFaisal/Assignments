package com.GroupB;

import java.lang.Override;
import java.lang.String;

/**
 * Created by Group B on 3/23/15.
 */
public class Bird extends Animal{

    String name;

    public Bird(String weight, String name) {
        super(weight);
        this.name = name;
    }//end of constructor

    public boolean equals(Object obj){
        if(!(obj instanceof Bird)){
            return false;
        }//end of if
        boolean result = false;
        if(this.getName() == ((Bird)obj).getName()){
            result = true;
        }//end of if
        return result;
    }//end of equals

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bird: \n" +
                " Name: " + name +
                super.toString();
    }
}//end of Bird
