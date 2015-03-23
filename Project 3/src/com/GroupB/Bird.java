package com.GroupB;

/**
 * Created by abirfaisal on 3/23/15.
 */
public class Bird extends Animal{

    String Order;
    String Family;
    String Genus;
    String Species;

    public Bird(String weight, String order, String family, String genus, String species) {
        super(weight);
        Order = order;
        Family = family;
        Genus = genus;
        Species = species;
    }


    public String getOrder() {
        return Order;
    }

    public void setOrder(String order) {
        Order = order;
    }

    public String getFamily() {
        return Family;
    }

    public void setFamily(String family) {
        Family = family;
    }

    public String getGenus() {
        return Genus;
    }

    public void setGenus(String genus) {
        Genus = genus;
    }

    public String getSpecies() {
        return Species;
    }

    public void setSpecies(String species) {
        Species = species;
    }


    @Override
    public String toString() {
        return "Bird{" +
                "Order: " + Order + '\'' +
                ", Family: " + Family + '\'' +
                ", Genus: " + Genus + '\'' +
                ", Species: " + Species + '\'' + super.toString() +
                '}';
    }
}//end of Bird
