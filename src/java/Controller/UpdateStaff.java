package Controller;

import DAO.DAOStaff;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import model.Staff;

//@WebServlet(name = "UpdateStaff", urlPatterns = {"/updateS"})
public class UpdateStaff extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            String submit = request.getParameter("Submit");
            DAOStaff dao = new DAOStaff();

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

                    Staff s = new Staff(0, email, pass, address, phone, gender, roleID, createdAt, updatedAt);
                    int success = dao.insertStaff(s);

                    if (success > 0) {
                        response.sendRedirect("StaffURL");
                    } else {
                        response.sendRedirect("form-add-nhan-vien.jsp");
                    }
                }
            }

            if ("updateProduct".equals(service)) {
                response.sendRedirect("UpdateAccount.jsp");
            }

            if ("deleteStaff".equals(service)) {
                int sid = Integer.parseInt(request.getParameter("sid"));
                dao.deleteAccount(sid);
                response.sendRedirect("StaffURL");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
