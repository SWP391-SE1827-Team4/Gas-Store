/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAOProducts;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.time.LocalDateTime;
import java.util.UUID;
import model.Product;

/**
 *
 * @author xuank
 */
@WebServlet(name = "UpdateProduct", urlPatterns = {"/updateP"})
public class updateProduct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String service = request.getParameter("service");
        String submit = request.getParameter("Submit");
        DAOProducts dao = new DAOProducts();

        if ("insertProduct".equals(service)) {
            if (submit == null) {
                request.getRequestDispatcher("form-add-san-pham.jsp").forward(request, response);
            } else {
                // Retrieve parameters from the request
                int category = Integer.parseInt(request.getParameter("category"));
                String serial = request.getParameter("serial");
                String name = request.getParameter("name");
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                double price = Double.parseDouble(request.getParameter("price"));
                LocalDateTime createdAt = LocalDateTime.parse(request.getParameter("createdAt"));
                LocalDateTime updatedAt = LocalDateTime.parse(request.getParameter("UpdatedAt"));
                String description = request.getParameter("description");
                String Image = request.getParameter("ImageUpload");

                Product s = new Product(0, category, serial, name, quantity, price, description, Image, createdAt, updatedAt);
                int success = dao.InsertProduct(s);

                if (success > 0) {
                    request.getRequestDispatcher("ProductURL").forward(request, response);
                } else {
                    response.sendRedirect("form-add-san-pham.jsp");
                }
            }
        }

        if ("updateProduct".equals(service)) {
            if (submit == null) {
                // Show form for updating staff
                String pid = request.getParameter("pid");
                Product product = dao.getProductById(Integer.parseInt(pid));
                request.setAttribute("product", product);
                request.getRequestDispatcher("updateProducts.jsp").forward(request, response);
            } else {
                // Process form submission to update staff
                int ID = Integer.parseInt(request.getParameter("ProductID"));
                int category = Integer.parseInt(request.getParameter("category"));
                String serial = request.getParameter("serial");
                String name = request.getParameter("name");
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                double price = Double.parseDouble(request.getParameter("price"));
                LocalDateTime createdAt = LocalDateTime.parse(request.getParameter("createdAt"));
                LocalDateTime updatedAt = LocalDateTime.parse(request.getParameter("UpdatedAt"));
                String description = request.getParameter("description");
                Part filePart = request.getPart("ImageUpload");
                String fileName = UUID.randomUUID().toString() + "_" + filePart.getSubmittedFileName();
                String fileUrl = "/uploads/" + fileName; // Assuming uploads directory exists
                String uploadPath = request.getServletContext().getRealPath("") + File.separator + "uploads";
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                filePart.write(uploadPath + File.separator + fileName);

                Product p = new Product(ID, category, serial, name, quantity, price, description, fileName, createdAt, updatedAt);
                dao.updateProduct(p);
                response.sendRedirect("ProductURL");
            }
        }

        if ("deleteProduct".equals(service)) {
            int pid = Integer.parseInt(request.getParameter("pid"));
            dao.deleteProduct(pid);
            response.sendRedirect("ProductURL");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
