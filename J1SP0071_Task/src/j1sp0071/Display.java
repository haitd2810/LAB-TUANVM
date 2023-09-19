/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0071;

import java.util.ArrayList;

/**
 *
 * @author Duy Hai
 */
public class Display {

    public void Displaymenu() {
        System.out.println("==========Task program==========");
        System.out.println("1. Add Task");
        System.out.println("2. Delete task");
        System.out.println("3. Display Task");
        System.out.println("4. exit");
    }
    public void DisplayDataTasks (ArrayList<Task> TList){
        System.out.println("ID\tName\t\tTask Type\tDate\t\tTime\tAssignee\tReviewer");
        //access all element of List to display
        for(int i=0; i< TList.size();i++){
            System.out.println(TList.get(i));
        }
    }
}
