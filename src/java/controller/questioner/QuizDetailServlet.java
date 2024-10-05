package controller.questioner;
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

@WebServlet(name = "QuizDetailServlet", urlPatterns = {"/quizdetail"})

public class QuizDetailServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String strQuizid = request.getParameter("quizId");
        int quizId = Integer.parseInt(strQuizid);

        QuestionDAO quesD = new QuestionDAO();
        List<Question> listQues = quesD.getQuestionByQuizId(quizId);
        request.setAttribute("listQues", listQues);
        request.getRequestDispatcher("quizDetail.jsp").forward(request, response);

    }
}
