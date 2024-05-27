package Controller;

import Dal.RegisterDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;

@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Register at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        String name = request.getParameter("customerName");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        String phoneNum = request.getParameter("phone");
        String address = request.getParameter("address");
        String gender = request.getParameter("Gender");
        String image = "default.jpg"; // Default image path
        int roleId = 1; // Assume 1 for regular customer
        String message = "";

        try {
            if (!phoneNum.matches("^0\\d{9}$")) {
                message = "Nhập đúng số điện thoại.";
            }

            if (password.length() < 6) {
                message = "Mật khẩu ít nhất 6 kí tự.";
            }

            if (!email.contains("@")) {
                message = "Địa chỉ email không hợp lệ.";
            }

            RegisterDAO registerDao = new RegisterDAO();
            if (message.isEmpty()) {
                boolean isSuccess = registerDao.registerCustomer(name, email, password, phoneNum, address, gender, image);
                if (isSuccess) {
                    message = "Tạo tài khoản thành công.";
                } else {
                    message = "Tài khoản đã tồn tại.";
                }
            }

        } catch (SQLException | ClassNotFoundException ex) {
            message = "Đã xảy ra lỗi. Vui lòng thử lại.";
            ex.printStackTrace();
        }

        session.setAttribute("mess", message);
        response.sendRedirect("login.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
