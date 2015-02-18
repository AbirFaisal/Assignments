package com.COP2800GroupB.Project2;

//


import com.COP2800GroupB.Project2.Company.*;

public class Main {





    //change these to definitions and make it accessable
    //from the entire program
    public final int MAX_MANAGERS = 20;
    public final int MAX_EMPLOYEES = 100;
    public final int MAX_PERSONS = 500;

    public static void main(String[] args) {

        //Initalize databases
        //Initalize.init();

        //Display mainMenu

        MainMenu.mainMenu();


        //Person Class test
        //create new name of Name type
        Name nameTest = new Name("first" , "Middle", "Last");

        //create new manager of Manager type
        Manager testManager = new Manager(true, "title", "department");

        //create new employee of employe type
        Employee employeeTest = new Employee("positon", "title", testManager);

        //create new address of address type
        Address addressTest = new Address("1","2","city","state","zip","country");

        //create new person of Person type

        //                       NAME OBJ   STRING   STRING   EMPLOYEE OBJ  ADDRESS OBJ
        Person test = new Person(nameTest , "email", "phone", employeeTest, addressTest );



        //get first name test

        // test object, get name, get first name
        Print(test.getName().getFirst());

    }


    //so we don't have to type so much
    public static void Print(String string){
        System.out.print(string);
    }

}