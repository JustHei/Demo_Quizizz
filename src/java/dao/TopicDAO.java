package dao;
// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com

import java.util.ArrayList;
import java.util.List;
import model.*;

public class TopicDAO extends MyDAO {

    public List<Topic> getAllTopic() {
        List<Topic> topics = new ArrayList<>();
        try {
            xSql = "SELECT * FROM topic";
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int topicId = rs.getInt("topic_id");
                String topicName = rs.getString("topic_name");
                Topic topic = new Topic(topicId, topicName);
                topics.add(topic);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return topics;
    }

    public Topic getTopicById(int topicId) {
        Topic topic = null;
        try {
            xSql = "SELECT * FROM topic WHERE topic_id = ?";
            ps = con.prepareStatement(xSql);
            ps.setInt(1, topicId);
            rs = ps.executeQuery();
            if (rs.next()) {
                String topicName = rs.getString("topic_name");
                topic = new Topic(topicId, topicName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return topic;
    }

}
