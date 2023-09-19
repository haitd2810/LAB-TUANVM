/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0052;

import java.util.List;

public class Display {

    public void DisplayMenu() {
        System.out.println("\t\tMENU");
        System.out.println("========================================================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Diplay the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
        System.out.println("========================================================================");
    }

    public void DisplayCountryInformation(List<SouthEastAsiaCountries> EList){
        SouthEastAsiaCountries EAcountry = new SouthEastAsiaCountries();
        System.out.printf("ID\t\t     Name\t\t  ToTal Area\t\tTerrain");
        System.out.println();
        //access all element of EList to display
        for (int i = 0; i < EList.size(); i++) {
            System.out.println(EList.get(i).toString());
            System.out.println();
        }
    }
}
