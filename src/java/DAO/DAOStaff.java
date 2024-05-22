/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;
import model.Staff;
import java.sql.Timestamp;
/**
 *
 * @author xuank
 */
public class DAOStaff extends DBContext {

    public List<Staff> getAllAccount() {
        List<Staff> list = new ArrayList<>();
        try {
            String sql = "SELECT TOP (1000) [Staff_ID]\n"
                    + "       ,[Staff_Email]\n"
                    + "       ,CONVERT(NVARCHAR(MAX), DecryptByKey([Staff_Password])) AS [Staff_OriginalPassword]\n"
                    + "       ,[Staff_Address]\n"
                    + "       ,[Staff_PhoneNum]\n"
                    + "       ,[Staff_Gender]\n"
                    + "       ,[Role_ID]\n"
                    + "       ,[Created_At]\n"
                    + "       ,[Updated_At]\n"
                    + "FROM [GasStore].[dbo].[Staffs]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Staff s = new Staff();
                s.setStaffID(rs.getInt(1));
                s.setStaff_Email(rs.getString(2));
                s.setStaff_Password(rs.getString(3));
                s.setStaff_Address(rs.getString(4));
                s.setStaff_PhoneNum(rs.getString(5));
                s.setStaff_Gender(rs.getString(6));
                s.setRole_ID(rs.getInt(7));

                // Convert Timestamp to LocalDateTime
                Timestamp createdAtTimestamp = rs.getTimestamp(8);
                LocalDateTime createdAt = createdAtTimestamp != null ? createdAtTimestamp.toLocalDateTime() : null;
                s.setCreated_At(createdAt);

                Timestamp updatedAtTimestamp = rs.getTimestamp(9);
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
    public Staff checkAccountExist(String user) {
        try {
            String sql = "SELECT * FROM Staffs where [Name] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Staff s = new Staff();
                s.setStaffID(rs.getInt(1));
                s.setStaff_Email(rs.getString(2));
                s.setStaff_Password(rs.getString(3));
                s.setStaff_Address(rs.getString(4));
                s.setStaff_PhoneNum(rs.getString(5));
                s.setStaff_Gender(rs.getString(6));
                s.setRole_ID(rs.getInt(7));
                s.setCreated_At((LocalDateTime) rs.getObject(8));
                s.setUpdated_At((LocalDateTime) rs.getObject(9));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int insertStaff(Staff s) {
        String sql = "INSERT INTO [dbo].[Staffs] ([Staff_Email], [Staff_Password], [Staff_Address], [Staff_PhoneNum], [Staff_Gender], [Role_ID], [Created_At], [Updated_At]) VALUES (?, CONVERT(VARBINARY(MAX), ?), ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, s.getStaff_Email());
            stm.setString(2, s.getStaff_Password());
            stm.setString(3, s.getStaff_Address());
            stm.setString(4, s.getStaff_PhoneNum());
            stm.setString(5, s.getStaff_Gender());
            stm.setInt(6, s.getRole_ID());
            stm.setTimestamp(7, Timestamp.valueOf(s.getCreated_At()));
            stm.setTimestamp(8, Timestamp.valueOf(s.getUpdated_At()));
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
    public void deleteAccount(int sid) {
        try {
            String sql = "DELETE FROM [Staffs]\n"
                    + "WHERE Staff_ID = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        DAOStaff daoStaff = new DAOStaff();

        // Create a new Staff object
//        Staff newStaff = new Staff();
//        newStaff.setStaff_Email("xuankhanh03642@gmail.com");
//        newStaff.setStaff_Password("123456");
//        newStaff.setStaff_Address("12345 Main St, Cityville");
//        newStaff.setStaff_PhoneNum("555-1234567");
//        newStaff.setStaff_Gender("Male");
//        newStaff.setRole_ID(4); // Replace with the desired role ID
//        newStaff.setCreated_At(LocalDateTime.now());
//        newStaff.setUpdated_At(LocalDateTime.now());
//
//        // Insert the new staff record
//        int rowsAffected = daoStaff.insertStaff(newStaff);
//        System.out.println("Rows affected: " + rowsAffected);
        DAOStaff a = new DAOStaff();
        List<Staff> list = a.getAllAccount();
        for (Staff s : list) {
            System.out.println(s);
        }
    }
}
