/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0071;

import java.util.*;

/**
 *
 * @author Duy Hai
 */
public class TaskManagement {
    
    public void addTask(ArrayList<Task> TList, int TaskID){
        String name, assignee, reviewer, taskTypeID;
        String taskType = new String();
        Date date;
        Double planFrom, planTo;
        GetInput getInput = new GetInput();
        System.out.println("-------------Add Task---------------");
        //[a-zA-Z]: contains character from a to z or A to Z
        //+: check happen one or more time
        name = getInput.getString("Requirement name: ", "[a-zA-Z ]+");
        //[1-4]: Just contains number from 1 to 4
        //{1}: check happen just 1 time
        taskTypeID = getInput.getString("Task Type: ", "[1-4]{1}");
        //check taskTypeID to add tasktype
        switch(taskTypeID){
            case "1":
                taskType = "Code";
                break;
            case "2":
                taskType ="Test";
                break;
            case "3":
                taskType ="Design";
                break;
            case "4":
                taskType = "Review";
                break;
        }
        //[0-9]: just contains number from 0 to 9
        //{2}: check just happen 2 time
        //{4}: check just happen 4 time
        date = getInput.getDate("Date:", "[0-9]{2}-[0-9]{2}-[0-9]{4}");
        //loop to check time task is duplicated or not
        while(true){
            planFrom = getInput.getDouble("From: ", 8.0, 17);
            planTo = getInput.getDouble("To: ", planFrom+0.5, 17.5);
            int indexDup = getInput.checkDupDate(date, TList);
            //check date is valid on list or not
            if(indexDup!=-1){
                //check time of date in list and new time is added is duplicated or not
                if(planFrom <= TList.get(indexDup).getPlanFrom() && planTo <= TList.get(indexDup).getPlanFrom()){
                    break;
                }else if(planFrom >= TList.get(indexDup).getPlanTo()&& planTo >= TList.get(indexDup).getPlanTo()){
                    break;
                }else{
                    System.out.println("The time has been inserted into another time period ("
                            + TList.get(indexDup).getPlanFrom()+" - "+TList.get(indexDup).getPlanTo()+"). Please enter again!");
                }
            }else{
                break;
            }
        }
        //.: contains any character
        //+: check happen one or more time
        assignee = getInput.getString("Assignee: ", ".+");
        //.: contains any character
        //+: check happen one or more time
        reviewer = getInput.getString("Reviewer: ", ".+");
        Task task = new Task(TaskID,name, taskType, date, planFrom, planTo, assignee,reviewer );
        TList.add(task);
    }
    
    public void deleteTask (ArrayList<Task> TList){
        System.out.println("--------------Delete Task----------------");
        GetInput getInput = new GetInput();
        //enter id want to delete is not empty
        int id = getInput.getInt("ID: ", 0, Integer.MAX_VALUE);
        int index=-1;
        //access all element of list to find id
        for(int i = 0; i < TList.size();i++){
            if(TList.get(i).getTaskID() == id){
                index = i;
            }
        }
        if(index!=-1){
            TList.remove(index);
            System.out.println("Delete success");
        }else{
            System.out.println("Not found ID in List to delete");
        }
    }
    public void SortTasksByID(ArrayList<Task> TList){
        //loop with time is equal size list to sort all element, each loop sort 1 element
        for (int i = 0; i < TList.size(); i++) {
            //access from first element to before the last element unsorted
            for (int j = 0; j < TList.size() - i - 1; j++) {
                //compare 1 pair ID to sort element
                if (TList.get(j).getTaskID()>(TList.get(j + 1).getTaskID())) {
                    Collections.swap(TList, j, j + 1);
                }
            }
        }
    }
    
}
