package com.COP2800GroupB.Project2;

import com.COP2800GroupB.Project2.DatabaseEngine.Database;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //Initlaize the databases we want (name.extension, size)
        //Put this in a class later
        Database.initalize("Manager.gbdb", 20);
        Database.initalize("Employees.gbdb", 100);
        Database.initalize("People.gbdb", 500);




    }
}
