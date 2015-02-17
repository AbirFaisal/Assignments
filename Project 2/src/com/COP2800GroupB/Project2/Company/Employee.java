package com.COP2800GroupB.Project2.Company;

/**
 * Created by abirfaisal on 2/16/15.
 */
public class Employee {

    String position;
    String hourlyRate;
    Manager manager;

    //Constructor
    public Employee(String position, String hourlyRate, Manager manager) {
        this.position = position;
        this.hourlyRate = hourlyRate;
        this.manager = manager;
    }

    //Setters and getters
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(String hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
