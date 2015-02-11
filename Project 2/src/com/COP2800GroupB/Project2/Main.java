package com.COP2800GroupB.Project2;

import com.COP2800GroupB.Project2.DatabaseEngine.Database;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //Initlaize the databases we want (name.extension, size)
        //Put this in a class later
        int Manager[] = Database.createDB("Manager.gbdb", 20);
        int Employees[] = Database.createDB("Employees.gbdb", 100);
        int People[] = Database.createDB("People.gbdb", 500);




    }
}
