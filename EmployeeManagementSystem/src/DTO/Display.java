/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author Duy Hai
 */
public class Display {

    public void displayMenu(){
        System.out.println("===============================================");
        System.out.println("1. Add employees");
        System.out.println("2. Update employees");
        System.out.println("3. Remove employees");
        System.out.println("4. Search employees");
        System.out.println("5. Sort employees by salary");
        System.out.println("6. Exit");
        System.out.println("===============================================");
    }

    public void displayInformationEmployee(ArrayList<Employees> EList){
        System.out.printf("%-4s %-13s %-12s %-12s %-26s %-10s %-4s %-10s %-12s %10s\n",
                "ID", "First Name", "Last Name", "Phone", "Email", "Address",
                "Sex", "Salary", "Agency", "Date Of Birth");
        //access all element of List to display employee
        for(Employees employees : EList){
            System.out.println(employees);
        }
    }

    public void displayMenuUpdate(){
        System.out.println("Please enter what you want to update: ");
        System.out.println("1. Update ID");
        System.out.println("2. Update First Name");
        System.out.println("3. Update Last Name");
        System.out.println("4. Update Email");
        System.out.println("5. Update Address");
        System.out.println("6. Update Sex");
        System.out.println("7. Update Agency");
        System.out.println("8. Update Phone number");
        System.out.println("9. Update Date Of Birth");
        System.out.println("10. Update Salary");
        System.out.println("11. Exit");
    }


        
}
