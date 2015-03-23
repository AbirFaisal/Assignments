package com.GroupB;

/**
 * Created by abirfaisal on 3/23/15.
 */
public class Animal {


    private String weight;


    public Animal(String weight) {
        this.weight = weight;
    }


    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }



    @Override
    public String toString() {
        String result;
        result = "Animal Weight: " + weight;
        return result;
    }
}
