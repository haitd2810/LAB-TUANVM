/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0052;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        int choice;
        ManageSouthEastAsiaCountries manage = new ManageSouthEastAsiaCountries();
        List<SouthEastAsiaCountries> SList = new ArrayList<>();
        GetInput GetInput = new GetInput();
        Display display = new Display();
        //loop again to when user want to exit
        do {
            //step 1: Display menu
            display.DisplayMenu();
            //step 2: Selects an choice from option of menu
            choice = GetInput.getInt("Enter your choice: ", 1, 5);
            // step 3: display option by choice
            switch (choice) {
                //3.1: add the information of 11 countries in SouthEast Asia
                case 1:
                    manage.AddCountryInformation(SList);
                    break;
                //3.2: Display information of countries
                case 2:
                    display.DisplayCountryInformation(SList);
                    break;
                //3.3: Search information of countries by name
                case 3:
                    manage.SearchCountriesInformationByName(SList);
                    break;
                //3.4: Sort the information of countries increasing with the country name.
                case 4:
                    manage.SortInformationCountries(SList);
                    break;
                //3.5: Exit
                case 5:
                    break;
            }
        } while (choice != 5);
    }

    

}
