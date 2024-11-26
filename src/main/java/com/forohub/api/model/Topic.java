package com.forohub.api.model;

import com.forohub.api.record.topic.TopicCreateData;
import com.forohub.api.record.topic.TopicUpdateData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Topics")
@Table(name = "topics")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private Boolean active;
    // Others tables
    private String author;
    private String course;
    private String answers;

    public Topic(TopicCreateData topicCreateData) {
        this.title = topicCreateData.title();
        this.message = topicCreateData.message();
        this.creationDate = topicCreateData.creationDate();
        this.author = topicCreateData.author();
        this.course = topicCreateData.course();
        this.answers = topicCreateData.answers();
        this.active = true;
    }

    public void updateData(TopicUpdateData topicUpdateData) {
        if (topicUpdateData.title() != null) {
            this.title = topicUpdateData.title();
        }
        if (topicUpdateData.message() != null) {
            this.message = topicUpdateData.message();
        }
    }

    public void deactivate() {
        this.active = false;
    }
}
