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

@WebServlet(name = "EnrollKeyServlet", urlPatterns = {"/enrollkey"})

public class EnrollKeyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int quizId = Integer.parseInt(request.getParameter("quizId"));
        String key = request.getParameter("key");

        QuizDAO qd = new QuizDAO();
        qd.setQuizPublic(quizId);

        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("user");
        int userId = u.getUserId();

        List<Quiz> listQ = qd.getQuizByQuestionerId(userId);
        request.setAttribute("listQ", listQ);

        TopicDAO td = new TopicDAO();
        List<Topic> listT = td.getAllTopic();
        request.setAttribute("listT", listT);

        request.getRequestDispatcher("home.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("user");
        int userId = u.getUserId();

        TopicDAO td = new TopicDAO();
        List<Topic> listT = td.getAllTopic();
        request.setAttribute("listT", listT);

        int quizId = Integer.parseInt(request.getParameter("quizId"));
        String key = request.getParameter("key");

        QuizDAO qd = new QuizDAO();
        List<Quiz> list = qd.getQuizIsNotPublic();

        boolean enrollkeyExist = false; // Biến cờ

        for (Quiz q : list) {
            if (q.getEnrolKey().equalsIgnoreCase(key)) {
                request.setAttribute("mess", "Enroll key is already exists!");
                List<Quiz> listQ = qd.getQuizByQuestionerId(userId);
                request.setAttribute("listQ", listQ);
                enrollkeyExist = true; // Đánh dấu điều kiện đã thỏa mãn
                break; // Thoát khỏi vòng for
            }
        }

        if (!enrollkeyExist) {
            qd.setEnrollKey(quizId, key);
        }

        List<Quiz> listQ = qd.getQuizByQuestionerId(userId);
        request.setAttribute("listQ", listQ);

        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

}
