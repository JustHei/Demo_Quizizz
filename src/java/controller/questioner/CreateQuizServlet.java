package controller.questioner;
// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com

import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.*;
import model.*;

@WebServlet(name = "CreateQuizServlet", urlPatterns = {"/createquiz"})

public class CreateQuizServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TopicDAO td = new TopicDAO();
        List<Topic> listTopic = td.getAllTopic();
        request.setAttribute("listTopic", listTopic);
        request.getRequestDispatcher("createQuiz.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("user");
        int userId = u.getUserId();

        String strQuizName = request.getParameter("quizname").trim();
        String strEnrollkey = request.getParameter("enrollkey").trim();

        QuizDAO qd = new QuizDAO();
        List<Quiz> list = qd.getQuizIsNotPublic();
        boolean quizNameExists = false;
        boolean enrollkeyExists = false;

        for (Quiz q : list) {
            if (q.getQuizName().equalsIgnoreCase(strQuizName) && q.getEnrolKey().equalsIgnoreCase(strEnrollkey)) {
                quizNameExists = true;
                enrollkeyExists = true;
                break;
            } else if (q.getQuizName().equalsIgnoreCase(strQuizName)) {
                quizNameExists = true;
            } else if (q.getEnrolKey().equalsIgnoreCase(strEnrollkey)) {
                enrollkeyExists = true;
            }
        }

        TopicDAO td = new TopicDAO();
        List<Topic> listT = td.getAllTopic();
        request.setAttribute("listTopic", listT);

        if (quizNameExists && enrollkeyExists) {
            request.setAttribute("mess", "Quiz name and Enroll key are already exist!");
            // Đẩy người dùng trở lại trang createQuiz.jsp
            request.getRequestDispatcher("createQuiz.jsp").forward(request, response);
        } else if (quizNameExists) {
            request.setAttribute("mess", "Quiz name is already exists!");
            // Đẩy người dùng trở lại trang createQuiz.jsp
            request.getRequestDispatcher("createQuiz.jsp").forward(request, response);
        } else if (enrollkeyExists) {
            request.setAttribute("mess", "Enroll key is already exists!");
            // Đẩy người dùng trở lại trang createQuiz.jsp
            request.getRequestDispatcher("createQuiz.jsp").forward(request, response);
        } else {
            int quizCreatedId = createQuiz(request, userId, strQuizName, strEnrollkey);
            createQuestions(request, quizCreatedId);
            request.setAttribute("mess", "Create Quiz success");

            List<Quiz> listQ = qd.getQuizByQuestionerId(userId);
            request.setAttribute("listQ", listQ);

            // Đẩy người dùng về trang home.jsp sau khi tạo thành công
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
    }

    private int createQuiz(HttpServletRequest request, int userId, String quizName, String enrollKey) {
        String strTopic = request.getParameter("topic");
        int topicId = Integer.parseInt(strTopic);

        boolean isPublic = enrollKey.isEmpty();
        QuizDAO qd = new QuizDAO();
        Quiz quiz = isPublic ? new Quiz(quizName, topicId, userId, true) : new Quiz(quizName, topicId, userId, false, enrollKey);
        qd.createQuiz(quiz);
        return qd.getMaxId();
    }

    private void createQuestions(HttpServletRequest request, int quizCreatedId) {
        QuestionDAO qud = new QuestionDAO();
        for (int i = 1; i <= 4; i++) {
            String questionContent = request.getParameter("qs" + i);
            String strQuestionKey = request.getParameter("qs" + i + "key");
            boolean questionKey = Boolean.parseBoolean(strQuestionKey);
            Question question = new Question(questionContent, questionKey, quizCreatedId);
            qud.createQuestion(question);
        }
    }

}
