package Dal;

import DBContext.DBContext;
import Model.User;
import Model.Manager;
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
                String sql = "UPDATE Users SET User_Password = HASHBYTES('SHA2_256', ?), Updated_At = GETDATE() WHERE User_Email = ?";
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

    public User checkLoginUser(String userEmail, String userPassword) throws SQLException, ClassNotFoundException {
        DBContext dbContext = new DBContext();
        try (Connection con = dbContext.getConnection()) {
            if (con != null) {
                String sql = "SELECT * FROM Users WHERE User_Email = ? AND User_Password = HASHBYTES('SHA2_256', ?)";
                try (PreparedStatement stm = con.prepareStatement(sql)) {
                    stm.setString(1, userEmail);
                    stm.setString(2, userPassword);
                    try (ResultSet rs = stm.executeQuery()) {
                        if (rs.next()) {
                            User user = new User();
                            user.setUserId(rs.getInt("User_ID"));
                            user.setUserName(rs.getString("User_Name"));
                            user.setUserPassword(rs.getString("User_Password"));
                            user.setUserEmail(rs.getString("User_Email"));
                            user.setUserPhoneNum(rs.getString("User_PhoneNum"));
                            user.setUserAddress(rs.getString("User_Address"));
                            user.setUserGender(rs.getString("User_Gender"));
                            user.setUserImage(rs.getString("User_Image"));
                            user.setCustomer(rs.getBoolean("IsCustomer"));
                            user.setGuest(rs.getBoolean("IsGuest"));
                            return user;
                        }
                    }
                }
            }
        }
        return null;
    }

    public Manager checkLoginManager(String managerEmail, String managerPassword) throws SQLException, ClassNotFoundException {
        DBContext dbContext = new DBContext();
        try (Connection con = dbContext.getConnection()) {
            if (con != null) {
                String sql = "SELECT * FROM Managers WHERE Manager_Email = ? AND Manager_Password = HASHBYTES('SHA2_256', ?)";
                try (PreparedStatement stm = con.prepareStatement(sql)) {
                    stm.setString(1, managerEmail);
                    stm.setString(2, managerPassword);
                    try (ResultSet rs = stm.executeQuery()) {
                        if (rs.next()) {
                            Manager manager = new Manager();
                            manager.setManagerId(rs.getInt("Manager_ID"));
                            manager.setManagerEmail(rs.getString("Manager_Email"));
                            manager.setManagerPassword(rs.getBytes("Manager_Password"));
                            manager.setManagerAddress(rs.getString("Manager_Address"));
                            manager.setManagerPhoneNum(rs.getString("Manager_PhoneNum"));
                            manager.setManagerGender(rs.getString("Manager_Gender"));
                            manager.setAdmin(rs.getBoolean("IsAdmin"));
                            manager.setStaff(rs.getBoolean("IsStaff"));
                            return manager;
                        }
                    }
                }
            }
        }
        return null;
    }
}
