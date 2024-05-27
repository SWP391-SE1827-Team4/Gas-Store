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
            String sql = "SELECT p.Product_ID, p.Category_ID, p.SerialProduct_Number, p.Product_Name,img.Image_URL,\n"
                    + "p.Product_Quantity, p.Product_Price, p.Product_Description, p.Created_At, p.Updated_At\n"
                    + "FROM Products p \n"
                    + "LEFT JOIN Image_Product img ON p.Product_ID = img.Product_ID";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt(1));
                product.setCategoryID(rs.getInt(2));
                product.setSerialProduct_Number(rs.getString(3));
                product.setProduct_Name(rs.getString(4));
                product.setImage(rs.getString(5));
                product.setProduct_Quantity(rs.getInt(6));
                product.setProduct_Price(rs.getDouble(7));
                product.setProduct_Description(rs.getString(8));
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

    public int getTotalProducts() {
        try {
            String sql = "select count(id)  from Products ";

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
                product.setCreated_At((LocalDateTime) rs.getObject(8));
                product.setUpdated_At((LocalDateTime) rs.getObject(9));
                list.add(product);

            }
        } catch (Exception ex) {
            Logger.getLogger(DAOCategories.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Product getProductById(int productId) {
        try {
            String sql = "select *  from Products where Product_ID = ?";
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
                Timestamp createdAtTimestamp = rs.getTimestamp(8);
                LocalDateTime createdAt = createdAtTimestamp != null ? createdAtTimestamp.toLocalDateTime() : null;
                product.setCreated_At(createdAt);

                Timestamp updatedAtTimestamp = rs.getTimestamp(9);
                LocalDateTime updatedAt = updatedAtTimestamp != null ? updatedAtTimestamp.toLocalDateTime() : null;
                product.setUpdated_At(updatedAt);
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
            String sql = "select * from Products where Product_ID = ?";

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

    public int insertProduct(Product product) {
        int productId = 0;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            connection.setAutoCommit(false); // Start a transaction

            // Insert into Products table
            String sql = "INSERT INTO [dbo].[Products] "
                    + "([Category_ID], [SerialProduct_Number], [Product_Name], "
                    + "[Product_Quantity], [Product_Price], [Product_Description], "
                    + "[Created_At], [Updated_At]) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

            stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, product.getCategoryID());
            stm.setString(2, product.getSerialProduct_Number());
            stm.setString(3, product.getProduct_Name());
            stm.setInt(4, product.getProduct_Quantity());
            stm.setDouble(5, product.getProduct_Price());
            stm.setString(6, product.getProduct_Description());
            stm.setTimestamp(7, Timestamp.valueOf(product.getCreated_At()));
            stm.setTimestamp(8, Timestamp.valueOf(product.getUpdated_At()));
            stm.executeUpdate();

            // Get the newly created Product_ID
            rs = stm.getGeneratedKeys();
            if (rs.next()) {
                productId = rs.getInt(1);
            }

            // Insert into Image_Product table
            sql = "INSERT INTO [dbo].[Image_Product] ([Product_ID], [Image_URL]) VALUES(?, ?)";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, productId);
            stm.setString(2, product.getImage());
            stm.executeUpdate();

            connection.commit(); // Commit the transaction
        } catch (SQLException ex) {
            try {
                connection.rollback(); // Rollback the transaction on error
            } catch (SQLException e) {
                Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, "Rollback failed: " + e.getMessage(), e);
            }
            Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, "Insert product failed: " + ex.getMessage(), ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                connection.setAutoCommit(true); // Restore the auto-commit mode
            } catch (SQLException e) {
                Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, "Closing resources failed: " + e.getMessage(), e);
            }
        }

        return productId;
    }

    public void deleteProduct(int pid) {
        try {
            connection.setAutoCommit(false); // Start a transaction

            // Delete from Image_Product table
            String deleteImageSql = "DELETE FROM [dbo].[Image_Product] WHERE Product_ID = ?";
            PreparedStatement deleteImageStm = connection.prepareStatement(deleteImageSql);
            deleteImageStm.setInt(1, pid);
            deleteImageStm.executeUpdate();

            // Delete from Products table
            String deleteProductSql = "DELETE FROM [dbo].[Products] WHERE Product_ID = ?";
            PreparedStatement deleteProductStm = connection.prepareStatement(deleteProductSql);
            deleteProductStm.setInt(1, pid);
            deleteProductStm.executeUpdate();

            connection.commit(); // Commit the transaction
        } catch (SQLException ex) {
            try {
                connection.rollback(); // Rollback the transaction on error
            } catch (SQLException e) {
                Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, e);
            }
            Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.setAutoCommit(true); // Restore the auto-commit mode
            } catch (SQLException e) {
                Logger.getLogger(DAOProducts.class.getName()).log(Level.SEVERE, null, e);
            }
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
            stm.setObject(7, p.getCreated_At());
            stm.setObject(8, p.getUpdated_At());
            stm.setInt(9, p.getProductID());
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
//        DAOProducts a = new DAOProducts();
//        List<Product> list = a.getAllProducts();
//        for (Product product : list) {
//            System.out.println(product);
//        }
        Product newProduct = new Product();
        newProduct.setCategoryID(1);
        newProduct.setSerialProduct_Number("SN123456");
        newProduct.setProduct_Name("Example Product");
        newProduct.setProduct_Quantity(100);
        newProduct.setProduct_Price(29.99);
        newProduct.setProduct_Description("This is an example product.");
        newProduct.setCreated_At(LocalDateTime.now());
        newProduct.setUpdated_At(LocalDateTime.now());
        newProduct.setImage("http://example.com/image.jpg");

        DAOProducts dao = new DAOProducts();
        int productId = dao.insertProduct(newProduct);
        System.out.println("Inserted product with ID: " + productId);
    }
}
