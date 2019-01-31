package com.zts;

import com.zts.dao.UserRepository;
import com.zts.entity.User;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

/**
 * @author zhangtusheng
 */
@SpringBootApplication
public class UserApplication {
    public static void main(String[] args){
        SpringApplication.run(UserApplication.class,args);
    }

    @Bean
    ApplicationRunner init(UserRepository userRepository){
        return args -> {
            User user1 = new User(1L, "zhangsan", "张三", 11);
            User user2 = new User(2L, "lisi", "李四", 11);
            User user3 = new User(3L, "wangwu", "王五", 11);
            Stream.of(user1, user2, user3).forEach(userRepository::save);
        };
    }
}
