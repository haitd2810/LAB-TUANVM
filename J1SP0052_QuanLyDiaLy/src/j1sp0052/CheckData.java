/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0052;

import java.util.List;

public class CheckData {

    public boolean checkIDDuplicate(String code, List<SouthEastAsiaCountries> SList) {
        //access all element of List to find element duplicate
        for (int i = 0; i < SList.size(); i++) {
            //check code is entered is valid in list or not
            if (SList.get(i).getCountryCode().toUpperCase().equals(code.toUpperCase())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkNameCountryDuplicate(String CountryName, List<SouthEastAsiaCountries> SList) {
        //access all element is added to array to find element duplicate
        for (int i = 0; i < SList.size(); i++) {
            //check Name is entered is valid in list or not
            if (SList.get(i).getCountryName().toLowerCase().equals(CountryName.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public boolean CheckNameCountryValid(String CountryName) {
        String[] SoutheastAsia = {"Viet Nam", "Lao", "Campuchia", "Thai Lan",
            "Myanmar", "Malaysia", "Singapore", "Indonesia", "Brunei",
            "Philippines", "Dong Timor"};
        //access all element of array country to find CountryName is Southeast Asia or not
        for (int i = 0; i < SoutheastAsia.length; i++) {
            if (SoutheastAsia[i].toLowerCase().equals(CountryName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
