package com.forohub.api.model;

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
    // Others tables
    private String author;
    private String course;
    private String answers;
}
