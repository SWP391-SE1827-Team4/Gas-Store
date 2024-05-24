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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.User_Account;

/**
 *
 * @author Admin
 */
public class DAOCustomer extends DBContext {

    public List<User_Account> getAllAccount() {
        List<User_Account> list = new ArrayList<>();
        try {
            String sql = "SELECT TOP (1000) [User_ID]\n"
                    + "      ,[User_Name]\n"
                    + "      ,[User_Password]\n"
                    + "      ,[User_Email]\n"
                    + "      ,[User_PhoneNum]\n"
                    + "      ,[User_Address]\n"
                    + "      ,[User_Gender]\n"
                    + "      ,[Created_At]\n"
                    + "      ,[Updated_At]\n"
                    + "      ,[IsCustomer]\n"
                    + "      ,[IsGuest]\n"
                    + "  FROM [GasStore].[dbo].[Users]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User_Account s = new User_Account();
                s.setUser_ID(rs.getInt(1));
                s.setUser_Name(rs.getString(2));
                s.setUser_Password(rs.getString(3));
                s.setUser_Email(rs.getString(4));
                s.setUser_PhoneNum(rs.getString(5));
                s.setUser_Address(rs.getString(6));
                s.setUser_Gender(rs.getString(7));

                // Convert Timestamp to LocalDateTime
                Timestamp createdAtTimestamp = rs.getTimestamp(8);
                LocalDateTime createdAt = createdAtTimestamp != null ? createdAtTimestamp.toLocalDateTime() : null;
                s.setCreated_At(createdAt);

                Timestamp updatedAtTimestamp = rs.getTimestamp(9);
                LocalDateTime updatedAt = updatedAtTimestamp != null ? updatedAtTimestamp.toLocalDateTime() : null;
                s.setUpdated_At(updatedAt);
                s.setIsCustomer(rs.getBoolean(10));
                s.setIsGuest(rs.getBoolean(11));
                list.add(s);
            }
        } catch (Exception ex) {
            Logger.getLogger(DAOManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

//    public Staff login(String user, String pass) {
//        try {
//            String sql = "SELECT * FROM Users where [users] = ? and pass = ?";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setString(1, user);
//            stm.setString(2, pass);
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                Account account = new Account();
//                account.setUid(rs.getInt(1));
//                account.setUsers(rs.getString(2));
//                account.setPass(rs.getString(3));
//                account.setIsSell(rs.getBoolean(4));
//                account.setIsAdmin(rs.getBoolean(5));
//                account.setActive(rs.getBoolean(6));
//                return account;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOStaff.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
    public User_Account checkAccountExist(String user) {
        try {
            String sql = "SELECT * FROM Users where [User_Name] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User_Account s = new User_Account();
                s.setUser_ID(rs.getInt(1));
                s.setUser_Name(rs.getString(2));
                s.setUser_Password(rs.getString(3));
                s.setUser_Email(rs.getString(4));
                s.setUser_PhoneNum(rs.getString(5));
                s.setUser_Address(rs.getString(6));
                s.setUser_Gender(rs.getString(7));

                // Convert Timestamp to LocalDateTime
                Timestamp createdAtTimestamp = rs.getTimestamp(8);
                LocalDateTime createdAt = createdAtTimestamp != null ? createdAtTimestamp.toLocalDateTime() : null;
                s.setCreated_At(createdAt);

                Timestamp updatedAtTimestamp = rs.getTimestamp(9);
                LocalDateTime updatedAt = updatedAtTimestamp != null ? updatedAtTimestamp.toLocalDateTime() : null;
                s.setUpdated_At(updatedAt);
                s.setIsCustomer(rs.getBoolean(10));
                s.setIsGuest(rs.getBoolean(11));

                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int insertUser(User_Account s) {
        String sql = "INSERT INTO [dbo].[Users]\n"
                + "           ([User_Name]\n"
                + "           ,[User_Password]\n"
                + "           ,[User_Email]\n"
                + "           ,[User_PhoneNum]\n"
                + "           ,[User_Address]\n"
                + "           ,[User_Gender]\n"
                + "           ,[Created_At]\n"
                + "           ,[Updated_At]\n"
                + "           ,[IsCustomer]\n"
                + "           ,[IsGuest])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,CONVERT(VARBINARY(MAX), ?)\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, s.getUser_Name());
            stm.setString(2, s.getUser_Password());
            stm.setString(3, s.getUser_Email());
            stm.setString(4, s.getUser_PhoneNum());
            stm.setString(5, s.getUser_Address());
            stm.setString(6, s.getUser_Gender());
            stm.setTimestamp(7, Timestamp.valueOf(s.getCreated_At()));
            stm.setTimestamp(8, Timestamp.valueOf(s.getUpdated_At()));
            stm.setBoolean(9, s.isIsCustomer());
            stm.setBoolean(10, s.isIsGuest());
            return stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public User_Account getCustomersById(int cid) {
        try {
            String sql = "SELECT * FROM Users WHERE User_ID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            ResultSet rs = stm.executeQuery();

            // Check if the ResultSet has any records
            if (rs.next()) {
                // Create a new Staff object
                User_Account c = new User_Account();

                // Set properties of the Staff object from ResultSet
                c.setUser_ID(rs.getInt(1));
                c.setUser_Name(rs.getString(2));
                c.setUser_Password(rs.getString(3));
                c.setUser_Email(rs.getString(4));
                c.setUser_PhoneNum(rs.getString(5));
                c.setUser_Address(rs.getString(6));
                c.setUser_Gender(rs.getString(7));

                // Convert Timestamp to LocalDateTime
                Timestamp createdAtTimestamp = rs.getTimestamp(8);
                LocalDateTime createdAt = createdAtTimestamp != null ? createdAtTimestamp.toLocalDateTime() : null;
                c.setCreated_At(createdAt);

                Timestamp updatedAtTimestamp = rs.getTimestamp(9);
                LocalDateTime updatedAt = updatedAtTimestamp != null ? updatedAtTimestamp.toLocalDateTime() : null;
                c.setUpdated_At(updatedAt);
                c.setIsCustomer(rs.getBoolean(10));
                c.setIsGuest(rs.getBoolean(11));

                // Return the Staff object
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Return null if no record found or error occurred
        return null;
    }

//    public void updateAccountStaff(Staff s) {
//
//        try {
//            String sql = "UPDATE [dbo].[Staff]\n"
//                    + "   SET [AccountID] = ?\n"
//                    + "      ,[Name] = ?\n"
//                    + "      ,[Email] = ?\n"
//                    + "      ,[Gender] = ?\n"
//                    + "      ,[Address] = ?\n"
//                    + "      ,[Phone] = ?\n"
//                    + "      ,[Position] = ?\n"
//                    + " WHERE StaffID = ?";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setInt(1, s.getAccountID());
//            stm.setString(2, s.getName());
//            stm.setString(3, s.getEmail());
//            stm.setString(4, s.getGender());
//            stm.setString(5, s.getAddress());
//            stm.setString(6, s.getPhone());
//            stm.setString(7, s.getPosition());
//            stm.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOStaff.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
    public void updateAccountCustomer(User_Account c) {

        try {
            String sql = "UPDATE [dbo].[Users]\n"
                    + "   SET [User_Name] = ?\n"
                    + "      ,[User_Password] = CONVERT(varbinary(64), ?)\n"
                    + "      ,[User_Email] = ?\n"
                    + "      ,[User_PhoneNum] = ?\n"
                    + "      ,[User_Address] = ?\n"
                    + "      ,[User_Gender] = ?\n"
                    + "      ,[Created_At] = ?\n"
                    + "      ,[Updated_At] = ?\n"
                    + "      ,[IsCustomer] = ?\n"
                    + "      ,[IsGuest] = ?\n"
                    + " WHERE User_ID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, c.getUser_Name());
            stm.setString(2, c.getUser_Password());
            stm.setString(3, c.getUser_Email());
            stm.setString(4, c.getUser_PhoneNum());
            stm.setString(5, c.getUser_Address());
            stm.setString(6, c.getUser_Gender());
            stm.setObject(7, c.getCreated_At());
            stm.setObject(8, c.getUpdated_At());
            stm.setBoolean(9, c.isIsCustomer());
            stm.setBoolean(10, c.isIsGuest());
            stm.setInt(11, c.getUser_ID());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateAccountCustomer1(User_Account c) {

        try {
            String sql = "UPDATE [dbo].[Users]\n"
                    + "   SET [User_Name] = ?\n"
                    + "      ,[User_Password] = CONVERT(varbinary(64), ?)\n"
                    + "      ,[User_Email] = ?\n"
                    + "      ,[User_PhoneNum] = ?\n"
                    + "      ,[User_Address] = ?\n"
                    + "      ,[User_Gender] = ?\n"
                    + "      ,[Updated_At] = ?\n"
                    + "      ,[IsCustomer] = ?\n"
                    + "      ,[IsGuest] = ?\n"
                    + " WHERE User_ID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, c.getUser_Name());
            stm.setString(2, c.getUser_Password());
            stm.setString(3, c.getUser_Email());
            stm.setString(4, c.getUser_PhoneNum());
            stm.setString(5, c.getUser_Address());
            stm.setString(6, c.getUser_Gender());
            stm.setObject(7, c.getUpdated_At());
            stm.setBoolean(8, c.isIsCustomer());
            stm.setBoolean(9, c.isIsGuest());
            stm.setInt(10, c.getUser_ID());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteAccount(int cid) {
        try {
            String sql = "DELETE FROM [dbo].[Users]\n"
                    + "      WHERE [User_ID] = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        DAOCustomer dao = new DAOCustomer();

//        User_Account newUser = new User_Account();
//        newUser.setUser_Name("xuan khanh");
//        newUser.setUser_Password("123456789");
//        newUser.setUser_Email("xuankhanh@example1.com");
//        newUser.setUser_PhoneNum("0123456789");
//        newUser.setUser_Address("1234 ABC Street");
//        newUser.setUser_Gender("Male");
//        newUser.setRole_ID(2);
//
//        // Setting created_at and updated_at to current timestamp
//        LocalDateTime currentTimestamp = LocalDateTime.now();
//        newUser.setCreated_At(currentTimestamp);
//        newUser.setUpdated_At(currentTimestamp);
//
//        // Inserting the new User_Account
//        int rowsInserted = dao.insertUser(newUser);
//        if (rowsInserted > 0) {
//            System.out.println("User_Account inserted successfully!");
//        } else {
//            System.out.println("Failed to insert User_Account.");
//        }
        DAOCustomer a = new DAOCustomer();
        List<User_Account> list = a.getAllAccount();
        for (User_Account s : list) {
            System.out.println(s);
        }
    }
}
