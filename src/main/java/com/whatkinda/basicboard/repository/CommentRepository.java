package com.whatkinda.basicboard.repository;

import com.whatkinda.basicboard.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
