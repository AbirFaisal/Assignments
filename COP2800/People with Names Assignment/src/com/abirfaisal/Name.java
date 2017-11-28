package com.abirfaisal;

/*

Create a program that has at least three classes.
1. The class with main.
2. A class that defines a name (first name, middle name, and last name)
3. A class that defines a person (name, gender, age, and salary)
4. You will define all setters and getters, constructors and toString methods

The program will create and populate at least three different people.
The program will allow a user to change the fields for a person.
The program will output all three people.

Rules:
1. Gender must equal M or F only.
2. Age must be between 1 and 120.
3. Salary must be a positive number.
4. The first and last name must be in sentence case.
5. A middle name is optional (the code will account for this)

You will turn in your zipped up project and your class UML(s).
*see page 324*

 */


public class Name {

    private String firstName;
    private String middleName;
    private String lastName;


    //Constructors

    //Without Middle Name
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //With Middle Name
    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }





    //Setters and getters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        //Make sure only first letter is capitalized
        //Make whole string lower case
        firstName.toLowerCase();
        //Make first letter upper case
        Character.toUpperCase(firstName.charAt(0));

        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {

            return lastName;

    }

    public void setLastName(String lastName) {

        //Make sure only first letter is capitalized
        //Make whole string lower case
        lastName.toLowerCase();
        //Make first letter upper case
        Character.toUpperCase(lastName.charAt(0));

        this.lastName = lastName;
    }


    // get length of longest name in array
    public static int getConcatNameLength(Person[] array){

        int concatNameLength = 0;

        int firstName = 0;
        int middleName = 0;
        int lastName = 0;


        //find biggest full name length in array
        for (int i = 0; i < array.length; i++) {

            int tempfirst =array[i].getName().getFirstName().length();
            int tempMiddle =array[i].getName().getMiddleName().length();
            int tempLast =array[i].getName().getLastName().length();

            if (tempfirst >= firstName){
                firstName = tempfirst;
            }

            if (tempMiddle >= middleName){
                middleName = tempMiddle;
            }

            if (tempLast >= lastName){
                lastName = tempLast;
            }
        }

        concatNameLength = firstName + middleName + lastName - 1;

        return concatNameLength;
    }


}
