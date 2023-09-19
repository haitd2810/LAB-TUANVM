/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.List;

/**
 *
 * @author Duy Hai
 */
public class CheckData{
    public boolean CheckIDDuplicate(List<Employees> EList, String ID){
        for(int i = 0; i < EList.size(); i++){
            if(EList.get(i).getId().equals(ID)){
                return false;
            }
        }
        return true;
    }
    
    
}
