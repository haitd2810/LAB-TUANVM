/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managestatisticresult;

import java.util.ArrayList;


public class Manage {

    void createStudent(ArrayList<Student> SList) {
        System.out.println("===== Management Student Program =======");
        GetInput getInput = new GetInput();
        while (true) {
            //[a-zA-Z ]: matches with character from a to z or A to Z and space
            //+: check happen one or more times
            String Name = getInput.getString("Name: ", "[a-zA-Z ]+");
            //[a-zA-Z0-9 ]: matches with character from a to z or A to Z or number from 0 to 9 and space
            //+: check happen one or more times
            String Class = getInput.getString("Classes: ", "[a-zA-Z0-9 ]+");
            double Math = getInput.getDouble("Maths:", "Maths");
            double Chemistry = getInput.getDouble("Chemistry:", "Chemistry");
            double Physics = getInput.getDouble("Physics:", "Physics");
            SList.add(new Student(Name, Class, Math, Chemistry, Physics));
            String answer = getInput.getString("Do you want to enter more student information?(Y/N):", "Y||N");
            if(answer.equals("N")){
                break;
            }
        }
    }
    void displayStudentInfo(ArrayList<Student> SList){
        //access all element in studnet list
        for(int i=0;i < SList.size();i++){
            float avg = (float) (SList.get(i).getMath()+SList.get(i).getPhysics()
                        +SList.get(i).getChemistry())/3;
            System.out.println("----- Student"+(i+1)+" info-------");
            System.out.println("Name:" + SList.get(i).getStudentName());
            System.out.println("Classes:"+SList.get(i).getClasses());
            System.out.printf("AVG:%.1f\n",avg);
            //check avg to get type of student
            if(avg>7.5){
                System.out.println("Type:A");
            }else if(avg>=6 && avg <=7.5){
                System.out.println("Type:B");
            }else if(avg>=4 && avg <6){
                System.out.println("Type:C");
            }else{
                System.out.println("Type:D");
            }
        }
    }
    void displayClassificationInfo(ArrayList<Student> SList){
        float countA=0;
        float countB=0;
        float countC=0;
        float countD=0;
        System.out.println("--------- Classification Info ---------");
        for(int i=0; i < SList.size();i++){
            float avg = (float) (SList.get(i).getMath()+SList.get(i).getPhysics()
                        +SList.get(i).getChemistry())/3;
            if(avg>7.5){
                countA++;
            }else if(avg>=6 && avg <=7.5){
                countB++;
            }else if(avg>=4 && avg <6){
                countC++;
            }else{
                countD++;
            }
        }
        System.out.printf("A: %.1f", (countA*100)/SList.size());System.out.print("%\n");
        System.out.printf("B: %.1f", (countB*100)/SList.size());System.out.print("%\n");
        System.out.printf("C: %.1f", (countC*100)/SList.size());System.out.print("%\n");
        System.out.printf("D: %.1f", (countD*100)/SList.size());System.out.print("%\n");
    }
}
