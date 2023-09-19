/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0071;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Duy Hai
 */
public class GetInput {

    public int getInt(String msg, int min, int max) {
        int Number;
        Scanner sc = new Scanner(System.in);
        //loop to enter input again to when it ok
        while (true) {
            try {
                System.out.print(msg);
                Number = Integer.parseInt(sc.nextLine());
                //check input is ok or not
                if (Number >= min && Number <= max) {
                    break;
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Please enter in range " + min + "-" + max);
            }
        }
        return Number;
    }

    public Double getDouble(String msg, double min, double max) {
        Double Number;
        Scanner sc = new Scanner(System.in);
        //loop to enter input again to when it ok
        while (true) {
            try {
                System.out.print(msg);
                String numberString = sc.nextLine();
                if (numberString.matches("[0-9]+[.][0||5]")==true) {
                    Number = Double.parseDouble(numberString);
                    //check input is ok or not
                    if (Number >= min && Number <= max) {
                        break;
                    }
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Please enter in range " + min + "-" + max +" and with form (number.0 or number.5)");
            }
        }
        return Number;
    }

    public String getString(String msg, String Patner) {
        String str;
        Scanner sc = new Scanner(System.in);
        //loop to requirement user enter input to when it ok
        while (true) {
            try {
                System.out.print(msg);
                str = sc.nextLine();
                if (str.isEmpty() == false) {
                    if (str.matches(Patner) == true) {
                        break;
                    }
                }
                throw new Exception();
            } catch (Exception e) {
            }
        }
        return str;
    }

    public Date getDate(String msg, String Patner) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        Scanner sc = new Scanner(System.in);
        String str;
        //loop to require enter input again to when it ok
        while (true) {
            try {
                System.out.print(msg);
                str = sc.nextLine();
                //check date ir true format or not
                if (str.matches(Patner) == true) {
                    date = dateFormat.parse(str);
                    Date date2 = dateFormat.parse(dateFormat.format(new Date()));
                    //check date is before now or not
                    if (date.compareTo(date2) >= 0) {
                        break;
                    }
                }
                throw new Exception();
            } catch (Exception e) {

            }
        }
        return date;
    }

    public int checkDupDate(Date date, List<Task> TList) {
        for (int i = 0; i < TList.size(); i++) {
            //compare date of 2 task is same or not
            if (TList.get(i).getDate().compareTo(date) == 0) {
                return i;
            }
        }
        return -1;
    }

}
