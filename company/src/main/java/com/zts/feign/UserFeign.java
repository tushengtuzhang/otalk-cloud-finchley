package com.zts.feign;

import com.zts.entiry.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhangtusheng
 */
@FeignClient(name = "user")
public interface UserFeign {

    /**
     * 根据Id查找用户
     * @param id id
     * @return User
     */
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
