package com.zts.feign;

import com.zts.entiry.User;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhangtusheng
 */
@FeignClient(name = "user",configuration = UserFeign.UserFeignConfig.class)
public interface UserFeign {

    /**
     * 根据Id查找用户
     * @param id id
     * @return User
     */
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);


    class UserFeignConfig {
        @Bean
        public Logger.Level logger(){
            return Logger.Level.FULL;
        }
    }
}
