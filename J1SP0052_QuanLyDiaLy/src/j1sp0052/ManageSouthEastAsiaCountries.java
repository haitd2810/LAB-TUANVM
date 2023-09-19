/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0052;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ManageSouthEastAsiaCountries {

    public void AddCountryInformation(List<SouthEastAsiaCountries> EList) {
        CheckData check = new CheckData();
        SouthEastAsiaCountries country = new SouthEastAsiaCountries();
        String code, name, terrain;
        float totalArea;
        GetInput GetInput = new GetInput();
        //check list just have 11 countries SouthEast Asia
        if (EList.size() == 11) {
            System.out.println("There are 11 countries Southeast Asia in List. You are not input more country");
        } else {
            System.out.println("Enter country " + (EList.size() + 1) + ":");
            //loop to check code of country is duplicated or not
            while (true) {
                //[a-zA-Z]: just contains letter from a to z and A to Z
                //+: check happen one or more time
                code = GetInput.getString("Enter code of country:", "[a-zA-Z]+");
                //check code is duplicated or not
                if (check.checkIDDuplicate(code, EList) == true) {
                    break;
                } else {
                    System.out.println("This code is valid, please enter again!");
                }
            }
            //loop again to when name of country is in Southeast Asia
            while (true) {
                //.: contains character
                //+: check happen one or more time
                name = GetInput.getString("Enter name of country:", ".+");
                //check name of country is in Southeast Asia or not
                if (check.CheckNameCountryValid(name) == true) {
                    //check name of country is duplicated or not
                    if (check.checkNameCountryDuplicate(name, EList) == true) {
                        break;
                    }
                    System.out.println("This name of country is valid. Please enter again");
                } else {
                    System.out.println("This name is not in Southeast Asia. Please enter again!");
                }
            }
            totalArea = GetInput.getFloat("Enter total Area:", 0, Float.MAX_VALUE);
            //.: contains character
            //+: check happen one or more time
            terrain = GetInput.getString("Enter terrain of country:", ".+");
            country = new SouthEastAsiaCountries(code, name, totalArea, terrain);
            EList.add(country);
        }
    }

    public void SearchCountriesInformationByName(List<SouthEastAsiaCountries> EList) {
        String name;
        Scanner sc = new Scanner(System.in);
        GetInput GetInput = new GetInput();
        ArrayList<Integer> IList = new ArrayList<Integer>();
        //enter name with format is not empty
        name = GetInput.getString("Enter the name you want to search for:", ".+");
        //access all element in list to find name
        for (int i = 0; i < EList.size(); i++) {
            //check index of name in list
            if (EList.get(i).getCountryName().toLowerCase().contains(name.toLowerCase())) {
                IList.add(i);
            }
        }
        //check value index of country is valid in IList or not
        if (IList.size() == 0) {
            System.out.println("Not Found this name of country");
        } else {
            System.out.println("ID\t\t     Name\t\t  ToTal Area\t\tTerrain");
            //access index value in IList to compare with corresponding index of country in EList
            for (int i = 0; i < IList.size(); i++) {
                System.out.println(EList.get(IList.get(i)).toString());
            }
        }

    }

    public void SortInformationCountries(List<SouthEastAsiaCountries> EList) {
        Display display = new Display();
        //loop with time is equal size list to sort all element, each loop sort 1 element
        for (int i = 0; i < EList.size(); i++) {
            //access from first element to before the last element unsorted
            for (int j = 0; j < EList.size() - i - 1; j++) {
                if (EList.get(j).getCountryName().compareTo(EList.get(j + 1).getCountryName()) > 0) {
                    Collections.swap(EList, j, j + 1);
                }
            }
        }
        display.DisplayCountryInformation(EList);
    }

}
