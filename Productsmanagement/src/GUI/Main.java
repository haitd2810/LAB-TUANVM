/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GetInput getInput = new GetInput();
        Display display = new Display();
        ManageStorekeeper managerStorekeeper = new ManageStorekeeper();
        ManageProduct managerProduct = new ManageProduct();
        ArrayList<Storekeeper> SList = new ArrayList<>();
        ArrayList<Product> PList = new ArrayList<>();
        int choice;
        //loop again to when user want to exit
        do{
            //step 1: Display menu
            display.displayMenu();
            //step 2: Selects an choice from option of menu
            choice = getInput.getChoice("Enter your choice: ",1,6);
            //step 3: display option by choice
            switch (choice) {
                //step 3.1: Add information Storekeeper
                case 1: 
                    managerStorekeeper.addInformationStorekeeper(SList);
                    break;
                //step 3.2: Add information product
                case 2:
                    managerProduct.addInformationProduct(PList, SList);
                    break;
                //step 3.3: Update information product
                case 3:
                    managerProduct.updateInformationProduct(PList, SList);
                    break;
                //step 3.4: Search information product by Name, Category, Storekeeper, ReceiptDate
                case 4:
                    managerProduct.searchInformationProduct(PList);
                    break;
                //step 3.5: Sort information product by Expiry date and Date of manufacture
                case 5:
                    managerProduct.sortInformationProduct(PList);
                    break;
                //step 3.6: exit
                case 6:
                    break;
            }
        }while(choice!=6);
    }

}
