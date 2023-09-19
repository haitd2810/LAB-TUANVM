/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managestatisticresult;

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
    double getDouble(String msg, String err){
        double number;
        Scanner sc = new Scanner (System.in);
        //loop again to when input number valid
        while(true){
            try{
                System.out.print(msg);
                number = Double.parseDouble(sc.nextLine());
                //check number is positive number or not
                if(number >=0 && number <=10){
                    break;
                }else if (number<0){
                    System.out.println(err + " is greater than equal zero");
                }else if(number >10){
                    System.out.println(err + " is lesst than equal ten");
                }
                
            }catch(Exception e){
            }
        }
        return number;
    }
}
