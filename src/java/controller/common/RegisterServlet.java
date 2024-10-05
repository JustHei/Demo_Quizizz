package controller.common;
// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.UsersDAO;
import model.Users;

public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        String re_pass = request.getParameter("repass");

        // Kiểm tra xem tất cả các trường thông tin đã được nhập hay không
        if (username.isEmpty() || pass == null && re_pass.isEmpty()) {
            // Nếu có bất kỳ trường nào trống, hiển thị thông báo lỗi
            request.setAttribute("mess", "Please fill in all fields.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return; // Dừng xử lý tiếp theo
        }

        if (pass.equals(re_pass)) {
            response.sendRedirect("login.jsp");
        } else {
            UsersDAO usersDAO = new UsersDAO();
            Users users = usersDAO.checkLogin(username);
            if (users == null) {
                usersDAO.Register(username, pass, username, pass, pass, re_pass);
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("mess", "Username already exists!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        }
    }
}
