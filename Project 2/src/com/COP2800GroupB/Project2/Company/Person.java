package com.COP2800GroupB.Project2.Company;

/**
 * Created by abirfaisal on 2/16/15.
 */
public class Person {

    //generate and assign a UUID maybe? or nah?
    Name name;
    String email;
    String phone;
    Employee employee;
    Address address;


    //Constructor
    public Person(Name name, String email, String phone, Employee employee, Address address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.employee = employee;
        this.address = address;
    }

    //Setters and Getters
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
