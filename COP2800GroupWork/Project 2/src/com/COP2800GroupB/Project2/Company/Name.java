/*
 * *
 *  * Project Name: Project 2
 *  * Class Name: Name
 *  *
 *  * Created by David, Nicholas, Abir, Will, Brian on 3/1/15 10:48 PM
 *
 */

package com.COP2800GroupB.Project2.Company;


public class Name {


    //Fields
    private String first;
    private String middle;
    private String last;


    //Constructor
    public Name(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }


    //Setters and Getters
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
