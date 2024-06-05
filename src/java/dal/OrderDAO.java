/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;
import model.User;

/**
 *
 * @author Van Minh Tuan
 */
public class OrderDAO extends DBContext {

    public int insert(Order order, User user) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        int generatedId = -1; // Giá trị mặc định nếu không có id được tạo

        String sql = "INSERT INTO [dbo].[order]\n"
                + "           ([created_date]\n"
                + "           ,[user_id])\n"
                + "     VALUES\n"
                + "           (?, ?)";
        try {
            stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setDate(1, order.getCreated_date());
            stm.setInt(2, user.getId());
            stm.executeUpdate();

            // Lấy kết quả id được tạo ra
            rs = stm.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }

            System.out.println("Insert OK");
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return generatedId;
    }

    public Order getOrdersById(int orderId) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        Order order = null;
        User user;
         String sql = ""
                + "SELECT [Order_ID]\n"
                + "      ,[User_ID]\n"
                + "      ,[Product_ID]\n"
                + "      ,[Order_Status]\n"
                + "  FROM [Orders]\n"
                + "  WHERE Order_ID = " + orderId;
        try {
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                order = new Order();
                
                order.setId(rs.getInt("Order_ID"));
                order.setUser(new UserDAO().getUserById(rs.getInt("User_ID")));
                order.setOrderDetails(new OrderDetailDAO().getOrderDetailsByOrderId(rs.getInt("Order_ID")));
                order.setStatus(rs.getString("Order_Status"));
            }
            return order;

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                rs.close();
                connection.close();

            } catch (SQLException ex) {
                Logger.getLogger(OrderDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public ArrayList<Order> getOrders(int userId) {
        ArrayList<Order> orders = new ArrayList<>();

        PreparedStatement stm = null;
        ResultSet rs = null;
        Order order = null;
        User user;
        String sql = ""
                + "SELECT [Order_ID]\n"
                + "      ,[User_ID]\n"
                + "      ,[Product_ID]\n"
                + "      ,[Order_Status]\n"
                + "  FROM [Orders]\n"
                + "  WHERE User_ID = " + userId;
        try {
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                order = new Order();
                
                order.setId(rs.getInt("Order_ID"));
                order.setUser(new UserDAO().getUserById(rs.getInt("User_ID")));
                order.setOrderDetails(new OrderDetailDAO().getOrderDetailsByOrderId(rs.getInt("Order_ID")));
                order.setStatus(rs.getString("Order_Status"));
                    
                if(order.getOrderDetails().size() != 0)
                orders.add(order);
            }
            return orders;

        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                rs.close();
                connection.close();

            } catch (SQLException ex) {
                Logger.getLogger(OrderDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
