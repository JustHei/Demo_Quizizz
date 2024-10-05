package dao;
// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com

import java.sql.SQLException;
import java.util.*;
import model.*;

public class QuizAnswererDAO extends MyDAO {

    public QuizAnswerer getQuizAnswerById(int id) {
        QuizAnswerer quizAnswerer = null;

        try {
            xSql = "SELECT * FROM quiz_answerer WHERE id = ?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                int quizId = rs.getInt("quiz_id");
                int answererId = rs.getInt("answerer_id");
                double mark = rs.getDouble("mark");

                quizAnswerer = new QuizAnswerer(id, quizId, answererId, mark);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quizAnswerer;
    }

    public int getQuizParticipationCount(int quizId, int answererId) {
        int participationCount = 0;

        try {
            xSql = "SELECT COUNT(*) AS participation_count FROM quiz_answerer WHERE quiz_id = ? AND answerer_id = ?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, quizId);
            ps.setInt(2, answererId);

            rs = ps.executeQuery();

            if (rs.next()) {
                participationCount = rs.getInt("participation_count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return participationCount;
    }

    public List<QuizAnswerer> getQuizAnswerByAnswerId(int answererId) {
        List<QuizAnswerer> list = new ArrayList<>();
        QuizAnswerer quizAnswerer = null;

        try {
            xSql = "SELECT DISTINCT quiz_id, answerer_id FROM quiz_answerer WHERE answerer_id = ?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, answererId);

            rs = ps.executeQuery();

            while (rs.next()) {
                int quizId = rs.getInt("quiz_id");
                quizAnswerer = new QuizAnswerer(quizId, answererId);
                list.add(quizAnswerer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public double getAverageMarkForQuizByAnswerer(int quizId, int answererId) {
        double averageMark = 0.0;

        try {
            xSql = "SELECT AVG(mark) AS average_mark FROM quiz_answerer WHERE quiz_id = ? AND answerer_id = ?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, quizId);
            ps.setInt(2, answererId);

            rs = ps.executeQuery();

            if (rs.next()) {
                averageMark = rs.getDouble("average_mark");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return averageMark;
    }

    public void addQuizAnswerer(int quizid, int answererid, double mark) {
        try {
            xSql = "INSERT INTO quiz_answerer (quiz_id, answerer_id, mark) VALUES (?, ?, ?)";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, quizid);
            ps.setInt(2, answererid);
            ps.setDouble(3, mark);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
