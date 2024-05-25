/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAOCustomer;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;
import model.User_Account;

/**
 *
 * @author xuank
 */
@WebServlet(name = "UpdateCustomer", urlPatterns = {"/updateC"})
public class UpdateCustomer extends HttpServlet {

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
        DAOCustomer dao = new DAOCustomer();

        if ("insertCustomer".equals(service)) {
            if (submit == null) {
                request.getRequestDispatcher("form-add-Khach-hang.jsp").forward(request, response);
                return;
            } else {
                // Retrieve parameters from the request
                String email = request.getParameter("email");
                String name = request.getParameter("name");
                String pass = request.getParameter("pass");
                String address = request.getParameter("address");
                String phone = request.getParameter("phone");
                String gender = request.getParameter("gender");

                LocalDateTime createdAt = LocalDateTime.parse(request.getParameter("createdAt"));
                LocalDateTime updatedAt = LocalDateTime.parse(request.getParameter("UpdatedAt"));

                // Set isGuest to true by default
                boolean isCustomer = false;
                boolean isGuest = true;

                User_Account s = new User_Account(0, name, pass, email, phone, address, gender, createdAt, updatedAt, isCustomer, isGuest);
                int success = dao.insertUser(s);

                if (success > 0) {
                    response.sendRedirect("CustomerURL");
                } else {
                    response.sendRedirect("form-add-khach-hang.jsp");
                }
                return;
            }
        }

        if ("updateUser".equals(service)) {
            if (submit == null) {
                // Show form for updating customer
                String cid = request.getParameter("cid");
                User_Account customer = dao.getCustomersById(Integer.parseInt(cid));
                request.setAttribute("customer", customer);
                request.getRequestDispatcher("updateCustomer.jsp").forward(request, response);
            } else {
                // Process form submission to update customer
                int ID = Integer.parseInt(request.getParameter("UserID"));
                String email = request.getParameter("UserEmail");
                String name = request.getParameter("UserName");
                String pass = request.getParameter("UserPassword");
                String address = request.getParameter("UserAddress");
                String phone = request.getParameter("UserPhoneNum");
                String gender = request.getParameter("UserGender");
                LocalDateTime updatedAt = LocalDateTime.parse(request.getParameter("UpdatedAt"));
                boolean isCustomer = request.getParameter("IsCustomer").equals("1"); // Check if isAdmin value is "1"
                boolean isGuest = request.getParameter("IsGuest").equals("1"); // Check if isStaff value is "1"

                User_Account c = new User_Account(ID, name, pass, email, phone, address, gender, updatedAt, isCustomer, isGuest);
                dao.updateAccountCustomer1(c);
                response.sendRedirect("CustomerURL");
            }
        }

        if ("deleteCustomer".equals(service)) {
            int cid = Integer.parseInt(request.getParameter("cid"));
            dao.deleteAccount(cid);
            response.sendRedirect("CustomerURL");
            return;
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
