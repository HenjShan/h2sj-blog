package com.hanshan.h2sj.blog.admin.service;

import com.hanshan.h2sj.blog.domain.entity.Admin;
import com.hanshan.h2sj.blog.domain.entity.User;
import com.hanshan.h2sj.blog.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired(required = false)
    private UserRepository userRepository;


    public User addUser(User user){
        return userRepository.save(user);
    }
}
