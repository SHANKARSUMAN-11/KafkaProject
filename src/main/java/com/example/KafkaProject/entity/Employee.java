package com.example.KafkaProject.entity;

import java.util.Date;

public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Date dateOfJoining;

    public long getEmployeeId(){
        return employeeId;
    }
    public void setEmployeeId(long employeeId){
        this.employeeId=employeeId;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public String getLastName(){return lastName;}
    public void setLastName(String lastName){this.lastName=lastName;}

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
}
