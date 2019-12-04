package com.hanshan.h2sj.blog.admin.controller;

import com.hanshan.h2sj.blog.admin.service.UserService;
import com.hanshan.h2sj.blog.domain.entity.Article;
import com.hanshan.h2sj.blog.domain.entity.ArticleType;
import com.hanshan.h2sj.blog.domain.entity.User;
import com.hanshan.h2sj.blog.domain.repository.ArticleRepository;
import com.hanshan.h2sj.blog.domain.repository.ArticleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleTypeRepository articleTypeRepository;

    @GetMapping(value = "users")
    @ResponseBody
    public String userlist(){
        return "userlist";
    }

    @GetMapping(value = "adduser")
    @ResponseBody
    public String saveUser(
            @RequestParam("account") String account,
            @RequestParam("password") String password
    ){
        User user = new User();
        user.setUserAccount(account);
        user.setUserPassword(password);
        userService.addUser(user);
        return "ok";
    }

    @GetMapping(value = "test")
    @ResponseBody
    public String test(){

        Article article = new Article();
        article.setArticleTitle("testtitle");
        article.setArticleContent("testcontent");

        ArticleType articleType = new ArticleType();
        articleType.setAtypeName("Java");
        articleType.addArticle(article);

        Article save = articleRepository.save(article);
        ArticleType save1 = articleTypeRepository.save(articleType);


        return "ok";
    }


    @GetMapping(value = "testgetarticle")
    @ResponseBody
    public Article getArticle(){

        Article one = articleRepository.getOne(2l);
        System.out.println(one);
//        for (ArticleType atype:one.getArticleTypes()
//             ) {
//            System.out.println(atype);
//        }
        return one;
    }
}
