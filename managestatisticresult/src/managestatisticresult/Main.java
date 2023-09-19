/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managestatisticresult;

import java.util.ArrayList;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Manage manage = new Manage();
        ArrayList<Student> SList = new ArrayList<>();
        //step 1: input student ìnormation
        manage.createStudent(SList);
        //step 2: display student info
        manage.displayStudentInfo(SList);
        //step 3: display classification infor
        manage.displayClassificationInfo(SList);
    }
    
}
