/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0052;

import java.util.List;
import java.util.Scanner;

public class GetInput {

    public float getFloat(String msg, float min, float max) {
        float number;
        Scanner sc = new Scanner(System.in);
        //loop to enter input again to when it ok
        while (true) {
            try {
                System.out.println(msg);
                number = Float.parseFloat(sc.nextLine());
                //check input is in range or not
                if (number > min && number < max) {
                    break;
                }
                throw new Exception();
            } catch (Exception e) {
            }
        }
        return number;
    }

    public String getString(String msg, String Format) {
        String str;
        Scanner sc = new Scanner(System.in);
        //loop to enter input again to when it ok
        while (true) {
            try {
                System.out.println(msg);
                str = sc.nextLine();
                //check input is ok or not
                if (str.matches(Format) == true) {
                    break;
                }
                throw new Exception();
            } catch (Exception e) {
            }
        }
        return str;
    }

    public int getInt(String msg, int min, int max) {
        int Number;
        Scanner sc = new Scanner(System.in);
        //loop to enter input again to when it ok
        while (true) {
            try {
                System.out.print(msg);
                Number = Integer.parseInt(sc.nextLine());
                //check number input is in range or not
                if (Number >= min && Number <= max) {
                    break;
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Please enter an number in range (" + min + "->" + max + ")");
            }
        }
        return Number;
    }
}
