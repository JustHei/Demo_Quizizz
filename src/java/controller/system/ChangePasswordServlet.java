/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.system;

import dao.UsersDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Users;

/**
 *
 * @author hardi
 */
public class ChangePasswordServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangePasswordServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePasswordServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        String username = user.getUsername();
        
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        UsersDAO accountdao = new UsersDAO();
        String errorMessage = "";

        if (!accountdao.checkPassword(username, oldPassword)) {
            errorMessage = "Old password is incorrect.";
        } else if (accountdao.checkPassword(username, newPassword)) {
            errorMessage = "New password cannot be the same as the old password. Please try again.";
        } else if (!newPassword.equals(confirmPassword)) {
            errorMessage = "Passwords do not match! Please try again.";
        } else if (newPassword.length() < 6 || newPassword.length() > 20) {
            errorMessage = "Password must be between 6 and 20 characters long!";
        } else if (newPassword.contains(" ")) {
            errorMessage = "Password must not contain spaces!";
        } else {
            boolean isUpdated = accountdao.updatePassword(username, newPassword);
            if (isUpdated) {
                // Lưu mật khẩu mới vào session, ghi đè lên mật khẩu cũ
                session.setAttribute("password", newPassword);
                response.sendRedirect("profile");
                return; // Thoát khỏi phương thức để tránh tiếp tục xử lý
            } else {
                request.getRequestDispatcher("changePassword.jsp").forward(request, response);
            }
        }
        request.setAttribute("errorMessage", errorMessage);
        request.getRequestDispatcher("changePassword.jsp").forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
