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

@WebServlet(name = "EnrollQuizServlet", urlPatterns = {"/enrollquiz"})

public class EnrollQuizServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String strQuizid = request.getParameter("quizId");
        int quizId = Integer.parseInt(strQuizid);

        QuestionDAO quesD = new QuestionDAO();
        List<Question> listQues = quesD.getQuestionByQuizId(quizId);
        request.setAttribute("listQues", listQues);
        request.getRequestDispatcher("doQuiz.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String enrollkey = request.getParameter("txt");

        QuizDAO qd = new QuizDAO();
        Quiz q = qd.getQuizByEnrollKey(enrollkey);

        if (q == null) {
            request.setAttribute("mess", "Enroll FAIl!");
            List<Quiz> listQ = qd.getQuizPublic();
            request.setAttribute("listQ", listQ);

            TopicDAO td = new TopicDAO();
            List<Topic> listT = td.getAllTopic();
            request.setAttribute("listT", listT);

            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            QuestionDAO quesD = new QuestionDAO();
            List<Question> listQues = quesD.getQuestionByQuizId(q.getQuizId());
            request.setAttribute("listQues", listQues);
            request.getRequestDispatcher("doQuiz.jsp").forward(request, response);
        }
        

    }

}
