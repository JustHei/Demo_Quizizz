package dao;
// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com

import java.sql.SQLException;
import java.util.*;
import model.*;


public class QuizStatisticsDAO  extends MyDAO{
    
    public List<QuizStatistics> getQuizStatisticsForQuestioner(int questionerId) {
        List<QuizStatistics> quizStatsList = new ArrayList<>();

        try {
            xSql = "SELECT q.quiz_id, q.quiz_name, COUNT(qa.answerer_id) AS num_participants"
                    + ", AVG(qa.mark) AS average_mark, MAX(qa.mark) AS max_mark FROM quiz AS q " +
                   "LEFT JOIN quiz_answerer AS qa ON q.quiz_id = qa.quiz_id " +
                   "WHERE q.questioner_id = ? " +
                   "GROUP BY q.quiz_id, q.quiz_name";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, questionerId);

            rs = ps.executeQuery();

            while (rs.next()) {
                int quizId = rs.getInt("quiz_id");
                String quizName = rs.getString("quiz_name");
                int numParticipants = rs.getInt("num_participants");
                double averageMark = rs.getDouble("average_mark");
                double maxMark = rs.getDouble("max_mark");

                QuizStatistics stats = new QuizStatistics(quizId, quizName, numParticipants, averageMark, maxMark);
                quizStatsList.add(stats);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quizStatsList;
    }
    
    public List<QuizStatistics> getQuizStatisticsForAnswerer(int answererId) {
        List<QuizStatistics> quizStatisticsList = new ArrayList<>();

        try {
            xSql = "SELECT q.quiz_id, q.quiz_name, COUNT(qa.answerer_id) AS numParticipants"
                    + ", AVG(qa.mark) AS averageMark, MAX(qa.mark) AS maxMark " +
                   "FROM quiz q " +
                   "JOIN quiz_answerer qa ON q.quiz_id = qa.quiz_id " +
                   "WHERE qa.answerer_id = ? " +
                   "GROUP BY q.quiz_id, q.quiz_name";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, answererId);

            rs = ps.executeQuery();

            while (rs.next()) {
                int quizId = rs.getInt("quiz_id");
                String quizName = rs.getString("quiz_name");
                int numParticipants = rs.getInt("numParticipants");
                double averageMark = rs.getDouble("averageMark");
                double maxMark = rs.getDouble("maxMark");

                QuizStatistics quizStatistics = new QuizStatistics(quizId, quizName, numParticipants, averageMark, maxMark);
                quizStatisticsList.add(quizStatistics);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quizStatisticsList;
    }
}
