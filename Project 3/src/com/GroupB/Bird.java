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

    @Override
    public boolean equals(Object obj){

        if(obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        return Boolean.parseBoolean(null);
    }

    public String getWeight() {
        return name;

    }//end of equals

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bird\t" + super.toString() + "\t" +name;
    }
}//end of Bird
