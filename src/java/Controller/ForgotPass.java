/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;
import Model.Send;
import Dal.LoginDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.http.HttpSession;
/**
 *
 * @author Tuan anh
 */
@WebServlet(name="ForgotPass", urlPatterns={"/forgot"})
public class ForgotPass extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            LoginDao dao = new LoginDao();
            String emailReset = request.getParameter("email");
            String email = "anhnthe172081@fpt.edu.vn";
            String password = "tpny idbp ncdd huuy";
            String subject = "Hi";
            Random code = new Random();
            int newPass = code.nextInt(999999);
            String message = "<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "<h1>This is your new password:</h1>"
                    + "</br>"
                    + "<h2>" + newPass + "</h2>"
                    + "</html>\n";
            Send.send(emailReset, subject, message, email, password);
            
           boolean a =  dao.updatePassword(emailReset, String.valueOf(newPass));
           HttpSession session = request.getSession();
            if (a) {
                 session.setAttribute("mess", "Please check your email");
            }else{
            session.setAttribute("mess", "Gmail does not exist");
            }
            response.sendRedirect("login.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(ForgotPass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ForgotPass.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
