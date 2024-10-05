package dao;
// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com

import java.sql.SQLException;
import java.util.*;
import model.*;

public class QuizDAO extends MyDAO {

    public List<Quiz> getAllQuiz() {
        List<Quiz> quizList = new ArrayList<>();

        try {
            xSql = "SELECT * FROM quiz";
            ps = con.prepareStatement(xSql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int quizId = rs.getInt("quiz_id");
                String quizName = rs.getString("quiz_name");
                int topicId = rs.getInt("topic_id");
                int questionerId = rs.getInt("questioner_id");
                boolean isPublic = rs.getBoolean("is_public");
                String enrolKey = rs.getString("enrol_key");

                Quiz quiz = new Quiz(quizId, quizName, topicId, questionerId, isPublic, enrolKey);
                quizList.add(quiz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quizList;
    }

    public List<Quiz> getQuizPublic() {
        List<Quiz> publicQuizzes = new ArrayList<>();

        try {
            xSql = "SELECT * FROM quiz WHERE is_public = 1";
            ps = con.prepareStatement(xSql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int quizId = rs.getInt("quiz_id");
                String quizName = rs.getString("quiz_name");
                int topicId = rs.getInt("topic_id");
                int questionerId = rs.getInt("questioner_id");
                String enrolKey = rs.getString("enrol_key");

                Quiz quiz = new Quiz(quizId, quizName, topicId, questionerId, true, enrolKey);
                publicQuizzes.add(quiz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return publicQuizzes;
    }

    public List<Quiz> getQuizIsNotPublic() {
        List<Quiz> publicQuizzes = new ArrayList<>();

        try {
            xSql = "SELECT * FROM quiz WHERE is_public = 0";
            ps = con.prepareStatement(xSql);

            rs = ps.executeQuery();

            while (rs.next()) {
                int quizId = rs.getInt("quiz_id");
                String quizName = rs.getString("quiz_name");
                int topicId = rs.getInt("topic_id");
                int questionerId = rs.getInt("questioner_id");
                String enrolKey = rs.getString("enrol_key");

                Quiz quiz = new Quiz(quizId, quizName, topicId, questionerId, true, enrolKey);
                publicQuizzes.add(quiz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return publicQuizzes;
    }

    public List<Quiz> getQuizByQuestionerId(int questionerId) {
        List<Quiz> quizList = new ArrayList<>();

        try {
            xSql = "SELECT * FROM quiz WHERE questioner_id = ?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, questionerId);

            rs = ps.executeQuery();

            while (rs.next()) {
                int quizId = rs.getInt("quiz_id");
                String quizName = rs.getString("quiz_name");
                int topicId = rs.getInt("topic_id");
                boolean isPublic = rs.getBoolean("is_public");
                String enrolKey = rs.getString("enrol_key");

                Quiz quiz = new Quiz(quizId, quizName, topicId, questionerId, isPublic, enrolKey);
                quizList.add(quiz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quizList;
    }

    public Quiz getQuizById(int quizId) {
        Quiz quiz = null;

        try {
            xSql = "SELECT * FROM quiz WHERE quiz_id = ?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, quizId);

            rs = ps.executeQuery();

            if (rs.next()) {
                String quizName = rs.getString("quiz_name");
                int topicId = rs.getInt("topic_id");
                int questionerId = rs.getInt("questioner_id");
                boolean isPublic = rs.getBoolean("is_public");
                String enrolKey = rs.getString("enrol_key");

                quiz = new Quiz(quizId, quizName, topicId, questionerId, isPublic, enrolKey);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quiz;
    }

    public Quiz getQuizByEnrollKey(String enrolKey) {
        Quiz quiz = null;

        try {
            xSql = "SELECT * FROM quiz WHERE enrol_key = ?";
            ps = con.prepareStatement(xSql);
            ps.setString(1, enrolKey);

            rs = ps.executeQuery();

            if (rs.next()) {
                int quizId = rs.getInt("quiz_id");
                String quizName = rs.getString("quiz_name");
                int topicId = rs.getInt("topic_id");
                int questionerId = rs.getInt("questioner_id");
                boolean isPublic = rs.getBoolean("is_public");

                quiz = new Quiz(quizId, quizName, topicId, questionerId, isPublic, enrolKey);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quiz;
    }

    public List<Quiz> getQuizByTopicId(int topicId) {
        List<Quiz> quizzes = new ArrayList<>();

        try {
            xSql = "SELECT * FROM quiz WHERE topic_id = ?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, topicId);

            rs = ps.executeQuery();

            while (rs.next()) {
                int quizId = rs.getInt("quiz_id");
                String quizName = rs.getString("quiz_name");
                int questionerId = rs.getInt("questioner_id");
                boolean isPublic = rs.getBoolean("is_public");
                String enrolKey = rs.getString("enrol_key");

                Quiz quiz = new Quiz(quizId, quizName, topicId, questionerId, isPublic, enrolKey);
                quizzes.add(quiz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quizzes;
    }

    public boolean createQuiz(Quiz quiz) {
        try {
            if (quiz.getEnrolKey() != null) {
                xSql = "INSERT INTO quiz (quiz_name, topic_id, questioner_id, is_public, enrol_key) VALUES (?, ?, ?, ?, ?)";
                ps = con.prepareStatement(xSql);
                ps.setString(1, quiz.getQuizName());
                ps.setInt(2, quiz.getTopicId());
                ps.setInt(3, quiz.getQuestionerId());
                ps.setBoolean(4, quiz.isIsPublic());
                ps.setString(5, quiz.getEnrolKey());
            } else {
                xSql = "INSERT INTO quiz (quiz_name, topic_id, questioner_id, is_public) VALUES (?, ?, ?, ?)";
                ps = con.prepareStatement(xSql);
                ps.setString(1, quiz.getQuizName());
                ps.setInt(2, quiz.getTopicId());
                ps.setInt(3, quiz.getQuestionerId());
                ps.setBoolean(4, quiz.isIsPublic());
            }

            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0; // Trả về true nếu bài kiểm tra được tạo thành công
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Trả về false nếu có lỗi khi tạo bài kiểm tra
    }

    public void deleteQuiz(int quizId) {
        try {
            // Xóa bản ghi trong bảng QuizAnswerer tham chiếu tới quiz_id
            xSql = "DELETE FROM quiz_answerer WHERE quiz_id = ?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, quizId);
            ps.executeUpdate();

            // Xóa bản ghi trong bảng Question tham chiếu tới quiz_id
            xSql = "DELETE FROM question WHERE quiz_id = ?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, quizId);
            ps.executeUpdate();

            // Cuối cùng, xóa bản ghi trong bảng Quiz
            xSql = "DELETE FROM quiz WHERE quiz_id = ?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, quizId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean updateQuiz(Quiz quiz) {
        boolean updated = false;
        try {
            // Cập nhật dữ liệu trong bảng quiz
            xSql = "UPDATE quiz SET quiz_name = ?, topic_id = ?, questioner_id = ?, is_public = ?, enrol_key = ? WHERE quiz_id = ?";
            ps = con.prepareStatement(xSql);
            ps.setString(1, quiz.getQuizName());
            ps.setInt(2, quiz.getTopicId());
            ps.setInt(3, quiz.getQuestionerId());
            ps.setBoolean(4, quiz.isIsPublic());
            ps.setString(5, quiz.getEnrolKey());
            ps.setInt(6, quiz.getQuizId());

            int rowsAffected = ps.executeUpdate();
            updated = rowsAffected > 0; // Trả về true nếu cập nhật thành công

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated; // Trả về false nếu có lỗi khi cập nhật
    }

    public boolean setQuizPublic(int quizId) {
        try {
            xSql = "UPDATE quiz SET is_public = 1, enrol_key = NULL WHERE quiz_id = ?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, quizId);

            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0; // Trả về true nếu cập nhật thành công
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Trả về false nếu có lỗi khi cập nhật
    }

    public boolean setEnrollKey(int quizId, String enrollKey) {
        try {
            xSql = "UPDATE quiz SET is_public = 0, enrol_key = ? WHERE quiz_id = ?";
            ps = con.prepareStatement(xSql);
            ps.setString(1, enrollKey);
            ps.setInt(2, quizId);

            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0; // Trả về true nếu cập nhật thành công
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Trả về false nếu có lỗi khi cập nhật
    }

    public int getMaxId() {
        int maxId = 0;
        try {
            xSql = "SELECT MAX(quiz_id) FROM quiz";
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();

            if (rs.next()) {
                maxId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maxId;
    }

}
