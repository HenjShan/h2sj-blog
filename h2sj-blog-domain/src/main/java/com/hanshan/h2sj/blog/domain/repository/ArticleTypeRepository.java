package com.hanshan.h2sj.blog.domain.repository;

import com.hanshan.h2sj.blog.domain.entity.ArticleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleTypeRepository extends JpaRepository<ArticleType,Long> {
}
