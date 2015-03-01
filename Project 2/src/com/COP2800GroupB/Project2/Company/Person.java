package com.COP2800GroupB.Project2.Company;


public class Person {


    //Fields
    private Name name;
    private String email;
    private String phone;
    private Employee employee;
    private Address address;
    private Date dateCreated;


    //Constructor
    public Person(Name name, String email, String phone, Employee employee, Address address, Date dateCreated) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.employee = employee;
        this.address = address;
        this.dateCreated = dateCreated;
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

    public Date getDate() {
        return dateCreated;
    }

    public void setDate(Date date) {
        this.dateCreated = date;
    }
}