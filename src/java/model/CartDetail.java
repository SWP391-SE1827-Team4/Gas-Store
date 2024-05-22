/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author xuank
 */
public class CartDetail {

    int OrderDetail_ID;
    int OrderID;
    int ProductID;
    int Order_Quantity;
    String OrderDetail_Status;
    float Total_Amount_Paid;
    Date Created_At;
    Date Updated_At;

    public CartDetail() {
    }

    public CartDetail(int OrderDetail_ID, int OrderID, int ProductID, int Order_Quantity, String OrderDetail_Status, float Total_Amount_Paid, Date Created_At, Date Updated_At) {
        this.OrderDetail_ID = OrderDetail_ID;
        this.OrderID = OrderID;
        this.ProductID = ProductID;
        this.Order_Quantity = Order_Quantity;
        this.OrderDetail_Status = OrderDetail_Status;
        this.Total_Amount_Paid = Total_Amount_Paid;
        this.Created_At = Created_At;
        this.Updated_At = Updated_At;
    }

    public int getOrderDetail_ID() {
        return OrderDetail_ID;
    }

    public void setOrderDetail_ID(int OrderDetail_ID) {
        this.OrderDetail_ID = OrderDetail_ID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getOrder_Quantity() {
        return Order_Quantity;
    }

    public void setOrder_Quantity(int Order_Quantity) {
        this.Order_Quantity = Order_Quantity;
    }

    public String getOrderDetail_Status() {
        return OrderDetail_Status;
    }

    public void setOrderDetail_Status(String OrderDetail_Status) {
        this.OrderDetail_Status = OrderDetail_Status;
    }

    public float getTotal_Amount_Paid() {
        return Total_Amount_Paid;
    }

    public void setTotal_Amount_Paid(float Total_Amount_Paid) {
        this.Total_Amount_Paid = Total_Amount_Paid;
    }

    public Date getCreated_At() {
        return Created_At;
    }

    public void setCreated_At(Date Created_At) {
        this.Created_At = Created_At;
    }

    public Date getUpdated_At() {
        return Updated_At;
    }

    public void setUpdated_At(Date Updated_At) {
        this.Updated_At = Updated_At;
    }

    @Override
    public String toString() {
        return "CartDetail{" + "OrderDetail_ID=" + OrderDetail_ID + ", OrderID=" + OrderID + ", ProductID=" + ProductID + ", Order_Quantity=" + Order_Quantity + ", OrderDetail_Status=" + OrderDetail_Status + ", Total_Amount_Paid=" + Total_Amount_Paid + ", Created_At=" + Created_At + ", Updated_At=" + Updated_At + '}';
    }

}
