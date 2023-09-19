/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.*;

/**
 *
 * @author Duy Hai
 */
public class EmployeeManegement {

    public void addInformationEmployee(ArrayList<Employees> EList) {
        CheckData check = new CheckData();
        Display display = new Display();
        Scanner sc = new Scanner(System.in);
        GetInput getInput = new GetInput();
        String id;
        //loop again to when id input is not duplicate
        while(true){
            //[0-9]: matches with just is number from 0 to 9
            //+: check happen one or more time
            id = getInput.getString("Enter ID of Employee: ", "[0-9]+", EList);
            //check id is exist in list or not
            if(check.CheckIDDuplicate(EList, id) == true){
                break;
            }else{
                System.out.println("This ID is duplicate. Please enter again.");
            }
        }
        //[a-zA-Z ]: is character from a to z or A to Z with space
        //+: check happen one or more time
        String FirstName=getInput.getString("Enter First Name: ", 
                                            "[a-zA-Z ]+", EList);
        //[a-zA-Z ]: is character from a to z or A to Z with space
        //+: check happen one or more time
        String LastName = getInput.getString("Enter Last Name: ", 
                                             "[a-zA-Z ]+", EList);
        //0: 0 have to be in first
        //[938]: the seccond number must be 9 or 3 or 8
        //[0-9]: just contains number from 0 to 9
        //{8}: just contains 8 number
        String Phone = getInput.getString("Enter phone Employee: ", 
                                          "0[938]{1}[0-9]{8}", EList);
        /*[a-zA-Z0-9_]: Matches with character is from a to z or A to Z 
        or number from 0 to 9 or character*/
        //+: check happen one or more time
        //[@]: just contains @
        //[a-zA-Z]: is character from a to z or A to Z
        //[.]: just constain character .
        String Email = getInput.getString("Enter email: ", 
                                "[a-zA-Z0-9_]+[@][a-zA-Z]+[.][a-zA-Z]+", EList);
        //[a-zA-Z ]: is character from a to z or A to Z with space
        //+: check happen one or more time
        String Address=getInput.getString("Enter address: ","[a-zA-Z ]+",EList);
        //F||M: just is F or M
        String Sex = getInput.getString("Enter sex(F or M): ", "F||M", EList);
        Double Salary = getInput.getDouble("Enter salary: ");
        //[a-zA-Z ]: is character from a to z or A to Z with space
        //+: check happen one or more time
        String agency = getInput.getString("Enter agency: ","[a-zA-Z ]+",EList);
        Date DOB = getInput.getDate();
        EList.add(new Employees(id, FirstName, LastName, Email, Address, 
                                Sex, agency, Phone, DOB, Salary));
        display.displayInformationEmployee(EList);
    }

    public void updateInformationEmployee(ArrayList<Employees> EList) {
        CheckData check = new CheckData();
        String answer;
        Scanner sc = new Scanner(System.in);
        GetInput getInput = new GetInput();
        String id;
        int indexID;
        //loop again to update employee
        do{
            //loop again to check idUpdate exist in list or not
            while(true){
                //[0-9]: Just is number from 0 to 9
                //+: check happen one or more time
                id = getInput.getString("Enter id you want to update: ", 
                                        "[0-9]+", EList);
                indexID = -1;
                //access all element of EList to find index of id
                for(int i = 0; i < EList.size(); i++) {
                    //compare each index with id to get index of id
                    if(EList.get(i).getId().equals(id)){
                        indexID = i;
                        break;
                    }
                }
                //check index of idUpdate is exist in list or not
                if(indexID == -1){
                    System.out.println("Not found ID want to update");
                }else{
                    break;
                }
            }
            Display display = new Display();
            display.displayMenuUpdate();
            int choice = getInput.getInt("Please enter your choice "
                                         + "what you want to update: ", 1, 11);
            //check choice to update by choice from menuUpdate
            switch(choice){
                case 1:
                    //loop again to input id is not duplicate with other
                    while(true){
                        //[0-9]: matches with just is digit from 0 to 9
                        //+: check happen one or more time
                        String IDUpdate = getInput.getString("Enter new id: ", 
                                                             "[0-9]+", EList);
                        int NewIndex = -1;
                        /*access all element in list to check id duplicate */
                        for(int i = 0; i < EList.size(); i++){
                            /*check position i 
                            to skip case position of empoyee is updating*/
                            if(i == indexID){
                                continue;
                            }else{
                                //check ID is valid in list (except ID updating)
                                if(EList.get(i).getId().equals(IDUpdate)){
                                    NewIndex = i;
                                }
                            }
                        }
                        //check new ID is duplicated or not
                        if(NewIndex == -1){
                            EList.get(indexID).setId(IDUpdate);
                            break;
                        }else{
                            System.out.print("This ID is duplicate.");
                            System.out.print(" Please enter again\n");
                        }
                    }
                    System.out.println("Update Successfully");
                    break;
                case 2:
                    //.: is any character
                    //+: check happen one or more time
                    String newFirstName =getInput.getString("Enter First Name:", 
                                                        ".+", EList);
                    EList.get(indexID).setFirstName(newFirstName);
                    System.out.println("Update Successfully");
                    break;
                case 3:
                    //.: is any character
                    //+: check happen one or more time
                    String newLastName=getInput.getString("Enter Last Name:", 
                                                          ".+", EList);
                    EList.get(indexID).setLastName(newLastName);
                    System.out.println("Update Successfully");
                    break;
                case 4:
                    /*[a-zA-Z0-9_]: Matches with character is [a-z]or [A-Z]
                    or number from [0-9]*/
                    //+: check happen one or more time
                    //[@]: just contains @
                    //[a-zA-Z]: is character from a to z or A to Z
                    //[.]: just constain character .
                    String newEmail=getInput.getString("Enter email: ", 
                                                       "[a-zA-Z0-9_]+[@][a-zA-Z]+[.][a-zA-Z]+", EList);
                    EList.get(indexID).setEmail(newEmail);
                    System.out.println("Update Successfully");
                    break;
                case 5:
                    //.: is any character
                    //+: check happen one or more time
                    String newAddress=getInput.getString("Enter address: ",
                                                         ".+", EList);
                    EList.get(indexID).setAddress(newAddress);
                    System.out.println("Update Successfully");
                    break;
                case 6:
                    //F||M: just is F or M
                    String Sex =getInput.getString("Enter sex(F or M): ", 
                                                   "F||M", EList);
                    EList.get(indexID).setSex(Sex);
                    System.out.println("Update Successfully");
                    break;
                case 7:
                    //.: is any character
                    //+: check happen one or more time
                    String newAgency=getInput.getString("Enter agency: ", 
                                                        ".+", EList);
                    EList.get(indexID).setAgency(newAgency);
                    System.out.println("Update Successfully");
                    break;
                case 8:
                    //0: 0 have to be in first
                    //[938]: the seccond number must be 9 or 3 or 8
                    //[0-9]: just contains number from 0 to 9
                    //{8}: just contains 8 number
                    String newPhone=getInput.getString("Enter phone Employee: ",
                                                       "0[938]{1}[0-9]{8}",EList);
                    EList.get(indexID).setPhone(newPhone);
                    System.out.println("Update Successfully");
                    break;
                case 9:
                    EList.get(indexID).setDOB(getInput.getDate());
                    System.out.println("Update Successfully");
                    break;
                case 10:
                    double newSalary=getInput.getDouble("Enter salary: ");
                    EList.get(indexID).setSalary(newSalary);
                    System.out.println("Update Successfully");
                    break;
                default:
                    break;
            }
            //Y||y||N||n: matches character just is Y or y or N or n
            answer = getInput.getString("Do you want to continue update?(Y/N)", 
                                        "Y||y||N||n", EList);
        }while(answer.toLowerCase().equals("n") == false);
        Display display = new Display();
        display.displayInformationEmployee(EList);

    }

