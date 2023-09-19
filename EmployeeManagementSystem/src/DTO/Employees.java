/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Duy Hai
 */
public class Employees {
    private String id, FirstName,LastName, Email,Address,Sex,Agency;
    private String phone;
    private Date DOB;
    private double Salary;

    public Employees(){
    }

    public Employees(String id, String FirstName, String LastName, String Email, String Address, String Sex, String Agency, String phone, Date DOB, double Salary) {
        this.id = id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Address = Address;
        this.Sex = Sex;
        this.Agency = Agency;
        this.phone = phone;
        this.DOB = DOB;
        this.Salary = Salary;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getFirstName(){
        return FirstName;
    }

    public void setFirstName(String FirstName){
        this.FirstName = FirstName;
    }

    public String getLastName(){
        return LastName;
    }

    public void setLastName(String LastName){
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email){
        this.Email = Email;
    }

    public String getAddress(){
        return Address;
    }

    public void setAddress(String Address){
        this.Address = Address;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex){
        this.Sex = Sex;
    }

    public String getAgency(){
        return Agency;
    }

    public void setAgency(String Agency){
        this.Agency = Agency;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public Date getDOB(){
        return DOB;
    }

    public void setDOB(Date DOB){
        this.DOB = DOB;
    }

    public double getSalary(){
        return Salary;
    }

    public void setSalary(double Salary){
        this.Salary = Salary;
    }

    @Override
    public String toString(){
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%-4s %-13s %-12s %-12s %-26s %-10s %-4s %-10.1f %-13s", 
                id,FirstName,LastName,phone,Email,
                Address,Sex,Salary,Agency) + s.format(DOB) ; 
    }
    
}
