/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
class GetInput {
    int getChoice(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int choice;
        //loop to input again to when it ok
        while (true) {
            try {
                System.out.println(msg);
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= min && choice <= max) {
                    break;
                }
                throw new Exception();
            } catch (Exception e) {
            }
        }
        return choice;
    }
    int getInt(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int choice;
        //loop to input again to when it ok
        while (true) {
            try {
                System.out.println(msg);
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= min && choice <= max) {
                    break;
                }
                throw new Exception();
            } catch (Exception e) {
            }
        }
        return choice;
    }

    double getDouble(String msg, double min, double max) {
        Scanner sc = new Scanner(System.in);
        double choice;
        //loop to input again to when it ok
        while (true) {
            try {
                System.out.println(msg);
                choice = Double.parseDouble(sc.nextLine());
                if (choice >= min && choice <= max) {
                    break;
                }
                throw new Exception();
            } catch (Exception e) {
            }
        }
        return choice;
    }

    String getString(String msg, String format) {
        String str;
        Scanner sc = new Scanner(System.in);
        //loop to enter input again to when it ok
        while (true) {
            try {
                System.out.println(msg);
                str = sc.nextLine();
                //check input is not empty
                if (str.trim().isEmpty() == false) {
                    //check input is ok or not
                    if (str.matches(format) == true) {
                        break;
                    }
                }
                throw new Exception();
            } catch (Exception e) {
            }
        }
        return str;
    }

    public Date getDate(int opt, String msg) {
        Scanner sc = new Scanner(System.in);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        String str;
        //check format of date is ok or not
        while (true) {
            try {
                System.out.print(msg);
                str = sc.nextLine();
                /*compare date with format DD/MM/YYYY*/
            //[0-9]: check just be number from 0 to 9
            //{1,2}: check happen 1 or 2 times
            //{4}: check happen 4 time
                if (str.matches("[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}") == true) {
                    date = dateFormat.parse(str);
                    Date date2 = new Date();//new date() to get date at now
                    //check option to compare
                    /*
                    1: check date is in the past
                     */
                    if (opt == 1) {
                        //compare date is before now or not
                        if (date.compareTo(date2) <= 0) {
                            break;
                        } else {
                            System.out.println("Date is not in the future");
                        }
                    } else {
                        break;
                    }
                } else {
                    System.out.println("please enter true format of date (dd/MM/yyyy)");
                }
            } catch (Exception e) {
                System.out.println("Date is not exist!");
            }
        }
        return date;
    }
    
}
