/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0071;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Duy Hai
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        int TaskID = 1;
        GetInput getInput = new GetInput();
        TaskManagement task = new TaskManagement();
        ArrayList<Task> TList = new ArrayList<>();
        Display display = new Display();
        int choice;
        //loop to display menu and requirement user choose option again
        do {
            //step 1: Display menu
            display.Displaymenu();
            //step 2: User choose an option from menu
            choice = getInput.getInt("Enter your choice", 1, 4);
            switch (choice) {
                //step 3: add task
                case 1:
                    task.addTask(TList,TaskID++);
                    break;
                //step 4: delete task
                case 2:
                    task.deleteTask(TList);
                    break;
                //step 5: show task
                case 3:
                    display.DisplayDataTasks(TList);
                    break;
                //step 6: exit the program
                case 4:
                    break;
            }

        } while (choice != 4);
    }
}