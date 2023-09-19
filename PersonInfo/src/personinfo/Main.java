/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personinfo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ManagementPerson manage = new ManagementPerson();
        Person[] Person = new Person[3];
        //step 1: input person information
        manage.inputPersonInformation(Person);
        //step 2: Sort person information by salary
        manage.SortPersonInfo(Person);
        //step 3: display person information
        manage.displayPersonInfo(Person);
    }

}
