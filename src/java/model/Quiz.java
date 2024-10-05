// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com
package model;

public class Quiz {
    private int quizId;
    private String quizName;
    private int topicId;
    private int questionerId;
    private boolean isPublic;
    private String enrolKey;

    public Quiz() {
    }

    public Quiz(int quizId, String quizName, int topicId, int questionerId, boolean isPublic, String enrolKey) {
        this.quizId = quizId;
        this.quizName = quizName;
        this.topicId = topicId;
        this.questionerId = questionerId;
        this.isPublic = isPublic;
        this.enrolKey = enrolKey;
    }

    public Quiz(String quizName, int topicId, int questionerId, boolean isPublic, String enrolKey) {
        this.quizName = quizName;
        this.topicId = topicId;
        this.questionerId = questionerId;
        this.isPublic = isPublic;
        this.enrolKey = enrolKey;
    }

    public Quiz(String quizName, int topicId, int questionerId, boolean isPublic) {
        this.quizName = quizName;
        this.topicId = topicId;
        this.questionerId = questionerId;
        this.isPublic = isPublic;
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

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getQuestionerId() {
        return questionerId;
    }

    public void setQuestionerId(int questionerId) {
        this.questionerId = questionerId;
    }

    public boolean isIsPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public String getEnrolKey() {
        return enrolKey;
    }

    public void setEnrolKey(String enrolKey) {
        this.enrolKey = enrolKey;
    }

    

    @Override
    public String toString() {
        return "Quiz [quizId=" + quizId + ", quizName=" + quizName + ", topicId=" + topicId + ", questionerId=" + questionerId + ", isPublic=" + isPublic + ", enrolKey=" + enrolKey + "]";
    }
}
