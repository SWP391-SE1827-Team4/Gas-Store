/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author xuank
 */
public class Categories {

    int CategoryID;
    String CategoryName;
    int TotalProducts;
    String Description;

    public Categories() {
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public int getTotalProducts() {
        return TotalProducts;
    }

    public void setTotalProducts(int TotalProducts) {
        this.TotalProducts = TotalProducts;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "Categories{" + "CategoryID=" + CategoryID + ", CategoryName=" + CategoryName + ", TotalProducts=" + TotalProducts + ", Description=" + Description + '}';
    }

}
