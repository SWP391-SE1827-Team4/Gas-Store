/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAOManager;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import model.Managers;

/**
 *
 * @author xuank
 */
@WebServlet(name = "StaffController", urlPatterns = {"/StaffURL"})
public class StaffController extends HttpServlet {

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
            DAOManager dao = new DAOManager();
            String service = request.getParameter("service");
            String submit = request.getParameter("Submit");
            List<Managers> staffList = dao.getAllAccount();
            request.setAttribute("staff", staffList); // Update the attribute name if needed
            request.getRequestDispatcher("table-data-nhan-vien.jsp").forward(request, response);

            if ("insertStaff".equals(service)) {
                if (submit == null) {
                    request.getRequestDispatcher("form-add-nhan-vien.jsp").forward(request, response);
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

                    // Debugging information
                    System.out.println("Email: " + email);
                    System.out.println("Pass: " + pass);
                    System.out.println("Address: " + address);
                    System.out.println("Phone: " + phone);
                    System.out.println("Gender: " + gender);
                    System.out.println("RoleID: " + roleID);
                    System.out.println("CreatedAt: " + createdAt);
                    System.out.println("UpdatedAt: " + updatedAt);

//                    Managers s = new Managers(0, email, pass, address, phone, gender, roleID, createdAt, updatedAt);
//                    int success = dao.insertStaff(s);
//
//                    if (success > 0) {
//                        response.sendRedirect("StaffURL");
//                    } else {
//                        response.sendRedirect("form-add-nhan-vien.jsp");
//                    }
                }
            }
            if ("updateStaff".equals(service)) {
                if (submit == null) {
                    // Show form for updating staff
                    String staffID = request.getParameter("sid");
                    Managers staff = dao.getManagerById(Integer.parseInt(staffID));
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

                    Managers staff = new Managers();
                    dao.updateAccountManagers1(staff);
                    response.sendRedirect("StaffURL");
                }
            }

            if ("deleteStaff".equals(service)) {
                int id = Integer.parseInt(request.getParameter("uid"));
                dao.deleteAccount(id);
                response.sendRedirect("StaffURL");
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of DAOCustomer
        DAOManager dao = new DAOManager();

        // Retrieve all user accounts from the database
        List<Managers> accounts = dao.getAllAccount();

        // Print the retrieved user accounts
        System.out.println("Retrieved User Accounts:");
        for (Managers m : accounts) {
            System.out.println(m);
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