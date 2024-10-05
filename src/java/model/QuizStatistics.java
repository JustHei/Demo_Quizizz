// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com
package model;

public class QuizStatistics {

    private int quizId;
    private String quizName;
    private int numParticipants;
    private double averageMark;
    private double maxMark;

    public QuizStatistics(int quizId, String quizName, int numParticipants, double averageMark, double maxMark) {
        this.quizId = quizId;
        this.quizName = quizName;
        this.numParticipants = numParticipants;
        this.averageMark = averageMark;
        this.maxMark = maxMark;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public int getNumParticipants() {
        return numParticipants;
    }

    public void setNumParticipants(int numParticipants) {
        this.numParticipants = numParticipants;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public double getMaxMark() {
        return maxMark;
    }

    public void setMaxMark(double maxMark) {
        this.maxMark = maxMark;
    }

    @Override
    public String toString() {
        return "QuizStatistics{" + "quizId=" + quizId + ", quizName=" + quizName + ", numParticipants=" + numParticipants + ", averageMark=" + averageMark + ", maxMark=" + maxMark + '}';
    }

}
