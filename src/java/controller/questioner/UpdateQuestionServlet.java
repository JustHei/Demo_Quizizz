/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.questioner;

import dao.QuestionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Question;

/**
 *
 * @author hardi
 */
public class UpdateQuestionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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
            out.println("<title>Servlet UpdateQuestionServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateQuestionServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strQuizId = request.getParameter("quizId");
        int quizId = Integer.parseInt(strQuizId);

        // Tạo đối tượng QuestionDAO và lấy danh sách câu hỏi
        QuestionDAO questionDAO = new QuestionDAO();
        List<Question> listQues = questionDAO.getQuestionByQuizId(quizId);

        // Chuyển danh sách câu hỏi đến trang JSP
        request.setAttribute("listQues", listQues);
        request.setAttribute("quizId", quizId); // Thêm quizId vào request để sử dụng trong trang JSP
        request.getRequestDispatcher("updateQuestion.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Nhận dữ liệu từ form và kiểm tra null hoặc rỗng
            String strQuestionId = request.getParameter("questionId");
            String strQuizId = request.getParameter("quizId");

            // Nếu giá trị null hoặc rỗng, có thể xử lý lỗi hoặc gán giá trị mặc định
            if (strQuestionId == null || strQuestionId.trim().isEmpty()) {
                throw new NumberFormatException("Question ID is missing.");
            }
            if (strQuizId == null || strQuizId.trim().isEmpty()) {
                throw new NumberFormatException("Quiz ID is missing.");
            }

            int questionId = Integer.parseInt(strQuestionId);
            String questionContent = request.getParameter("questionContent");
            boolean questionKey = Boolean.parseBoolean(request.getParameter("questionKey"));
            int quizId = Integer.parseInt(strQuizId);

            // Tạo đối tượng Question
            Question question = new Question(questionId, questionContent, questionKey, quizId);

            // Tạo đối tượng QuestionDAO và gọi phương thức updateQuestion
            QuestionDAO questionDAO = new QuestionDAO();
            boolean isUpdated = questionDAO.updateQuestion(question);

            // Kiểm tra kết quả và điều hướng
            if (isUpdated) {
                // Thành công, chuyển hướng về trang chính với thông báo
                response.sendRedirect("home.jsp?message=Question%20updated%20successfully");
            } else {
                // Thất bại, thông báo lỗi và quay lại trang cập nhật
                request.setAttribute("errorMessage", "Failed to update question.");
                request.setAttribute("listQues", questionDAO.getQuestionByQuizId(quizId)); // Cung cấp lại danh sách câu hỏi
                request.getRequestDispatcher("updateQuestion.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            // Xử lý lỗi nếu có lỗi chuyển đổi số
            request.setAttribute("errorMessage", "Invalid number format: " + e.getMessage());
            request.getRequestDispatcher("updateQuestion.jsp").forward(request, response);
        }
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
