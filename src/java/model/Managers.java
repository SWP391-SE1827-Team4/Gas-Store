/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.Date;
import java.time.LocalDateTime;

/**
 *
 * @author xuank
 */
public class Managers {

    int Manager_ID;
    String Manager_Email;
    String Manager_Password;
    String Manager_Address;
    String Manager_PhoneNum;
    String Manager_Gender;
    boolean IsAdmin;
    boolean IsStaff;
    private LocalDateTime created_At;
    private LocalDateTime updated_At;

    public Managers(int Manager_ID, String Manager_Email, String Manager_Password, String Manager_Address, String Manager_PhoneNum, String Manager_Gender, boolean IsAdmin, boolean IsStaff, LocalDateTime created_At, LocalDateTime updated_At) {
        this.Manager_ID = Manager_ID;
        this.Manager_Email = Manager_Email;
        this.Manager_Password = Manager_Password;
        this.Manager_Address = Manager_Address;
        this.Manager_PhoneNum = Manager_PhoneNum;
        this.Manager_Gender = Manager_Gender;
        this.IsAdmin = IsAdmin;
        this.IsStaff = IsStaff;
        this.created_At = created_At;
        this.updated_At = updated_At;
    }

    public Managers(int Manager_ID, String Manager_Email, String Manager_Password, String Manager_Address, String Manager_PhoneNum, String Manager_Gender, boolean IsAdmin, boolean IsStaff, LocalDateTime updated_At) {
        this.Manager_ID = Manager_ID;
        this.Manager_Email = Manager_Email;
        this.Manager_Password = Manager_Password;
        this.Manager_Address = Manager_Address;
        this.Manager_PhoneNum = Manager_PhoneNum;
        this.Manager_Gender = Manager_Gender;
        this.IsAdmin = IsAdmin;
        this.IsStaff = IsStaff;
        this.updated_At = updated_At;
    }

    public Managers() {
    }

    public int getManager_ID() {
        return Manager_ID;
    }

    public void setManager_ID(int Manager_ID) {
        this.Manager_ID = Manager_ID;
    }

    public String getManager_Email() {
        return Manager_Email;
    }

    public void setManager_Email(String Manager_Email) {
        this.Manager_Email = Manager_Email;
    }

    public String getManager_Password() {
        return Manager_Password;
    }

    public void setManager_Password(String Manager_Password) {
        this.Manager_Password = Manager_Password;
    }

    public String getManager_Address() {
        return Manager_Address;
    }

    public void setManager_Address(String Manager_Address) {
        this.Manager_Address = Manager_Address;
    }

    public String getManager_PhoneNum() {
        return Manager_PhoneNum;
    }

    public void setManager_PhoneNum(String Manager_PhoneNum) {
        this.Manager_PhoneNum = Manager_PhoneNum;
    }

    public String getManager_Gender() {
        return Manager_Gender;
    }

    public void setManager_Gender(String Manager_Gender) {
        this.Manager_Gender = Manager_Gender;
    }

    public boolean isIsAdmin() {
        return IsAdmin;
    }

    public void setIsAdmin(boolean IsAdmin) {
        this.IsAdmin = IsAdmin;
    }

    public boolean isIsStaff() {
        return IsStaff;
    }

    public void setIsStaff(boolean IsStaff) {
        this.IsStaff = IsStaff;
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

    @Override
    public String toString() {
        return "Managers{" + "Manager_ID=" + Manager_ID + ", Manager_Email=" + Manager_Email + ", Manager_Password=" + Manager_Password + ", Manager_Address=" + Manager_Address + ", Manager_PhoneNum=" + Manager_PhoneNum + ", Manager_Gender=" + Manager_Gender + ", IsAdmin=" + IsAdmin + ", IsStaff=" + IsStaff + ", created_At=" + created_At + ", updated_At=" + updated_At + '}';
    }

}
