package com.hanshan.h2sj.blog.domain.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "h2sj_article")
@Data
public class Article implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long articleId;

    @Column(name = "article_title")
    private String articleTitle;

    @Column(name = "article_content")
    private String articleContent;

    @Column(name = "article_praise")
    private Integer articlePraise;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id")
    private Admin articleAuthor;

    @ManyToMany(mappedBy = "articles",targetEntity = ArticleType.class,fetch = FetchType.LAZY)
    private List<ArticleType> articleTypes = new ArrayList<>();


}
