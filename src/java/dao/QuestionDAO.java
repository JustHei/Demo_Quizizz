package dao;
// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com

import java.sql.SQLException;
import java.util.*;
import model.*;

public class QuestionDAO extends MyDAO {

    public List<Question> getQuestionByQuizId(int quizId) {
        List<Question> questions = new ArrayList<>();
        try {
            xSql = "SELECT * FROM question WHERE quiz_id = ?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, quizId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int questionId = rs.getInt("question_id");
                String questionContent = rs.getString("question_content");
                boolean questionKey = rs.getBoolean("question_key");
                Question question = new Question(questionId, questionContent, questionKey, quizId);
                questions.add(question);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }

    public Question getQuestionById(int questionId) {
        Question question = null;
        try {
            xSql = "SELECT * FROM question WHERE question_id = ?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, questionId);
            rs = ps.executeQuery();

            if (rs.next()) {
                String questionContent = rs.getString("question_content");
                boolean questionKey = rs.getBoolean("question_key");
                int quizId = rs.getInt("quiz_id");
                question = new Question(questionId, questionContent, questionKey, quizId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }

    public boolean createQuestion(Question question) {
        try {
            xSql = "INSERT INTO question (question_content, question_key, quiz_id) VALUES (?, ?, ?)";
            ps = con.prepareStatement(xSql);
            ps.setString(1, question.getQuestionContent());
            ps.setBoolean(2, question.isQuestionKey());
            ps.setInt(3, question.getQuizId());

            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0; // Trả về true nếu câu hỏi được tạo thành công
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Trả về false nếu có lỗi khi tạo câu hỏi
    }

    public boolean updateQuestion(Question question) {
        try {
            xSql = "UPDATE question SET question_content = ?, question_key = ?, quiz_id = ? WHERE question_id = ?";
            ps = con.prepareStatement(xSql);
            ps.setString(1, question.getQuestionContent());
            ps.setBoolean(2, question.isQuestionKey());
            ps.setInt(3, question.getQuizId());
            ps.setInt(4, question.getQuestionId());

            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0; // Trả về true nếu câu hỏi được cập nhật thành công
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Trả về false nếu có lỗi khi cập nhật câu hỏi
    }

}
