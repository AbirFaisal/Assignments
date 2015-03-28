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

    public boolean equals(Object obj){
        if(!(obj instanceof Dog)){
            return false;
        }//end of if
        boolean result = false;
        if(this.getBreed() == ((Dog)obj).getBreed()){
            result = true;
        }//end of if
        return result;
    }//end of equals

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Dog: \n" +
                " Breed: " +
                breed +
                super.toString();
    }//end of toString

}//end of Dog
