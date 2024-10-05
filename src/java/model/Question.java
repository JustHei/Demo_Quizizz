// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com
package model;


public class Question {
    private int questionId;
    private String questionContent;
    private boolean questionKey;
    private int quizId;

    public Question() {
    }

    public Question(int questionId, String questionContent, boolean questionKey, int quizId) {
        this.questionId = questionId;
        this.questionContent = questionContent;
        this.questionKey = questionKey;
        this.quizId = quizId;
    }

    public Question(String questionContent, boolean questionKey, int quizId) {
        this.questionContent = questionContent;
        this.questionKey = questionKey;
        this.quizId = quizId;
    }
    
    

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public boolean isQuestionKey() {
        return questionKey;
    }

    public void setQuestionKey(boolean questionKey) {
        this.questionKey = questionKey;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    

    @Override
    public String toString() {
        return "Question [questionId=" + questionId + ", questionContent=" + questionContent + ", questionKey=" + questionKey + ", quizId=" + quizId + "]";
    }
}
