/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAOCartDetail;
import DAO.DAOManager;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author xuank
 */
public class updateOrderDetail extends HttpServlet {

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
        DAOCartDetail dao = new DAOCartDetail();

//        if ("insertStaff".equals(service)) {
//            if (submit == null) {
//                request.getRequestDispatcher("form-add-nhan-vien.jsp").forward(request, response);
//            } else {
//                // Retrieve parameters from the request
//                String email = request.getParameter("email");
//                String pass = request.getParameter("pass");
//                String address = request.getParameter("address");
//                String phone = request.getParameter("phone");
//                String gender = request.getParameter("gender");
//                String isAdminParam = request.getParameter("isAdmin");
//                String isStaffParam = request.getParameter("isStaff");
//                boolean isAdmin = "1".equals(isAdminParam);
//                boolean isStaff = "1".equals(isStaffParam);
//                LocalDateTime createdAt = LocalDateTime.parse(request.getParameter("createdAt"));
//                LocalDateTime updatedAt = LocalDateTime.parse(request.getParameter("UpdatedAt"));
//
//                Managers s = new Managers(0, email, address, address, phone, gender, isAdmin, isStaff, createdAt, updatedAt);
//                int success = dao.insertManagers(s);
//
//                if (success > 0) {
//                    response.sendRedirect("StaffURL");
//                } else {
//                    response.sendRedirect("form-add-nhan-vien.jsp");
//                }
//            }
//        }
//
//        if ("updateManager".equals(service)) {
//            if (submit == null) {
//                // Show form for updating staff
//                String ManagerID = request.getParameter("sid");
//                Managers staffList = dao.getManagerById(Integer.parseInt(ManagerID));
//                request.setAttribute("staffList", staffList);
//                request.getRequestDispatcher("updateStaff.jsp").forward(request, response);
//            } else {
//                // Process form submission to update staff
//                int staffID = Integer.parseInt(request.getParameter("StaffID"));
//                String staffEmail = request.getParameter("StaffEmail");
//                String staffPassword = request.getParameter("StaffPassword");
//                String staffAddress = request.getParameter("StaffAddress");
//                String staffPhoneNum = request.getParameter("StaffPhoneNum");
//                String gender = request.getParameter("gender");
//                boolean isAdmin = request.getParameter("isAdmin").equals("1"); // Check if isAdmin value is "1"
//                boolean isStaff = request.getParameter("isStaff").equals("1"); // Check if isStaff value is "1"
//                LocalDateTime updatedAt = LocalDateTime.parse(request.getParameter("UpdatedAt"));
//
//                Managers s = new Managers(staffID, staffEmail, staffPassword, staffAddress, staffPhoneNum, gender, isAdmin, isStaff, updatedAt);
//                dao.updateAccountManagers1(s);
//                response.sendRedirect("StaffURL");
//            }
//        }
        if ("deleteOrders".equals(service)) {
            int oid = Integer.parseInt(request.getParameter("oid"));
            dao.deleteOrder(oid);
            response.sendRedirect("ShippingURL");
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
