/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Image;
import java.util.Date;
import java.time.LocalDateTime;

/**
 *
 * @author xuank
 */
public class Product {

    int ProductID;
    int CategoryID;
    String SerialProduct_Number;
    String Product_Name;
    int Product_Quantity;
    double Product_Price;
    String Product_Description;
    private String Image;
    private LocalDateTime created_At;
    private LocalDateTime updated_At;

    public Product() {
    }

    public Product(int ProductID, int CategoryID, String SerialProduct_Number, String Product_Name, int Product_Quantity, double Product_Price, String Product_Description, String Image, LocalDateTime updated_At) {
        this.ProductID = ProductID;
        this.CategoryID = CategoryID;
        this.SerialProduct_Number = SerialProduct_Number;
        this.Product_Name = Product_Name;
        this.Product_Quantity = Product_Quantity;
        this.Product_Price = Product_Price;
        this.Product_Description = Product_Description;
        this.Image = Image;
        this.updated_At = updated_At;
    }

    @Override
    public String toString() {
        return "Product{" + "ProductID=" + ProductID + ", CategoryID=" + CategoryID + ", SerialProduct_Number=" + SerialProduct_Number + ", Product_Name=" + Product_Name + ", Product_Quantity=" + Product_Quantity + ", Product_Price=" + Product_Price + ", Product_Description=" + Product_Description + ", Image=" + Image + ", created_At=" + created_At + ", updated_At=" + updated_At + '}';
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getSerialProduct_Number() {
        return SerialProduct_Number;
    }

    public void setSerialProduct_Number(String SerialProduct_Number) {
        this.SerialProduct_Number = SerialProduct_Number;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String Product_Name) {
        this.Product_Name = Product_Name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public int getProduct_Quantity() {
        return Product_Quantity;
    }

    public void setProduct_Quantity(int Product_Quantity) {
        this.Product_Quantity = Product_Quantity;
    }

    public double getProduct_Price() {
        return Product_Price;
    }

    public void setProduct_Price(double Product_Price) {
        this.Product_Price = Product_Price;
    }

    public String getProduct_Description() {
        return Product_Description;
    }

    public void setProduct_Description(String Product_Description) {
        this.Product_Description = Product_Description;
    }

    public LocalDateTime getCreated_At() {
        return created_At;
    }

    public void setCreated_At(LocalDateTime created_At) {
        this.created_At = created_At;
    }

    public LocalDateTime getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(LocalDateTime updated_At) {
        this.updated_At = updated_At;
    }

    public Product(int ProductID, int CategoryID, String SerialProduct_Number, String Product_Name, int Product_Quantity, double Product_Price, String Product_Description, String Image, LocalDateTime created_At, LocalDateTime updated_At) {
        this.ProductID = ProductID;
        this.CategoryID = CategoryID;
        this.SerialProduct_Number = SerialProduct_Number;
        this.Product_Name = Product_Name;
        this.Product_Quantity = Product_Quantity;
        this.Product_Price = Product_Price;
        this.Product_Description = Product_Description;
        this.Image = Image;
        this.created_At = created_At;
        this.updated_At = updated_At;
    }

}
