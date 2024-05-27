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
public class Admins {
     int Admin_ID ;
    String Admin_Email ;
   String Admin_Password ;
 String   Admin_Address ;
   String Admin_PhoneNum ;
  int  Role_ID ;
   Date Created;
   Date Updated_At ;

    public Admins() {
    }

    public Admins(int Admin_ID, String Admin_Email, String Admin_Password, String Admin_Address, String Admin_PhoneNum, int Role_ID, Date Created, Date Updated_At) {
        this.Admin_ID = Admin_ID;
        this.Admin_Email = Admin_Email;
        this.Admin_Password = Admin_Password;
        this.Admin_Address = Admin_Address;
        this.Admin_PhoneNum = Admin_PhoneNum;
        this.Role_ID = Role_ID;
        this.Created = Created;
        this.Updated_At = Updated_At;
    }

    public int getAdmin_ID() {
        return Admin_ID;
    }

    public void setAdmin_ID(int Admin_ID) {
        this.Admin_ID = Admin_ID;
    }

    public String getAdmin_Email() {
        return Admin_Email;
    }

    public void setAdmin_Email(String Admin_Email) {
        this.Admin_Email = Admin_Email;
    }

    public String getAdmin_Password() {
        return Admin_Password;
    }

    public void setAdmin_Password(String Admin_Password) {
        this.Admin_Password = Admin_Password;
    }

    public String getAdmin_Address() {
        return Admin_Address;
    }

    public void setAdmin_Address(String Admin_Address) {
        this.Admin_Address = Admin_Address;
    }

    public String getAdmin_PhoneNum() {
        return Admin_PhoneNum;
    }

    public void setAdmin_PhoneNum(String Admin_PhoneNum) {
        this.Admin_PhoneNum = Admin_PhoneNum;
    }

    public int getRole_ID() {
        return Role_ID;
    }

    public void setRole_ID(int Role_ID) {
        this.Role_ID = Role_ID;
    }

    public Date getCreated() {
        return Created;
    }

    public void setCreated(Date Created) {
        this.Created = Created;
    }

    public Date getUpdated_At() {
        return Updated_At;
    }

    public void setUpdated_At(Date Updated_At) {
        this.Updated_At = Updated_At;
    }
   
   
   
   
    
}
