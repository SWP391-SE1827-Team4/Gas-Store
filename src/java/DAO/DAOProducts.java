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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Vector;
import model.Product;

public class DAOProducts extends DBContext {

//    public Vector<Product> getProducts(String sql) {
//        Vector<Product> vector = new Vector<>();
//        try {
//
//            //statement : send sql command and get result 
//            Statement s = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            ResultSet rs = s.executeQuery(sql);
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                int CategoryID = rs.getInt(2);
//                String Name = rs.getString(3);
//                int Quantity = rs.getInt(4);
//                float price = rs.getFloat(5);
//                int WarrantyPeriod = rs.getInt(6);
//                String ImageLink = rs.getString(7);
//                String Desciption = rs.getString(8);
//                Product p = new Product(id, CategoryID, Desciption, Name, Quantity, price, Desciption, Name, Created_At, Updated_At);
//                vector.add(p);
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return vector;
//    }
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "Select * from Products";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt(1));
                product.setCategoryID(rs.getInt(2));
                product.setSerialProduct_Number(rs.getString(3));
                product.setProduct_Name(rs.getString(4));
                product.setProduct_Quantity(rs.getInt(5));
                product.setProduct_Price(rs.getDouble(6));
                product.setProduct_Description(rs.getString(7));
                Timestamp createdAtTimestamp = rs.getTimestamp(8);
                LocalDateTime createdAt = createdAtTimestamp != null ? createdAtTimestamp.toLocalDateTime() : null;
                product.setCreated_At(createdAt);

                Timestamp updatedAtTimestamp = rs.getTimestamp(9);
                LocalDateTime updatedAt = updatedAtTimestamp != null ? updatedAtTimestamp.toLocalDateTime() : null;
                product.setUpdated_At(updatedAt);
                list.add(product);
            }
        } catch (Exception ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Product> getProductsByCategoryId(int categoryId) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "select * from Products where Products.categoryId = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, categoryId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt(1));
                product.setCategoryID(rs.getInt(2));
                product.setSerialProduct_Number(rs.getString(3));
                product.setProduct_Name(rs.getString(4));
                product.setProduct_Quantity(rs.getInt(5));
                product.setProduct_Price(rs.getDouble(6));
                product.setProduct_Description(rs.getString(7));
                product.setImage(rs.getString(8));
                Timestamp createdAtTimestamp = rs.getTimestamp(9);
                LocalDateTime createdAt = createdAtTimestamp != null ? createdAtTimestamp.toLocalDateTime() : null;
                product.setCreated_At(createdAt);

                Timestamp updatedAtTimestamp = rs.getTimestamp(10);
                LocalDateTime updatedAt = updatedAtTimestamp != null ? updatedAtTimestamp.toLocalDateTime() : null;
                product.setUpdated_At(updatedAt);
                list.add(product);
            }
        } catch (Exception ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Product> getProductsWithPagging(int page, int PAGE_SIZE) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "select *  from Products order by id\n"
                    + "offset (?-1)*? row fetch next ? rows only";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, page);
            stm.setInt(2, PAGE_SIZE);
            stm.setInt(3, PAGE_SIZE);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt(1));
                product.setCategoryID(rs.getInt(2));
                product.setSerialProduct_Number(rs.getString(3));
                product.setProduct_Name(rs.getString(4));
                product.setProduct_Quantity(rs.getInt(5));
                product.setProduct_Price(rs.getDouble(6));
                product.setProduct_Description(rs.getString(7));
                product.setImage(rs.getString(8));
                product.setCreated_At((LocalDateTime) rs.getObject(9));
                product.setUpdated_At((LocalDateTime) rs.getObject(10));
                list.add(product);
            }
        } catch (Exception ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int getTotalProducts() {
        try {
            String sql = "select count(id)  from Product ";

            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public List<Product> search(String keyword) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "select *  from Products where name like ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + keyword + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt(1));
                product.setCategoryID(rs.getInt(2));
                product.setSerialProduct_Number(rs.getString(3));
                product.setProduct_Name(rs.getString(4));
                product.setProduct_Quantity(rs.getInt(5));
                product.setProduct_Price(rs.getDouble(6));
                product.setProduct_Description(rs.getString(7));
                product.setImage(rs.getString(8));
                product.setCreated_At((LocalDateTime) rs.getObject(9));
                product.setUpdated_At((LocalDateTime) rs.getObject(10));
                list.add(product);

            }
        } catch (Exception ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Product getProductById(int productId) {
        try {
            String sql = "select *  from Products where id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, productId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt(1));
                product.setCategoryID(rs.getInt(2));
                product.setSerialProduct_Number(rs.getString(3));
                product.setProduct_Name(rs.getString(4));
                product.setProduct_Quantity(rs.getInt(5));
                product.setProduct_Price(rs.getDouble(6));
                product.setProduct_Description(rs.getString(7));
                product.setImage(rs.getString(8));
                product.setCreated_At((LocalDateTime) rs.getObject(9));
                product.setUpdated_At((LocalDateTime) rs.getObject(10));
                return product;
            }
        } catch (Exception ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Product> getProductsBySellId(int Id) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "select * from Products where sell_ID = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, Id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt(1));
                product.setCategoryID(rs.getInt(2));
                product.setSerialProduct_Number(rs.getString(3));
                product.setProduct_Name(rs.getString(4));
                product.setProduct_Quantity(rs.getInt(5));
                product.setProduct_Price(rs.getDouble(6));
                product.setProduct_Description(rs.getString(7));
                product.setImage(rs.getString(8));
                product.setCreated_At((LocalDateTime) rs.getObject(9));
                product.setUpdated_At((LocalDateTime) rs.getObject(10));
                list.add(product);
            }
        } catch (Exception ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int InsertProduct(Product product) {
        try {
            String sql = "INSERT INTO [dbo].[Products]\n"
                    + "           ([Category_ID]\n"
                    + "           ,[SerialProduct_Number]\n"
                    + "           ,[Product_Name]\n"
                    + "           ,[Product_Quantity]\n"
                    + "           ,[Product_Price]\n"
                    + "           ,[Product_Description]\n"
                    + "           ,[Product_Image]\n"
                    + "           ,[Created_At]\n"
                    + "           ,[Updated_At])\n"
                    + "     VALUES(\n"
                    + "          ?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, product.getCategoryID());
            stm.setString(2, product.getSerialProduct_Number());
            stm.setString(3, product.getProduct_Name());
            stm.setInt(4, product.getProduct_Quantity());
            stm.setDouble(5, product.getProduct_Price());
            stm.setString(6, product.getProduct_Description());
            stm.setString(7, product.getImage());
            stm.setObject(8, product.getCreated_At());
            stm.setObject(9, product.getUpdated_At());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void deleteProduct(int pid) {
        try {
            String sql = "DELETE FROM [Products]\n"
                    + "WHERE Product_ID = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateProduct(Product p) {
        try {
            String sql = "UPDATE [dbo].[Product]\n"
                    + "   SET [Category_ID] = ?\n"
                    + "      ,[SerialProduct_Number] = ?\n"
                    + "      ,[Product_Name] = ?\n"
                    + "      ,[Product_Quantity] = ?\n"
                    + "      ,[Product_Price] = ?\n"
                    + "      ,[Product_Description] = ?\n"
                    + "      ,[Product_Image] = ?\n"
                    + "      ,[Created_At] = ?\n"
                    + "      ,[Updated_At] = ?\n"
                    + " WHERE [Product_ID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, p.getCategoryID());
            stm.setString(2, p.getSerialProduct_Number());
            stm.setString(3, p.getProduct_Name());
            stm.setInt(4, p.getProduct_Quantity());
            stm.setDouble(5, p.getProduct_Price());
            stm.setString(6, p.getProduct_Description());
            stm.setString(7, p.getImage());
            stm.setObject(8, p.getCreated_At());
            stm.setObject(9, p.getUpdated_At());
            stm.setInt(10, p.getProductID());
            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    public List<Product> getAllProductsLast() {
//        List<Product> list = new ArrayList<>();
//        try {
//            String sql = "SELECT TOP 6 * FROM products ORDER BY ID DESC";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                Product product = new Product();
//                product.setId(rs.getInt(1));
//                product.setName(rs.getString(2));
//                product.setImageUrl(rs.getString(3));
//                product.setPrice(rs.getFloat(4));
//                product.setTitle(rs.getString(5));
//                product.setDescription(rs.getString(6));
//                product.setSellId(rs.getInt(7));
//                product.setCategoryId(rs.getInt(8));
//                product.setStatus(rs.getBoolean(9));
//                list.add(product);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
    public static void main(String[] args) {
        DAOProducts a = new DAOProducts();
        List<Product> list = a.getAllProducts();
        for (Product product : list) {
            System.out.println(product);
        }
    }
}
