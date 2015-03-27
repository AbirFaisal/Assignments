package com.GroupB;

/**
 * Created by abirfaisal on 3/23/15.
 */
public class Animal {


    private String weight;


    public Animal(String weight) {
        this.weight = weight;
    }

    public boolean equals(Object obj){
        if(!(obj instanceof Animal)){
            return false;
        }//end of if
        boolean result = false;
        if(this.getWeight() == ((Animal)obj).getWeight()){
            result = true;
        }//end of if
        return result;
    }//end of equals

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
