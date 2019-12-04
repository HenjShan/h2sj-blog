package com.hanshan.h2sj.blog.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "h2sj_articletype")
@Data
public class ArticleType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atype_id")
    private Long atypeId;

    @Column(name = "atype_name")
    private String atypeName;


    @ManyToMany(fetch = FetchType.LAZY,targetEntity = Article.class)
    @JoinTable(
            name = "h2sj_article_and_type",
            joinColumns = {@JoinColumn(name = "atype_id",referencedColumnName = "atype_id",foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))},
            inverseJoinColumns = {@JoinColumn(name = "article_id",referencedColumnName = "article_id",foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))}
    )
    private List<Article> articles = new ArrayList<>();

    public void addArticle(Article article){
        articles.add(article);
    }

}
