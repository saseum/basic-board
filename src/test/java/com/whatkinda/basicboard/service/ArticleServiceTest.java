package com.whatkinda.basicboard.service;

import com.whatkinda.basicboard.domain.Article;
import com.whatkinda.basicboard.domain.type.SearchType;
import com.whatkinda.basicboard.dto.ArticleDto;
import com.whatkinda.basicboard.dto.ArticleUpdateDto;
import com.whatkinda.basicboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@DisplayName("비즈니스 로직 - Article")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks
    private ArticleService sut;

    @Mock
    private ArticleRepository articleRepository;

    @DisplayName("게시글 검색 시, 게시글 목록을 반환한다.")
    @Test
    void givenSearch_whenSearchingArticle_thenReturnsList() {
        // given

        // when
        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword");

        // then
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글을 조회 시, 게시글을 반환한다.")
    @Test
    void givenArticleId_whenSearchingArticle_thenReturnsDetail() {
        // given

        // when
        ArticleDto article = sut.searchArticle(1L);

        // then
        assertThat(article).isNull();
    }

    @DisplayName("게시글 정보 입력 시, 게시글을 생성한다.")
    @Test
    void givenArticleInfo_whenSavingArticle_thenSavesThis() {
        // given
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // when
        sut.saveArticle(ArticleDto.of(LocalDateTime.now(), "whatkinda", "title", "content", "#wakanda"));

        // then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글 아이디와 수정 정보 입력 시, 게시글을 수정한다.")
    @Test
    void givenArticleIdAndModifiedInfo_whenUpdatingArticle_thenUpdatesThis() {
        // given
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // when
        sut.updateArticle(1L, ArticleUpdateDto.of("title", "contents", "#newHashtag"));

        // then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글 아이디 입력 시, 게시글을 삭제한다.")
    @Test
    void givenArticleId_whenDeletingArticle_thenDeletesThis() {
        // given
        willDoNothing().given(articleRepository).delete(any(Article.class));

        // when
        sut.deleteArticle(1L);

        // then
        then(articleRepository).should().delete(any(Article.class));
    }
}