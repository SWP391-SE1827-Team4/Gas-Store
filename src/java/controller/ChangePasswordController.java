/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import utils.PasswordValidator;
import utils.SendMail;

/**
 *
 * @author Hung
 */
@WebServlet(name = "ChangePasswordController", urlPatterns = {"/changePassword"})
public class ChangePasswordController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("menu", "pass");
        request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User userOld = (User) session.getAttribute("user");
        request.setAttribute("menu", "pass");

        String pass = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        if (!PasswordValidator.isValidPassword(pass) || !PasswordValidator.isValidPassword(newPassword)) {
            request.setAttribute("mess", "Password must have at least 8 characters, including upper and lower case letters and numbers");
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
            return;
        }
        User user = new UserDAO().checkUser(userOld.getEmail(), pass);
        if (user == null) {
            request.setAttribute("mess", "Old Password not correct");
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
            return;
        }

        user.setPassword(newPassword);

        new UserDAO().updateUserPass(user);

        user = new UserDAO().getUserById(user.getId());
        session.setAttribute("user", user);

        request.setAttribute("mess", "Change Pass successful");

        SendMail.sendMailFunction(user.getEmail(), "Change Pass successful", "Your password has been changed");

        request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
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
