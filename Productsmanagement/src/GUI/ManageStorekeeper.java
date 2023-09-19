/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;


public class ManageStorekeeper {

    public void addInformationStorekeeper(ArrayList<Storekeeper> SList) {
        CheckData check = new CheckData();
        GetInput getInput = new GetInput();
        String StorekeeperName;
        //loop again to when name of storekeeper ok
        while(true){
            //[a-zA-Z ]: check just contains character from a to z or A to Z and space
            //+: check happen one or more time
            StorekeeperName = getInput.getString("Enter name of storekeeper: ", "[a-zA-Z ]+");
            //check Storekeeper is valid in list or not
            if(check.checkDuplicateNameStorekeeper(StorekeeperName, SList)==true){
                break;
            }else{
                System.out.println("This name of storekeeper is valid in list storekeeper. Please enter again");
            }
        }
        SList.add(new Storekeeper(SList.size()+1, StorekeeperName));
        Display display = new Display();
        display.displayInformationStorekeeper(SList);
    }
}
