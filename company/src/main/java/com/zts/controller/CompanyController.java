package com.zts.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zts.entiry.User;
import com.zts.feign.UserFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhangtusheng
 */
@RestController
@RequestMapping("/company")
@Slf4j
public class CompanyController {

    @Resource
    private UserFeign userFeign;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Long id){
        return userFeign.findById(id);
    }


    public User findByIdFallback(Long id,Throwable throwable){
        log.error("进入查找用户回退方法",throwable);
        return new User(id,"default","默认",30);
    }




}
