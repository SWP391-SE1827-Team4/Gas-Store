/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;
import Model.Products;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeDao {
    public List<Products> getAllProducts() throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Products> productList = new ArrayList<>();

        try {
            con = DBContext.makeConnection();
            if (con != null) {
                String sql = "WITH RankedImages AS (\n" +
"    SELECT \n" +
"        p.Product_ID,\n" +
"        p.Category_ID,\n" +
"        p.SerialProduct_Number,\n" +
"        p.Product_Name,\n" +
"        p.Product_Quantity,\n" +
"        p.Product_Price,\n" +
"        p.Product_Description,\n" +
"        p.Created_At,\n" +
"        p.Updated_At,\n" +
"        i.Image_URL,\n" +
"        ROW_NUMBER() OVER (PARTITION BY p.Product_ID ORDER BY i.Image_ID) AS rn\n" +
"    FROM \n" +
"        Products p\n" +
"    INNER JOIN \n" +
"        Image_Product i\n" +
"    ON \n" +
"        p.Product_ID = i.Product_ID\n" +
")\n" +
"SELECT \n" +
"    Product_ID,\n" +
"    Category_ID,\n" +
"    SerialProduct_Number,\n" +
"    Product_Name,\n" +
"    Product_Quantity,\n" +
"    Product_Price,\n" +
"    Product_Description,\n" +
"    Created_At,\n" +
"    Updated_At,\n" +
"    Image_URL\n" +
"FROM \n" +
"    RankedImages\n" +
"WHERE \n" +
"    rn = 1;";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    Products product = new Products(
                        rs.getInt("Product_ID"),
                        rs.getInt("Category_ID"),
                        rs.getString("SerialProduct_Number"),
                        rs.getString("Product_Name"),
                        rs.getInt("Product_Quantity"),
                        rs.getInt("Product_Price"),
                        rs.getString("Product_Description"),
                            rs.getString("Image_URL"),
                        rs.getDate("Created_At"),
                        rs.getDate("Updated_At")
                    );
                    productList.add(product);
                }
            }
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) { /* ignored */ }
            try { if (stm != null) stm.close(); } catch (SQLException e) { /* ignored */ }
            try { if (con != null) con.close(); } catch (SQLException e) { /* ignored */ }
        }
        return productList;
    }
    public List<Products> searchProductsByName(String name) throws SQLException, ClassNotFoundException {
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    List<Products> productList = new ArrayList<>();

    try {
        con = DBContext.makeConnection();
        if (con != null) {
            String sql = "WITH RankedImages AS (\n" +
                    "    SELECT \n" +
                    "        p.Product_ID,\n" +
                    "        p.Category_ID,\n" +
                    "        p.SerialProduct_Number,\n" +
                    "        p.Product_Name,\n" +
                    "        p.Product_Quantity,\n" +
                    "        p.Product_Price,\n" +
                    "        p.Product_Description,\n" +
                    "        p.Created_At,\n" +
                    "        p.Updated_At,\n" +
                    "        i.Image_URL,\n" +
                    "        ROW_NUMBER() OVER (PARTITION BY p.Product_ID ORDER BY i.Image_ID) AS rn\n" +
                    "    FROM \n" +
                    "        Products p\n" +
                    "    INNER JOIN \n" +
                    "        Image_Product i\n" +
                    "    ON \n" +
                    "        p.Product_ID = i.Product_ID\n" +
                    ")\n" +
                    "SELECT \n" +
                    "    Product_ID,\n" +
                    "    Category_ID,\n" +
                    "    SerialProduct_Number,\n" +
                    "    Product_Name,\n" +
                    "    Product_Quantity,\n" +
                    "    Product_Price,\n" +
                    "    Product_Description,\n" +
                    "    Created_At,\n" +
                    "    Updated_At,\n" +
                    "    Image_URL\n" +
                    "FROM \n" +
                    "    RankedImages\n" +
                    "WHERE \n" +
                    "    rn = 1 AND Product_Name LIKE ?;"; // Sử dụng LIKE để tìm kiếm một phần của tên sản phẩm
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + name + "%"); // Gán tham số cho câu truy vấn
            rs = stm.executeQuery();
            while (rs.next()) {
                Products product = new Products(
                        rs.getInt("Product_ID"),
                        rs.getInt("Category_ID"),
                        rs.getString("SerialProduct_Number"),
                        rs.getString("Product_Name"),
                        rs.getInt("Product_Quantity"),
                        rs.getInt("Product_Price"),
                        rs.getString("Product_Description"),
                        rs.getString("Image_URL"),
                        rs.getDate("Created_At"),
                        rs.getDate("Updated_At")
                );
                productList.add(product);
            }
        }
    } finally {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            /* ignored */
        }
        try {
            if (stm != null) stm.close();
        } catch (SQLException e) {
            /* ignored */
        }
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            /* ignored */
        }
    }
    return productList;
}

    public static void main(String[] args) {
        HomeDao homeDao = new HomeDao();
        try {
            List<Products> productList = homeDao.searchProductsByName("a");
            for (Products product : productList) {
                System.out.println("Product ID: " + product.getProductId());
                System.out.println("Category ID: " + product.getCategoryId());
                System.out.println("Serial Product Number: " + product.getSerialProductNumber());
                System.out.println("Product Name: " + product.getProductName());
                System.out.println("Product Quantity: " + product.getProductQuantity());
                System.out.println("Product Price: " + product.getProductPrice());
                System.out.println("Product Description: " + product.getProductDescription());
                System.out.println("Image URL: " + product.getImage_URL());
                System.out.println("Created At: " + product.getCreatedAt());
                System.out.println("Updated At: " + product.getUpdatedAt());
                System.out.println("-----------------------");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
