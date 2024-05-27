/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Tuan anh
 */
public class Customers {
    
    int User_ID ;
    String User_Name ;
  String  User_Password ;
  String  User_Email ;
  String  User_PhoneNum ;
  String  User_Address ;
   int Role_ID ;
   Date Created_At ;
 Date   Updated_At ;

    public Customers() {
    }

    public Customers(int User_ID, String User_Name, String User_Password, String User_Email, String User_PhoneNum, String User_Address, int Role_ID, Date Created_At, Date Updated_At) {
        this.User_ID = User_ID;
        this.User_Name = User_Name;
        this.User_Password = User_Password;
        this.User_Email = User_Email;
        this.User_PhoneNum = User_PhoneNum;
        this.User_Address = User_Address;
        this.Role_ID = Role_ID;
        this.Created_At = Created_At;
        this.Updated_At = Updated_At;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int User_ID) {
        this.User_ID = User_ID;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String User_Name) {
        this.User_Name = User_Name;
    }

    public String getUser_Password() {
        return User_Password;
    }

    public void setUser_Password(String User_Password) {
        this.User_Password = User_Password;
    }

    public String getUser_Email() {
        return User_Email;
    }

    public void setUser_Email(String User_Email) {
        this.User_Email = User_Email;
    }

    public String getUser_PhoneNum() {
        return User_PhoneNum;
    }

    public void setUser_PhoneNum(String User_PhoneNum) {
        this.User_PhoneNum = User_PhoneNum;
    }

    public String getUser_Address() {
        return User_Address;
    }

    public void setUser_Address(String User_Address) {
        this.User_Address = User_Address;
    }

    public int getRole_ID() {
        return Role_ID;
    }

    public void setRole_ID(int Role_ID) {
        this.Role_ID = Role_ID;
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
    
  
    
    
}
