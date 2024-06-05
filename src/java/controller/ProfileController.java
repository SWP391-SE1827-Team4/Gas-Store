/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Base64;
import model.User;
import utils.FileUtils;

/**
 *
 * @author Hung
 */
@WebServlet(name = "ProfileController", urlPatterns = {"/Profile"})
@MultipartConfig
public class ProfileController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User userFake = new UserDAO().getUserById(1);

        session.setAttribute("user", userFake);
        request.setAttribute("menu", "general");
        
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User userOld = (User) session.getAttribute("user");
        userOld = new UserDAO().getUserById(userOld.getId());
        if (request.getParameter("imageUser") != null) {
//            // Xử lý tải lên file
//            Part filePart = request.getPart("imageUser");
//            InputStream fileContent = filePart.getInputStream();
//            if (FileUtils.isImageFile(fileContent)) {
//                // Đọc nội dung file vào mảng byte
//                ByteArrayOutputStream output = new ByteArrayOutputStream();
//                byte[] buffer = new byte[4096];
//                int bytesRead;
//                while ((bytesRead = fileContent.read(buffer)) != -1) {
//                    output.write(buffer, 0, bytesRead);
//                }
//                byte[] imageData = output.toByteArray();
//
//            }
            userOld.setImage(request.getParameter("imageUser"));

        }

        userOld.setFullname(request.getParameter("fullname"));
        userOld.setPhone(request.getParameter("phone"));
        userOld.setAddress(request.getParameter("address"));

        new UserDAO().updateUser(userOld);
        userOld = new UserDAO().getUserById(1);
        session.setAttribute("user", userOld);
//        request.setAttribute("base64Image", base64Image);
        request.setAttribute("mess", "Save data successful");
        request.setAttribute("menu", "general");
        request.getRequestDispatcher("profile.jsp").forward(request, response);
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
