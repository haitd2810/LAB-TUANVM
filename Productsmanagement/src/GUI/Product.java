
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    private int ProductID;
    private String ProductName, Location;
    private double Price;
    private Date ExpiryDate, DOManufacture;
    private String Category, Storekeeper;
    private Date ReceptDate;

    public Product() {
    }

    public Product(int ProductID, String ProductName, String Location, double Price, Date ExpiryDate, Date DOManufacture, String Category, String Storekeeper, Date ReceptDate) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.Location = Location;
        this.Price = Price;
        this.ExpiryDate = ExpiryDate;
        this.DOManufacture = DOManufacture;
        this.Category = Category;
        this.Storekeeper = Storekeeper;
        this.ReceptDate = ReceptDate;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public Date getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(Date ExpiryDate) {
        this.ExpiryDate = ExpiryDate;
    }

    public Date getDOManufacture() {
        return DOManufacture;
    }

    public void setDOManufacture(Date DOManufacture) {
        this.DOManufacture = DOManufacture;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getStorekeeper() {
        return Storekeeper;
    }

    public void setStorekeeper(String Storekeeper) {
        this.Storekeeper = Storekeeper;
    }

    public Date getReceptDate() {
        return ReceptDate;
    }

    public void setReceptDate(Date ReceptDate) {
        this.ReceptDate = ReceptDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("%d\t\t%-10s\t%-10s\t%.1f\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s", 
                ProductID,ProductName,Location,Price,dateFormat.format(ExpiryDate),
                dateFormat.format(DOManufacture),Category,Storekeeper,dateFormat.format(ReceptDate)); //To change body of generated methods, choose Tools | Templates.
    }
    
}
