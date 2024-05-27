package Dal;

import DBContext.DBContext;
import Model.Admins;
import Model.Customers;
import Model.Staffs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        DBContext dbContext = new DBContext();
        try (Connection con = dbContext.getConnection()) {
            if (con != null) {
                String sql = "UPDATE Customers SET User_Password = HASHBYTES('SHA2_256', ?), Updated_At = GETDATE() WHERE User_Email = ?";
                try (PreparedStatement stm = con.prepareStatement(sql)) {
                    stm.setString(1, newPassword);
                    stm.setString(2, userEmail);

                    int rowsUpdated = stm.executeUpdate();
                    return rowsUpdated > 0;
                }
            }
        }
        return false;
    }

    public Customers checkLoginCustomer(String userEmail, String userPassword) throws SQLException, ClassNotFoundException {
        DBContext dbContext = new DBContext();
        try (Connection con = dbContext.getConnection()) {
            if (con != null) {
                String sql = "SELECT * FROM Customers WHERE User_Email = ? AND User_Password = HASHBYTES('SHA2_256', ?)";
                try (PreparedStatement stm = con.prepareStatement(sql)) {
                    stm.setString(1, userEmail);
                    stm.setString(2, userPassword);
                    try (ResultSet rs = stm.executeQuery()) {
                        if (rs.next()) {
                            return new Customers(
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
                }
            }
        }
        return null;
    }

    public Admins checkLoginAdmin(String username, String password) throws SQLException, ClassNotFoundException {
        DBContext dbContext = new DBContext();
        try (Connection con = dbContext.getConnection()) {
            if (con != null) {
                String sql = "SELECT * FROM Admins WHERE Admin_Email = ? AND Admin_Password = HASHBYTES('SHA2_256', ?)";
                try (PreparedStatement stm = con.prepareStatement(sql)) {
                    stm.setString(1, username);
                    stm.setString(2, password);
                    try (ResultSet rs = stm.executeQuery()) {
                        if (rs.next()) {
                            return new Admins(
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
                }
            }
        }
        return null;
    }

    public Staffs checkLoginStaff(String username, String password) throws SQLException, ClassNotFoundException {
        DBContext dbContext = new DBContext();
        try (Connection con = dbContext.getConnection()) {
            if (con != null) {
                String sql = "SELECT * FROM Staffs WHERE Staff_Email = ? AND Staff_Password = HASHBYTES('SHA2_256', ?)";
                try (PreparedStatement stm = con.prepareStatement(sql)) {
                    stm.setString(1, username);
                    stm.setString(2, password);
                    try (ResultSet rs = stm.executeQuery()) {
                        if (rs.next()) {
                            return new Staffs(
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
                }
            }
        }
        return null;
    }
}
