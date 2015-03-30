package com.GroupB;

/**
 * Created by Group B on 3/23/15.
 */
public class Dog extends Animal{

    private String breed;

    public Dog(String weight, String breed) {
        super(weight);
        this.breed = breed;
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

    }//end of equals

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Dog \t" + super.toString() + "\t" + breed;
    }

}//end of Dog
