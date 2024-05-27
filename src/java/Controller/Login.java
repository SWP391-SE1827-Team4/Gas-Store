/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Dal.LoginDao;
import Model.Admins;
import Model.Customers;
import Model.Staffs;
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
@WebServlet(name="Login", urlPatterns={"/login"})
public class Login extends HttpServlet {
   
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
            out.println("<title>Servlet Login</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath () + "</h1>");
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
       response.sendRedirect("login.jsp");
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
      
        response.setContentType("text/html;charset=UTF-8");
        String url = "login.jsp";
        String role = request.getParameter("role");
        String password = request.getParameter("pass");
        String button = request.getParameter("btAction");
        String username = request.getParameter("email");
        
        try {         
            if (role != null && !role.isEmpty()) {
                switch (role) {
                    case "customer":
                        LoginDao customerDao = new LoginDao();
                        Customers customer = customerDao.checkLoginCustomer(username, password);
                        if (customer != null) {
                            HttpSession session = request.getSession();
                            session.setAttribute("customer", customer);
                            session.setAttribute("role", "customer");
                            response.sendRedirect("home");
                            return;
                        }
                        break;
                    case "admin":
                        LoginDao adminDao = new LoginDao();
                        Admins admin = adminDao.checkLoginAdmin(username, password);
                        if (admin != null) {
                            HttpSession session = request.getSession();
                            session.setAttribute("admin", admin);
                            session.setAttribute("role", "admin");
                            response.sendRedirect("listadmin");
                            return;
                        }
                        break;
                    case "staff":
                        LoginDao staffDao = new LoginDao();
                        Staffs staff = staffDao.checkLoginStaff(username, password);
                        if (staff != null) {
                            HttpSession session = request.getSession();
                            session.setAttribute("role", "staff");
                            session.setAttribute("staff", staff);
                            response.sendRedirect("liststaff");
                            return;
                        }
                        break;
                }
            }
            // If none of the conditions above are met, it means login failed
            HttpSession session = request.getSession();
            session.setAttribute("mess", "Invalid email or password");
            response.sendRedirect(url);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            // Redirect to an error page or handle the error appropriately
            response.sendRedirect("error.jsp");
        }
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
