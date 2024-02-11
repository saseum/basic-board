package com.whatkinda.basicboard.dto;

public record ArticleUpdateDto(
        String title,
        String contents,
        String hashtag
) {
    public static ArticleUpdateDto of(String title, String contents, String hashtag) {
        return new ArticleUpdateDto(title, contents, hashtag);
    }
}
