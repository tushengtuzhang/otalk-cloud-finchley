package com.zts.controller;

import com.zts.dao.UserRepository;
import com.zts.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author zhangtusheng
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserRepository userRepository;

    @RequestMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id){
        return  userRepository.findById(id);
    }

}
