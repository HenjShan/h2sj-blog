package com.hanshan.h2sj.blog.domain.entity;



import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "h2sj_comment")
@Data
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "comment_content")
    private String commentContent;

    @Column(name = "comment_createdate")
    private Date commentCreatedate;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User commentAuthor;

    @ManyToOne(targetEntity = Article.class)
    @JoinColumn(name = "article_id",referencedColumnName = "article_id")
    private Article commentArticle;

    @OneToOne(targetEntity = Comment.class)
    @JoinColumn(name = "parent_id",nullable = true,referencedColumnName = "comment_id")
    private Long commentParent;
}
