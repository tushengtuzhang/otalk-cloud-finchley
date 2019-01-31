package com.zts.controller;

import com.zts.entiry.User;
import com.zts.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author zhangtusheng
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Resource
    private UserFeign userFeign;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Long id){
        return userFeign.findById(id);
    }




}
