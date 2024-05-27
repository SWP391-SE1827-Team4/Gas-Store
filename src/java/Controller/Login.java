package Controller;

import Dal.LoginDao;
import Model.Manager;
import Model.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;

@WebServlet(name="Login", urlPatterns={"/login"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (var out = response.getWriter()) {
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       response.sendRedirect("login.jsp");
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "login.jsp";
        String role = request.getParameter("role");
        String password = request.getParameter("pass");
        String username = request.getParameter("email");
        
        try {         
            if (role != null && !role.isEmpty()) {
                LoginDao loginDao = new LoginDao();
                HttpSession session = request.getSession();
                
                switch (role) {
                    case "customer":
                        User user = loginDao.checkLoginUser(username, password);
                        if (user != null) {
                            session.setAttribute("user", user);
                            session.setAttribute("role", "customer");
                            response.sendRedirect("home");
                            return;
                        }
                        break;
                    case "admin":
                        Manager admin = loginDao.checkLoginManager(username, password);
                        if (admin != null && admin.isAdmin()) {
                            session.setAttribute("manager", admin);
                            session.setAttribute("role", "admin");
                            response.sendRedirect("listadmin");
                            return;
                        }
                        break;
                    case "staff":
                        Manager staff = loginDao.checkLoginManager(username, password);
                        if (staff != null && staff.isStaff()) {
                            session.setAttribute("manager", staff);
                            session.setAttribute("role", "staff");
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
            response.sendRedirect("error404.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
