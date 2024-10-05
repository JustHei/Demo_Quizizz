package controller.answerer;
// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com

import dao.*;
import model.*;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "DoQuizServlet", urlPatterns = {"/doquiz"})

public class DoQuizServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int totalQuestions = 4;

        double mark = 0;
        
        QuestionDAO quesD = new QuestionDAO();
        for (int i = 0; i < totalQuestions; i++) {
            String keyParameter = "qs" + i + "key";
            String idParameter = "qs" + i + "Id";

            String strInputKey = request.getParameter(keyParameter);
            String strQuestionId = request.getParameter(idParameter);

            boolean inputKey = Boolean.parseBoolean(strInputKey);
            int questionId = Integer.parseInt(strQuestionId);

            boolean correctKey = quesD.getQuestionById(questionId).isQuestionKey();

            if (inputKey == correctKey) {
                mark += 25;
            }
        }

        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("user");
        int userId = u.getUserId();

        int quizId = quesD.getQuestionById(Integer.parseInt(request.getParameter("qs1Id"))).getQuizId();
        
        QuizAnswererDAO qad = new QuizAnswererDAO();
        qad.addQuizAnswerer(quizId, userId, mark);

        request.setAttribute("mark", mark);
        request.getRequestDispatcher("mark.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

    }

}
