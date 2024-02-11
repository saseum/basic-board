package com.whatkinda.basicboard.dto;

import java.time.LocalDateTime;

public record ArticleDto(
        LocalDateTime createdAt,
        String createdBy,
        String title,
        String contents,
        String hashtag
) {
    public static ArticleDto of(LocalDateTime createdAt, String createdBy, String title, String contents, String hashtag) {
        return new ArticleDto(createdAt, createdBy, title, contents, hashtag);
    }
}
