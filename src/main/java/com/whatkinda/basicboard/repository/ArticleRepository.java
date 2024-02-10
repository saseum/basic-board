package com.whatkinda.basicboard.repository;

import com.whatkinda.basicboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
