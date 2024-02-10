package com.whatkinda.basicboard.repository;

import com.whatkinda.basicboard.config.JpaConfig;
import com.whatkinda.basicboard.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("JPA Connection Test")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;

    @DisplayName("SELECT 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine() {
        // given

        // when
        List<Article> articles = articleRepository.findAll();

        // then
        assertThat(articles).isNotNull().hasSize(123);
    }

    @DisplayName("INSERT 테스트")
    @Test
    void givenTestData_whenInserting_thenWorksFine() {
        // given
        long prevCnt = articleRepository.count();
        Article article = Article.of("new article", "new contents", "#whatkinda");

        // when
        Article savedArticle = articleRepository.save(article);

        // then
        assertThat(articleRepository.count()).isEqualTo(prevCnt + 1);
    }

    @DisplayName("UPDATE 테스트")
    @Test
    void givenTestData_whenUpdating_thenWorksFine() {
        // given
        Article article = articleRepository.findById(1L).orElseThrow();
        String updatedHashtag = "#wakanda";
        article.setHashtag(updatedHashtag);

        // when
        Article savedArticle = articleRepository.save(article);

        // then
        assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag", updatedHashtag);
    }

    @DisplayName("DELETE 테스트")
    @Test
    void givenTestData_whenDeleting_thenWorksFine() {
        // given
        Article article = articleRepository.findById(1L).orElseThrow();
        long prevArticleCnt = articleRepository.count();
        long prevCommentCnt = commentRepository.count();
        int deletedCommentsSize = article.getComments().size();

        // when
        articleRepository.delete(article);

        // then
        assertThat(articleRepository.count()).isEqualTo(prevArticleCnt - 1);
        assertThat(commentRepository.count()).isEqualTo(prevCommentCnt - deletedCommentsSize);
    }
}