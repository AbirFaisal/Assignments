package com.abirfaisal;

/*
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


public class Person {



    private Name name;
    private boolean gender;
    private String age;
    private String salary;

    //Constructor
    public Person(Name name, boolean gender, String age, String salary) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
    }

    //Setters and Getters
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {

        try {

            // Convert string age into integer
            int temp = Integer.parseInt(age);

            // make sure age is between 1 and 120
            if (temp <= 1){
                throw new RuntimeException("Age is less than or equal to 1");
            }else if (temp >=120){
                throw new RuntimeException("Age is greater than or equal to 120");
            }else {
                this.age = age;
            }

        }catch (RuntimeException e){
            System.out.print(e);
        }

    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {

        try {

            //test if salary is less than 0
            double temp = Double.parseDouble(salary);

            if (temp > 0){
                throw new RuntimeException("Salary is negative. Are you giving or earning money?");
            }else {
                this.salary = salary;
            }

        }catch (RuntimeException e){
            System.out.print(e);
        }
    }
}
