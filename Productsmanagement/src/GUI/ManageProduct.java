/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class ManageProduct {

    public void addInformationProduct(ArrayList<Product> PList, ArrayList<Storekeeper> SList) {
        //check list Storekeeper is empty or not
        if (SList.isEmpty()) {
            System.out.println("Please add Storekeeper before add Product");
        } else {
            int ProductID, StorekeeperID;
            String ProductName, Location, Category, Storekeeper;
            double Price;
            Date ExpiryDate, DOManufacture, ReceiptDate;
            GetInput getInput = new GetInput();
            CheckData check = new CheckData();
            Display display = new Display();
            //loop again to when ProductID is ok
            while (true) {
                ProductID = getInput.getInt("Enter Product ID: ", 1, Integer.MAX_VALUE);
                //check ID Product is exist in list or not
                if (check.checkDuplicateIDProduct(ProductID, PList) == true) {
                    break;
                } else {
                    System.out.println("This ID Product is valid. Please enter again!");
                }
            }
            //[a-zA-Z ]: just contains character from a to z or A to Z and space
            //+: check happen one or more time
            ProductName = getInput.getString("Enter product Name: ", "[a-zA-Z ]+");
            //[a-zA-Z ]: just contains character from a to z or A to Z and space
            //+: check happen one or more time
            Location = getInput.getString("Enter Location of Product: ", "[a-zA-Z ]+");
            Price = getInput.getDouble("Enter price of Product: ", 1, Double.MAX_VALUE);
            DOManufacture = getInput.getDate(1, "Enter Date of Manufacture of Product: ");
            //loop to when Expiry Date is ok
            while (true) {
                ExpiryDate = getInput.getDate(2, "Enter Expiry Date:");
                //check Expiry Date is before date of manufacture or not
                if (ExpiryDate.compareTo(DOManufacture) > 0) {
                    break;
                } else {
                    System.out.println("Expiry Date must be after Date of Manufacture");
                }
            }
            //.: contains any chacracter
            //+: check happen one or more timr
            Category = getInput.getString("Enter category of product: ", ".+");
            //loop again to check storekeeper is valid on list storekeeper
            while (true) {
                int indexStorekeeperID = -1;
                display.displayInformationStorekeeper(SList);
                StorekeeperID = getInput.getInt("Enter ID of Storekeeper: ", 1, Integer.MAX_VALUE);
                //access all element of Storekeeper List to find ID is valid or not
                for (int i = 0; i < SList.size(); i++) {
                    //check StorekeerID is valid in Storekeeper list or not
                    if (SList.get(i).getStorekeeperID() == StorekeeperID) {
                        indexStorekeeperID = i;
                    }
                }
                //check Storekeeper is exist in list storekeeper or not
                if (indexStorekeeperID == -1) {
                    System.out.println("Not Found Storekeeper. Please enter again");
                } else {
                    Storekeeper = SList.get(indexStorekeeperID).getStorekeeperName();
                    break;
                }
            }
            //loop to when Expiry Date is ok
            while (true) {
                ReceiptDate = getInput.getDate(1, "Enter Receipt Date: ");
                //check receiptDate is after date of manufacture or not
                if (ReceiptDate.compareTo(DOManufacture) >= 0) {
                    break;
                } else {
                    System.out.println("Receipt date have to be after date of manufacture");
                }
            }
            PList.add(new Product(ProductID, ProductName, Location, Price, ExpiryDate, DOManufacture, Category, Storekeeper, ReceiptDate));
            display.displayInformationProduct(PList);
        }
    }

    public void updateInformationProduct(ArrayList<Product> PList, ArrayList<Storekeeper> SList) {
        String answer;
        CheckData check = new CheckData();
        GetInput getInput = new GetInput();
        Display display = new Display();
        int indexIDUpdate = -1;
        int NewIDProduct;
        int IDProduct;
        //loop again to update Product
        do {
            //loop again to when find ID of Product in List
            while (true) {
                IDProduct = getInput.getInt("Enter ID of Product want to update: ", 1, Integer.MAX_VALUE);
                //access all element of list product to find ID of product is valid in list or not
                for (int i = 0; i < PList.size(); i++) {
                    //check IDProduct is valid in list to update or not
                    if (PList.get(i).getProductID() == IDProduct) {
                        indexIDUpdate = i;
                    }
                }
                //check ID update is exist in product list or not
                if (indexIDUpdate != -1) {
                    break;
                } else {
                    System.out.println("This ID is not found in List. Please enter again");
                }
            }
            display.displayMenuUpdate();
            int choice = getInput.getInt("Enter option you want to update: ", 1, 9);
            switch (choice) {
                case 1:
                    //loop again to when ID ok
                    while (true) {
                        NewIDProduct = getInput.getInt("Enter new ID: ", 1, Integer.MAX_VALUE);
                        int indexNewID = -1;
                        //access all element of List Product to check new ID is duplicate or not
                        for (int i = 0; i < PList.size(); i++) {
                            //check new ID Product with other element except Product that is updating
                            if (i == indexIDUpdate) {
                                continue;
                            } else {
                                //check New ID Product is valid in List or not
                                if (PList.get(i).getProductID() == NewIDProduct) {
                                    indexNewID = i;
                                }
                            }
                        }
                        //check index is valid in list or not
                        if (indexNewID == -1) {
                            PList.get(indexIDUpdate).setProductID(NewIDProduct);
                            break;
                        } else {
                            System.out.println("This ID is duplicate in List. Please enter again");
                        }
                    }
                    System.out.println("Update Successfully");
                    break;
                case 2:
                    //[a-zA-Z ]: Just contains character from a to z or A to Z and space
                    //+: check happen one or more tiem
                    PList.get(indexIDUpdate).setProductName(getInput.getString("Enter new Name: ", "[a-zA-Z ]+"));
                    System.out.println("Update Successfully");
                    break;
                case 3:
                    //[a-zA-Z ]: Just contains character from a to z or A to Z and space
                    //+: check happen one or more tiem
                    PList.get(indexIDUpdate).setLocation(getInput.getString("Enter new Location of Product: ", "[a-zA-Z ]+"));
                    System.out.println("Update Successfully");
                    break;
                case 4:
                    PList.get(indexIDUpdate).setPrice(getInput.getDouble("Enter price of Product: ", 1, Double.MAX_VALUE));
                    System.out.println("Update Successfully");
                    break;
                case 5:
                    //loop again to when ExpiryDate is ok
                    while (true) {
                        Date ExpiryDate = getInput.getDate(2, "Enter new Expiry Date:");
                        //check Expiry Date is after date of manufacture or not
                        if (ExpiryDate.compareTo(PList.get(indexIDUpdate).getDOManufacture()) > 0) {
                            PList.get(indexIDUpdate).setExpiryDate(ExpiryDate);
                            System.out.println("Update Successfully");
                            break;
                        } else {
                            System.out.println("Expiry Date must be after Date of Manufacture");
                        }
                    }
                    break;
                case 6:
                    //loop again to when Date of manufacture is ok
                    while (true) {
                        Date DOManufacture = getInput.getDate(1, "Enter new Date Of Manufacture: ");
                        //check Date of manufacture is before Expiry date or not
                        if (DOManufacture.compareTo(PList.get(indexIDUpdate).getExpiryDate()) < 0) {
                            PList.get(indexIDUpdate).setDOManufacture(DOManufacture);
                            System.out.println("Update Successfully");
                            break;
                        } else {
                            System.out.println("Date of manufacture is before Expiry Date");
                        }
                    }
                    break;
                case 7:
                    //.: contains any character
                    //+: check happen one or more times
                    PList.get(indexIDUpdate).setCategory(getInput.getString("Enter category of product: ", ".+"));
                    System.out.println("Update Successfully");
                    break;
                case 8:
                    //loop again to when new storekeeper is valid
                    while (true) {
                        display.displayInformationStorekeeper(SList);
                        int StorekeeperID = getInput.getInt("Enter new Storekeeper: ", 1, Integer.MAX_VALUE);
                        //Check new Storekeeper is exist in list storekeeper or not
                        if (check.CheckExistStorekeeper(StorekeeperID, SList) == true) {
                            PList.get(indexIDUpdate).setStorekeeper(SList.get(StorekeeperID - 1).getStorekeeperName());
                            System.out.println("Update Successfully");
                            break;
                        } else {
                            System.out.println("Not Found This Storekeeper. Please enter again!");
                        }
                    }
                    break;
                case 9:
                    //loop again to Receipt date is ok
                    while (true) {
                        Date ReceiptDate = getInput.getDate(1, "Enter new Receipt Date: ");
                        //check receipt date is after (or in) date of manufacture or not
                        if (ReceiptDate.compareTo(PList.get(indexIDUpdate).getDOManufacture()) >= 0) {
                            PList.get(indexIDUpdate).setReceptDate(ReceiptDate);
                            System.out.println("Update Successfully");
                            break;
                        } else {
                            System.out.println("Receipt Date is not valid");
                        }
                    }
                    break;
            }
            //Y||y||N||n: Just be one in 4 character (Y or y or N or n)
            answer = getInput.getString("Do you want to continue? (Y|N)", "Y||y||N||n");
        } while (!answer.toLowerCase().equals("n"));
        display.displayInformationProduct(PList);
    }

    public void searchInformationProduct(ArrayList<Product> PList) {
        Display display = new Display();
        display.displayMenuSearch();
        GetInput getInput = new GetInput();
        int Choice = getInput.getChoice("Enter your choice: ", 1, 4);
        ArrayList<Integer> IList = new ArrayList<>();
        switch (Choice) {
            case 1:
                //.: contains any character
                //+: check happen one or more times
                String NameProduct = getInput.getString("Enter name of Product you want to search: ", ".+");
                //access all element in List Product to find name of product
                for (int i = 0; i < PList.size(); i++) {
                    //check Name of all elements of list product to find name is searching
                    if (PList.get(i).getProductName().toLowerCase().contains(NameProduct.toLowerCase())) {
                        IList.add(i);
                    }
                }
                break;
            case 2:
                //.: contains any character
                //+: check happen one or more times
                String Category = getInput.getString("Enter category of Product you want to search: ", ".+");
                //access all element in List Product to find category of product
                for (int i = 0; i < PList.size(); i++) {
                    //check category of all elements of list product to find category is searching
                    if (PList.get(i).getCategory().toLowerCase().contains(Category.toLowerCase())) {
                        IList.add(i);
                    }
                }
                break;
            case 3:
                //.: contains any character
                //+: check happen one or more times
                String Storekeeper = getInput.getString("Enter storekeeper of Product you want to search: ", ".+");
                //access all element in List Product to find storekeeper of product
                for (int i = 0; i < PList.size(); i++) {
                    //check storekeeper of all elements of list product to find storekeeper is searching
                    if (PList.get(i).getStorekeeper().toLowerCase().contains(Storekeeper.toLowerCase())) {
                        IList.add(i);
                    }
                }
                break;
            case 4:
                Date ReceiptDate = getInput.getDate(2, "Enter receipt date of product you want to search: ");
                //access all element in List Product to find ReceiptDate of product
                for (int i = 0; i < PList.size(); i++) {
                    //check ReceiptDate of all elements of list product to find ReceiptDate is searching
                    if (PList.get(i).getReceptDate().compareTo(ReceiptDate) == 0) {
                        IList.add(i);
                    }
                }
                break;
            default:
                break;
        }
        //check List index of data search have whatever value index or not
        if (IList.isEmpty()) {
            System.out.println("Not found");
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            System.out.printf("%-5s\t%-10s\t%-10s\t%.10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\n",
                    "ProductID", "ProductName", "Location", "Price", "ExpiryDate", "DOManufacture", "Category",
                    "Storekeeper", "ReceiptDate");
            //access all element of list index to get index of date search
            for (int i = 0; i < IList.size(); i++) {
                System.out.println(PList.get(IList.get(i)));
            }
        }
    }

    public void sortInformationProduct(ArrayList<Product> PList) {
        Collections.sort(PList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                //compare 2 ExpiryDate to sort the following date (compared to the remaining date) standing after
                if (o1.getExpiryDate().compareTo(o2.getExpiryDate()) != 0) {
                    return o1.getExpiryDate().compareTo(o2.getExpiryDate());
                } 
                //check if ExpiryDate equal, Compare ReceiptDate to sort
                else {
                    return o1.getReceptDate().compareTo(o2.getReceptDate());
                }
            }
        });
        Display display = new Display();
        display.displayInformationProduct(PList);
    }
}
