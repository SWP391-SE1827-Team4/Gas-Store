package Controller;

import utils.Send;
import Dal.LoginDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "ForgotPass", urlPatterns = {"/forgot"})
public class ForgotPass extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            LoginDao dao = new LoginDao();
            String emailReset = request.getParameter("email");
            String email = "anhnthe172081@fpt.edu.vn";
            String password = "tpny idbp ncdd huuy";
            String subject = "Password Reset";
            Random code = new Random();
            int newPass = code.nextInt(999999);
            String message = "<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "<h1>This is your new password:</h1>"
                    + "<br/>"
                    + "<h2>" + newPass + "</h2>"
                    + "</html>\n";
            Send.send(emailReset, subject, message, email, password);

            boolean isUpdated = dao.updatePassword(emailReset, String.valueOf(newPass));
            HttpSession session = request.getSession();
            if (isUpdated) {
                session.setAttribute("mess", "Please check your email for the new password.");
            } else {
                session.setAttribute("mess", "Email does not exist.");
            }
            response.sendRedirect("login.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(ForgotPass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ForgotPass.class.getName()).log(Level.SEVERE, null, ex);
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
        return "ForgotPass servlet";
    }
}
