/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Dal.RegisterDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 *
 * @author Tuan anh
 */
@WebServlet(name="Register", urlPatterns={"/register"})
public class Register extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Register at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         HttpSession session = request.getSession();

    PrintWriter out = response.getWriter();

   
String name =  request.getParameter("customerName");
        String email =request.getParameter("email");
        String password = request.getParameter("pass");
        String phoneNum = request.getParameter("phone");
        String address =request.getParameter("address");
        String gender =request.getParameter("Gender");
        int roleId = 1; // Assume 1 for regular customer
    String message = ""; // Biến để xây dựng thông báo
   
    
    out.print(name+email+password+phoneNum+address+gender);
    try {
        // Kiểm tra số điện thoại
        if (!phoneNum.matches("^0\\d{9}$")) {
            message = "Nhập đúng số điện thoại.";
        }

        // Kiểm tra mật khẩu
        if (password.length() < 6) {
            message = "Mật khẩu ít nhất 6 kí tự.";
        }

        // Kiểm tra email
        if (!email.contains("@")) {
            message = "Địa chỉ email không hợp lệ.";
        }
        RegisterDao RegisterDao= new RegisterDao();
        // Thực hiện chèn dữ liệu cho khách hàng nếu không có lỗi về dữ liệu
        if (message.isEmpty()) {
            boolean isSuccess = RegisterDao.insertCustomer(name, email, password, phoneNum, address, gender, roleId);
            if (isSuccess) {
                message = "Tạo tài khoản thành công.";
            } else {
                message = "Tài khoản đã tồn tại.";
            }
        }

    } catch (SQLException | ClassNotFoundException ex) {
        System.out.println("An error occurred: " + ex.getMessage());
    }

    // Đặt thông báo vào session
    session.setAttribute("mess", message);

    response.sendRedirect("login.jsp");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
