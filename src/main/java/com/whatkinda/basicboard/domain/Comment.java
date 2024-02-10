package com.whatkinda.basicboard.domain;

import java.time.LocalDateTime;

public class Comment {

    private Long id;
    private String title;
    private String hashtag;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;
}
