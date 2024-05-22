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
public class UserWarranty {

    int UserWarranty_ID;
    int Order_ID;
    int Product_ID;
    String Image;
    String Description;
    String UserWarranty_Status;
    Date UserWarranty_Start_Date;
    Date UserWarranty_End_Date;
    Date Created_At;
    Date Updated_At;
    int Staff_ID;

    public UserWarranty() {
    }

    
    public UserWarranty(int UserWarranty_ID, int Order_ID, int Product_ID, String Image, String Description, String UserWarranty_Status, Date UserWarranty_Start_Date, Date UserWarranty_End_Date, Date Created_At, Date Updated_At, int Staff_ID) {
        this.UserWarranty_ID = UserWarranty_ID;
        this.Order_ID = Order_ID;
        this.Product_ID = Product_ID;
        this.Image = Image;
        this.Description = Description;
        this.UserWarranty_Status = UserWarranty_Status;
        this.UserWarranty_Start_Date = UserWarranty_Start_Date;
        this.UserWarranty_End_Date = UserWarranty_End_Date;
        this.Created_At = Created_At;
        this.Updated_At = Updated_At;
        this.Staff_ID = Staff_ID;
    }

    public int getUserWarranty_ID() {
        return UserWarranty_ID;
    }

    public void setUserWarranty_ID(int UserWarranty_ID) {
        this.UserWarranty_ID = UserWarranty_ID;
    }

    public int getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(int Order_ID) {
        this.Order_ID = Order_ID;
    }

    public int getProduct_ID() {
        return Product_ID;
    }

    public void setProduct_ID(int Product_ID) {
        this.Product_ID = Product_ID;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getUserWarranty_Status() {
        return UserWarranty_Status;
    }

    public void setUserWarranty_Status(String UserWarranty_Status) {
        this.UserWarranty_Status = UserWarranty_Status;
    }

    public Date getUserWarranty_Start_Date() {
        return UserWarranty_Start_Date;
    }

    public void setUserWarranty_Start_Date(Date UserWarranty_Start_Date) {
        this.UserWarranty_Start_Date = UserWarranty_Start_Date;
    }

    public Date getUserWarranty_End_Date() {
        return UserWarranty_End_Date;
    }

    public void setUserWarranty_End_Date(Date UserWarranty_End_Date) {
        this.UserWarranty_End_Date = UserWarranty_End_Date;
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

    public int getStaff_ID() {
        return Staff_ID;
    }

    public void setStaff_ID(int Staff_ID) {
        this.Staff_ID = Staff_ID;
    }

    @Override
    public String toString() {
        return "UserWarranty{" + "UserWarranty_ID=" + UserWarranty_ID + ", Order_ID=" + Order_ID + ", Product_ID=" + Product_ID + ", Image=" + Image + ", Description=" + Description + ", UserWarranty_Status=" + UserWarranty_Status + ", UserWarranty_Start_Date=" + UserWarranty_Start_Date + ", UserWarranty_End_Date=" + UserWarranty_End_Date + ", Created_At=" + Created_At + ", Updated_At=" + Updated_At + ", Staff_ID=" + Staff_ID + '}';
    }

}
