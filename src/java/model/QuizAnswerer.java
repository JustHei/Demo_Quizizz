
package model;


public class QuizAnswerer {

    private int id;
    private int quizId;
    private int answererId;
    private double mark;

    public QuizAnswerer() {
    }

    public QuizAnswerer(int quizId, int answererId) {
        this.quizId = quizId;
        this.answererId = answererId;
    }

    public QuizAnswerer(int id, int quizId, int answererId, double mark) {
        this.id = id;
        this.quizId = quizId;
        this.answererId = answererId;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getAnswererId() {
        return answererId;
    }

    public void setAnswererId(int answererId) {
        this.answererId = answererId;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "QuizAnswerer [id=" + id + ", quizId=" + quizId + ", answererId=" + answererId + ", mark=" + mark + "]";
    }
}
