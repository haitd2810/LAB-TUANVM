/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Duy Hai
 */
public class GetInput {
    public int getChoice(String msg,int min, int max){
        int choice;
        Scanner sc = new Scanner(System.in);
        //loop to check input again to when it ok
        while(true){
            try{
                System.out.print(msg);
                choice = Integer.parseInt(sc.nextLine());
                //check choice in range
                if(choice >= min && choice <= max){
                    break;
                }
                throw new Exception();
            }catch(Exception e){
                System.out.println("Please enter in range "+min+" - "+max);
            }
        }
        return choice;
    }   

    public int getInt(String msg,int min, int max){
        int number;
        Scanner sc = new Scanner(System.in);
        //loop to check input again to when it ok
        while(true){
            try{
                System.out.print(msg);
                number = Integer.parseInt(sc.nextLine());
                //check input number is in ragne or not
                if(number >= min && number <= max){
                    break;
                }
                throw new Exception();
            }catch(Exception e){
                System.out.println("Please enter in range "+min+" - "+max);
            }
        }
        return number;
    }

    public Double getDouble(String msg){
        Double number;
        Scanner sc = new Scanner(System.in);
        //loop to check input again to when it ok
        while(true){
            try{
                System.out.print(msg);
                number = Double.parseDouble(sc.nextLine());
                //check input number is positive number 
                if(number > 0){
                    break;
                }
                throw new Exception();
            }catch(Exception e){

            }
        }
        return number;
    }

    public String getString(String msg, String Format, List<Employees> EList){
        CheckData check = new CheckData();
        String s;
        Scanner sc = new Scanner(System.in);
        //loop to check input ok to when it ok
        while(true){
            try{
                System.out.print(msg);
                s = sc.nextLine();
                //check input is empty or not
                if(s.isEmpty() == false){
                    //check format of input is ok or not
                    if(s.matches(Format) == true){
                        break;
                    }
                }
                throw new Exception();
            }catch(Exception e){
            }
        }
        return s;
    }

    public Date getDate(){
        Scanner sc = new Scanner(System.in);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        String DateInput;
        //check format of date is ok or not
        while(true){
            try{
                System.out.print("Enter date: ");
                DateInput = sc.nextLine();
                /*compare date with format DD/MM/YYYY*/
                //[0-9]: just constain number from 0 to 9
                //{2}: check just happen 2 times
                //{4}: check just happen 4 times
                if(DateInput.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")){
                    date = dateFormat.parse(DateInput);
                    DateTimeFormatter localDateformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate localdate1=LocalDate.parse(DateInput, localDateformat);
                    LocalDate localnow = LocalDate.now();
                    Period period = Period.between(localdate1, localnow);
                    //compare date is in the past or not
                    if(localdate1.compareTo(localnow) <= 0){
                        //check date is enough 18 years old or not
                        if(period.getYears() >= 18){
                            break;
                        }else{
                            System.out.print("This employee is not enough 18.");
                            System.out.print(" Please enter again\n");
                        }
                    }else{
                        System.out.println("Date is not in the future");
                    }
                }else{
                    System.out.print("please enter true format of date");
                    System.out.print(" (dd/MM/yyyy)\n");
                }
            }catch(Exception e){
                System.out.println("Date is not exist!");
            }
        }
        return date;
    }
}
