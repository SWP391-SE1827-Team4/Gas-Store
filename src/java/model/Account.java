/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author xuank
 */
public class Account {

    int AccountID;
    String Username;
    String Password;
    boolean isAdmin;
    boolean isStaff;

    public Account() {
    }

    public Account(int AccountID, String Username, String Password, boolean isAdmin, boolean isStaff) {
        this.AccountID = AccountID;
        this.Username = Username;
        this.Password = Password;
        this.isAdmin = isAdmin;
        this.isStaff = isStaff;
    }

    public Account(String Username, String Password, boolean isAdmin, boolean isStaff) {
        this.Username = Username;
        this.Password = Password;
        this.isAdmin = isAdmin;
        this.isStaff = isStaff;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isIsStaff() {
        return isStaff;
    }

    public void setIsStaff(boolean isStaff) {
        this.isStaff = isStaff;
    }

    @Override
    public String toString() {
        return "Account{" + "AccountID=" + AccountID + ", Username=" + Username + ", Password=" + Password + ", isAdmin=" + isAdmin + ", isStaff=" + isStaff + '}';
    }

}
