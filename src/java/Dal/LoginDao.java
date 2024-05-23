package Dal;


import Model.Admins;
import Model.Customers;
import Model.Staffs;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tuan anh
 */
public class LoginDao {
    public static void main(String[] args) {
        // Test updatePassword method
        String userEmail = "mmmm@gmail.com";
        String newPassword = "12345678a";
 LoginDao d = new LoginDao();
        try {
            boolean success = d.updatePassword(userEmail, newPassword);
            if (success) {
                System.out.println("Password updated successfully for user with email: " + userEmail);
            } else {
                System.out.println("Failed to update password for user with email: " + userEmail);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
public boolean updatePassword(String userEmail, String newPassword) throws SQLException, ClassNotFoundException {
    Connection con = null;
    PreparedStatement stm = null;

    try {
        con = DBContext.makeConnection();
        if (con != null) {
            // Update the password in the database
            String sql = "UPDATE Customers SET User_Password = HASHBYTES('SHA2_256', ?), Updated_At = GETDATE() WHERE User_Email = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, newPassword);
            stm.setString(2, userEmail);

            int rowsUpdated = stm.executeUpdate();
            return rowsUpdated > 0;
        }
    } finally {
        try { if (stm != null) stm.close(); } catch (SQLException e) { /* log the exception */ }
        try { if (con != null) con.close(); } catch (SQLException e) { /* log the exception */ }
    }
    return false;
}

     
 public Customers checkLoginCustomer(String userEmail, String userPassword) throws SQLException, ClassNotFoundException {
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    Customers customer = null;

    try {
        con = DBContext.makeConnection();
        if (con != null) {
            String sql = "SELECT * FROM Customers WHERE User_Email = ? AND User_Password = HASHBYTES('SHA2_256', ?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, userEmail);
            stm.setString(2, userPassword);
            rs = stm.executeQuery();
            if (rs.next()) {
                customer = new Customers(
                    rs.getInt("User_ID"),
                    rs.getString("User_Name"),
                    rs.getString("User_Password"),
                    rs.getString("User_Email"),
                    rs.getString("User_PhoneNum"),
                    rs.getString("User_Address"),
                    rs.getInt("Role_ID"),
                    rs.getDate("Created_At"),
                    rs.getDate("Updated_At")
                );
            }
        }
    } finally {
        try { if (rs != null) rs.close(); } catch (SQLException e) { /* ignored */ }
        try { if (stm != null) stm.close(); } catch (SQLException e) { /* ignored */ }
        try { if (con != null) con.close(); } catch (SQLException e) { /* ignored */ }
    }
    return customer;
}



       // test curs
//  public static void main(String[] args) {
//        try {
//            // Test email and password
//            String userEmail = "mmmm@gmail.com";
//            String userPassword = "12345678";
//
//            LoginDao dao = new LoginDao();
//            Customers customer = dao.checkLoginCustomer(userEmail, userPassword);
//
//            if (customer != null) {
//                System.out.println("Login successful!");
//                System.out.println("User ID: " + customer.getUser_ID());
//                System.out.println("User Name: " + customer.getUser_Name());
//                System.out.println("User Email: " + customer.getUser_Email());
//                // Print other attributes as needed
//            } else {
//                System.out.println("Login failed! Invalid email or password.");
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }}
public Admins checkLoginAdmin(String username, String password) throws SQLException, ClassNotFoundException {
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    Admins admin = null;

    try {
        con = DBContext.makeConnection();
        if (con != null) {
            String sql = "SELECT * FROM Admins WHERE Admin_Email = ? AND Admin_Password = HASHBYTES('SHA2_256', ?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setBytes(2, password.getBytes());  
            rs = stm.executeQuery();
            if (rs.next()) {
                admin = new Admins(
                    rs.getInt("Admin_ID"),
                    rs.getString("Admin_Email"),
                    rs.getString("Admin_Password"),
                    rs.getString("Admin_Address"),
                    rs.getString("Admin_PhoneNum"),
                    rs.getInt("Role_ID"),
                    rs.getDate("Created_At"),
                    rs.getDate("Updated_At")
                );
            }
        }
    } finally {
        try { if (rs != null) rs.close(); } catch (SQLException e) { /* ignored */ }
        try { if (stm != null) stm.close(); } catch (SQLException e) { /* ignored */ }
        try { if (con != null) con.close(); } catch (SQLException e) { /* ignored */ }
    } 
    return admin;
}



//public static void main(String[] args) {
//        try {
//            //    String adminUsername = 
////    String adminPassword = 
//        
//            // Test username and password
//            String username ="example@gmail.com";
//            String password ="password";
//LoginDao dao = new LoginDao();
//            // Call the method to check login
//            Admins admin = dao.checkLoginAdmin(username, password);
//
//            if (admin != null) {
//                System.out.println("Login successful!");
//                System.out.println("Admin ID: " + admin.getAdmin_ID());
//                System.out.println("Admin Email: " + admin.getAdmin_Email());
//                // Print other attributes as needed
//            } else {
//                System.out.println("Login failed! Invalid username or password.");
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }}


public Staffs checkLoginStaff(String username, String password) throws SQLException, ClassNotFoundException {
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    Staffs staff = null;

    try {
        con = DBContext.makeConnection();
        if (con != null) {
            String sql = "SELECT * FROM Staffs WHERE Staff_Email = ? AND Staff_Password = HASHBYTES('SHA2_256', ?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setBytes(2, password.getBytes());  
            rs = stm.executeQuery();
            if (rs.next()) {
                staff = new Staffs(
                    rs.getInt("Staff_ID"),
                    rs.getString("Staff_Email"),
                    rs.getString("Staff_Password"),
                    rs.getString("Staff_Address"),
                    rs.getString("Staff_PhoneNum"),
                    rs.getString("Staff_Gender"),
                    rs.getInt("Role_ID"),
                    rs.getDate("Created_At"),
                    rs.getDate("Updated_At")
                );
            }
        }
    } finally {
        try { if (rs != null) rs.close(); } catch (SQLException e) { /* ignored */ }
        try { if (stm != null) stm.close(); } catch (SQLException e) { /* ignored */ }
        try { if (con != null) con.close(); } catch (SQLException e) { /* ignored */ }
    } 
    return staff;
}

//    public static void main(String[] args) {
//        String staffUsername = 
//        String staffPassword = 
//
//        LoginDao loginDao = new LoginDao();
//public static void main(String[] args) {
//        try {
//            // Test username and password
//            String username = "staff@example.com";
//            String password = "staffpassword";
//LoginDao loginDao = new LoginDao();
//            // Call the method to check login
//            Staffs staff = loginDao.checkLoginStaff(username, password);
//
//            if (staff != null) {
//                System.out.println("Login successful!");
//                System.out.println("Staff ID: " + staff.getStaff_ID());
//                System.out.println("Staff Email: " + staff.getStaff_Email());
//                // Print other attributes as needed
//            } else {
//                System.out.println("Login failed! Invalid username or password.");
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
    }



    
        
    
   





    
    
      


