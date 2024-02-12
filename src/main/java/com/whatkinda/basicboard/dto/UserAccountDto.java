package com.whatkinda.basicboard.dto;

import com.whatkinda.basicboard.domain.UserAccount;

import java.time.LocalDateTime;

public record UserAccountDto(
        String userId,
        String password,
        String email,
        String nickname,
        String memo,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {
    public static UserAccountDto of(String userId, String password,
                                    String email, String nickname, String memo,
                                    LocalDateTime createdAt, String createdBy,
                                    LocalDateTime modifiedAt, String modifiedBy) {
        return new UserAccountDto(userId, password, email, nickname, memo, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static UserAccountDto from(UserAccount entity) {
        return new UserAccountDto(
                entity.getUserId(),
                entity.getPassword(),
                entity.getEmail(),
                entity.getNickname(),
                entity.getMemo(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public UserAccount toEntity() {
        return UserAccount.of(
                userId,
                password,
                email,
                nickname,
                memo
        );
    }
}
