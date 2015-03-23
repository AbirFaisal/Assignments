package com.GroupB;

/**
 * Created by abirfaisal on 3/23/15.
 */
public class Dog extends Animal{

    private String breed;

    public Dog(String weight, String breed) {
        super(weight);
        this.breed = breed;
    }//end of constructor

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed: '" +
                breed + '\'' +
                super.toString() +
                '}';
    }//end of toString

}//end of Dog
