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
public class Staffs {
   
    int Staff_ID ;
   String Staff_Email;
  String  Staff_Password;
   String Staff_Address;
   String Staff_PhoneNum ;
   String Staff_Gender ;
   int Role_ID;
   Date Created_At ;
 Date Updated_At;

    public Staffs(int Staff_ID, String Staff_Email, String Staff_Password, String Staff_Address, String Staff_PhoneNum, String Staff_Gender, int Role_ID, Date Created_At, Date Updated_At) {
        this.Staff_ID = Staff_ID;
        this.Staff_Email = Staff_Email;
        this.Staff_Password = Staff_Password;
        this.Staff_Address = Staff_Address;
        this.Staff_PhoneNum = Staff_PhoneNum;
        this.Staff_Gender = Staff_Gender;
        this.Role_ID = Role_ID;
        this.Created_At = Created_At;
        this.Updated_At = Updated_At;
    }

    public Staffs() {
    }

    public int getStaff_ID() {
        return Staff_ID;
    }

    public void setStaff_ID(int Staff_ID) {
        this.Staff_ID = Staff_ID;
    }

    public String getStaff_Email() {
        return Staff_Email;
    }

    public void setStaff_Email(String Staff_Email) {
        this.Staff_Email = Staff_Email;
    }

    public String getStaff_Password() {
        return Staff_Password;
    }

    public void setStaff_Password(String Staff_Password) {
        this.Staff_Password = Staff_Password;
    }

    public String getStaff_Address() {
        return Staff_Address;
    }

    public void setStaff_Address(String Staff_Address) {
        this.Staff_Address = Staff_Address;
    }

    public String getStaff_PhoneNum() {
        return Staff_PhoneNum;
    }

    public void setStaff_PhoneNum(String Staff_PhoneNum) {
        this.Staff_PhoneNum = Staff_PhoneNum;
    }

    public String getStaff_Gender() {
        return Staff_Gender;
    }

    public void setStaff_Gender(String Staff_Gender) {
        this.Staff_Gender = Staff_Gender;
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
