/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personinfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ManagementPerson {

    void inputPersonInformation(Person[] Person) {
        int count = 0;
        //loop again to when input enough 3 person
        while (count < 3) {
            System.out.println("============Management Person Programmer===========");
            GetInput getInput = new GetInput();
            //[a-zA-Z ]: matches with character from a to z or A to Z and psace
            //+: check happen one or more times
            String Name = getInput.getString("Please input name:", "[a-zA-Z ]+");
            //[a-zA-Z ]: matches with character from a to z or A to Z and psace
            //+: check happen one or more times
            String address = getInput.getString("Please input address:", "[a-zA-Z ]+");
            double salary = getInput.getDouble("Please input salary:");
            Person[count]=new Person(Name, address, salary);
            count++;
        }
    }

    void displayPersonInfo(Person[] Person) {
        //access all element in person list
        for (int i = 0; i < Person.length; i++) {
            System.out.println("Information of Person you have entered:");
            System.out.println(Person[i]);
            System.out.println();
        }
    }

    void SortPersonInfo(Person[] Person) {
        /*loop with times is equal size of person to sort all person
        each loop sort 1 person*/
        for(int i=0; i < Person.length;i++){
            //access from first element to before the last element unsorted
            for(int j=0; j < Person.length-i-1;j++){
                //compare 1 pair person
                if(Person[j].getSalary()>Person[j+1].getSalary()){
                    Person temp = Person[j];
                    Person[j] = Person[j+1];
                    Person[j+1]=temp;
                }
            }
        }
    }
}
