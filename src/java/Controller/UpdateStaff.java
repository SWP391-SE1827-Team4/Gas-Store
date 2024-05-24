package Controller;

import DAO.DAOManager;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import model.Managers;

@WebServlet(name = "UpdateStaff", urlPatterns = {"/updateS"})
public class UpdateStaff extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String service = request.getParameter("service");
        String submit = request.getParameter("Submit");
        DAOManager dao = new DAOManager();

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
                String isAdminParam = request.getParameter("isAdmin");
                String isStaffParam = request.getParameter("isStaff");
                boolean isAdmin = "1".equals(isAdminParam);
                boolean isStaff = "1".equals(isStaffParam);
                LocalDateTime createdAt = LocalDateTime.parse(request.getParameter("createdAt"));
                LocalDateTime updatedAt = LocalDateTime.parse(request.getParameter("UpdatedAt"));

                Managers s = new Managers(0, email, address, address, phone, gender, isAdmin, isStaff, createdAt, updatedAt);
                int success = dao.insertManagers(s);

                if (success > 0) {
                    response.sendRedirect("StaffURL");
                } else {
                    response.sendRedirect("form-add-nhan-vien.jsp");
                }
            }
        }

        if ("updateManager".equals(service)) {
            if (submit == null) {
                // Show form for updating staff
                String ManagerID = request.getParameter("sid");
                Managers staffList = dao.getManagerById(Integer.parseInt(ManagerID));
                request.setAttribute("staffList", staffList);
                request.getRequestDispatcher("updateStaff.jsp").forward(request, response);
            } else {
                // Process form submission to update staff
                int staffID = Integer.parseInt(request.getParameter("StaffID"));
                String staffEmail = request.getParameter("StaffEmail");
                String staffPassword = request.getParameter("StaffPassword");
                String staffAddress = request.getParameter("StaffAddress");
                String staffPhoneNum = request.getParameter("StaffPhoneNum");
                String gender = request.getParameter("gender");
                boolean isAdmin = request.getParameter("isAdmin").equals("1"); // Check if isAdmin value is "1"
                boolean isStaff = request.getParameter("isStaff").equals("1"); // Check if isStaff value is "1"
                LocalDateTime updatedAt = LocalDateTime.parse(request.getParameter("UpdatedAt"));

                Managers s = new Managers(staffID, staffEmail, staffPassword, staffAddress, staffPhoneNum, gender, isAdmin, isStaff, updatedAt);
                dao.updateAccountManagers1(s);
                response.sendRedirect("StaffURL");
            }
        }

        if ("deleteStaff".equals(service)) {
            int sid = Integer.parseInt(request.getParameter("sid"));
            dao.deleteAccount(sid);
            response.sendRedirect("StaffURL");
        }
    }

// Method to convert hexadecimal string to byte array
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