    public void removeEmployee(ArrayList<Employees> EList){
        CheckData check = new CheckData();
        Scanner sc = new Scanner(System.in);
        GetInput getInput = new GetInput();
        String idRemove;
        //loop again to when not found ID want to remove
        while(true){
            //[0-9]: matches with number from 0-9
            idRemove = getInput.getString("Enter id you want to remove: ", 
                                          "[0-9]+", EList);
            //check idRemove is exist in list employees or not
            if(check.CheckIDDuplicate(EList, idRemove) == false){
                break;
            }else{
                System.out.println("Not Found ID in list");
            }
        }
        //access all element of EList to find index of id
        for(int i = 0; i < EList.size(); i++){
            //compare each index with id to get index of id
            if(EList.get(i).getId().equals(idRemove)){
                EList.remove(i);
                break;
            }
        }
        System.out.println("Delete successfully");
        Display display = new Display();
        display.displayInformationEmployee(EList);
    }

    public void searchInformationEmployee(ArrayList<Employees> EList) {
        ArrayList<Integer> IList = new ArrayList<>();
        GetInput getInput = new GetInput();
        String name;
        //.: matches with any character
        //+: check happen one or more time
        name = getInput.getString("Enter name of employee want to search: ", 
                                  ".+", EList);
        //access all element of employee list to find name in list
        for(int i = 0; i < EList.size(); i++){
            String FullName = EList.get(i).getFirstName() + " " 
                              + EList.get(i).getLastName();
            //check name is valid in list or not
            if(FullName.toLowerCase().contains(name.toLowerCase())){
                IList.add(i);
            }
        }
        //check list index search have some index result Search or not
        if(IList.isEmpty()){
            System.out.println("Not Found");
        }else{
            System.out.printf("%-4s %-13s %-12s %-12s %-26s %-10s %-4s %-10s %-12s %10s\n",
                    "ID", "First Name", "Last Name", "Phone", "Email", "Address",
                    "Sex", "Salary", "Agency", "Date Of Birth");
            //access all value of IList to display
            for(int i = 0; i < IList.size(); i++){
                System.out.println(EList.get(IList.get(i)));
            }
        }
    }

    public void sortInformationEmployee(ArrayList<Employees> EList) {
        /*loop with time equal size of EList to sort all element of EList. 
        each loop sort 1 element*/
        for(int i = 0; i < EList.size(); i++){
            //access from first element to before the last element unsorted
            for(int j = 0; j < EList.size() - i - 1; j++){
                /*compare 1 pair element to sort Employee have bigger Salary is
                 stand after Employee have smaller salary*/
                if(EList.get(j).getSalary() > EList.get(j + 1).getSalary()){
                    Collections.swap(EList, j, j + 1);
                }
            }
        }
        Display display = new Display();
        display.displayInformationEmployee(EList);
    }
}
