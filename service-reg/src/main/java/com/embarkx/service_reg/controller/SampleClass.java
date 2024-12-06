package com.embarkx.service_reg.controller;


//id, name, Address -> address 1, add 2, pincode, Department and Salary
public class SampleClass {

    private final int id;
    private final String name;
    private final String department;
    private final Long salary;
    private final Address address;

    public SampleClass(int id, String name, String department, Long salary, Address address) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.address = address;
    }

    public final int getId() {
        return id;
    }

    public final String getName() {
        return name;
    }

    public final String getDepartment() {
        return department;
    }

    public final Address getAddress() {
        return address;
    }
}
