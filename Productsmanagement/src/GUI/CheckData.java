/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;

public class CheckData {
    
    public boolean checkDuplicateNameStorekeeper(String StorekeeperName, ArrayList<Storekeeper> SList){
        //access all element of list to find id of storekeeper
        for (int i = 0; i < SList.size(); i++) {
            //check StorekeeperID is valid in list or not
            if (StorekeeperName.equals(SList.get(i).getStorekeeperName())) {
                return false;
            }
        }
        return true;
    }
    public boolean checkDuplicateIDProduct(int ProductID, ArrayList<Product> PList) {
        //access all elelemt of list to find id of product
        for (int i = 0; i < PList.size(); i++) {
            //checl Product ID is valid in list or not
            if (ProductID == PList.get(i).getProductID()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean CheckExistStorekeeper(int StorekeeperID, ArrayList<Storekeeper> SList){
        //access all element of list to find id of storekeeper
        for (int i = 0; i < SList.size(); i++) {
            //check StorekeeperID is valid in list or not
            if (SList.get(i).getStorekeeperID()==StorekeeperID) {
                return true;
            }
        }
        return false;
    }
}
