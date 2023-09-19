/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentinfo68;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Manage {
    void inputStudentInformation(ArrayList<Student> SList){
        GetInput getInput = new GetInput();
        System.out.println("============ Collection Sort Program ==============");
        while(true){
            System.out.println("Please input student information");
            String name = getInput.getString("Name: ", "[a-zA-Z ]+");
            String Classes = getInput.getString("classes: ", "[A-Z0-9]+");
            float mark = getInput.getFloat("Mark: ");
            SList.add(new Student(name, mark, Classes));
            String answer = getInput.getString("Do you want to enter more student information?(Y/N):", "Y||N");
            //check answer to continue or break
            if(answer.equals("N")){
                break;
            }
        }
    }
    void sortStudentInformation(ArrayList<Student> SList){
        Collections.sort(SList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }
    void displayStudentInformation(ArrayList<Student> SList){
        //access all elemnt in student list
        for(int i=0; i < SList.size();i++){
            System.out.println("---------------Student "+(i+1)+"--------------");
            System.out.println(SList.get(i));
        }
    }
}
