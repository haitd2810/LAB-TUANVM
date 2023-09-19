/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentinfo68;

import java.util.Scanner;


public class GetInput {
    float getFloat(String msg){
        Scanner sc = new Scanner (System.in);
        float number;
        //loop again to when input number is ok
        while(true){
            try{
                System.out.print(msg);
                number = Float.parseFloat(sc.nextLine());
                //check number is positive number or not
                if(number > 0) break;
                throw new Exception();
            }catch(Exception e){
                
            }
        }
        return number;
    }
    
    String getString(String msg,String format){
        Scanner sc = new Scanner(System.in);
        String str;
        //loop again to when str input valid
        while(true){
            System.out.print(msg);
            str = sc.nextLine();
            //check input is empty or not
            if(str.trim().isEmpty()==false){
                //check input string is true format
                if(str.matches(format)==true){
                    break;
                }else{
                    System.out.println("Please enter true format");
                }
            }else{
                System.out.println("Not empty!");
            }
        }
        return str;
    }
}
