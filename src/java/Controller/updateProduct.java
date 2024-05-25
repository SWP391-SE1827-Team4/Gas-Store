/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAOProducts;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import model.Product;

/**
 *
 * @author xuank
 */
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
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            String submit = request.getParameter("Submit");
            DAOProducts dao = new DAOProducts();

            if ("insertProduct".equals(service)) {
                if (submit == null) {
                    request.getRequestDispatcher("form-add-san-pham.jsp").forward(request, response);
                } else {
                    // Retrieve parameters from the request
                    String email = request.getParameter("email");
                    String pass = request.getParameter("pass");
                    String address = request.getParameter("address");
                    String phone = request.getParameter("phone");
                    String gender = request.getParameter("gender");
                    int roleID = Integer.parseInt(request.getParameter("Role"));
                    LocalDateTime createdAt = LocalDateTime.parse(request.getParameter("createdAt"));
                    LocalDateTime updatedAt = LocalDateTime.parse(request.getParameter("UpdatedAt"));

                    Product s = new Product();
                    int success = dao.InsertProduct(s);

                    if (success > 0) {
                        response.sendRedirect("ProductURL");
                    } else {
                        response.sendRedirect("form-add-san-pham.jsp");
                    }
                }
            }

            if ("updateProduct".equals(service)) {
                if (submit == null) {
                    // Show form for updating staff
                    String staffID = request.getParameter("sid");
                    Product staff = dao.getProductById(Integer.parseInt(staffID));
                    request.setAttribute("staff", staff);
                    request.getRequestDispatcher("updateStaff.jsp").forward(request, response);
                } else {
                    // Process form submission to update staff
                    int staffID = Integer.parseInt(request.getParameter("StaffID"));
                    String staffEmail = request.getParameter("StaffEmail");
                    String staffPassword = request.getParameter("StaffPassword");
                    String staffAddress = request.getParameter("StaffAddress");
                    String staffPhoneNum = request.getParameter("StaffPhoneNum");
                    String gender = request.getParameter("gender");
                    LocalDateTime updatedAt = LocalDateTime.parse(request.getParameter("UpdatedAt"));

                    Product p = new Product();
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
