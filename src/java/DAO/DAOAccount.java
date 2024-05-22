/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author Admin
 */
public class DAOAccount extends DBContext {

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Account where isAdmin != 1";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setAccountID(rs.getInt(1));
                account.setUsername(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setIsAdmin(rs.getBoolean(4));
                account.setIsStaff(rs.getBoolean(5));
                list.add(account);
            }
        } catch (Exception ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Account login(String user, String pass) {
        try {
            String sql = "SELECT * FROM Users where [users] = ? and pass = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setAccountID(rs.getInt(1));
                account.setUsername(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setIsAdmin(rs.getBoolean(4));
                account.setIsStaff(rs.getBoolean(5));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Account checkAccountExist(String user) {
        try {
            String sql = "SELECT * FROM Users where [users] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setAccountID(rs.getInt(1));
                account.setUsername(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setIsAdmin(rs.getBoolean(4));
                account.setIsStaff(rs.getBoolean(5));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertAccount(String user, String pass) {
        try {
            String sql = "INSERT INTO [dbo].[Account]\n"
                    + "           ([Username]\n"
                    + "           ,[Password]\n"
                    + "           ,[IsAdmin]\n"
                    + "           ,[IsStaff])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ?\n"
                    + "           ?\n"
                    + "           ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, pass);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Account getAccountById(int accountId) {
        try {
            String sql = "select *  from Account where AccountID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, accountId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setAccountID(rs.getInt(1));
                account.setUsername(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setIsAdmin(rs.getBoolean(4));
                account.setIsStaff(rs.getBoolean(5));
                return account;
            }
        } catch (Exception ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateAccount(Account account) {

        try {
            String sql = "UPDATE [dbo].[Account]\n"
                    + "   SET [Username] = ?\n"
                    + "      ,[Password] = ?\n"
                    + "      ,[IsAdmin] = ?\n"
                    + "      ,[IsStaff] = ?\n"
                    + " WHERE AccountID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, account.getUsername());
            stm.setString(2, account.getPassword());
            stm.setBoolean(3, account.isIsAdmin());
            stm.setBoolean(4, account.isIsStaff());
            stm.setInt(5, account.getAccountID());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteAccount(int uid) {
        try {
            String sql = "DELETE FROM [Account]\n"
                    + "WHERE AccountID = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, uid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public static void main(String[] args) {
//        try {
//            System.out.println(new AccountDBContext().getAccountById(4));
//
//        } catch (Exception e) {
//        }
//    }
}
