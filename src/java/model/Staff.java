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
public class Staff {

    int StaffID;
    String Staff_Email;
    String Staff_Password;
    String Staff_Address;
    String Staff_PhoneNum;
    String Staff_Gender;
    int Role_ID;
    private LocalDateTime created_At;
    private LocalDateTime updated_At;

    public Staff() {
    }

    public Staff(int StaffID, String Staff_Email, String Staff_Password, String Staff_Address, String Staff_PhoneNum, String Staff_Gender, int Role_ID, LocalDateTime created_At, LocalDateTime updated_At) {
        this.StaffID = StaffID;
        this.Staff_Email = Staff_Email;
        this.Staff_Password = Staff_Password;
        this.Staff_Address = Staff_Address;
        this.Staff_PhoneNum = Staff_PhoneNum;
        this.Staff_Gender = Staff_Gender;
        this.Role_ID = Role_ID;
        this.created_At = created_At;
        this.updated_At = updated_At;
    }

    public Staff(int StaffID, String email, String pass, String address, String phone, String gender, int roleID, LocalDate createdAt, LocalDate updatedAt) {
        this.StaffID = StaffID;
        this.Staff_Email = Staff_Email;
        this.Staff_Password = Staff_Password;
        this.Staff_Address = Staff_Address;
        this.Staff_PhoneNum = Staff_PhoneNum;
        this.Staff_Gender = Staff_Gender;
        this.Role_ID = Role_ID;
        this.created_At = created_At;
        this.updated_At = updated_At;
    }

    public Staff(int staffID, String staffEmail, String staffPassword, String staffAddress, String staffPhoneNum, String gender, LocalDateTime updatedAt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getStaffID() {
        return StaffID;
    }

    public void setStaffID(int StaffID) {
        this.StaffID = StaffID;
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
        return StaffID + " " + Staff_Email + " " + Staff_Password + " " + Staff_Address + " " + Staff_PhoneNum + " " + Staff_Gender + " " + Role_ID + " " + created_At + " " + updated_At;
    }

}
