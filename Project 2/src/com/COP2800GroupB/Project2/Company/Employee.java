package com.COP2800GroupB.Project2.Company;

/**
 * Created by abirfaisal on 2/16/15.
 */
public class Employee {

    boolean employee;   //is employee?
    String position;    //Employee Position
    String hourlyRate;  //Hourly Pay Rate
    Manager manager;    //Manager Object
    Date dateHired;     //Hold date hired


    //Constructor
    public Employee(boolean employee, String position, String hourlyRate, Manager manager, Date dateHired) {
        this.employee = employee;
        this.position = position;
        this.hourlyRate = hourlyRate;
        this.manager = manager;
        this.dateHired = dateHired;
    }


    //Setters and getters

    public boolean isEmployee() {
        return employee;
    }

    public void setEmployee(boolean employee) {

        //If not employee then set manager to false

        if (!employee){
            this.manager.setManager(false);
        }

        this.employee = employee;
    }

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

    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }
}
