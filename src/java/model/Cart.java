/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author xuank
 */
public class Cart {

    int CartID;
    int UserID;

    public Cart() {
    }

    public Cart(int CartID, int UserID) {
        this.CartID = CartID;
        this.UserID = UserID;
    }

    public int getCartID() {
        return CartID;
    }

    public void setCartID(int CartID) {
        this.CartID = CartID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    @Override
    public String toString() {
        return "Sales{" + "CartID=" + CartID + ", UserID=" + UserID + '}';
    }
}
