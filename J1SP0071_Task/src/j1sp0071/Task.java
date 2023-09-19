/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0071;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Duy Hai
 */
public class Task {
    private int TaskID;
    private String RequirementName;
    private String TaskType;
    private Date date;
    private Double planFrom,planTo;
    private String assignee, Expert;

    public Task() {
    }

    public Task(int TaskID, String RequirementName, String TaskType, Date date, Double planFrom, Double planTo, String assignee, String Expert) {
        this.TaskID = TaskID;
        this.RequirementName = RequirementName;
        this.TaskType = TaskType;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.Expert = Expert;
    }

    public int getTaskID() {
        return TaskID;
    }

    public void setTaskID(int TaskID) {
        this.TaskID = TaskID;
    }

    

    public String getRequirementName() {
        return RequirementName;
    }

    public void setRequirementName(String RequirementName) {
        this.RequirementName = RequirementName;
    }

    public String getTaskType() {
        return TaskType;
    }

    public void setTaskType(String TaskType) {
        this.TaskType = TaskType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(Double planFrom) {
        this.planFrom = planFrom;
    }

    public Double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(Double planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getExpert() {
        return Expert;
    }

    public void setExpert(String Expert) {
        this.Expert = Expert;
    }
    
    

    @Override
    public String toString() {
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        return String.format("%d\t%-10s\t%-10s\t%-10s\t%.1f\t%-10s\t%-10s", 
                TaskID,RequirementName,TaskType, s.format(date),(planTo-planFrom),assignee,Expert); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
