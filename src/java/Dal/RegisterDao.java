package Dal;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tuan anh
 */
public class RegisterDao {
//public int getIdAccount(String username, String password)
//        throws SQLException, ClassNotFoundException {
//    Connection con = null;
//    PreparedStatement stm = null;
//    ResultSet rs = null;
//
//    int id = 0;
//    try {
//        // 1. Connect DB
//        con = DBContext.makeConnection();
//        if (con != null) {
//            // 2. Create SQL String
//            String sql = "SELECT * FROM Account WHERE username = ? AND password = ?";
//            // 3. Create Statement
//            stm = con.prepareStatement(sql);
//            stm.setString(1, username);
//            stm.setString(2, password);
//            // 4. Execute Query
//            rs = stm.executeQuery();
//            // 5. Process Result
//            if (rs.next()) {
//                 id = rs.getInt("AccountID");
//                
//            }
//        }
//    } finally {
//        // Close resources in reverse order of their creation
//        if (rs != null) {
//            rs.close();
//        }
//        if (stm != null) {
//            stm.close();
//        }
//        if (con != null) {
//            con.close();
//        }
//    } 
//    return id;
//}


  

public boolean insertCustomer(String name, String email, String password, String phoneNum, String address, String gender, int roleId) throws SQLException, ClassNotFoundException {
    Connection con = null;
    PreparedStatement stm = null;

    try {
        con = DBContext.makeConnection();
        if (con != null) {
            String sql = "INSERT INTO Customers (User_Name, User_Email, User_Password, User_PhoneNum, User_Address, User_Gender, Role_ID) VALUES (?, ?, HASHBYTES('SHA2_256', ?), ?, ?, ?, ?)";
            stm = con.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, email);
            stm.setString(3, password);
            stm.setString(4, phoneNum);
            stm.setString(5, address);
            stm.setString(6, gender);
            stm.setInt(7, roleId);

            int rowsAffected = stm.executeUpdate();

            // Kiểm tra số hàng đã bị ảnh hưởng (rowsAffected) để xác định việc chèn thành công hay không
            return rowsAffected > 0;
        }
    } finally {
        try { if (stm != null) stm.close(); } catch (SQLException e) { /* ignored */ }
        try { if (con != null) con.close(); } catch (SQLException e) { /* ignored */ }
    }
    return false;
}


    public static void main(String[] args) {
        RegisterDao registerDao = new RegisterDao();
        
        // Thực hiện chèn dữ liệu cho một khách hàng mới
        String name = "John Doe";
        String email = "johndoe111111@example.com";
        String password = "password123";
        String phoneNum = "0123456789";
        String address = "123 Street, City";
        String gender = "Male";
        int roleId = 1; // Assume 1 for regular customer
        
        try {
            boolean isSuccess = registerDao.insertCustomer(name, email, password, phoneNum, address, gender, roleId);
            if (isSuccess) {
                System.out.println("Customer registration successful!");
            } else {
                System.out.println("Failed to register customer.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}



   
  
//    public static void main(String[] args) {
//        try {
//            RegisterDao loginDao = new RegisterDao();
//            // Thêm một bản ghi mới vào bảng User_Account để kiểm thử
//            loginDao.insertUserAccount(4,"Trần Văn A", "Nam", "user1@example.com", "0123456789", "Hà Nội", 0, 1);
//         
//        
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }


