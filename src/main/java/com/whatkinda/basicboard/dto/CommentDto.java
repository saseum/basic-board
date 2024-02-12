package com.whatkinda.basicboard.dto;

import com.whatkinda.basicboard.domain.Article;
import com.whatkinda.basicboard.domain.Comment;

import java.time.LocalDateTime;

public record CommentDto(
        Long id,
        Long articleId,
        UserAccountDto userAccountDto,
        String contents,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {
    public static CommentDto of(Long id, Long articleId, UserAccountDto userAccountDto, String contents
            , LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new CommentDto(id, articleId, userAccountDto, contents, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static CommentDto from(Comment entity) {
        return new CommentDto(
                entity.getId(),
                entity.getArticle().getId(),
                UserAccountDto.from(entity.getUserAccount()),
                entity.getContents(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public Comment toEntity(Article entity) {
        return Comment.of(
                entity,
                userAccountDto.toEntity(),
                contents
        );
    }
}
