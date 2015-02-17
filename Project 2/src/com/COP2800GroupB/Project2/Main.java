package com.COP2800GroupB.Project2;

//


import com.COP2800GroupB.Project2.Company.Address;
import com.COP2800GroupB.Project2.Company.Employee;
import com.COP2800GroupB.Project2.Company.Name;
import com.COP2800GroupB.Project2.Company.Person;

public class Main {





    //change these to definitions and make it accessable
    //from the entire program
    public final int MAX_MANAGERS = 20;
    public final int MAX_EMPLOYEES = 100;
    public final int MAX_PERSONS = 500;

    public static void main(String[] args) {

        //Initalize databases
        Initalize.init();

        Name nameTest = new Name("first" , "Middle", "Last");

        Employee employeeTest = new Employee();

        Address addressTest = new Address("1","2","city","state","zip","country");


        Person test = new Person(nameTest , "email", "phone", employeeTest, addressTest );






    }
}