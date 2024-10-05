package controller;
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

@WebServlet(name = "DeleteQuizServlet", urlPatterns = {"/deletequiz"})

public class DeleteQuizServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("user");
        int userId = u.getUserId();

        int quizid = Integer.parseInt(request.getParameter("quizId"));
        QuizDAO qd = new QuizDAO();
        qd.deleteQuiz(quizid);

        List<Quiz> listQ = qd.getQuizByQuestionerId(userId);
        request.setAttribute("listQ", listQ);

        TopicDAO td = new TopicDAO();
        List<Topic> listT = td.getAllTopic();
        request.setAttribute("listT", listT);

        request.getRequestDispatcher("home.jsp").forward(request, response);

    }

}
