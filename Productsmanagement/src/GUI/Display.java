/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


class Display {

    void displayMenu() {
        System.out.println("====================================================");
        System.out.println("1. Add Storekeeper");
        System.out.println("2. Add Product");
        System.out.println("3. Update Product");
        System.out.println("4. Search Product (By Name, Category, Storekeeper, ReceiptDate)");
        System.out.println("5. Sort Product (by Expiry date, Date of manufacture)");
        System.out.println("6. exist");
        System.out.println("====================================================");
    }

    void displayInformationStorekeeper(ArrayList<Storekeeper> SList) {
        if (SList.isEmpty()) {
            System.out.println("List StoreKeeper is empty!");
        } else {
            System.out.printf("%s\t%-10s", "StorekeeperID", "StorekeeperName");
            //access all element of list Storekeeper to display
            for (int i = 0; i < SList.size(); i++) {
                System.out.printf("\n%d\t\t%-10s", SList.get(i).getStorekeeperID(), SList.get(i).getStorekeeperName());
            }
            System.out.println();
        }
    }
    
    void displayInformationProduct(ArrayList<Product> PList){
        if (PList.isEmpty()) {
            System.out.println("List StoreKeeper is empty!");
        } else {
            System.out.printf("%-5s\t%-10s\t%-10s\t%.10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\n",
                    "ProductID", "ProductName","Location","Price","ExpiryDate","DOManufacture","Category",
                    "Storekeeper","ReceiptDate");
            //access all element of list Storekeeper to display
            for (Product product : PList) {
                System.out.println(product);
            }
            System.out.println();
        }
    }
    
    void displayMenuUpdate(){
        System.out.println("1. Update ID");
        System.out.println("2. Update Name of Product");
        System.out.println("3. Update Location");
        System.out.println("4. Update Price");
        System.out.println("5. Update Expiry Date");
        System.out.println("6. Update Date Of Manufacture");
        System.out.println("7. Update Category");
        System.out.println("8. Update Storekeeper of Product");
        System.out.println("9. Update Receipt Date");
    }
    
    void displayMenuSearch(){
        System.out.println("What do you want to search by: ");
        System.out.println("1. By Name");
        System.out.println("2. By Category");
        System.out.println("3. By Storekeeper");
        System.out.println("4. By ReceiptDate");
    }

}
