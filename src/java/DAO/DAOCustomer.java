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
import model.Staff;
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
                    + "      ,CONVERT(NVARCHAR(MAX), DecryptByKey([User_Password])) AS [User_OriginalPassword]\n"
                    + "      ,[User_Email]\n"
                    + "      ,[User_PhoneNum]\n"
                    + "      ,[User_Address]\n"
                    + "      ,[User_Gender]\n"
                    + "      ,[Role_ID]\n"
                    + "      ,[Created_At]\n"
                    + "      ,[Updated_At]\n"
                    + "  FROM [GasStore].[dbo].[Customers]";
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
                s.setRole_ID(rs.getInt(8));

                // Convert Timestamp to LocalDateTime
                Timestamp createdAtTimestamp = rs.getTimestamp(9);
                LocalDateTime createdAt = createdAtTimestamp != null ? createdAtTimestamp.toLocalDateTime() : null;
                s.setCreated_At(createdAt);

                Timestamp updatedAtTimestamp = rs.getTimestamp(10);
                LocalDateTime updatedAt = updatedAtTimestamp != null ? updatedAtTimestamp.toLocalDateTime() : null;
                s.setUpdated_At(updatedAt);

                list.add(s);
            }
        } catch (Exception ex) {
            Logger.getLogger(DAOStaff.class.getName()).log(Level.SEVERE, null, ex);
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
            String sql = "SELECT * FROM Customers where [User_Name] = ?";
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
                s.setRole_ID(rs.getInt(8));

                // Convert Timestamp to LocalDateTime
                Timestamp createdAtTimestamp = rs.getTimestamp(9);
                LocalDateTime createdAt = createdAtTimestamp != null ? createdAtTimestamp.toLocalDateTime() : null;
                s.setCreated_At(createdAt);

                Timestamp updatedAtTimestamp = rs.getTimestamp(10);
                LocalDateTime updatedAt = updatedAtTimestamp != null ? updatedAtTimestamp.toLocalDateTime() : null;
                s.setUpdated_At(updatedAt);

                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int insertUser(User_Account s) {
        String sql = "INSERT INTO [dbo].[Customers]\n"
                + "           ([User_Name]\n"
                + "           ,[User_Password]\n"
                + "           ,[User_Email]\n"
                + "           ,[User_PhoneNum]\n"
                + "           ,[User_Address]\n"
                + "           ,[User_Gender]\n"
                + "           ,[Role_ID]\n"
                + "           ,[Created_At]\n"
                + "           ,[Updated_At])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,CONVERT(VARBINARY(MAX), ?)\n"
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
            stm.setInt(7, s.getRole_ID());
            stm.setTimestamp(8, Timestamp.valueOf(s.getCreated_At()));
            stm.setTimestamp(9, Timestamp.valueOf(s.getUpdated_At()));
            return stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

//    public Staff getAccountById(int accountId) {
//        try {
//            String sql = "select *  from Staff where StaffID = ?";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setInt(1, accountId);
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                Staff s = new Staff();
//                s.setStaffID(rs.getInt(1));
//                s.setAccountID(2);
//                s.setName(rs.getString(3));
//                s.setEmail(rs.getString(4));
//                s.setGender(rs.getString(5));
//                s.setAddress(rs.getString(6));
//                s.setPhone(rs.getString(7));
//                s.setPosition(rs.getString(8));
//                return s;
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(DAOStaff.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
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
    public void deleteAccount(int cid) {
        try {
            String sql = "DELETE FROM [Customers]\n"
                    + "WHERE [User_ID] = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        DAOCustomer dao = new DAOCustomer();

        User_Account newUser = new User_Account();
        newUser.setUser_Name("xuan khanh");
        newUser.setUser_Password("123456789");
        newUser.setUser_Email("xuankhanh@example1.com");
        newUser.setUser_PhoneNum("0123456789");
        newUser.setUser_Address("1234 ABC Street");
        newUser.setUser_Gender("Male");
        newUser.setRole_ID(2);

        // Setting created_at and updated_at to current timestamp
        LocalDateTime currentTimestamp = LocalDateTime.now();
        newUser.setCreated_At(currentTimestamp);
        newUser.setUpdated_At(currentTimestamp);

        // Inserting the new User_Account
        int rowsInserted = dao.insertUser(newUser);
        if (rowsInserted > 0) {
            System.out.println("User_Account inserted successfully!");
        } else {
            System.out.println("Failed to insert User_Account.");
        }
//        DAOCustomer a = new DAOCustomer();
//        List<User_Account> list = a.getAllAccount();
//        for (User_Account s : list) {
//            System.out.println(s);
//        }
    }
}
