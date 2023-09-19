/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personinfo;

import java.util.Scanner;


public class GetInput {
    String getString(String msg, String format){
        String str;
        Scanner sc = new Scanner(System.in);
        //loop again to when string input valid
        while(true){
            try{
                System.out.print(msg);
                str = sc.nextLine();
                //check input is empty or not
                if(str.isEmpty()==false){
                    //check format input
                    if(str.matches(format)==true){
                        break;
                    }
                    throw new Exception();
                }
            }catch(Exception e){
                
            }
        }
        return str;
    }
    double getDouble(String msg){
        double number;
        Scanner sc = new Scanner (System.in);
        //loop again to when input number valid
        while(true){
            try{
                System.out.print(msg);
                number = Double.parseDouble(sc.nextLine());
                //check number is positive number or not
                if(number >0){
                    break;
                }else{
                    System.out.println("you must input a positive number");
                }
                
            }catch(Exception e){
                System.out.println("you must input digit");
            }
        }
        return number;
    }
}
