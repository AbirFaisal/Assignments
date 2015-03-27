package com.GroupB;

import java.lang.Override;
import java.lang.String;

/**
 * Created by abirfaisal on 3/23/15.
 */
public class Bird extends Animal{

    String name;

    public Bird(String weight, String name) {
        super(weight);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' + super.toString() +
                '}';
    }
}//end of Bird
