/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Managers;

/**
 *
 * @author xuank
 */
public class DAOShipping extends DBContext {

    public List<Managers> getAllAccount() {
        List<Managers> list = new ArrayList<>();
        try {
            String sql = "SELECT TOP (1000) [Manager_ID]\n"
                    + "      ,[Manager_Email]\n"
                    + "      ,[Manager_Password]\n"
                    + "      ,[Manager_Address]\n"
                    + "      ,[Manager_PhoneNum]\n"
                    + "      ,[Manager_Gender]\n"
                    + "      ,[IsAdmin]\n"
                    + "      ,[IsStaff]\n"
                    + "      ,[Created_At]\n"
                    + "      ,[Updated_At]\n"
                    + "  FROM [GasStore].[dbo].[Managers]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Managers s = new Managers();
                s.setManager_ID(rs.getInt(1));
                s.setManager_Email(rs.getString(2));
                s.setManager_Password(rs.getString(3));
                s.setManager_Address(rs.getString(4));
                s.setManager_PhoneNum(rs.getString(5));
                s.setManager_Gender(rs.getString(6));
                s.setIsAdmin(rs.getBoolean(7));
                s.setIsStaff(rs.getBoolean(8));
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
    public Vector<Managers> getStaffs(String sql) {
        Vector<Managers> vector = new Vector<>();
        try {

            //statement : send sql command and get result 
            Statement s = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                int ManagerID = rs.getInt(1);
//            int ProductID = rs.getInt(
//            "ProductID);
                String ManagerEmail = rs.getString(2);
//            String ProductName = rs.getString("ProductName");
                String ManagerPass = rs.getString(3);
                String ManagerAddress = rs.getString(4);
                String ManagerPhone = rs.getString(5);
                String ManagerGender = rs.getString(6);
                boolean isAdmin = rs.getBoolean(7);
                boolean isStaff = rs.getBoolean(8);
                LocalDateTime CreatedAt = (LocalDateTime) rs.getObject(9);
                LocalDateTime UpdatedAt = (LocalDateTime) rs.getObject(10);

                Managers st = new Managers(ManagerID, ManagerEmail, ManagerPass, ManagerAddress, ManagerPhone, ManagerGender, isAdmin, isStaff, CreatedAt, UpdatedAt);
                vector.add(st);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vector;
    }

//    public Managers checkAccountExist(String user) {
//        try {
//            String sql = "SELECT * FROM Managers where [Name] = ?";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setString(1, user);
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                Managers s = new Managers();
//                s.setStaffID(rs.getInt(1));
//                s.setStaff_Email(rs.getString(2));
//                s.setStaff_Password(rs.getString(3));
//                s.setStaff_Address(rs.getString(4));
//                s.setStaff_PhoneNum(rs.getString(5));
//                s.setStaff_Gender(rs.getString(6));
//                s.setRole_ID(rs.getInt(7));
//                s.setCreated_At((LocalDateTime) rs.getObject(8));
//                s.setUpdated_At((LocalDateTime) rs.getObject(9));
//                return s;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOManager.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
    public int insertManagers(Managers s) {
        String sql = "INSERT INTO [dbo].[Managers]\n"
                + "           ([Manager_Email]\n"
                + "           ,[Manager_Password]\n"
                + "           ,[Manager_Address]\n"
                + "           ,[Manager_PhoneNum]\n"
                + "           ,[Manager_Gender]\n"
                + "           ,[IsAdmin]\n"
                + "           ,[IsStaff]\n"
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
            stm.setString(1, s.getManager_Email());
            stm.setString(2, s.getManager_Password());
            stm.setString(3, s.getManager_Address());
            stm.setString(4, s.getManager_PhoneNum());
            stm.setString(5, s.getManager_PhoneNum());
            stm.setBoolean(6, s.isIsAdmin());
            stm.setBoolean(7, s.isIsStaff());
            stm.setTimestamp(8, Timestamp.valueOf(s.getCreated_At()));
            stm.setTimestamp(9, Timestamp.valueOf(s.getUpdated_At()));

            return stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public Managers getManagerById(int sid) {
        try {
            String sql = "SELECT * FROM Managers WHERE Manager_ID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            ResultSet rs = stm.executeQuery();

            // Check if the ResultSet has any records
            if (rs.next()) {
                // Create a new Staff object
                Managers s = new Managers();
                s.setManager_ID(rs.getInt(1));
                s.setManager_Email(rs.getString(2));
                s.setManager_Password(rs.getString(3));
                s.setManager_Address(rs.getString(4));
                s.setManager_PhoneNum(rs.getString(5));
                s.setManager_Gender(rs.getString(6));
                s.setIsAdmin(rs.getBoolean(7));
                s.setIsStaff(rs.getBoolean(8));
                // Convert Timestamp to LocalDateTime
                Timestamp createdAtTimestamp = rs.getTimestamp(9);
                LocalDateTime createdAt = createdAtTimestamp != null ? createdAtTimestamp.toLocalDateTime() : null;
                s.setCreated_At(createdAt);

                Timestamp updatedAtTimestamp = rs.getTimestamp(10);
                LocalDateTime updatedAt = updatedAtTimestamp != null ? updatedAtTimestamp.toLocalDateTime() : null;
                s.setUpdated_At(updatedAt);

                // Return the Staff object
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Return null if no record found or error occurred
        return null;
    }

    public void updateAccountManagers(Managers s) {

        try {
            String sql = "UPDATE [dbo].[Managers]\n"
                    + "   SET [Manager_Email] = ?\n"
                    + "      ,[Manager_Password] = CONVERT(varbinary(64), ?)\n"
                    + "      ,[Manager_Address] = ?\n"
                    + "      ,[Manager_PhoneNum] = ?\n"
                    + "      ,[Manager_Gender] = ?\n"
                    + "      ,[IsAdmin] = ?\n"
                    + "      ,[IsStaff] = ?\n"
                    + "      ,[Created_At] = ?\n"
                    + "      ,[Updated_At] = ?\n"
                    + " WHERE Manager_ID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, s.getManager_Email());
            stm.setString(2, s.getManager_Password());
            stm.setString(3, s.getManager_Address());
            stm.setString(4, s.getManager_PhoneNum());
            stm.setString(5, s.getManager_PhoneNum());
            stm.setBoolean(6, s.isIsAdmin());
            stm.setBoolean(7, s.isIsStaff());
            stm.setObject(8, s.getCreated_At());
            stm.setObject(9, s.getUpdated_At());
            stm.setInt(10, s.getManager_ID());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateAccountManagers1(Managers s) {

        try {
            String sql = "UPDATE [dbo].[Managers]\n"
                    + "   SET [Manager_Email] = ?\n"
                    + "      ,[Manager_Password] = CONVERT(varbinary(64), ?)\n"
                    + "      ,[Manager_Address] = ?\n"
                    + "      ,[Manager_PhoneNum] = ?\n"
                    + "      ,[Manager_Gender] = ?\n"
                    + "      ,[IsAdmin] = ?\n"
                    + "      ,[IsStaff] = ?\n"
                    + "      ,[Updated_At] = ?\n"
                    + " WHERE Manager_ID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, s.getManager_Email());
            stm.setString(2, s.getManager_Password());
            stm.setString(3, s.getManager_Address());
            stm.setString(4, s.getManager_PhoneNum());
            stm.setString(5, s.getManager_Gender());
            stm.setBoolean(6, s.isIsAdmin());
            stm.setBoolean(7, s.isIsStaff());
            stm.setObject(8, s.getUpdated_At());
            stm.setInt(9, s.getManager_ID());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteAccount(int sid) {
        try {
            String sql = "DELETE FROM [Managers]\n"
                    + "WHERE Manager_ID = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        DAOManager daoStaff = new DAOManager();

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
        DAOManager a = new DAOManager();
        List<Managers> list = a.getAllAccount();
        for (Managers s : list) {
            System.out.println(s);
        }
    }
}
