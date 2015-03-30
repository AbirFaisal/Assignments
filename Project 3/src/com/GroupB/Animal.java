package com.GroupB;

/**
 * Created by Group B on 3/23/15.
 */
public class Animal {


    private String weight;


    public Animal(String weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        //Animal animal = (Animal)obj;

        return Boolean.parseBoolean(null);
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result
                + ((weight == null) ? 0 : weight.hashCode());

        result = prime * result + id;

        result = prime * result
                + ((weight == null) ? 0 : weight.hashCode());
        return result;
    }



    @Override
    public String toString() {
        String result;
        result = weight + "\t";
        return result;
    }
}
