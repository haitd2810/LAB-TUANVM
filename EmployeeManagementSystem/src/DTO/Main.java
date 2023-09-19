/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.*;

/**
 *
 * @author Duy Hai
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Display display = new Display();
        ArrayList<Employees> EList = new ArrayList<>();
        EmployeeManegement manage = new EmployeeManegement();
        GetInput getInput = new GetInput();
        int choice;
        //loop to display menu and option of user again
        do{
            //step 1: display menu
            display.displayMenu();
            //step 2: Select an choice from option of menu
            choice = getInput.getChoice("Enter your choice: ", 1, 6);
            //step 3: Display option by choice 
            switch(choice){
                //step 3.1: add information employee
                case 1:
                    manage.addInformationEmployee(EList);
                    break;
                //step 3.2: Update information of employee
                case 2:
                    manage.updateInformationEmployee(EList);
                    break;
                //step 3.3: remove employee
                case 3:
                    manage.removeEmployee(EList);
                    break;
                //step 3.4: search information employee by name
                case 4:
                    manage.searchInformationEmployee(EList);
                    break;
                //step 3.5: sort information employeess by salary
                case 5:
                    manage.sortInformationEmployee(EList);
                    break;
                //step 3.6: exit
                case 6:
                    break;
            }
        }while(choice != 6);

    }

}
