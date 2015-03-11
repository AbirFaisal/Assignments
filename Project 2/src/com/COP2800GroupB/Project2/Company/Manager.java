/*
 * *
 *  * Project Name: Project 2
 *  * Class Name: Manager
 *  *
 *  * Created by David, Nicholas, Abir, Will, Brian on 3/1/15 10:48 PM
 *
 */

package com.COP2800GroupB.Project2.Company;


public class Manager {


    //Fields
    private boolean manager;
    private String title;
    private String department;


    //Constructor
    public Manager(boolean manager, String title, String department) {
        this.manager = manager;
        this.title = title;
        this.department = department;
    }


    //Setters and Getters
    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
