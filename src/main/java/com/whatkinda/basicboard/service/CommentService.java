package com.whatkinda.basicboard.service;

import com.whatkinda.basicboard.dto.CommentDto;
import com.whatkinda.basicboard.repository.ArticleRepository;
import com.whatkinda.basicboard.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class CommentService {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public List<CommentDto> searchComments(Long articleId) {
        return List.of();
    }

    public void saveComment(CommentDto dto) {
    }

    public void updateComment(CommentDto dto) {
    }

    public void deleteComment(Long commentId) {
    }

}
