package com.forohub.api.record.topic;

import com.forohub.api.model.Topic;

import java.time.LocalDateTime;

public record TopicRequestData(
        Long id,
        String title,
        String message,
        LocalDateTime creationDate,
        String author,
        String course,
        String answers
        ) {

    public TopicRequestData(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate(), topic.getAuthor(), topic.getCourse(), topic.getAnswers());
    }
}
