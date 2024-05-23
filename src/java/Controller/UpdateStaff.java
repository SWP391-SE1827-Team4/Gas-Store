package Controller;

import DAO.DAOStaff;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Vector;
import model.Staff;

@WebServlet(name = "UpdateStaff", urlPatterns = {"/updateS"})
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

                    Staff s = new Staff(0, email, pass, address, phone, gender, roleID, createdAt, updatedAt);
                    int success = dao.insertStaff(s);

                    if (success > 0) {
                        response.sendRedirect("StaffURL");
                    } else {
                        response.sendRedirect("form-add-nhan-vien.jsp");
                    }
                }
            }

            if ("updateStaff".equals(service)) {
                if (submit == null) {
                    // Show form for updating staff
                    String staffID = request.getParameter("sid");
                    Staff staff = dao.getStaffById(Integer.parseInt(staffID));
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

                    Staff staff = new Staff(staffID, staffEmail, staffPassword, staffAddress, staffPhoneNum, gender, staffID, updatedAt, updatedAt);
                    dao.updateAccountStaff1(staff);
                    response.sendRedirect("StaffURL");
                }
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
