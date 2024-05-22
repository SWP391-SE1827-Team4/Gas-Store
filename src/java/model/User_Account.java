/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author xuank
 */
public class User_Account {

    int User_ID;
    String User_Name;
    String User_Password;
    String User_Email;
    String User_PhoneNum;
    String User_Address;
    String User_Gender;
    int Role_ID;
    private LocalDateTime created_At;
    private LocalDateTime updated_At;

    public User_Account() {
    }

    public User_Account(int User_ID, String User_Name, String User_Password, String User_Email, String User_PhoneNum, String User_Address, String User_Gender, int Role_ID, LocalDateTime created_At, LocalDateTime updated_At) {
        this.User_ID = User_ID;
        this.User_Name = User_Name;
        this.User_Password = User_Password;
        this.User_Email = User_Email;
        this.User_PhoneNum = User_PhoneNum;
        this.User_Address = User_Address;
        this.User_Gender = User_Gender;
        this.Role_ID = Role_ID;
        this.created_At = created_At;
        this.updated_At = updated_At;
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

    public String getUser_Gender() {
        return User_Gender;
    }

    public void setUser_Gender(String User_Gender) {
        this.User_Gender = User_Gender;
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
        return "User_Account{" + "User_ID=" + User_ID + ", User_Name=" + User_Name + ", User_Password=" + User_Password + ", User_Email=" + User_Email + ", User_PhoneNum=" + User_PhoneNum + ", User_Address=" + User_Address + ", User_Gender=" + User_Gender + ", Role_ID=" + Role_ID + ", created_At=" + created_At + ", updated_At=" + updated_At + '}';
    }

}
