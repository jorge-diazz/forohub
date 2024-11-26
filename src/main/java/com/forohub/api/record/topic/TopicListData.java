package com.forohub.api.record.topic;

import com.forohub.api.model.Topic;

import java.time.LocalDateTime;

public record TopicListData(Long id, String title, String message, LocalDateTime creationDate) {
    public TopicListData(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate());
    }
}
