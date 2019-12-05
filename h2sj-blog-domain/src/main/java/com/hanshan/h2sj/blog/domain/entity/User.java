package com.hanshan.h2sj.blog.domain.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "h2sj_user")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_account")
    private String userAccount;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_portrait")
    private String userPortrait;

    @Column(name = "user_birthday")
    private Date userBirthday;

    @Column(name = "user_gender")
    private Integer userGender;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_phone",unique = true)
    private String userPhone;

    @OneToMany(mappedBy = "commentAuthor",fetch = FetchType.LAZY,targetEntity = Comment.class)
    private List<Comment> comments = new ArrayList<>();

}
