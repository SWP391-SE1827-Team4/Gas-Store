/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CartItem;
import model.Order;
import model.OrderDetail;
import model.Product;
import model.User;

/**
 *
 * @author Van Minh Tuan
 */
public class OrderDetailDAO extends DBContext {

    public void insert(Order order, CartItem cartItem) {
        PreparedStatement stm = null;

        String sql = "INSERT INTO [dbo].[order_detail]\n"
                + "           ([product_quantity]\n"
                + "           ,[product_id]\n"
                + "           ,[order_id]\n"
                + "           ,[price])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?)";
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, cartItem.getQuantity());
            stm.setInt(2, cartItem.getProduct().getId());
            stm.setInt(3, order.getId());
            stm.setDouble(4, cartItem.getProduct().getPrice());
            stm.executeUpdate();

            System.out.println("Insert OK");
        } catch (SQLException ex) {
            Logger.getLogger(OrderDetailDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();

            } catch (SQLException ex) {
                Logger.getLogger(OrderDetailDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new OrderDetailDAO().getOrderDetailsByOrderId(2).size());
    }
    
    public ArrayList<OrderDetail> getOrderDetailsByOrderId(int orderId) {
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();

        PreparedStatement stm = null;
        ResultSet rs = null;
        User user;
        String sql = ""
                + "SELECT [OrderDetail_ID]\n"
                + "      ,[Order_ID]\n"
                + "      ,[Product_ID]\n"
                + "      ,[Order_Quantity]\n"
                + "      ,[OrderDetail_Status]\n"
                + "      ,[Total_Amount_Paid]\n"
                + "      ,[Payment_Completion_Date]\n"
                + "      ,[Payment_Method]\n"
                + "  FROM [Order_Details]\n"
                + "  WHERE [Order_ID] = " + orderId;

        try {
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setId(rs.getInt("OrderDetail_ID"));
                orderDetail.setProduct(new ProductDAO().getProductsById(rs.getInt("Product_ID")));
                orderDetail.setProduct_quantity(rs.getInt("Order_Quantity"));
                orderDetail.setStatus(rs.getString("OrderDetail_Status"));
                orderDetail.setPrice(rs.getDouble("Total_Amount_Paid"));
                orderDetail.setPaymentDate(rs.getDate("Payment_Completion_Date"));
                orderDetail.setPaymentMethod(rs.getString("Payment_Method"));

                orderDetails.add(orderDetail);
                
            }
            return orderDetails;

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
