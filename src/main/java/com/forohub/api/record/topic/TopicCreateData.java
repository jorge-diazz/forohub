package com.forohub.api.record.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicCreateData(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotNull
        LocalDateTime creationDate,
        @NotBlank
        String author,
        @NotBlank
        String course,
        @NotBlank
        String answers
        ) {
}
