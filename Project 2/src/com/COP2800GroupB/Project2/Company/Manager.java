package com.COP2800GroupB.Project2.Company;

/**
 * Created by abirfaisal on 2/16/15.
 */
public class Manager {

    private boolean manager;    //isManager?
    private String title;       //Title
    private String department;  //Department

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
