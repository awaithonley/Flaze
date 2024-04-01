package com.flaze.repository;

import com.flaze.entity.ArticleEntity;
import com.flaze.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    Boolean existsByTitle(String title);

    Optional<ArticleEntity> findByTitle(String title);

    List<ArticleEntity> findByAuthorId(Long authorId);

}



