/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

public class Products {
    private int productId;
    private int categoryId;
    private String serialProductNumber;
    private String productName;
    private int productQuantity;
    private int productPrice;
    private String productDescription;
    private String Image_URL;

    @Override
    public String toString() {
        return "Products{" + "productId=" + productId + ", categoryId=" + categoryId + ", serialProductNumber=" + serialProductNumber + ", productName=" + productName + ", productQuantity=" + productQuantity + ", productPrice=" + productPrice + ", productDescription=" + productDescription + ", Image_URL=" + Image_URL + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
    private Date createdAt;
    private Date updatedAt;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getSerialProductNumber() {
        return serialProductNumber;
    }

    public void setSerialProductNumber(String serialProductNumber) {
        this.serialProductNumber = serialProductNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getImage_URL() {
        return Image_URL;
    }

    public void setImage_URL(String Image_URL) {
        this.Image_URL = Image_URL;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Products(int productId, int categoryId, String serialProductNumber, String productName, int productQuantity, int productPrice, String productDescription, String Image_URL, Date createdAt, Date updatedAt) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.serialProductNumber = serialProductNumber;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.Image_URL = Image_URL;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Products() {
    }

    
}