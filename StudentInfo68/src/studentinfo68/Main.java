/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentinfo68;

import java.util.ArrayList;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Manage manage = new Manage();
        ArrayList<Student> SList = new ArrayList<>();
        //Step 1: Input Student information
        manage.inputStudentInformation(SList);
        //step 2: Sort Student Information
        manage.sortStudentInformation(SList);
        //step 3: display Student information after sorted
        manage.displayStudentInformation(SList);
    }
    
}
