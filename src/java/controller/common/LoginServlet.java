package controller.common;
// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com

import dao.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.*;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // lay ra input email, password cua nguoi dung
        String user = request.getParameter("username");
        String password = request.getParameter("password");

        // dang nhap
        UsersDAO ud = new UsersDAO();
        Users u = ud.Login(user, password);

        // neu tai khoan chua ton tai
        if (u == null) {
            request.setAttribute("mess", "Wrong username or password!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else   { // neu tai khoan tont tai, tao session -> tra ve home (servlet)
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
            response.sendRedirect("home");
        } 

    }

}
