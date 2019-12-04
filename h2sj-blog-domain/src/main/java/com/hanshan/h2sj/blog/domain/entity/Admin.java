package com.hanshan.h2sj.blog.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "h2sj_admin")
@Data
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "admin_account")
    private String adminAccount;

    @Column(name = "admin_password")
    private String adminPassword;

    @OneToMany(mappedBy = "articleAuthor",fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    private Set<Article> articles = new HashSet<>();
}
